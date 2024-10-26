package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.algaworks.junit.utilidade.SaudacaoUtil.saudar;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes no utilitário de saudação")
class SaudacaoUtilTest {

    @Test
    @DisplayName("Dado um horário matutino, Quando saudar, Então deve retornar bom dia")
    public void saudarBomDia() {
        int horaValida = 9;
        String saudacao = saudar(horaValida);
        assertEquals("Bom dia", saudacao, "Saudação incorreta");
    }

    @Test
    @DisplayName("Dado um horário vespertino, Quando saudar, Então deve retornar boa tarde")
    public void saudarBoaTarde() {
        int horaValida = 14;
        String saudacao = saudar(horaValida);
        assertEquals("Boa tarde", saudacao, "Saudação incorreta");
    }

    @Test
    @DisplayName("Dado um horário noturno, Quando saudar, Então deve retornar boa noite")
    public void saudarBoaNoite() {
        int horaValida = 22;
        String saudacao = saudar(horaValida);
        assertEquals("Boa noite", saudacao, "Saudação incorreta");
    }

    @Test
    @DisplayName("Dado um horário inválido, Quando saudar, Então deve lançar uma exceção")
    public void deveLancarException() {
        int horaInvalida = -10;
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> saudar(horaInvalida));
        assertEquals("Hora inválida", e.getMessage());
    }

    @Test
    @DisplayName("Dado um horário válido, Quando saudar, Então não deve lançar  uma exceção")
    public void naoDeveLancarException() {
        int horaValida = 0;
        assertDoesNotThrow(() -> saudar(horaValida));
    }

}