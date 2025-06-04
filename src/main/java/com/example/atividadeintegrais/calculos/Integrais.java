package com.example.atividadeintegrais.calculos;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Integrais implements IntegracaoNumerica {

    @Override
    public double calculaResultadoDaExpressao(String expressao, double valor) {
        ExpressionBuilder builder = new ExpressionBuilder(expressao);
        FuncoesExtras.addFuncoes(builder);
        Expression e = builder.variable("x")
                .build()
                .setVariable("x", valor);
        return e.evaluate();
    }
    public double calculaResultadoDaExpressao(String expressao) {
        ExpressionBuilder builder = new ExpressionBuilder(expressao);
        FuncoesExtras.addFuncoes(builder);
        Expression e = builder.variable("x")
                .build();
        return e.evaluate();
    }

    @Override
    public double regraDoTrapezioSimples(double limiteInferior, double limiteSuperior, String expressao) {
        double altura = limiteSuperior - limiteInferior;
        double y1 = calculaResultadoDaExpressao(expressao, limiteInferior);
        double y2 = calculaResultadoDaExpressao(expressao, limiteSuperior);

        double resultado = (altura * (y1 + y2)) / 2;
        double erro = erroTrapezioSimples(limiteInferior, limiteSuperior, expressao);
        System.out.println("\n[Trapezio Simples] Erro de truncamento: " + erro);

        return resultado;
    }

    @Override
    public double regraDoTrapezioComposta(double limiteInferior, double limiteSuperior, String expressao, int trapezios) {
        double altura = (limiteSuperior - limiteInferior) / trapezios;
        double resultado = 0;

        for (int i = 0; i < trapezios; i++) {
            resultado += regraDoTrapezioSimples(
                    limiteInferior + (altura * i),
                    limiteInferior + (altura * (i + 1)),
                    expressao
            );
        }

        double erro = erroTrapezioComposta(limiteInferior, limiteSuperior, expressao, trapezios);
        System.out.println("\n[Trapezio Composto] Erro de truncamento: " + erro);

        return resultado;
    }

    @Override
    public double primeiraRegraDeSimpson(double limiteInferior, double limiteSuperior, String expressao) {
        double altura = (limiteSuperior - limiteInferior) / 2;
        double y1 = calculaResultadoDaExpressao(expressao, limiteInferior);
        double y2 = calculaResultadoDaExpressao(expressao, limiteInferior + altura);
        double y3 = calculaResultadoDaExpressao(expressao, limiteSuperior);

        double resultado = altura * (y1 + (4 * y2) + y3) / 3;
        double erro = erroSimpsonComposta(limiteInferior, limiteSuperior, expressao, 2);
        System.out.println("\n[Simpson Simples] Erro de truncamento: " + erro);

        return resultado;
    }

    @Override
    public double primeiraRegraDeSimpsonComMaisDeDoisSubintervalos(double limiteInferior, double limiteSuperior, String expressao, int paresDeSubintervalos) {
        double altura = (limiteSuperior - limiteInferior) / (2 * paresDeSubintervalos);
        double resultado = 0;

        for (int i = 0; i < paresDeSubintervalos; i++) {
            double left = limiteInferior + (2 * altura * i);
            double right = left + (2 * altura);
            resultado += primeiraRegraDeSimpson(left, right, expressao);
        }

        double erro = erroSimpsonComposta(limiteInferior, limiteSuperior, expressao, 2 * paresDeSubintervalos);
        System.out.println("\n[Simpson Composta] Erro de truncamento: " + erro);

        return resultado;
    }

    @Override
    public double segundaRegraDeSimpson(double limiteInferior, double limiteSuperior, String expressao) {
        double altura = (limiteSuperior - limiteInferior) / 3;
        double y1 = calculaResultadoDaExpressao(expressao, limiteInferior);
        double y2 = calculaResultadoDaExpressao(expressao, limiteInferior + altura);
        double y3 = calculaResultadoDaExpressao(expressao, limiteSuperior - altura);
        double y4 = calculaResultadoDaExpressao(expressao, limiteSuperior);

        double resultado = 3 * altura * (y1 + (3 * y2) + (3 * y3) + y4) / 8;

        double erro = erroSimpsonComposta(limiteInferior, limiteSuperior, expressao, 3); // 3 subintervalos
        System.out.println("\n[Simpson 3/8 Simples] Erro de truncamento: " + erro);

        return resultado;
    }

    @Override
    public double segundaRegraDeSimpsonComMaisDeTresSubintervalos(double limiteInferior, double limiteSuperior, String expressao, int trioDeSubintervalos) {
        double altura = (limiteSuperior - limiteInferior) / (3 * trioDeSubintervalos);
        double resultado = 0;

        for (int i = 0; i < trioDeSubintervalos; i++) {
            double left = limiteInferior + (3 * altura * i);
            double right = left + (3 * altura);
            resultado += segundaRegraDeSimpson(left, right, expressao);
        }

        int n = 3 * trioDeSubintervalos;
        double erro = erroSimpsonComposta(limiteInferior, limiteSuperior, expressao, n);
        System.out.println("\n[Simpson 3/8 Composta] Erro de truncamento: " + erro);

        return resultado;
    }

    private double derivadaSegunda(String expressao, double x) {
        double h = 1e-5;
        double fxMaisH = calculaResultadoDaExpressao(expressao, x + h);
        double fx = calculaResultadoDaExpressao(expressao, x);
        double fxMenosH = calculaResultadoDaExpressao(expressao, x - h);
        return (fxMaisH - 2 * fx + fxMenosH) / (h * h);
    }

    private double derivadaQuarta(String expressao, double x) {
        double h = 1e-2;
        double f1 = calculaResultadoDaExpressao(expressao, x - 2 * h);
        double f2 = calculaResultadoDaExpressao(expressao, x - h);
        double f3 = calculaResultadoDaExpressao(expressao, x);
        double f4 = calculaResultadoDaExpressao(expressao, x + h);
        double f5 = calculaResultadoDaExpressao(expressao, x + 2 * h);

        return (f1 - 4 * f2 + 6 * f3 - 4 * f4 + f5) / Math.pow(h, 4);
    }

    private double erroTrapezioSimples(double a, double b, String expressao) {
        double h = b - a;
        double xMeio = (a + b) / 2;
        double derivadaSegunda = derivadaSegunda(expressao, xMeio);
        return -Math.pow(h, 3) / 12 * derivadaSegunda;
    }

    public double erroTrapezioComposta(double a, double b, String expressao, int n) {
        double h = (b - a)/n;
        double maxSegundaDerivada = Math.max(
                Math.abs(derivadaSegunda(expressao, a)),
                Math.abs(derivadaSegunda(expressao, b))
        );
        return -Math.pow(h, 2) * (b - a) / 12 * maxSegundaDerivada;
    }

    private double erroSimpsonComposta(double a, double b, String expressao, int n) {
        if (n % 2 != 0 && n % 3 != 0) {
            throw new IllegalArgumentException("Número de subintervalos precisa ser par (Simpson 1/3) ou múltiplo de 3 (Simpson 3/8).");
        }

        double xMeio = (a + b) / 2;
        double quartaDerivada = derivadaQuarta(expressao, xMeio);
        double h = (b - a) / n;
        return -Math.pow(h, 4) * (b - a) / 180 * quartaDerivada;
    }
}
