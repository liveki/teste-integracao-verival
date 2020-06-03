package com.trabalhoverival.app;

public class Fatorial {
    Multiplicador resultado;

    public Fatorial(Multiplicador multiplicador) {
        this.resultado = multiplicador;
    }

    public Fatorial fatorial(Numero numero) throws IllegalArgumentException {

        if (numero.valor() < 0) {
            throw new IllegalArgumentException("Only positive numbers are allowed.");
        }

        if (numero.valor() == 0) {
            this.resultado.set(new Numero(1));
            return this;
        }

        resultado.set(numero);
        Numero aux = numero.duplica();

        while (aux.valor() > 1) {
            resultado.vezes(aux.dec());
        }

        return this;
    }

}