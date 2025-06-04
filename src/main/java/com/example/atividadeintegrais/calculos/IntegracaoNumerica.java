package com.example.atividadeintegrais.calculos;

public interface IntegracaoNumerica {

    public double calculaResultadoDaExpressao(String expressao, double valor);
    public double calculaResultadoDaExpressao(String expressao);

    public double regraDoTrapezioSimples(double limiteInferior, double limiteSuperior, String expressao);

    public double regraDoTrapezioComposta(double limiteInferior, double limiteSuperior, String expressao, int trapezios);

    public double primeiraRegraDeSimpson(double limiteInferior, double limiteSuperior, String expressao);

    public double primeiraRegraDeSimpsonComMaisDeDoisSubintervalos(double limiteInferior, double limiteSuperior, String expressao, int parDeSubintervalos);

    public double segundaRegraDeSimpson(double limiteInferior, double limiteSuperior, String expressao);

    public double segundaRegraDeSimpsonComMaisDeTresSubintervalos(double limiteInferior, double limiteSuperior, String expressao, int trioDeSubintervalos);
}
