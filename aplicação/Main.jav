package aplicação;

import modelo.*;
import java.util.ArrayList;

public class Main{

    public static void main(String[] args) {
        
        // Listas para armazenar os objetos principais (Requisito 4)
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();
        ArrayList<Produto> produtos = new ArrayList<>();
        ArrayList<Mercado> mercados = new ArrayList<>();

        // Cria o estoque central
        Estoque depositoCentral = new Estoque("Depósito Central");

        // ==========================================================
        // 1. ADICIONAR OBJETOS
        // ==========================================================
        System.out.println("========= 1. ADICIONANDO DADOS =========");
        
        Fornecedor f1 = new Fornecedor(1, "Grãos & Cia", "11.111.111/0001-11", "555-1234");
        Fornecedor f2 = new Fornecedor(2, "Bebidas SA", "22.222.222/0001-22", "555-5678");
        fornecedores.add(f1);
        fornecedores.add(f2);

        Produto p1 = new Produto(101, "Arroz 1kg", "Arroz branco Tipo 1", 3.50, 5.00);
        p1.setFornecedor(f1); // Vincula fornecedor ao produto
        Produto p2 = new Produto(102, "Feijão 1kg", "Feijão carioca", 5.00, 7.50);
        p2.setFornecedor(f1);
        Produto p3 = new Produto(201, "Refrigerante 2L", "Refrigerante sabor cola", 4.00, 6.00);
        p3.setFornecedor(f2);
        
        produtos.add(p1);
        produtos.add(p2);
        produtos.add(p3);

        // Adicionando Produtos ao Depósito Central
        depositoCentral.adicionarProduto(p1, 500);
        depositoCentral.adicionarProduto(p2, 300);
        depositoCentral.adicionarProduto(p3, 400);

        Mercado m1 = new Mercado(1, "Mercado Centro", "Rua das Flores, 123");
        Mercado m2 = new Mercado(2, "Mercado Bairro", "Av. Principal, 987");
        mercados.add(m1);
        mercados.add(m2);

        // ==========================================================
        // 2. LISTAR OBJETOS
        // ==========================================================
        System.out.println("\n========= 2. LISTANDO DADOS INICIAIS =========");
        
        System.out.println("--- Lista de Fornecedores ---");
        for(Fornecedor f : fornecedores) {
            System.out.println(f.toString());
        }

        System.out.println("\n--- Lista de Produtos (Detalhes) ---");
        for(Produto p : produtos) {
            System.out.println(p.getDetalhes());
            System.out.println("---");
        }

        depositoCentral.listarItens();

        // ==========================================================
        // 3. DEMONSTRAÇÃO DA LÓGICA (Simulando operações)
        // ==========================================================
        System.out.println("\n========= 3. SIMULANDO OPERAÇÕES =========");
        
        // Mercado 1 solicita abastecimento do Depósito
        m1.solicitarAbastecimento(depositoCentral, 101, 50); // Pede 50 Arroz
        
        // Mercado 2 solicita abastecimento
        m2.solicitarAbastecimento(depositoCentral, 102, 25); // Pede 25 Feijão
        
        System.out.println("\n--- Estoques após abastecimento ---");
        depositoCentral.listarItens();
        m1.verificarEstoqueLocal();
        
        // Mercado 1 realiza uma venda
        m1.realizarVenda(101, 5); // Vende 5 Arroz

        System.out.println("\n--- Estoque Mercado 1 após venda ---");
        m1.verificarEstoqueLocal();

        // ==========================================================
        // 4. EDITAR OBJETOS
        // ==========================================================
        System.out.println("\n========= 4. EDITANDO DADOS =========");
        
        // Editando o telefone do Fornecedor 2
        f2.atualizarTelefone("555-9999");
        
        // Editando o preço de venda do Produto 1 (Arroz)
        p1.atualizarPrecoVenda(5.50);

        // ==========================================================
        // 5. REMOVER OBJETOS
        // ==========================================================
        System.out.println("\n========= 5. REMOVENDO DADOS =========");
        
        System.out.println("Total de produtos na lista antes: " + produtos.size());
        
        // Para remover, precisamos encontrar o objeto. 
        // Vamos remover o Produto 3 (Refrigerante)
        Produto produtoParaRemover = null;
        for(Produto p : produtos) {
            if (p.getCodigo() == 201) { // Código 201 = Refrigerante
                produtoParaRemover = p;
                break;
            }
        }
        
        if(produtoParaRemover != null) {
            produtos.remove(produtoParaRemover);
            System.out.println("Produto '" + produtoParaRemover.getNomeProduto() + "' removido da lista principal.");
        }
        
        System.out.println("Total de produtos na lista depois: " + produtos.size());
    }
}
