package aplicacao;

import modelo.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import exceções.ValorInvalidoException;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Listas
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Imprimivel> listaDeImprimiveis = new ArrayList<>();

        // Criação de Objetos
        Estoque depositoCentral = new Estoque("Depósito Central");
        
        // EstoqueLocal herdando de Estoque (Correto)
        EstoqueLocal estoqueFilial = new EstoqueLocal("Estoque Filial Norte", 5000.00);
        
        Mercado mercadoCentral = new Mercado(1, "Mercado Central", "Rua Principal, 10");

        // Adicionando à lista polimórfica (ambos são 'Imprimivel')
        listaDeImprimiveis.add(mercadoCentral);
        listaDeImprimiveis.add(estoqueFilial);

        // Exibindo informações usando Polimorfismo
        System.out.println("--- Relatório Geral (Polimorfismo via Interface) ---");
        for (Imprimivel item : listaDeImprimiveis) {
            item.exibirInfo(); // Cada um exibe do seu jeito
            System.out.println("-------------------------");
        }

        // --- Adicionando produto inicial com tratamento de erro ---
        try {
            Produto p1 = new Produto(101, "Arroz", "Tipo 1", 4.00, 6.00); 
            produtos.add(p1);
            depositoCentral.adicionarProduto(p1, 100);
        } catch (ValorInvalidoException e) {
            System.out.println("Erro ao criar produto inicial: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro genérico ao criar produto inicial: " + e.getMessage());
        }

        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n1. Listar Produtos");
            System.out.println("2. Adicionar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("0. Sair");
            System.out.print("Opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar buffer
            } catch (InputMismatchException e) {
                System.out.println("\nERRO: Digite apenas números inteiros.");
                scanner.nextLine();
                opcao = -1;
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Produtos Cadastrados ---");
                    for (Produto p : produtos) {
                        System.out.println(p.getDetalhes());
                    }
                    break;

                case 2:
                    try {
                        System.out.println("\n--- Novo Produto ---");
                        System.out.print("Código: ");
                        int cod = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nome: ");
                        String nome = scanner.nextLine();
                        System.out.print("Custo: ");
                        double custo = scanner.nextDouble();
                        System.out.print("Venda: ");
                        double venda = scanner.nextDouble();
                        scanner.nextLine();

                        // Construtor deve lançar ValorInvalidoException se negativo
                        Produto novo = new Produto(cod, nome, "Sem descrição", custo, venda);
                        produtos.add(novo);
                        System.out.println("Produto cadastrado!");

                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Valor digitado não é um número válido.");
                        scanner.nextLine();
                    } catch (ValorInvalidoException e) {
                        System.out.println("Erro de Regra de Negócio: " + e.getMessage());
                    } catch (Exception e) {
                         System.out.println("Erro genérico: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Código para remover: ");
                    try {
                        int codRemove = scanner.nextInt();
                        scanner.nextLine();
                        Produto pRemove = buscarProdutoPorCodigo(produtos, codRemove);
                        if (pRemove != null) {
                            produtos.remove(pRemove);
                            System.out.println("Removido!");
                        } else {
                            System.out.println("Não encontrado.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: Código inválido.");
                        scanner.nextLine();
                    }
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
                default: 
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }

    private static Produto buscarProdutoPorCodigo(ArrayList<Produto> produtos, int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null; // Retorna null se não achar
    }
}