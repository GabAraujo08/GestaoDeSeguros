package org.example.entities.veiculo;

import org.example.entities.enums.Marca;
import java.util.Map;


public interface Veiculo<T> {

    /**
     * Retorna o tipo do veículo (ex: Carro, Moto, Caminhão, etc.).
     * @return Uma string que representa o tipo do veículo.
     */
    String getTipo();

    /**
     * Retorna a placa do veículo.
     * @return Uma string que representa a placa do veículo.
     */
    String getPlaca();

    /**
     * Retorna uma descrição detalhada do veículo em formato de mapa chave-valor.
     * @return Um {@code Map} contendo a descrição do veículo.
     */
    Map<String, Object> obterDescricao();

    /**
     * Calcula a depreciação do valor do veículo com base em sua idade, modelo ou outros fatores.
     * @return O valor da depreciação calculado para o veículo.
     */
    double calcularDepreciacao();

    /**
     * Retorna o valor de mercado atual do veículo.
     * @return O valor de mercado como um {@code float}.
     */
    float getValorMercado();

    /**
     * Retorna o ano de fabricação do veículo.
     * @return O ano de fabricação como um inteiro.
     */
    int getAno();

    /**
     * Retorna o modelo do veículo.
     * @return Uma string representando o modelo do veículo.
     */
    String getModelo();

    /**
     * Retorna a marca do veículo.
     * @return Um enum {@link Marca} que representa a marca do veículo.
     */
    Marca getMarca();
}
