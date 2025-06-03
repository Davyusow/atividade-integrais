package com.example.atividadeintegrais.view;

import com.example.atividadeintegrais.calculos.IntegracaoNumerica;
import com.example.atividadeintegrais.calculos.Integrais;

import java.util.Scanner;

public class View {

    IntegracaoNumerica calculadora = new Integrais();
    Scanner scanner = new Scanner(System.in);

    public void askForInputsTrapezioSimples(){
        String function;
        double limiteInferior, limiteSuperior;
        double resultado;

        System.out.println("\nDigite o limite inferior da integral: ");
        limiteInferior = scanner.nextDouble();

        System.out.println("\nDigite o limite superior da integral: ");
        limiteSuperior = scanner.nextDouble();


        System.out.print("\nDigite a função a ser calculada: ");
        scanner.nextLine(); // limpa buffer (ignore)
        function = scanner.nextLine();

        resultado = calculadora.regraDoTrapezioSimples(limiteInferior, limiteSuperior, function);
        System.out.println("\nResultado: " + resultado);
    }

    public void askForInputsTrapezioComposta(){
        String function;
        double limiteInferior, limiteSuperior;
        int trapezios;
        double resultado;

        System.out.println("\nDigite o limite inferior da integral: ");
        limiteInferior = scanner.nextDouble();

        System.out.println("\nDigite o limite superior da integral: ");
        limiteSuperior = scanner.nextDouble();

        System.out.println("\nDigite a quantidade de trapezios: ");
        trapezios = scanner.nextInt();


        System.out.print("\nDigite a função a ser calculada: ");
        scanner.nextLine(); // limpa buffer (ignore)
        function = scanner.nextLine();

        resultado = calculadora.regraDoTrapezioComposta(limiteInferior, limiteSuperior, function, trapezios);
        System.out.println("\nResultado: " + resultado);
    }

    public void askForInputsPrimeiraRegraDeSimpson(){
        String function;
        double limiteInferior, limiteSuperior;
        double resultado;

        System.out.println("\nDigite o limite inferior da integral: ");
        limiteInferior = scanner.nextDouble();

        System.out.println("\nDigite o limite superior da integral: ");
        limiteSuperior = scanner.nextDouble();

        System.out.print("\nDigite a função a ser calculada: ");
        scanner.nextLine(); // limpa buffer (ignore)
        function = scanner.nextLine();

        resultado = calculadora.primeiraRegraDeSimpson(limiteInferior, limiteSuperior, function);
        System.out.println("\nResultado: " + resultado);
    }

    public void askForInputsPrimeiraRegraDeSimpsonComMaisDeUmParDeSubconjuntos(){
        String function;
        double limiteInferior, limiteSuperior;
        int pares;
        double resultado;

        System.out.println("\nDigite o limite inferior da integral: ");
        limiteInferior = scanner.nextDouble();

        System.out.println("\nDigite o limite superior da integral: ");
        limiteSuperior = scanner.nextDouble();

        System.out.println("\nDigite a quantidade de pares de subconjuntos: ");
        pares = scanner.nextInt();


        System.out.print("\nDigite a função a ser calculada: ");
        scanner.nextLine(); // limpa buffer (ignore)
        function = scanner.nextLine();

        resultado = calculadora.primeiraRegraDeSimpsonComMaisDeDoisSubintervalos(limiteInferior, limiteSuperior, function, pares);
        System.out.println("\nResultado: " + resultado);
    }

    public void askForInputsSegundaRegraDeSimpson(){
        String function;
        double limiteInferior, limiteSuperior;
        double resultado;

        System.out.println("\nDigite o limite inferior da integral: ");
        limiteInferior = scanner.nextDouble();

        System.out.println("\nDigite o limite superior da integral: ");
        limiteSuperior = scanner.nextDouble();

        System.out.print("\nDigite a função a ser calculada: ");
        scanner.nextLine(); // limpa buffer (ignore)
        function = scanner.nextLine();

        resultado = calculadora.segundaRegraDeSimpson(limiteInferior, limiteSuperior, function);
        System.out.println("\nResultado: " + resultado);
    }

    public void askForInputsSegundaRegraDeSimpsonComMaisDeUmTrioDeSubconjuntos(){
        String function;
        double limiteInferior, limiteSuperior;
        int trio;
        double resultado;

        System.out.println("\nDigite o limite inferior da integral: ");
        limiteInferior = scanner.nextDouble();

        System.out.println("\nDigite o limite superior da integral: ");
        limiteSuperior = scanner.nextDouble();

        System.out.println("\nDigite a quantidade de trio de subconjuntos: ");
        trio = scanner.nextInt();


        System.out.print("\nDigite a função a ser calculada: ");
        scanner.nextLine(); // limpa buffer (ignore)
        function = scanner.nextLine();

        resultado = calculadora.segundaRegraDeSimpsonComMaisDeTresSubintervalos(limiteInferior, limiteSuperior, function, trio);
        System.out.println("\nResultado: " + resultado);
    }

}

