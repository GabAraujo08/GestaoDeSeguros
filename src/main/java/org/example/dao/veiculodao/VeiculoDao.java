package org.example.dao.veiculodao;

import org.example.entities.veiculo.Veiculo;

import java.util.List;

public interface VeiculoDao {
    void create(Veiculo veiculo);

    List<Veiculo> readAll();

    void update(Veiculo veiculo);

    void delete(String placa);
}
