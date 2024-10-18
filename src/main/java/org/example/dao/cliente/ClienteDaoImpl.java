package org.example.dao.cliente;

import org.example.config.DatabaseConfig;
import org.example.entities.cliente.Cliente;
import org.example.exceptions.cliente.ClienteAlreadyExistsException;
import org.example.exceptions.cliente.ClienteDaoException;
import org.example.exceptions.cliente.ClienteNotFoundException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDaoImpl implements ClienteDao{

    private DatabaseConfig db;

    @Override
    public Cliente create(Cliente cliente) throws ClienteAlreadyExistsException {
        if(existsClienteByCpf(cliente.getCpf())){
            throw new ClienteAlreadyExistsException("Usuário já existe.");
        }
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
            return cliente;
        }catch (SQLException e){
            throw new ClienteDaoException("Erro ao criar usuário.");
        }
    }

    @Override
    public List<Cliente> readAll() throws ClienteDaoException{
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
                throw new ClienteDaoException("Erro ao ler usuários.");
            }
            return result;
        }
    

    @Override
    public Cliente update(Cliente cliente) throws ClienteNotFoundException{
        if(!existsClienteByCpf(cliente.getCpf())){
            throw new ClienteNotFoundException("Usuário não existe..");
        }
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

            connection.close();
            return cliente;
        }catch(SQLException e) {
            throw new ClienteDaoException("Erro ao atualizar usuário.");
        }
    }

    @Override
    public void delete(String cpf) throws ClienteNotFoundException{
        if(!existsClienteByCpf(cpf)){
            throw new ClienteNotFoundException("Usuário já existe.");
        }
        String sql = "DELETE FROM CLIENTE WHERE cpf = ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            int linhasAlteradas = pstmt.executeUpdate();
            if (linhasAlteradas == 0) {
                throw new ClienteNotFoundException("Usuário não encontrado.");
            }
            connection.close();
        } catch (SQLException e) {
            throw new ClienteDaoException("Erro ao deletar usuário.");
        }
    }

    @Override
    public Boolean existsClienteByCpf(String cpf) throws ClienteDaoException {
        String sql = "SELECT * FROM CLIENTE WHERE cpf = ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();
            Boolean result = rs.next();
            connection.close();
            return result;
        } catch (SQLException e) {
            throw new ClienteDaoException("Erro ao verificar se usuário existe.");
        }
    }


    @Override
    public Cliente findByCpf(String cpf) throws ClienteNotFoundException {
        String sql = "SELECT * FROM CLIENTE WHERE cpf = ?";
        try {
            Connection connection = db.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, cpf);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String cep = rs.getString("cep");
                String estado = rs.getString("estado");
                String cidade = rs.getString("cidade");
                String logradouro = rs.getString("logradouro");
                String numLogradouro = rs.getString("numLogradouro");
                String telefone = rs.getString("telefone");
                Cliente cliente = new Cliente(nome, cpf, cep, estado, cidade, logradouro, numLogradouro, telefone);
                connection.close();
                return cliente;
            } else {
                throw new ClienteNotFoundException("Usuário não encontrado.");
            }
        } catch (SQLException e) {
            throw new ClienteNotFoundException("Erro ao buscar usuário.");
        }
    }
}
