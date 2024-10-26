package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testes na conta bancária")
class ContaBancariaTest {

    @Nested
    class Saldo {
        @Test
        @DisplayName("Dado um saldo inicial, quando criar uma conta bancária, então deve criar uma conta bancária")
        void shouldCreateBankAccount() {
            BigDecimal saldoInicial = new BigDecimal(10);
            ContaBancaria conta = new ContaBancaria(saldoInicial);
            assertInstanceOf(ContaBancaria.class, conta);
        }

        @Test
        @DisplayName("Dado um saldo inicial nulo, quando criar uma conta bancária, então deve lançar uma exceção")
        void shouldThrowExceptionWhenBalanceIsNull() {
            assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(null));
        }

        @Test
        @DisplayName("Dado um saldo inicial negativo, quando criar uma conta bancária, então deve lançar uma exceção")
        void shouldThrowExceptionWhenBalanceIsNegative() {
            assertThrows(IllegalArgumentException.class, () -> new ContaBancaria(new BigDecimal(-10)));
        }

        @Test
        @DisplayName("Dado uma conta bancária, quando consultar o saldo, então deve retornar o saldo da conta")
        void shouldReturnBalance() {
            BigDecimal saldoInicial = new BigDecimal(10);
            ContaBancaria conta = new ContaBancaria(saldoInicial);
            assertEquals(saldoInicial, conta.saldo());
        }
    }

    @Nested
    class Saque {
        @Test
        @DisplayName("Dado uma conta bancária com um saldo inicial, quando efetuar um saque, então deve debitar o valor do saque do saldo")
        void shouldWithdrawAmount() {
            ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
            conta.saque(new BigDecimal(5));
            assertEquals(new BigDecimal(5), conta.saldo());
        }

        @Test
        @DisplayName("Dado uma conta bancária com um saldo inicial, quando efetuar um saque, então deve lançar uma exceção quando o saldo for insuficiente")
        void shouldThrowExceptionWhenBalanceIsInsufficient() {
            ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
            assertThrows(RuntimeException.class, () -> conta.saque(new BigDecimal(20)));
        }

        @Test
        @DisplayName("Dado uma conta bancária com um saldo inicial, quando efetuar um saque, então deve lançar uma exceção quando o valor do saque for nulo")
        void shouldThrowExceptionWhenWithdrawalAmountIsNull() {
            ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
            assertThrows(IllegalArgumentException.class, () -> conta.saque(null));
        }

        @Test
        @DisplayName("Dado uma conta bancária com um saldo inicial, quando efetuar um saque, então deve lançar uma exceção quando o valor do saque for zero")
        void shouldThrowExceptionWhenWithdrawalAmountIsZero() {
            ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
            assertThrows(IllegalArgumentException.class, () -> conta.saque(BigDecimal.ZERO));
        }

        @Test
        @DisplayName("Dado uma conta bancária com um saldo inicial, quando efetuar um saque, então deve lançar uma exceção quando o valor do saque for negativo")
        void shouldThrowExceptionWhenWithdrawalAmountIsNegative() {
            ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
            assertThrows(IllegalArgumentException.class, () -> conta.saque(new BigDecimal(-5)));
        }
    }

    @Nested
    class Deposito {
        @Test
        @DisplayName("Dado uma conta bancária com um saldo inicial, quando efetuar um depósito, então deve creditar o valor do depósito no saldo")
        void shouldDepositAmount() {
            ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
            conta.deposito(new BigDecimal(10));
            assertEquals(new BigDecimal(20), conta.saldo());
        }

        @Test
        @DisplayName("Dado uma conta bancária com um saldo inicial, quando efetuar um depósito, então deve lançar uma exceção quando o valor do depósito for nulo")
        void shouldThrowExceptionWhenDepositAmountIsNull() {
            ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
            assertThrows(IllegalArgumentException.class, () -> conta.deposito(null));
        }

        @Test
        @DisplayName("Dado uma conta bancária com um saldo inicial, quando efetuar um depósito, então deve lançar uma exceção quando o valor do depósito for zero")
        void shouldThrowExceptionWhenDepositAmountIsZero() {
            ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
            assertThrows(IllegalArgumentException.class, () -> conta.deposito(BigDecimal.ZERO));
        }

        @Test
        @DisplayName("Dado uma conta bancária com um saldo inicial, quando efetuar um depósito, então deve lançar uma exceção quando o valor do depósito for negativo")
        void shouldThrowExceptionWhenDepositAmountIsNegative() {
            ContaBancaria conta = new ContaBancaria(new BigDecimal(10));
            assertThrows(IllegalArgumentException.class, () -> conta.deposito(new BigDecimal(-5)));
        }
    }

}