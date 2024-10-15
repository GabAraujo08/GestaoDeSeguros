package org.example.dao.segurodao;

import org.example.entities.cliente.Cliente;
import org.example.entities.seguro.Seguro;
import org.example.entities.veiculo.Veiculo;

import java.util.List;

public interface SeguroDao {

    void create(Seguro seguro);

    List<Seguro> readAll(String placa);

    void update(Seguro seguro);

    void delete(String apolice);


}
