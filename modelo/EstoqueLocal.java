package modelo;

public class EstoqueLocal extends Mercado{
    private String nomeLocal; // Ex: "Depósito Central" ou "Mercado Filial Centro"
    private int quantidadeProdutos;
    private double valorTotal;

    public EstoqueLocal(String nomeLocal, int quantidadeProdutos, double valorTotal,int id, String nome, String endereco) {
        super(nome,id, endereco);
        this.nomeLocal = nomeLocal;
        this.quantidadeProdutos = quantidadeProdutos;
        this.valorTotal = valorTotal;
    }
     public void exibirEstoqueLocal() {
        System.out.println("Quantidade de produtos: " + quantidadeProdutos);
        System.out.println("Valor total em estoque: R$ " + valorTotal);
    }
    @Override
    public void exibirInfo() {
        System.out.println("Informações do estoque:");
        System.out.println("Mercado: " + nome);
        System.out.println("Endereço: " + endereco);
        System.out.println("Produtos: " + quantidadeProdutos);
        System.out.println("Valor total: R$ " + valorTotal);
    }
}
