package com.beingsecured.maventest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("""
                    1-Gestão de quartos
                    2-Gestão de manutenções
                    3-Reservar quartos
                    4-Sair
                    Insira o número daquilo que quer fazer:""");
            try {
                int funcionalidade = scanner.nextInt();
                switch (funcionalidade) {
                    case 1:
                        System.out.println("""
                                    1-Criar quarto
                                    2-Editar quarto
                                    3-Remover quarto
                                    Insira o número daquilo que quer fazer:""");
                        try {
                            funcionalidade = scanner.nextInt();
                            switch (funcionalidade) {
                                case 1:
                                    System.out.println("Criar quarto");
                                    break;
                                case 2:
                                    System.out.println("Editar quarto");
                                    break;
                                case 3:
                                    System.out.println("Remover quarto");
                                    break;
                                default:
                                    System.out.println("Opção inválida.");
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Escolha um número que corresponda à opção.");
                            scanner.nextLine();
                        }
                        break;
                    case 2:
                        System.out.println("""
                                1-Registar manutenção
                                2-Verificar manutenção
                                Insira o número daquilo que quer fazer""");
                        try {
                            funcionalidade = scanner.nextInt();
                            switch (funcionalidade) {
                                case 1:
                                    System.out.println("Registar manutenção");
                                    break;
                                case 2:
                                    System.out.println("Verificar manutenção");
                                    break;
                                default:
                                    System.out.println("Opção inválida");
                            }
                            break;
                        }catch(InputMismatchException e) {
                            System.out.println("Escolha um número que corresponda à opção.");
                            scanner.nextLine();
                        }
                        break;
                    case 3:
                        System.out.println("Reservar");
                        break;
                    case 4:
                        System.out.println("Sair");
                        return;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Escolha um número que corresponda à opção.");
                scanner.nextLine();
            }
        }
    }
}