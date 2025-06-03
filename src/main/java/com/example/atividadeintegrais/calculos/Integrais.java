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
}
