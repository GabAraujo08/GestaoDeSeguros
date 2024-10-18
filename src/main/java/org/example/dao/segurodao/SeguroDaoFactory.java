package org.example.dao.segurodao;

public class SeguroDaoFactory {
    private SeguroDaoFactory() {
    }

    public static SeguroDao create() {
        return new SeguroDaoImpl();
    }
}
