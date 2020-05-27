package com.trabalhoverival.app;

public class Numero {
    private Integer valor;

    public Numero(int valor) {
        this.valor = valor;
    }

    public int valor() {
        return valor;
    }

    public Numero inc() {
        valor++;
        return (this);
    }

    public Numero dec() {
        valor--;
        return this;
    }

    public Numero abs() {
        valor = Math.abs(valor);
        return this;
    }

    public Numero duplica() {
        return new Numero(valor);
    }

    public String toString() {
        return valor.toString();
    }
}