package org.example.dao.veiculodao;

import org.example.config.DatabaseConfig;
import org.example.entities.enums.Marca;
import org.example.entities.veiculo.Carro;
import org.example.entities.veiculo.Moto;
import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.caminhao.FactoryCaminhao;
import org.example.entities.veiculo.carro.FactoryCarro;
import org.example.entities.veiculo.moto.FactoryMoto;
import org.example.exceptions.veiculo.VeiculoAlreadyExistsException;
import org.example.exceptions.veiculo.VeiculoDaoException;
import org.example.exceptions.veiculo.VeiculoNotFoundException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class VeiculoDaoImpl implements VeiculoDao {
    private DatabaseConfig db;




    @Override
    public Veiculo create(Veiculo veiculo) throws VeiculoAlreadyExistsException, VeiculoDaoException {
        if(VeiculoExistsByPlaca(veiculo.getPlaca())){
            throw new VeiculoAlreadyExistsException("Veículo já cadastrado.");
        }
        String sql = "INSERT INTO VEICULO(placa, tipo, marca, modelo, ano, valorMercado) values(?,?,?,?,?,?)";

        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, veiculo.getPlaca());
            pstmt.setString(2, veiculo.getClass().getSimpleName());
            pstmt.setString(3, veiculo.getMarca().toString());
            pstmt.setString(4, veiculo.getModelo());
            pstmt.setInt(5, veiculo.getAno());
            pstmt.setFloat(6, veiculo.getValorMercado());
            pstmt.executeUpdate();
            connection.close();
            return veiculo;
        } catch (SQLException e) {
            throw new VeiculoDaoException("Erro ao criar novo veículo.");
        }
    }

    @Override
    public List<Veiculo> readAll() throws VeiculoDaoException{
        String sql = "SELECT * FROM VEICULO";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            List<Veiculo> veiculos = new java.util.ArrayList<>(List.of());
            while (rs.next()) {
                String tipo = rs.getString("tipo");
                Marca marca = Marca.valueOf(rs.getString("marca"));
                String modelo = rs.getString("modelo");
                int ano = rs.getInt("ano");
                float valorMercado = rs.getFloat("valorMercado");
                switch (tipo) {
                    case "Carro":
                        veiculos.add(FactoryCarro.createCarro(rs.getString("placa"), marca, modelo, ano, valorMercado));
                        break;
                    case "Moto":
                        veiculos.add(FactoryMoto.createMoto(rs.getString("placa"), marca, modelo, ano, valorMercado));
                        break;
                    case "Caminhão":
                        veiculos.add(FactoryCaminhao.createCaminhao(rs.getString("placa"), marca, modelo, ano, valorMercado));  // Usando a factory correta
                        break;
                    default:
                        throw new VeiculoDaoException("Erro ao identificar veículo");
                }
            }
            connection.close();
            return veiculos;
        } catch (SQLException e) {
            throw new VeiculoDaoException("Erro ao buscar veículos.");
        }

    }

    @Override
    public Veiculo update(Veiculo veiculo) throws VeiculoNotFoundException {
        if(!VeiculoExistsByPlaca(veiculo.getPlaca())){
            throw new VeiculoNotFoundException("Veículo não encontrado.");
        }
        String sql = "UPDATE VEICULO SET tipo = ?, marca = ?, modelo = ?, ano = ?, valorMercado = ? WHERE placa = ?";

        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, veiculo.getClass().getSimpleName());
            pstmt.setString(2, veiculo.getMarca().toString());
            pstmt.setString(3, veiculo.getModelo());
            pstmt.setInt(4, veiculo.getAno());
            pstmt.setFloat(5, veiculo.getValorMercado());
            pstmt.setString(6, veiculo.getPlaca());
            pstmt.executeUpdate();
            connection.close();
            return veiculo;
        } catch (SQLException e) {
            throw new VeiculoDaoException("Erro ao atualizar veículo.");
        }
    }

    @Override
    public void delete(String placa) throws VeiculoNotFoundException {
        if(!VeiculoExistsByPlaca(placa)){
            throw new VeiculoNotFoundException("Veículo não encontrado.");
        }
        String sql = "DELETE FROM VEICULO WHERE placa = ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, placa);
            pstmt.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new VeiculoDaoException("Erro ao deletar veículo.");
        }
    }

    @Override
    public Boolean VeiculoExistsByPlaca(String placa) throws VeiculoDaoException {
        String sql = "SELECT * FROM VEICULO WHERE placa = ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, placa);
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new VeiculoDaoException("Erro ao buscar veículo.");
        }
    }

    /**
     * Método que procura no banco de dados um veículo com a placa informada e o retorna.
     * @param placa
     * @return
     * @throws VeiculoNotFoundException
     */
    @Override
    public Veiculo findByPlaca(String placa) throws VeiculoNotFoundException {
        String sql = "SELECT * FROM VEICULO WHERE placa = ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, placa);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String tipo = rs.getString("tipo");
                Marca marca = Marca.valueOf(rs.getString("marca"));
                String modelo = rs.getString("modelo");
                int ano = rs.getInt("ano");
                float valorMercado = rs.getFloat("valorMercado");
                switch (tipo) {
                    case "Carro":
                        return FactoryCarro.createCarro(placa, marca, modelo, ano, valorMercado);
                    case "Moto":
                        return FactoryMoto.createMoto(placa, marca, modelo, ano, valorMercado);
                    case "Caminhão":
                        return FactoryCaminhao.createCaminhao(placa, marca, modelo, ano, valorMercado);  // Usando a factory correta
                    default:
                        throw new VeiculoDaoException("Erro ao identificar veículo");
                }
            } else {
                throw new VeiculoNotFoundException("Veículo não encontrado.");
            }
        } catch (SQLException e) {
            throw new VeiculoDaoException("Erro ao buscar veículo.");
        }


    }


}
