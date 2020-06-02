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
    outro = outro.duplica();
    outro = outro.abs();
    final int multiplicador = outro.valor();

    for (outro.valor(); outro.valor() > 0; outro.dec()) {
      for (int j = 0; j < multiplicador; j++) {
        resultado.resultado().inc();
      }
    }

    return this;
  }

  public Numero resultado() {
    return resultado.resultado();
  }
}