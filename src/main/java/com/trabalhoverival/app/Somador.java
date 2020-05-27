package com.trabalhoverival.app;

public class Somador {
    private Numero resultado;

    public Somador() {
        this.resultado = new Numero(0);
    }

    public Somador set(Numero numero) {
        this.resultado = numero;
        return this;
    }

    public Somador mais(Numero outro) {
        outro = outro.duplica();
        outro = outro.abs();

        while (outro.valor() > 0) {
            resultado.inc();
            outro.dec();
        }

        return this;
    }

    public Somador menos(Numero outro) {
        outro = outro.duplica();
        outro = outro.abs();

        while (outro.valor() > 0) {
            resultado.dec();
            outro.dec();
        }

        return this;
    }

    public Numero resultado() {
        return resultado;
    }
}