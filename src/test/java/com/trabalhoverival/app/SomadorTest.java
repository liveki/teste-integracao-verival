package com.trabalhoverival.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomadorTest {
  Somador somador;
  Numero numero;

  @BeforeEach
  public void setUp() {
    somador = new Somador();
  }

  @Test
  void setPositiveNumberTest() {
    numero = new Numero(10);
    somador.set(numero);

    final int expected = 10;
    final int actual = somador.resultado().valor();

    assertEquals(expected, actual);
  }

  @Test
  void setNegativeNumberTest() {
    numero = new Numero(-18);
    somador.set(numero);

    final int expected = -18;
    final int actual = somador.resultado().valor();

    assertEquals(expected, actual);
  }

  @Test
  void sumWithPositiveNumberTest() {
    numero = new Numero(-18);
    somador.set(numero);
    somador.mais(new Numero(-8));

    final int expected = -10;
    final int actual = somador.resultado().valor();

    assertEquals(expected, actual);
  }

  @Test
  void sumWithNegativeNumberTest() {
    numero = new Numero(25);
    somador.set(numero);
    somador.mais(new Numero(-19));

    final int expected = 44;
    final int actual = somador.resultado().valor();

    assertEquals(expected, actual);
  }

  @Test
  void subtractionWithPositiveNumberTest() {
    numero = new Numero(-25);
    somador.set(numero);
    somador.menos(new Numero(30));

    final int expected = -55;
    final int actual = somador.resultado().valor();

    assertEquals(expected, actual);
  }

  void subtractionWithNegativeNumberTest() {
    numero = new Numero(30);
    somador.set(numero);
    somador.menos(new Numero(-30));

    final int expected = 0;
    final int actual = somador.resultado().valor();

    assertEquals(expected, actual);
  }

}