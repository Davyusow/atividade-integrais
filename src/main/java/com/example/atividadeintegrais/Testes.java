package com.example.atividadeintegrais;

import com.example.atividadeintegrais.controller.Conversor;

public class Testes {
    public static void main(String[] args) {
        var expressao = "2x+3-x";
        double valor = 10;
        var resultado =  Conversor.converterParaDouble(expressao,"x",valor);
        System.out.printf("O resultado da expressão %s, quando x é igual a %.0f é %.0f\n",expressao,valor,resultado);
    }
}
