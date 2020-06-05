package com.trabalhoverival.app;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FatorialTest {
  private Somador somador;
  private Fatorial fatorial;
  private Multiplicador multiplicador;
  private Numero numero;

  @BeforeEach
  public void setUp() {
    somador = new Somador();
    multiplicador = new Multiplicador(somador);
    fatorial = new Fatorial(multiplicador);
  }

  @Test
  public void factorizationWithNegativeFactorialTest() {
    numero = new Numero(-5);

    Exception exception = assertThrows(IllegalArgumentException.class, () -> {
      fatorial.fatorial(numero);
    });

    final String expectedMessage = "Only positive numbers are allowed.";
    final String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
  }

  @Test
  public void factorizationWithFactorialEqualToZeroTest() {
    numero = new Numero(0);

    final int expected = 1;
    final int actual = fatorial.fatorial(numero).resultado.resultado().valor();

    assertEquals(expected, actual);
  }

  @Test
  public void factorizationWithPositiveFactorialTest() {
    numero = new Numero(9);

    final int expected = 362880;
    final int actual = fatorial.fatorial(numero).resultado.resultado().valor();

    assertEquals(expected, actual);
  }

  @Test
  public void resultTest() {
    numero = new Numero(5);

    fatorial.fatorial(numero);

    final int expected = 120;
    final int actual = fatorial.resultado().valor();

    assertEquals(expected, actual);
  }
}