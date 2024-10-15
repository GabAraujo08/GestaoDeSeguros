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
                    String cpf = rs.getString("cpf").trim(); // Remove espaços no início e no final
                    cpf = Validadores.removeCaracteresEspeciais(cpf); // Remove caracteres especiais
                    String nome = rs.getString("nm_usuario");
                    String email = rs.getString("email");
                    String senha = rs.getString("senha_login");
                    Date dataNascimento = rs.getDate("dt_nasc");
                    String numeroUsuario = rs.getString("nr_usuario");
                    String endereco = rs.getString("endereco_usuario");
                    Usuario usuario = new Usuario(nome, email, senha, cpf);
                /*
                 Essa parte do código é responsável por verificar se os campos
                 estão nulos, e caso não estejam, setar os valores no objeto,
                 isso evita que caso os campos estejam nulos, a aplicação tente
                 setar um valor nulo no objeto, o que geraria um erro.
                 */
                    if (dataNascimento != null) {
                        usuario.setDataNascimento(dataNascimento.toString());
                    }
                    if (numeroUsuario != null) {
                        usuario.setTelefone(numeroUsuario);
                    }
                    if (endereco != null) {
                        usuario.alterarEndereco(endereco);
                    }
                    result.add(usuario);

                }
                connection.close();
            }catch(SQLException e){
                //e.printStackTrace();
                throw new UsuarioDaoException("Erro ao ler usuários.");
            }
            return result;
        }
    

    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public void delete(String cpf) {

    }
}
