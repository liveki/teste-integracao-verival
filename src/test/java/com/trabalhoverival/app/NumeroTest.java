package com.trabalhoverival.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

public class NumeroTest {
  private Numero numero;

  @Test
  public void testNegativeDecrement() {
    numero = new Numero(-7);
    Numero otherNumber = numero.dec();

    final int expected = -8;
    final int obtained = otherNumber.valor();

    Assertions.assertEquals(expected, obtained);
  }

  @Test
  public void testNegativeIncrement() {
    numero = new Numero(-7);
    Numero otherNumber = numero.inc();

    final int expected = -6;
    final int obtained = otherNumber.valor();

    Assertions.assertEquals(expected, obtained);
  }

  @Test
  public void testPositiveDecrement() {
    numero = new Numero(9);
    Numero otherNumber = numero.dec();

    final int expected = 8;
    final int obtained = otherNumber.valor();

    Assertions.assertEquals(expected, obtained);
  }

  @Test
  public void testPositiveIncrement() {
    numero = new Numero(10);
    Numero otherNumber = numero.inc();

    final int expected = 11;
    final int obtained = otherNumber.valor();

    Assertions.assertEquals(expected, obtained);
  }

  @Test
  public void absoluteValue() {
    numero = new Numero(-10);

    Numero otherNumber = numero.abs();

    final int expected = 10;
    final int obtained = otherNumber.valor();

    Assertions.assertEquals(expected, obtained);
  }

  @Test
  public void compareInstances() {
    numero = new Numero(-7);
    Numero otherNumber = numero.duplica();

    final int value1 = numero.valor();
    final int value2 = otherNumber.valor();

    Assertions.assertEquals(value1, value2);
    Assertions.assertFalse(numero == otherNumber);
  }

}