package aplicacao;

import modelo.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        

        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Mercado> mercados = new ArrayList<>();
        ArrayList<Mercado> unidades = new ArrayList<>();
        Estoque depositoCentral = new Estoque("Depósito Central");
        EstoqueLocal estoque = new EstoqueLocal("Mercado Central", "Rua das Flores, 123", 250, 12500.50);


        Fornecedor f1 = new Fornecedor(1, "Grãos & Cia", "11.111.111/0001-11", "555-1234");
        fornecedores.add(f1);
        
        Produto p1 = new Produto(101, "Arroz 1kg", "Arroz branco Tipo 1", 3.50, 5.00);
        p1.setFornecedor(f1);
        produtos.add(p1);
        
        Mercado m1 = new Mercado(1, "Mercado Centro", "Rua das Flores, 123");
        mercados.add(m1);
        depositoCentral.adicionarProduto(p1, 500); // Adiciona ao estoque
        // ==========================================================
       
        // Adiciona diferentes tipos de unidades (superclasse e subclasses)
        unidades.add(m1);                // Objeto da superclasse Mercado
        unidades.add(estoque);           // Objeto da subclasse EstoqueLocal

        // Percorre a lista e chama o mesmo método para todos
        for (Mercado unidade : unidades) {
            unidade.exibirInfo();  // Polimorfismo: comportamento muda conforme a classe real
            System.out.println("---------------------------------------------");
        }
        
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=============================================");
            System.out.println("            MENU DE GERENCIAMENTO            ");
            System.out.println("=============================================");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Adicionar Novo Produto");
            System.out.println("3. Editar Preço de Venda do Produto");
            System.out.println("4. Remover Produto");
            System.out.println("5. Ver Estoque Central");
            System.out.println("0. Sair");
            System.out.println("---------------------------------------------");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner (após o int)
            } catch (java.util.InputMismatchException e) {
                System.out.println("\nERRO: Entrada inválida. Por favor, digite um número de 0 a 5.");
                scanner.nextLine(); // Limpa a linha para evitar loop infinito
                opcao = -1;
                continue;
            }

            // ==========================================================
            // LÓGICA DO MENU COM SWITCH
            // ==========================================================
            switch (opcao) {
                case 1: // Listar Produtos
                    System.out.println("\n--- Lista Completa de Produtos ---");
                    if (produtos.isEmpty()) {
                        System.out.println("Nenhum produto cadastrado.");
                    }
                    for (Produto p : produtos) {
                        System.out.println(p.getDetalhes());
                        System.out.println("--------------------------------");
                    }
                    break;

                case 2: // Adicionar Novo Produto
                    System.out.println("\n--- Adicionar Novo Produto ---");
                    System.out.print("Código: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Descrição: ");
                    String descricao = scanner.nextLine();
                    System.out.print("Preço Custo: ");
                    double custo = scanner.nextDouble();
                    System.out.print("Preço Venda: ");
                    double venda = scanner.nextDouble();
                    scanner.nextLine(); // Limpar buffer
                    
                    Produto novoProduto = new Produto(codigo, nome, descricao, custo, venda);
                    produtos.add(novoProduto);
                    System.out.println("\nProduto '" + nome + "' adicionado com sucesso!");
                    
                    // Nota: Aqui seria o local para escolher o Fornecedor e o estoque inicial.
                    break;

                case 3: // Editar Preço de Venda
                    System.out.println("\n--- Editar Preço de Venda ---");
                    System.out.print("Digite o código do produto para editar: ");
                    int codigoEditar = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    
                    Produto produtoEditar = buscarProdutoPorCodigo(produtos, codigoEditar);
                    
                    if (produtoEditar != null) {
                        System.out.print("Novo Preço de Venda: ");
                        double novoPreco = scanner.nextDouble();
                        scanner.nextLine(); // Limpar buffer
                        produtoEditar.atualizarPrecoVenda(novoPreco);
                    } else {
                        System.out.println("ERRO: Produto com código " + codigoEditar + " não encontrado.");
                    }
                    break;

                case 4: // Remover Produto
                    System.out.println("\n--- Remover Produto ---");
                    System.out.print("Digite o código do produto para remover: ");
                    int codigoRemover = scanner.nextInt();
                    scanner.nextLine(); // Limpar buffer
                    
                    Produto produtoRemover = buscarProdutoPorCodigo(produtos, codigoRemover);
                    
                    if (produtoRemover != null) {
                        produtos.remove(produtoRemover);
                        System.out.println("Produto '" + produtoRemover.getNomeProduto() + "' removido.");
                    } else {
                        System.out.println("ERRO: Produto com código " + codigoRemover + " não encontrado.");
                    }
                    break;

                case 5: // Ver Estoque Central
                    System.out.println("\n--- Estoque do " + depositoCentral.getNomeLocal() + " ---");
                    depositoCentral.listarItens();
                    break;

                case 0: // Sair
                    System.out.println("\nSaindo do sistema. Até logo!");
                    break;
                    
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        }
        scanner.close(); // Fechar o scanner quando o loop termina.
    
    }
    
    /**
     * Método auxiliar para encontrar um produto na lista pelo seu código.
     */
    private static Produto buscarProdutoPorCodigo(ArrayList<Produto> produtos, int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null; // Retorna null se não encontrar o produto
    // Métodos herdados da superclasse
        estoque.exibirInfo();

        // Métodos da subclasse
        estoque.exibirEstoqueLocal();
    
    }
      
}
