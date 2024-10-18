package org.example.service.cliente;

public class ClienteServiceFactory {
    private ClienteServiceFactory() {
    }

    public static ClienteService create() {
        return new ClienteServiceImpl();
    }
}
