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
        resultado.set(valor.duplica());
        valor.dec();
        while (valor.valor() > 0) {
            resultado.vezes(valor);
            valor.dec();
        }

        return this;
    }

    public Numero resultado() {
        return this.resultado.resultado();
    }

}