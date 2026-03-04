import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaBancariaTest {

    private ContaBancaria conta;

    @BeforeEach
    void setUp() {
        conta = new ContaBancaria();
    }

    @Test
    void deveDepositarValorPositivo() {

        // Arrange
        double valorDeposito = 100.0;

        // Act
        conta.depositar(valorDeposito);

        // Assert
        assertEquals(100.0, conta.consultarSaldo());
    }

    @Test
    void naoDevePermitirDepositoZeroOuNegativo() {

        // Arrange
        double valorInvalido = 0.0;

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            conta.depositar(valorInvalido);
        });
    }

    @Test
    void deveSacarValorDisponivel() {

        // Arrange
        conta.depositar(200.0);

        // Act
        conta.sacar(50.0);

        // Assert
        assertEquals(150.0, conta.consultarSaldo());
    }

    @Test
    void naoDevePermitirSaqueMaiorQueSaldo() {

        // Arrange
        conta.depositar(100.0);

        // Act + Assert
        assertThrows(IllegalArgumentException.class, () -> {
            conta.sacar(200.0);
        });
    }

    @Test
    void deveConsultarSaldoCorretamente() {

        // Arrange
        conta.depositar(300.0);

        // Act
        double saldo = conta.consultarSaldo();

        // Assert
        assertEquals(300.0, saldo);
    }
}
