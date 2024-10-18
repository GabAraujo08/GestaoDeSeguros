package org.example.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private final String url;
    private final String user;
    private final String password;
    private Connection connection;

    private DatabaseConfig(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }


    /**
     * Método que retorna uma conexão com o banco de dados, caso a conexão esteja fechada ou nula, uma nova conexão é criada.
     * @return Connection.
     */
    public Connection getConnection() throws SQLException {
        if (this.connection == null || this.connection.isClosed()) {
            this.connection = DriverManager.getConnection(url, user, password);
        }
        return this.connection;
    }
    /**
     * Método que fecha a conexão com o banco de dados.
     * @throws SQLException se ocorrer um erro ao fechar a conexão
     */
    public void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }
}
