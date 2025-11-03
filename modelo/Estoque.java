package modelo;

import java.util.ArrayList;

public class Estoque {
    private ArrayList<ItemEstoque> itens;
    private String nomeLocal; // Ex: "Depósito Central" ou "Mercado Filial Centro"

    public Estoque(String nomeLocal) {
        this.nomeLocal = nomeLocal;
        this.itens = new ArrayList<>();
    }

    /**
     * Método auxiliar privado para buscar um ItemEstoque pelo código do produto.
     */
    public ItemEstoque buscarItem(int codigoProduto) {
        for (ItemEstoque item : itens) {
            if (item.getProduto().getCodigo() == codigoProduto) {
                return item;
            }
        }
        return null; // Não encontrou
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        ItemEstoque itemExistente = buscarItem(produto.getCodigo());

        if (itemExistente != null) {
            // Se o produto já existe, apenas soma a quantidade
            itemExistente.adicionarQuantidade(quantidade);
            System.out.println("Estoque de '" + produto.getNomeProduto() + "' atualizado para " + itemExistente.getQuantidade() + " em " + this.nomeLocal);
        } else {
            // Se é um produto novo, cria um novo ItemEstoque
            ItemEstoque novoItem = new ItemEstoque(produto, quantidade);
            this.itens.add(novoItem);
            System.out.println("Novo produto '" + produto.getNomeProduto() + "' adicionado ao estoque " + this.nomeLocal);
        }
    }

    public boolean removerProduto(int codigoProduto, int quantidade) {
        ItemEstoque item = buscarItem(codigoProduto);
        if (item != null) {
            boolean sucesso = item.removerQuantidade(quantidade);
            if(sucesso) {
                 System.out.println(quantidade + " unidades de '" + item.getProduto().getNomeProduto() + "' removidas de " + this.nomeLocal);
                 return true;
            } else {
                System.out.println("Falha ao remover: estoque insuficiente de '" + item.getProduto().getNomeProduto() + "' em " + this.nomeLocal);
                return false;
            }
        } else {
            System.out.println("Falha ao remover: produto com código " + codigoProduto + " não encontrado em " + this.nomeLocal);
            return false;
        }
    }

    /**
     * Move uma quantidade de um produto deste estoque (origem) para um estoque de destino.
     */
    public void transferirProduto(Estoque destino, int codigoProduto, int quantidade) {
        System.out.println("\n--- TENTATIVA DE TRANSFERÊNCIA ---");
        System.out.println("De: " + this.nomeLocal + " | Para: " + destino.nomeLocal + " | Produto cód: " + codigoProduto);

        ItemEstoque itemOrigem = buscarItem(codigoProduto);
        
        if (itemOrigem == null) {
            System.out.println("Transferência falhou: Produto não existe na origem.");
            return;
        }

        // Tenta remover da origem
        boolean sucessoRemocao = this.removerProduto(codigoProduto, quantidade);

        // Se conseguiu remover da origem, adiciona no destino
        if (sucessoRemocao) {
            destino.adicionarProduto(itemOrigem.getProduto(), quantidade);
            System.out.println("Transferência concluída com sucesso.");
        } else {
            System.out.println("Transferência falhou: estoque insuficiente na origem.");
        }
    }

    public void listarItens() {
        System.out.println("\n--- Itens no Estoque: " + this.nomeLocal + " ---");
        if (itens.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }
        for (ItemEstoque item : itens) {
            System.out.println(item); // Usa o toString() do ItemEstoque
        }
        System.out.println("-------------------------------------");
    }
    
    public String getNomeLocal() {
        return nomeLocal;
    }
}
