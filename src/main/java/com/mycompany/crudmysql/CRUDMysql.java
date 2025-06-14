/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crudmysql;

import java.util.List;
import java.util.Scanner;

public class CRUDMysql {

    public static void main(String[] args) {
       AlunoDAO dao = new AlunoDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        int opcaorelatorio;

        do {
            System.out.println("\n===== MENU ALUNOS =====");
            System.out.println("1 - Inserir aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Atualizar aluno");
            System.out.println("4 - Excluir aluno");
            System.out.println("5 - Relatórios");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do aluno: ");
                    String nome = scanner.nextLine();

                    double simulado1;
                    while (true) {
                        System.out.print("Digite a nota do Simulado 1 (entre 0 e 1): ");
                        try {
                            String entrada = scanner.nextLine().replace(",", ".");
                            simulado1 = Double.parseDouble(entrada);
                            if (simulado1 >= 0 && simulado1 <= 1) {
                                break;
                            } else {
                                System.out.println("Valor inválido! Digite um número entre 0 e 1.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida! Digite um número decimal (ex: 0.5).");
                        }
                    }

                    double simulado2;
                    while (true) {
                        System.out.print("Digite a nota do Simulado 2 (entre 0 e 1): ");
                        try {
                            String entrada = scanner.nextLine().replace(",", ".");
                            simulado2 = Double.parseDouble(entrada);
                            if (simulado2 >= 0 && simulado2 <= 1) {
                                break;
                            } else {
                                System.out.println("Valor inválido! Digite um número entre 0 e 1.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida! Digite um número decimal (ex: 0.5).");
                        }
                    }


                    double av;
                    while (true) {
                        System.out.print("Nota AV (entre 0 e 10): ");
                        try {
                            av = Double.parseDouble(scanner.nextLine());
                            if (av >= 0 && av <= 10) {
                                break;
                            } else {
                                System.out.println("Valor inválido! A nota AV deve estar entre 0 e 10.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida! Digite um número válido.");
                        }
                    }

                    System.out.print("Genero - 1: Masculino ou 2: Feminino: ");
                    Integer genero = Integer.valueOf(scanner.nextLine());

                    double notafinal = 0;
                    dao.inserir(new Aluno(nome, simulado1, simulado2, av, genero, notafinal));
                    break;

                case 2:
                    List<Aluno> alunos = dao.listar();
                    if (alunos.isEmpty()) {
                        System.out.println("Nenhum aluno encontrado.");
                    } else {
                        alunos.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("ID do aluno a atualizar: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Novo nome: ");
                    String novoNome = scanner.nextLine();
                    dao.atualizar(new Aluno(idAtualizar, novoNome));
                    break;

                case 4:
                    System.out.print("ID do aluno a excluir: ");
                    int idExcluir = scanner.nextInt();
                    dao.excluir(idExcluir);
                    break;

                case 5:

                    do {
                        System.out.println("\n===== RELATÓRIOS =====");
                        System.out.println("1 - Total de alunos cuja nota final foi superior a 7");
                        System.out.println("2 - Total de alunas (gênero feminino) com nota final acima de 7");
                        System.out.println("3 - Notas de todos os alunos e a média geral da turma");
                        System.out.println("0 - Sair");
                        System.out.print("Escolha uma opção: ");
                        opcaorelatorio = scanner.nextInt();
                        scanner.nextLine(); // limpar buffer

                        switch (opcaorelatorio) {


                            case 1:
                                List<Aluno> alunosrelatorio1 = dao.relatorioNotaFinalSuperior7();

                                if (alunosrelatorio1.isEmpty()) {
                                    System.out.println("Nenhum relatório encontrado.");
                                } else {
                                    alunosrelatorio1.forEach(System.out::println);
                                }
                                break;
                            case 2:
                                List<Aluno> alunosrelatorio2 = dao.relatorioFemininoNotaFinalSuperior7();

                                if (alunosrelatorio2.isEmpty()) {
                                    System.out.println("Nenhum relatório encontrado.");
                                } else {
                                    alunosrelatorio2.forEach(System.out::println);
                                }
                                break;
                            case 3:
                                RelatorioTurma relatorio = dao.relatorioNotaFinalTodosAlunosEMediaTurma();

                                List<Aluno> alunosRelatorio = relatorio.getAlunos();

                                if (alunosRelatorio.isEmpty()) {
                                    System.out.println("Nenhum relatório encontrado.");
                                } else {
                                    alunosRelatorio.forEach(System.out::println);
                                    System.out.printf("Média geral da turma: %.2f%n", relatorio.getMediaTurma());
                                }
                                break;

                        }

                    } while (opcaorelatorio != 0);
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
