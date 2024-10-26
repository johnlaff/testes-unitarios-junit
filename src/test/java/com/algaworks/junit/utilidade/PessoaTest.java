package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes na pessoa")
class PessoaTest {

    @Test
    @DisplayName("Dado um nome e sobrenome, Quando criar uma pessoa, Então deve retornar o nome completo")
    public void assercaoAgrupada() {
        Pessoa pessoa = new Pessoa("Alex", "Silva");

        assertAll("Asserções de pessoa",
                () -> assertEquals("Alex", pessoa.getNome()),
                () -> assertEquals("Silva", pessoa.getSobrenome()));

    }

}