package com.example.atividadeintegrais.controller;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class Conversor {
    /**
     * Converte uma String para um valor double
     *
     * @param expressao é o String da expressão a ser passado;
     * @param variavel é a String da variável Ex: 'x' em "2x+1";
     * @param valor é a entrada da variável, Ex: em uma expressão "2x+1", se o valor é 4,então seria f(4) = 2.4+1;
     *
     * @return resultado da expressão
     */
    public static Double converterParaDouble(String expressao,String variavel, double valor) {
        Expression e = new ExpressionBuilder(expressao).variable(variavel).build().setVariable(variavel,valor);
        //cria uma expressão com o construtor de expressões, com a variável passada mos argumentos asd
        return e.evaluate();
    }
}
