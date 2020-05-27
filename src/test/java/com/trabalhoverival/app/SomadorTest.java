package com.trabalhoverival.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SomadorTest {

    Somador somador;
    Numero numero_;

    @BeforeEach
    public void setUp() {
        somador = new Somador();
    }

    @Test
    void positivoSomaPositivo() {
        Numero numero = mock(Numero.class);
        when(numero.valor()).thenReturn(15);
        somador.set(numero);

        when (numero.valor()).thenReturn(1);
        somador.mais(numero);

        final int expected = 16;
        final int actual = somador.resultado().valor();

        assertEquals(expected, actual);

    }

}