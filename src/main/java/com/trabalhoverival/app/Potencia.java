package com.trabalhoverival.app;

public class Potencia {
    Multiplicador resultado;

    public Potencia(Multiplicador multiplicador) {
        this.resultado = multiplicador;
    }

    public void potencia(Numero numero) {
        // verifica se a potencia é de zero
        if (numero.valor() == 0) { 
            resultado.set(new Numero(1));
        }
        // verifica se a potencia é negativa
        Boolean isNegative = numero.valor() < 0;
        // copia numero a ser multiplicado
        Numero n = new Numero(resultado.resultado().valor());
        // calcula o numero
        while (numero.valor() >= 0) {
            resultado.vezes(n);
            numero.dec();
        }
        // se potencia é negativa, inverte e divide
        if (isNegative) {
            this.resultado.set(new Numero(1/this.resultado.resultado().valor()));
        }
    }

    public Numero resultado() {
        return this.resultado.resultado();
    }
}