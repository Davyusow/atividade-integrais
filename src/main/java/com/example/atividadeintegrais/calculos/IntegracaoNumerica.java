package com.example.atividadeintegrais.calculos;

public interface IntegracaoNumerica {

    public double calculaResultadoDaExpressao(String expressao, double valor);

    public double regraDoTrapezioSimples(double limiteInferior, double limiteSuperior, String expressao);

    public double regraDoTrapezioComposta(double limiteInferior, double limiteSuperior, String expressao, int trapezios);
}
