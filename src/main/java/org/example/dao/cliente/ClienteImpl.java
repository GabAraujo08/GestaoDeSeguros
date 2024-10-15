package org.example.dao.cliente;

import org.example.config.DatabaseConfig;
import org.example.entities.cliente.Cliente;
import org.example.exceptions.ClienteDaoException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClienteImpl implements ClienteDao{

    private DatabaseConfig db;

    public ClienteImpl(DatabaseConfig db) {
        this.db = db;
    }
    @Override
    public void create(Cliente cliente) {
        String sql = "INSERT INTO CLIENTE(nome, cpf, cep, estado, cidade, logradouro, numLogradouro, telefone) values(?,?,?,?,?,?,?,?)";
        try{
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getCep());
            pstmt.setString(4, cliente.getEstado());
            pstmt.setString(5, cliente.getCidade());
            pstmt.setString(6, cliente.getLogradouro());
            pstmt.setString(7, cliente.getNumLogradouro());
            pstmt.setString(8, cliente.getTelefone());
            pstmt.executeUpdate();
            connection.close();
        }catch (SQLException e){
            throw new ClienteDaoException("Erro ao criar usuário.");
        }
    }

    @Override
    public List<Cliente> readAll() {
            List<Cliente> result = new ArrayList<>();
            String sql = "SELECT * FROM CLIENTE";
            try {
                Connection connection = db.getConnection();
                Statement stmt = connection.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    String nome = rs.getString("nome");
                    String cpf = rs.getString("cpf");
                    String cep = rs.getString("cep");
                    String estado = rs.getString("estado");
                    String cidade = rs.getString("cidade");
                    String logradouro = rs.getString("logradouro");
                    String numLogradouro = rs.getString("numLogradouro");
                    String telefone = rs.getString("telefone");
                    Cliente cliente = new Cliente(nome, cpf, cep, estado, cidade, logradouro, numLogradouro, telefone);
                    result.add(cliente);
                }
                connection.close();
            }catch(SQLException e){
                //e.printStackTrace();
                throw new ClienteDaoException("Erro ao ler usuários.");
            }
            return result;
        }
    

    @Override
    public void update(Cliente cliente) {
        String sql = "UPDATE CLIENTE SET nome = ?, cep = ?, estado = ?, cidade = ?, logradouro = ?, numLogradouro = ?, telefone = ? WHERE cpf = ?";
        try{
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getCep());
            pstmt.setString(4, cliente.getEstado());
            pstmt.setString(5, cliente.getCidade());
            pstmt.setString(6, cliente.getLogradouro());
            pstmt.setString(7, cliente.getNumLogradouro());
            pstmt.setString(8, cliente.getTelefone());

            int linhasAlteradas = pstmt.executeUpdate();
            // Verifica se o CPF foi encontrado e deletado
            if (linhasAlteradas == 0) {
                throw new ClienteDaoException("Usuário não existe no banco.");
            }
            connection.close();
        }catch(SQLException e) {
            throw new ClienteDaoException("Erro ao atualizar usuário.");
        }
    }

    @Override
    public void delete(String cpf) {
        String sql = "DELETE FROM CLIENTE WHERE cpf = ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            int linhasAlteradas = pstmt.executeUpdate();
            if (linhasAlteradas == 0) {
                throw new ClienteDaoException("CPF não encontrado no banco de dados.");
            }
            connection.close();
        } catch (SQLException e) {
            throw new ClienteDaoException("Erro ao deletar usuário.");
        }
    }
}
