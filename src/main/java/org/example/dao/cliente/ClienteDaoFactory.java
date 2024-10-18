package org.example.dao.cliente;

public class ClienteDaoFactory {
    private ClienteDaoFactory() {
    }

    public static ClienteDao create() {
        return new ClienteDaoImpl();
    }
}