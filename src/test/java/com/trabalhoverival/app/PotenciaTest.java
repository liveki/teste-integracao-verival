package com.trabalhoverival.app;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PotenciaTest {
    Potencia potencia;
    Multiplicador multiplicador;
    Numero base, expoente;

    @BeforeEach
    public void setUp() {
        this.multiplicador = new Multiplicador(new Somador());
        this.potencia = new Potencia(this.multiplicador);
    }

    @Test
    public void positiveBaseAndPositiveExponentTest() {
        this.base = new Numero(2);
        this.expoente = new Numero(4);

        this.multiplicador.set(base);
        this.potencia.potencia(expoente);

        final int expected = 16;
        final int actual = this.potencia.resultado().valor();

        assertEquals(expected, actual);
    }

    @Test
    public void negativeBaseAndPositiveExponentTest() {
        this.base = new Numero(-2);
        this.expoente = new Numero(4);

        this.multiplicador.set(base);
        this.potencia.potencia(expoente);

        final int expected = 16;
        final int actual = this.potencia.resultado().valor();

        assertEquals(expected, actual);
    }

    @Test
    public void positiveBaseAndNegativeExponentTest() {
        this.base = new Numero(2);
        this.expoente = new Numero(-4);

        this.multiplicador.set(base);
        this.potencia.potencia(expoente);

        final int expected = 0;
        final int actual = this.potencia.resultado().valor();

        assertEquals(expected, actual);
    }

    @Test
    public void negativeBaseAndNegativeExponentTest() {
        this.base = new Numero(-2);
        this.expoente = new Numero(-4);

        this.multiplicador.set(base);
        this.potencia.potencia(expoente);

        final int expected = 0;
        final int actual = this.potencia.resultado().valor();

        assertEquals(expected, actual);
    }

    @Test
    public void exponentEqualsZeroTest() {
        this.base = new Numero(10);
        this.expoente = new Numero(0);

        this.multiplicador.set(base);
        this.potencia.potencia(expoente);

        final int expected = 1;
        final int actual = this.potencia.resultado().valor();

        assertEquals(expected, actual);
    }

    @Test
    public void baseEqualsZero() {
        this.base = new Numero(0);
        this.expoente = new Numero(10);

        this.multiplicador.set(base);
        this.potencia.potencia(expoente);

        final int expected = 0;
        final int actual = this.potencia.resultado().valor();

        assertEquals(expected, actual);
    }

    @Test
    public void negativeBaseAndEvenExponentEqualsPositiveResultTest() {
        this.base = new Numero(-5);
        this.expoente = new Numero(2);

        this.multiplicador.set(base);
        this.potencia.potencia(expoente);

        final int expected = 25;
        final int actual = this.potencia.resultado().valor();

        assertEquals(expected, actual);
    }

    @Test
    public void negativeBaseAndOddExponentTestEqualsNegativeResult() {
        this.base = new Numero(-5);
        this.expoente = new Numero(3);

        this.multiplicador.set(base);
        this.potencia.potencia(expoente);

        final int expected = -125;
        final int actual = this.potencia.resultado().valor();

        assertEquals(expected, actual);
    }
    
    @Test
    public void baseWithExponentEqualsOneIsHimselfTest() {
        this.base = new Numero(15);
        this.expoente = new Numero(1);

        this.multiplicador.set(base);
        this.potencia.potencia(expoente);

        final int expected = 15;
        final int actual = this.potencia.resultado().valor();

        assertEquals(expected, actual);
    }

}