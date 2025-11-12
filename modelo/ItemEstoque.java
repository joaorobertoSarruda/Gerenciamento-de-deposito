package modelo;

/**
 * Representa a relação entre um Produto e a sua quantidade em um Estoque.
 */
public class ItemEstoque {
    private Produto produto;
    private int quantidade;

    public ItemEstoque(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public void adicionarQuantidade(int valor) {
        if (valor > 0) {
            this.quantidade += valor;
        }
    }

    /**
     * Tenta remover uma quantidade do estoque.
     * Retorna true se a remoção foi bem-sucedida, false caso contrário.
     */
    public boolean removerQuantidade(int valor) {
        if (valor > 0 && this.quantidade >= valor) {
            this.quantidade -= valor;
            return true; // Remoção bem-sucedida
        }
        return false; // Não há estoque suficiente
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        // Permite ajuste manual, se necessário
        this.quantidade = quantidade;
    }
    
    @Override
    public String toString() {
        return "Item: " + produto.getNomeProduto() + " | Quantidade: " + quantidade;
    }
}
