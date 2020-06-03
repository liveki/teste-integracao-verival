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

    // multiplicação com zero
    if (resultado.resultado().valor() == 0 || outro.valor() == 0) {
      this.resultado.set(new Numero(0));
      return this;
    }
    // multiplicação com um
    if (outro.valor() == 1) {
      return this;
    }

    // mult com 2 negativos
    // mult com 1 negativo
    Boolean oneNegative = (!(this.resultado.resultado().valor() < 0) && (outro.valor() < 0))
        || ((this.resultado.resultado().valor() < 0) && !(outro.valor() < 0)); // isso é um XOR

    this.resultado.set(this.resultado.resultado().abs());

    Numero toSum = new Numero(resultado.resultado().valor());
    Integer aux = outro.abs().valor();

    while (aux > 1) {
      resultado.mais(toSum);
      aux--;
    }

    if (oneNegative) {
      this.resultado.set(new Numero(this.resultado.resultado().valor() * (-1)));
    }

    return this;
  }

  public Numero resultado() {
    return resultado.resultado();
  }
}