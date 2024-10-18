package org.example.dao.seguro;

public class SeguroDaoFactory {
    private SeguroDaoFactory() {
    }

    public static SeguroDao create() {
        return new SeguroDaoImpl();
    }
}
