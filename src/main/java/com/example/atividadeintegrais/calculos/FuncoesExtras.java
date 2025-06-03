package com.example.atividadeintegrais.calculos;

import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.function.Function;

public class FuncoesExtras {

    public static final Function SEN = new Function("sen",1) {
        @Override
        public double apply(double... doubles) {
            return Math.sin(Math.toRadians(doubles[0]));
        }
    };

    public static final Function ARCSEN = new Function("arcsen",1) {
        @Override
        public double apply(double... doubles) {
            return Math.asin(doubles[0]);
        }
    };

    public static final Function ARCCOS = new Function("arccos",1) {
        @Override
        public double apply(double... doubles) {
            return Math.acos(doubles[0]);
        }
    };

    public static final Function ARCTG = new Function("arctg",1) {
        @Override
        public double apply(double... doubles) {
            return Math.atan(doubles[0]);
        }
    };

    public static final Function SEC = new Function("sec",1) {
        @Override
        public double apply(double... doubles) {
            return 1/Math.cos(doubles[0]);
        }
    };

    public static final Function COSSEC = new Function("cossec",1) {
        @Override
        public double apply(double... doubles) {
            return 1/Math.cos(doubles[0]);
        }
    };

    public static final Function COTG = new Function("cotg",1) {
        @Override
        public double apply(double... doubles) {
            return Math.cos(doubles[0])/Math.sin(doubles[0]);
        }
    };

    public static final Function LN = new Function("ln",1) {
        @Override
        public double apply(double... doubles) {
            return Math.log(doubles[0]); //ja considera na base e (euler)
        }
    };

    public static void addFuncoes(ExpressionBuilder builder) {
        builder.function(SEN).function(ARCSEN).function(ARCCOS).function(ARCTG).function(SEC).function(COSSEC).function(COTG).function(LN);
    }
}
