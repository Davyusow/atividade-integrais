package com.example.atividadeintegrais.model;

public class Funcao {
    private String Expressao;
    private String variavel;
    private double valor;

    public Funcao(String expressao, String variavel, double valor) {
        this.Expressao = expressao;
        this.variavel = variavel;
        this.valor = valor;
    }

    public String getExpressao() {
        return Expressao;
    }
    public void setExpressao(String expressao) {
        Expressao = expressao;
    }
    public String getVariavel() {
        return variavel;
    }
    public void setVariavel(String variavel) {
        this.variavel = variavel;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    @Override
    public String toString(){
        return "Expressão: \n"+getExpressao()+
                "Tal que "+variavel+" é "+valor;
    }
}
