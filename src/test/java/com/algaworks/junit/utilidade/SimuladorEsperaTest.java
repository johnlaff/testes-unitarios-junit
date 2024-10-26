package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes no simulador de espera")
class SimuladorEsperaTest {

    @Test
    @DisplayName("Dado um tempo de espera, Quando esperar, Então deve esperar o tempo correto")
    void DeveEsperarENaoDarTimeout() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), ()-> SimuladorEspera.esperar(Duration.ofMillis(10)));
    }
}