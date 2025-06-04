package com.example.atividadeintegrais.view;

import com.example.atividadeintegrais.calculos.*;

import java.util.InputMismatchException;
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

    public void principal(){
        int opcao,metodo;
        System.out.println("Deseja aplicar qual método?" +
                "\n⟶ 1 para o método do trapézio" +
                "\n⟶ 2 para o método de simpson" +
                "\n⟶ Opção: ");
        opcao = lerInteiro(1,2);

        switch (opcao){
            case 1:
            System.out.println("Deseja aplicar qual regra?" +
                    "\n1 ⟶ para o trapézio simples" +
                    "\n2 ⟶ para o trapézio composto");
                    metodo = lerInteiro(1,2);
                    if(metodo == 1){
                        askForInputsTrapezioSimples();
                    }else if(metodo == 2){
                        askForInputsTrapezioComposta();
                    }
                break;
            case 2:
                System.out.println("Deseja aplicar qual regra?" +
                        "\n1 ⟶ para a primeira regra de simpson" +
                        "\n2 ⟶ para a primeira regra de simpson com mais de um par de subintervalos" +
                        "\n3 ⟶ para a segunda regra de simpson" +
                        "\n4 ⟶ para a segunda regra de simpson com mais de 3 subintervalos");
                metodo = lerInteiro(1,4);
                switch (metodo){
                    case 1:
                        askForInputsPrimeiraRegraDeSimpson();
                        break;
                    case 2:
                        askForInputsPrimeiraRegraDeSimpsonComMaisDeUmParDeSubconjuntos();
                        break;
                    case 3:
                        askForInputsSegundaRegraDeSimpson();
                        break;
                    case 4:
                        askForInputsSegundaRegraDeSimpsonComMaisDeUmTrioDeSubconjuntos();
                        break;
                }
            break;
            default:
                System.out.println("Opção inválida!");
                break;
        }
    }

    private int lerInteiro(int min,int max){
        int valor = 0;
        Scanner ler = new Scanner(System.in);
        do{
            try {
                valor = ler.nextInt();
                return valor;
            }catch (InputMismatchException e){
                System.out.println("O valor deve ser um inteiro!");
                ler.next();
            }
        }while (valor < min && valor > max);
        return valor;
    }
    private int lerInteiro(){
        int valor = 0;
        Scanner ler = new Scanner(System.in);
        do{
            try {
                valor = ler.nextInt();
                return valor;
            }catch (InputMismatchException e){
                System.out.println("O valor deve ser um inteiro!");
                ler.next();
            }
        }while (true);
    }
}

