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
<<<<<<< HEAD

        resultado.set(numero);
        Numero aux = numero.duplica();
=======
        resultado.set(valor.duplica());
        valor.dec();
        while (valor.valor() > 0) {
            resultado.vezes(valor);
            valor.dec();
        }
>>>>>>> 09798eb22eb3435da1d28c14cd6eeea37a089985

        while (aux.valor() > 1) {
            resultado.vezes(aux.dec());
        }

<<<<<<< HEAD
        return this;
=======
    public Numero resultado() {
        return this.resultado.resultado();
>>>>>>> 09798eb22eb3435da1d28c14cd6eeea37a089985
    }

}