package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes no filtro de números")
class FiltroNumerosTest {

    @Test
    @DisplayName("Dado uma lista de números, Quando filtrar por pares, Então deve retornar apenas números pares")
    public void deveRetornarNumerosPares() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);
        List<Integer> numerosParesEsperados = Arrays.asList(2, 4);
        List<Integer> resultadoFiltro = FiltroNumeros.numerosPares(numeros);
        assertIterableEquals(numerosParesEsperados, resultadoFiltro);
    }

    @Test
    @DisplayName("Dado uma lista de números, Quando filtrar por impares, Então deve retornar apenas números impares")
    public void deveRetornarNumerosImpares() {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4);
        List<Integer> numerosImparesEsperados = Arrays.asList(1, 3);
        List<Integer> resultadoFiltro = FiltroNumeros.numerosImpares(numeros);
        assertIterableEquals(numerosImparesEsperados, resultadoFiltro);
    }

}