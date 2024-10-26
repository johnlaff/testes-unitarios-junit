package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes na pessoa")
class PessoaTest {

    @Test
    @DisplayName("Deve criar uma pessoa com nome e sobrenome")
    public void assercaoAgrupada() {
        Pessoa pessoa = new Pessoa("Alex", "Silva");

        assertAll("Asserções de pessoa",
                () -> assertEquals("Alex", pessoa.getNome()),
                () -> assertEquals("Silva", pessoa.getSobrenome()));

    }

}