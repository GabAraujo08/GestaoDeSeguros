package org.example.dao.segurodao;

import org.example.config.DatabaseConfig;
import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.Seguro;
import org.example.entities.veiculo.Veiculo;
import org.example.exceptions.ClienteDaoException;
import org.example.exceptions.SeguroDaoException;
import org.example.service.cliente.ClienteServiceImpl;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.example.service.VeiculoService.buscarVeiculoPorPlaca;

public class SeguroImpl implements SeguroDao {
    private DatabaseConfig db;

    public SeguroImpl(DatabaseConfig db) {
        this.db = db;
    }
    @Override
    public void create(Seguro seguro) {
        // Aqui a apólice não é passada pois seria auto gerada pelo banco de dados.
        // Status não é passado pois é definido de acordo com a data de vigência.
        String sql = "INSERT INTO SEGURO(valorParcelaSeguro, premio, dataInicioVigencia, dataFimVigencia, cliente, veiculo) values(?,?,?,?,?,?,?)";
        try{
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
        }catch (SQLException e){
            throw new SeguroDaoException("Erro ao criar novo seguro.");
        }
    }

    @Override
    public List<Seguro> readAll() {
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


                Cliente cliente = ClienteServiceImpl.buscarClientePorCpf(cpfCliente);

                Veiculo veiculo = buscarVeiculoPorPlaca(placaVeiculo);


                Seguro seguro = new Seguro(valorParcelaSeguro, numeroApolice, dataInicioVigencia, cliente, dataFimVigencia, veiculo);
                result.add(seguro);
            }
            connection.close();
        } catch (SQLException e) {
            throw new ClienteDaoException("Erro ao ler seguros.");
        }
        return result;
    }

    @Override
    public void update(Seguro seguro) {
        String sql = "UPDATE SEGURO SET valorParcelaSeguro = ?, dataInicioVigencia = ?, dataFimVigencia = ?WHERE numeroApolice = ?";
        try{
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1, seguro.getValorParcelaSeguro());
            pstmt.setDate(2, java.sql.Date.valueOf(seguro.getDataInicioVigencia()));
            pstmt.setDate(3, java.sql.Date.valueOf(seguro.getDataFimVigencia()));
            pstmt.setString(4, seguro.getNumeroApolice());


            int linhasAlteradas = pstmt.executeUpdate();
            // Verifica se o CPF foi encontrado e deletado
            if (linhasAlteradas == 0) {
                throw new SeguroDaoException("Seguro não existe no banco.");
            }
            connection.close();
        }catch(SQLException e) {
            throw new SeguroDaoException("Erro ao atualizar seguro.");
        }
    }

    @Override
    public void delete(String apolice) {
        String sql = "DELETE FROM SEGURO WHERE numeroApolice = ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            int linhasAlteradas = pstmt.executeUpdate();
            if (linhasAlteradas == 0) {
                throw new SeguroDaoException("Seguro não encontrado no banco de dados.");
            }
            connection.close();
        } catch (SQLException e) {
            throw new SeguroDaoException("Erro ao deletar seguro.");
        }
    }
    }

