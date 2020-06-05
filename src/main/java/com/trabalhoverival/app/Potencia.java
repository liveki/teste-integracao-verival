package com.trabalhoverival.app;

public class Potencia {
    Multiplicador resultado;

    public Potencia(Multiplicador multiplicador) {
        this.resultado = multiplicador;
    }

    public void potencia(Numero numero) {
        int base = this.resultado.resultado().valor();
        int exponent = numero.valor();
        this.resultado.resultado().abs();
        // verifica se a potencia é de zero
        if (exponent == 0) { 
            resultado.set(new Numero(1));
        }
        // se potencia é negativa, inverte e divide
        if (exponent < 0) {
            this.resultado.set(new Numero(1/this.resultado.resultado().valor()));
            return;
        }
        // copia numero a ser multiplicado
        Numero n = new Numero(resultado.resultado().valor());
        // calcula o numero
        while (numero.valor() > 1) {
            resultado.vezes(n);
            numero.dec();
        }
        // verifica se a base é negativa e se o expoente é impar
        // se sim, resultado do calculo é negativo
        if (base < 0 && exponent % 2 != 0) {
            this.resultado.set(new Numero(this.resultado.resultado().valor()*(-1)));
        }
    }

    public Numero resultado() {
        return this.resultado.resultado();
    }
}