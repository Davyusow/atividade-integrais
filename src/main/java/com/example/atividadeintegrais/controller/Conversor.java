package com.example.atividadeintegrais.controller;

import com.example.atividadeintegrais.model.Funcao;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class Conversor {
    /**
     * Converte uma String para um valor double
     * @param funcao é uma classe usada para criar as expressões
     * @return resultado da expressão
     */
    public static Double converterParaDouble(Funcao funcao) {
        Expression e = new ExpressionBuilder(funcao.getExpressao()).variable(funcao.getVariavel()).build().setVariable(funcao.getVariavel(), funcao.getValor());
        //cria uma expressão com o construtor de expressões, com a variável passada mos argumentos asd
        return e.evaluate();
    }
}
