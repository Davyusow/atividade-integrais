package com.example.atividadeintegrais;

import com.example.atividadeintegrais.controller.Conversor;
import com.example.atividadeintegrais.model.Funcao;

public class Testes {
    public static void main(String[] args) {
        Funcao funcao = new Funcao("2x+3-x","x",10);
        var resultado =  Conversor.converterParaDouble(funcao);
        System.out.printf("O resultado da expressão %s, quando x é igual a %.0f é %.0f\n",funcao.getExpressao(),funcao.getValor(),resultado);
    }
}
