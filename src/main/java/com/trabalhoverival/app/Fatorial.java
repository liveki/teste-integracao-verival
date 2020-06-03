package com.trabalhoverival.app;

public class Fatorial {
    Multiplicador resultado;

    public Fatorial(Multiplicador multiplicador) {
        this.resultado = multiplicador;
    }

    public Fatorial fatorial(Numero valor) throws IllegalArgumentException {
        if (valor.valor() < 0) { 
            throw new IllegalArgumentException("Fatorial de número negativo não existe.");
        }
        if (valor.valor() == 0) { 
            this.resultado.set(new Numero(1));
        }

        //

        return this;
    }

    private Integer fat(Integer val) {
        if (val <= 1) { return 1; }
        return val * fat(val-1);
    }

}