package com.example.atividadeintegrais.calculos;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Integrais implements IntegracaoNumerica {

    @Override
    public double calculaResultadoDaExpressao(String expressao, double valor) {
        Expression e = new ExpressionBuilder(expressao)
                .variable("x")
                .build()
                .setVariable("x", valor);

        return e.evaluate();
    }

    @Override
    public double regraDoTrapezioSimples(double limiteInferior, double limiteSuperior, String expressao) {
        double altura = limiteSuperior - limiteInferior;
        double y1, y2;

        y1 = calculaResultadoDaExpressao(expressao, limiteInferior);
        y2 = calculaResultadoDaExpressao(expressao, limiteSuperior);

        return (altura * (y1 + y2))/2;
    }

    @Override
    public double regraDoTrapezioComposta(double limiteInferior, double limiteSuperior, String expressao, int trapezios) {
        double altura = (limiteSuperior - limiteInferior) / trapezios;
        double resultado = 0;

        for(int i = 0; i < trapezios; i++){
            resultado += regraDoTrapezioSimples((limiteInferior + (altura * i)), (limiteInferior + (altura * (i + 1))), expressao);
        }
        return resultado;
    }

    @Override
    public double primeiraRegraDeSimpson(double limiteInferior, double limiteSuperior, String expressao) {
        double altura = (limiteSuperior - limiteInferior) / 2;
        double y1, y2, y3;
        double x2 = limiteInferior + altura;

        y1 = calculaResultadoDaExpressao(expressao, limiteInferior);
        y2 = calculaResultadoDaExpressao(expressao, x2);
        y3 = calculaResultadoDaExpressao(expressao, limiteSuperior);

        return altura * (y1 + (4 * y2) + y3) / 3;
    }

    @Override
    public double primeiraRegraDeSimpsonComMaisDeDoisSubintervalos(double limiteInferior, double limiteSuperior, String expressao, int paresDeSubintervalos) {
        double altura = (limiteSuperior - limiteInferior) / (2 * paresDeSubintervalos);
        double resultado = 0;

        for(int i = 0; i < paresDeSubintervalos; i++){
            double left = (limiteInferior + (2 * altura * i));
            double right = left + (2 * altura);
            resultado += primeiraRegraDeSimpson(left, right, expressao);
        }

        return resultado;
    }

    @Override
    public double segundaRegraDeSimpson(double limiteInferior, double limiteSuperior, String expressao) {
        double altura = (limiteSuperior - limiteInferior) / 3;
        double y1, y2, y3, y4;

        y1 = calculaResultadoDaExpressao(expressao, limiteInferior);
        y2 = calculaResultadoDaExpressao(expressao, limiteInferior + altura);
        y3 = calculaResultadoDaExpressao(expressao, limiteSuperior - altura);
        y4 = calculaResultadoDaExpressao(expressao, limiteSuperior);

        return 3 * altura * (y1 + (3 * y2) + (3 * y3) + y4) / 8;
    }

    @Override
    public double segundaRegraDeSimpsonComMaisDeTresSubintervalos(double limiteInferior, double limiteSuperior, String expressao, int trioDeSubintervalos) {
        double altura = (limiteSuperior - limiteInferior) / (3 * trioDeSubintervalos);
        double resultado = 0;

        for(int i = 0; i < trioDeSubintervalos; i++){
            double left = (limiteInferior + (3 * altura * i));
            double right = left + (3 * altura);
            resultado += primeiraRegraDeSimpson(left, right, expressao);
        }

        return resultado;
    }
}
