package com.trabalhoverival.app;

public class Multiplicador {
  private Somador resultado;

  public Multiplicador(Somador somador) {
    this.resultado = somador;
  }

  public Multiplicador set(Numero valor) {
    this.resultado.set(valor);

    return this;
  }

  public Multiplicador vezes(Numero outro) {
    final int actualValue = resultado().valor();
    final int multiplier = outro.valor();

    // multiplicação com zero deve retornar 0
    if (actualValue == 0 || multiplier == 0) {
      this.resultado.set(new Numero(0));
      return this;
    }

    // multiplicação com um deve retornar o valor atual
    if (multiplier == 1) {
      return this;
    }

    // valor atual igual a 1 deve retornar o multiplicador
    if (actualValue == 1) {
      this.resultado.set(new Numero(multiplier));
      return this;
    }

    this.resultado.set(this.resultado.resultado().abs());

    Numero toSum = new Numero(actualValue);
    Integer aux = outro.abs().valor();

    while (aux > 1) {
      resultado.mais(toSum);
      aux--;
    }

    // verifica se um dos valores tem sinal negativo
    if ((actualValue > 0 && multiplier < 0) || ((actualValue < 0 && multiplier > 0))) {
      this.resultado.set(new Numero(this.resultado.resultado().valor() * (-1)));
    }

    return this;
  }

  public Multiplicador dividido(Numero outro) {
    final int actualValue = resultado().valor();
    final int dividend = outro.valor();
    outro = new Numero(outro.abs().valor());

    if (Math.abs(actualValue) < Math.abs(dividend)) {
      this.resultado.set(new Numero(0));
      return this;
    }

    this.resultado.set(this.resultado.resultado().abs());
    Numero toSum = new Numero(actualValue);
    int aux = 0;

    while (this.resultado.resultado().valor() > 0) {
      this.resultado.menos(outro);
      aux++;
    }


    if ((actualValue > 0 && dividend < 0) || ((actualValue < 0 && dividend > 0))) {
      this.resultado.set(new Numero(aux*-1));
    } else {
      this.resultado.set(new Numero(aux));
    }

    return this;
  }

  public Numero resultado() {
    return resultado.resultado();
  }
}