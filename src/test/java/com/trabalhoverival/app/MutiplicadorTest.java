package com.trabalhoverival.app;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MutiplicadorTest {
  private Somador somador;
  private Numero numero;
  private Multiplicador multiplicador;

  @BeforeEach
  public void setUp() {
    somador = new Somador();
    multiplicador = new Multiplicador(somador);
  }

  @Test
  public void multiplicationWithMultiplierEqualToOneTest() {
    numero = new Numero(10);
    multiplicador.set(numero);

    Numero outroNumero = new Numero(1);

    final int expected = 10;
    final int actual = multiplicador.vezes(outroNumero).resultado().valor();

    assertEquals(expected, actual);
  }

  @Test
  public void multiplicationWithActualValueEqualToOneTest() {
    numero = new Numero(1);
    multiplicador.set(numero);

    Numero outroNumero = new Numero(15);

    final int expected = 15;
    final int actual = multiplicador.vezes(outroNumero).resultado().valor();

    assertEquals(expected, actual);
  }

  @Test
  public void multiplicationWithMultiplierEqualToZeroTest() {
    numero = new Numero(25);
    multiplicador.set(numero);

    Numero outroNumero = new Numero(0);

    final int expected = 0;
    final int actual = multiplicador.vezes(outroNumero).resultado().valor();

    assertEquals(expected, actual);
  }

  @Test
  public void multiplicationWithActualValueEqualToZeroTest() {
    numero = new Numero(0);
    multiplicador.set(numero);

    Numero outroNumero = new Numero(31);

    final int expected = 0;
    final int actual = multiplicador.vezes(outroNumero).resultado().valor();

    assertEquals(expected, actual);
  }

  @Test
  public void multiplicationWithNegativeMultiplierTest() {
    numero = new Numero(10);
    multiplicador.set(numero);

    Numero outroNumero = new Numero(-5);

    final int expected = -50;
    final int actual = multiplicador.vezes(outroNumero).resultado().valor();

    assertEquals(expected, actual);
  }

  @Test
  public void multiplicationWithNegativeCurrentValueTest() {
    numero = new Numero(-10);
    multiplicador.set(numero);

    Numero outroNumero = new Numero(5);

    final int expected = -50;
    final int actual = multiplicador.vezes(outroNumero).resultado().valor();

    assertEquals(expected, actual);
  }

  @Test
  public void multiplicationWithNegativeMultiplierAndCurrentValueTest() {
    numero = new Numero(-5);
    multiplicador.set(numero);

    Numero outroNumero = new Numero(-5);

    final int expected = 25;
    final int actual = multiplicador.vezes(outroNumero).resultado().valor();

    assertEquals(expected, actual);
  }

  @Test
  public void multiplicationWithPositiveMultiplierAndCurrentValueTest() {
    numero = new Numero(6);
    multiplicador.set(numero);

    Numero outroNumero = new Numero(25);

    final int expected = 150;
    final int actual = multiplicador.vezes(outroNumero).resultado().valor();

    assertEquals(expected, actual);
  }

  @Test
  public void divisionByZeroTest() {
    numero = new Numero(5);
    multiplicador.set(numero);
    Numero outroNumero = new Numero(0);

    Exception exception = assertThrows(ArithmeticException.class, () -> {
      multiplicador.dividido(outroNumero);
    });

    final String expected = "Impossible to divide by zero";
    final String actual = exception.getMessage();

    assertTrue(actual.contains(expected));
  }

  @Test
  public void divisionWithDenominatorEqualsToZeroTest() {
    numero = new Numero(0);
    multiplicador.set(numero);
    Numero outro = new Numero(10);

    final int expected = 0;
    final int actual = multiplicador.dividido(outro).resultado().valor();

    assertEquals(expected, actual);
  }

  // Testa se um numero positivo é dividido por um menor e positivo que ele
  @Test
  public void divisionWithPositiveDividentGreaterThanPositiveDenominatorTest() {
    numero = new Numero(10);
    multiplicador.set(numero);
    Numero outro = new Numero(2);

    final int expected = 5;
    final int actual = multiplicador.dividido(outro).resultado().valor();

    assertEquals(expected, actual);
  }

  // Testa se um numero negativo é dividido por um menor e positivo que ele
  @Test
  public void divisionWithNegativeDividentGreaterThanPositiveDenominatorTest() {
    numero = new Numero(-10);
    multiplicador.set(numero);
    Numero outro = new Numero(2);

    final int expected = -5;
    final int actual = multiplicador.dividido(outro).resultado().valor();

    assertEquals(expected, actual);
  }

  // Testa se um numero positivo é dividido por um menor e negativo que ele
  @Test
  public void divisionWithPositiveDividentGreaterThanNegativeDenominatorTest() {
    numero = new Numero(10);
    multiplicador.set(numero);
    Numero outro = new Numero(-2);

    final int expected = -5;
    final int actual = multiplicador.dividido(outro).resultado().valor();

    assertEquals(expected, actual);
  }

  // Testa se um numero negativo é dividido por um menor e negativo que ele
  @Test
  public void divisionWithNegativeDividentGreaterThanNegativeDenominatorTest() {
    numero = new Numero(-10);
    multiplicador.set(numero);
    Numero outro = new Numero(-2);

    final int expected = 5;
    final int actual = multiplicador.dividido(outro).resultado().valor();

    assertEquals(expected, actual);
  }

  // Testa se um numero positivo é dividido por um maior e positivo que ele
  @Test
  public void divisionWithPositiveDividentSmallerThanPositiveDenominatorTest() {
    numero = new Numero(2);
    multiplicador.set(numero);
    Numero outro = new Numero(10);

    final int expected = 0;
    final int actual = multiplicador.dividido(outro).resultado().valor();

    assertEquals(expected, actual);
  }

  // Testa se um numero negativo é dividido por um maior e positivo que ele
  @Test
  public void divisionWithNegativeDividentSmallerThanPositiveDenominatorTest() {
    numero = new Numero(-2);
    multiplicador.set(numero);
    Numero outro = new Numero(10);

    final int expected = 0;
    final int actual = multiplicador.dividido(outro).resultado().valor();

    assertEquals(expected, actual);
  }

  // Testa se um numero positivo é dividido por um maior e negativo que ele
  @Test
  public void divisionWithPositiveDividentSmallerThanNegativeDenominatorTest() {
    numero = new Numero(2);
    multiplicador.set(numero);
    Numero outro = new Numero(-10);

    final int expected = 0;
    final int actual = multiplicador.dividido(outro).resultado().valor();

    assertEquals(expected, actual);
  }

  // Testa se um numero negativo é dividido por um maior e negativo que ele
  @Test
  public void divisionWithNegativeDividentSmallerThanNegativeDenominatorTest() {
    numero = new Numero(-2);
    multiplicador.set(numero);
    Numero outro = new Numero(-10);

    final int expected = 0;
    final int actual = multiplicador.dividido(outro).resultado().valor();

    assertEquals(expected, actual);
  }
}