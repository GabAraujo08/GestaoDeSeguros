package org.example.dao.segurodao;

import org.example.config.DatabaseConfig;
import org.example.entities.seguro.Seguro;
import org.example.exceptions.ClienteDaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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
            throw new SeguroDaoException("Erro ao criar usuário.");
        }
    }

    @Override
    public List<Seguro> readAll(String placa) {

    }

    @Override
    public void update(Seguro seguro) {

    }

    @Override
    public void delete(String apolice) {

    }
}
