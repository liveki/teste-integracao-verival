package com.trabalhoverival.app;

public class App {
    public static void main(String[] args) {
        Somador somador = new Somador();
        Multiplicador multiplicador = new Multiplicador(somador);
        Numero numero = new Numero(-10);
        multiplicador.set(numero);
        final Multiplicador resultado = multiplicador.vezes(new Numero(-9));

        System.out.println(resultado.resultado().valor());
    }
}
