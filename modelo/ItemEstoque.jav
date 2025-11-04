package modelo;

public class ItemEstoque{
    private Produto produto;
    private int quantidade;

    public ItemEstoque(Produto produto, int quantidade){
        this.produto = produto;
        this.quantidade = quantidade;
    }
    public int adicionarQuantidade(int quantidadeAdicional){
        this.quantidade += quantidadeAdicional;
        return this.quantidade;
    }
    public int removerQuantidade(int quantidadeRemovida){
        if (quantidadeRemovida <= this.quantidade){
            this.quantidade -= quantidadeRemovida;
        } else {
            System.out.println("ERRO! Quantidade insuficiente em estoque.");
        }
        return this.quantidade;
    }

    public Produto getProduto(){
        return this.produto;
    }   

    public int getQuantidade(){
        return this.quantidade;
    
}