package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes na conta bancária")
class ContaBancariaTest {

    @Test
    @DisplayName("Deve criar uma conta bancária com um saldo inicial")
    void shouldCreateBankAccount() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
        assertInstanceOf(ContaBancaria.class, conta);
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando o saldo inicial for nulo")
    void shouldThrowExceptionWhenBalanceIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(null));
    }

    @Test
    @DisplayName("Deve sacar um valor de uma conta bancária")
    void shouldWithdrawAmount() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
        conta.saque(new BigDecimal(5));
        assertEquals(new BigDecimal(5), conta.saldo());
    }

    @Test
    @DisplayName("Deve lançar uma exceção quando o saldo for insuficiente para o saque")
    void shouldThrowExceptionWhenBalanceIsInsufficient() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
        assertThrows(RuntimeException.class, () -> conta.saque(new BigDecimal(20)));
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando o valor do saque for nulo")
    void shouldThrowExceptionWhenWithdrawalAmountIsNull() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
        assertThrows(IllegalArgumentException.class, () -> conta.saque(null));
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando o valor do saque for zero")
    void shouldThrowExceptionWhenWithdrawalAmountIsZero() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
        assertThrows(IllegalArgumentException.class, () -> conta.saque(BigDecimal.ZERO));
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando o valor do saque for negativo")
    void shouldThrowExceptionWhenWithdrawalAmountIsNegative() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
        assertThrows(IllegalArgumentException.class, () -> conta.saque(new BigDecimal(-5)));
    }

    @Test
    @DisplayName("Deve depositar um valor em uma conta bancária")
    void shouldDepositAmount() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
        conta.deposito(new BigDecimal(10));
        assertEquals(new BigDecimal(20), conta.saldo());
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando o valor do depósito for nulo")
    void shouldThrowExceptionWhenDepositAmountIsNull() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
        assertThrows(IllegalArgumentException.class, () -> conta.deposito(null));
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando o valor do depósito for zero")
    void shouldThrowExceptionWhenDepositAmountIsZero() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
        assertThrows(IllegalArgumentException.class, () -> conta.deposito(BigDecimal.ZERO));
    }

    @Test
    @DisplayName("Deve lançar IllegalArgumentException quando o valor do depósito for negativo")
    void shouldThrowExceptionWhenDepositAmountIsNegative() {
        ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
        assertThrows(IllegalArgumentException.class, () -> conta.deposito(new BigDecimal(-5)));
    }
}