package com.trabalhoverival.app;

public class Fibonatti {
    Somador somador;

    public Fibonatti(Somador somador) {
        this.somador = somador;
    }

    public Fibonatti fibonatti(Numero numero) throws IllegalArgumentException{
        if (numero.valor() < 0) {
            throw new IllegalArgumentException("Negative values not allowed");
        }
        if (numero.valor() == 0 || numero.valor() == 1) {
            this.somador.set(numero);
            return this;
        }
        this.somador.set(new Numero(0));
        Numero n2 = new Numero(0), n1 = new Numero(1), n0 = new Numero(0); 
        while (numero.valor() > 0) {
            // sets the current value
            somador.set(new Numero(0));
            somador.mais(n2);
            somador.mais(n1);
            // upddates the n1 and n2 variables
            somador.set(new Numero(0));

            numero.dec();
        }
        // f1 = f(n-1) + f(n+2)

        return this;
    }

    public Numero resultado() {
        return this.somador.resultado();
    }

    
}