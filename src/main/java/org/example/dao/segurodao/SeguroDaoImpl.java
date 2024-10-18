package org.example.dao.segurodao;

import org.example.config.DatabaseConfig;
import org.example.dao.cliente.ClienteDao;
import org.example.dao.cliente.ClienteDaoFactory;
import org.example.dao.veiculodao.VeiculoDao;
import org.example.dao.veiculodao.VeiculoDaoFactory;
import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.Seguro;
import org.example.entities.seguro.caminhao.SeguroCaminhao;
import org.example.entities.seguro.carro.SeguroCarro;
import org.example.entities.seguro.moto.SeguroMoto;
import org.example.entities.veiculo.Veiculo;
import org.example.entities.veiculo.caminhao.FactoryCaminhao;
import org.example.entities.veiculo.carro.FactoryCarro;
import org.example.entities.veiculo.moto.FactoryMoto;
import org.example.exceptions.cliente.ClienteDaoException;
import org.example.exceptions.cliente.ClienteNotFoundException;
import org.example.exceptions.seguro.SeguroAlreadyExistsException;
import org.example.exceptions.seguro.SeguroDaoException;
import org.example.exceptions.seguro.SeguroNotFoundException;
import org.example.exceptions.veiculo.VeiculoDaoException;
import org.example.exceptions.veiculo.VeiculoNotFoundException;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SeguroDaoImpl implements SeguroDao {
    private DatabaseConfig db;
    private ClienteDao clienteDao = ClienteDaoFactory.create();
    private VeiculoDao veiculoDao = VeiculoDaoFactory.create();



    @Override
    public Seguro create(Seguro seguro) throws SeguroAlreadyExistsException {
        // Aqui a apólice não é passada pois seria auto gerada pelo banco de dados.
        // Status não é passado pois é definido de acordo com a data de vigência.
        if(SeguroByApolice(seguro.getNumeroApolice())){
            throw new SeguroAlreadyExistsException("Seguro já cadastrado.");
        }
        String sql = "INSERT INTO SEGURO(valorParcelaSeguro, premio, dataInicioVigencia, dataFimVigencia, cliente, veiculo) values(?,?,?,?,?,?,?)";

        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, seguro.getValorParcelaSeguro());
            pstmt.setDouble(2, seguro.getPremio());
            pstmt.setDate(3, java.sql.Date.valueOf(seguro.getDataInicioVigencia()));
            pstmt.setDate(4, java.sql.Date.valueOf(seguro.getDataFimVigencia()));
            pstmt.setString(5, seguro.getCliente().getCpf());
            pstmt.setString(6, seguro.getVeiculo().getPlaca());
            pstmt.setBoolean(7, seguro.isStatus());
            pstmt.executeUpdate();
            connection.close();
            return seguro;
        } catch (SQLException e) {
            throw new SeguroDaoException("Erro ao criar novo seguro.");
        }
    }

    @Override
    public List<Seguro> readAll() throws SeguroDaoException {
        List<Seguro> result = new ArrayList<>();
        String sql = "SELECT * FROM SEGURO";

        try {
            Connection connection = db.getConnection();
            Statement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String numeroApolice = rs.getString("numeroApolice");
                double valorParcelaSeguro = rs.getDouble("valorParcelaSeguro");
                double premio = rs.getDouble("premio");
                LocalDate dataInicioVigencia = rs.getDate("dataInicioVigencia").toLocalDate();
                LocalDate dataFimVigencia = rs.getDate("dataFimVigencia").toLocalDate();
                boolean status = rs.getBoolean("status");

                String cpfCliente = rs.getString("cliente");  // Chave estrangeira do Cliente
                String placaVeiculo = rs.getString("veiculo");  // Chave estrangeira do Veículo

                Cliente cliente = null;
                try {
                    cliente = clienteDao.findByCpf(cpfCliente);
                } catch (ClienteNotFoundException e) {
                    throw new SeguroDaoException("Cliente não encontrado.");
                }

                Veiculo veiculo = null;
                try {
                    veiculo = veiculoDao.findByPlaca(placaVeiculo);
                } catch (VeiculoNotFoundException e) {
                    throw new SeguroDaoException("Veículo não encontrado.");
                }

                switch (veiculo.getTipo()) {
                    case "Carro":
                        SeguroCarro seguroCarro = new SeguroCarro(valorParcelaSeguro, dataInicioVigencia, dataFimVigencia, cliente, veiculo);
                        result.add(seguroCarro);
                    case "Moto":
                        SeguroMoto seguroMoto = new SeguroMoto(valorParcelaSeguro, dataInicioVigencia, dataFimVigencia, cliente, veiculo);
                        result.add(seguroMoto);
                    case "Caminhão":
                        SeguroCaminhao seguroCaminhao = new SeguroCaminhao(valorParcelaSeguro, dataInicioVigencia, dataFimVigencia, cliente, veiculo);
                        result.add(seguroCaminhao);
                    default:
                        throw new VeiculoDaoException("Erro ao identificar veículo");
                }
            }
            connection.close();
        } catch (SQLException e) {
            throw new SeguroDaoException("Erro ao ler seguros.");
        }
        return result;
    }

    @Override
    public Seguro update(Seguro seguro) throws SeguroNotFoundException{
        String sql = "UPDATE SEGURO SET valorParcelaSeguro = ?, dataInicioVigencia = ?, dataFimVigencia = ?WHERE numeroApolice = ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, seguro.getValorParcelaSeguro());
            pstmt.setDate(2, java.sql.Date.valueOf(seguro.getDataInicioVigencia()));
            pstmt.setDate(3, java.sql.Date.valueOf(seguro.getDataFimVigencia()));
            pstmt.setString(4, seguro.getNumeroApolice());


            int linhasAlteradas = pstmt.executeUpdate();
            // Verifica se o CPF foi encontrado e deletado
            if (linhasAlteradas == 0) {
                throw new SeguroNotFoundException("Seguro não existe no banco.");
            }
            connection.close();
            return seguro;
        } catch (SQLException e) {
            throw new SeguroDaoException("Erro ao atualizar seguro.");
        }
    }


    @Override
    public void delete(String apolice) throws SeguroNotFoundException  {
        String sql = "DELETE FROM SEGURO WHERE numeroApolice = ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            int linhasAlteradas = pstmt.executeUpdate();
            if (linhasAlteradas == 0) {
                throw new SeguroNotFoundException("Seguro não encontrado.");
            }
            connection.close();
        } catch (SQLException e) {
            throw new SeguroDaoException("Erro ao deletar seguro.");
        }
    }

    @Override
    public Boolean SeguroByApolice(String apolice) throws SeguroDaoException {
        String sql = "SELECT * FROM SEGURO WHERE numeroApolice = ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, apolice);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                connection.close();
                return true;
            } else {
                connection.close();
                return false;
            }
        } catch (SQLException e) {
            throw new SeguroDaoException("Erro ao buscar seguro.");
        }
    }
}

