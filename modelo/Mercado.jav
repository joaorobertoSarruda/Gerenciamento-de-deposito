package modelo;

public class Mercado {
    private int id;
    private String nome;
    private String endereco;
    private Estoque estoqueLocal; // Composição: Cada mercado TEM UM estoque

    public Mercado(int id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        // Cria o estoque local, vinculado ao nome do mercado
        this.estoqueLocal = new Estoque("Estoque " + nome);
    }

    public void realizarVenda(int codigoProduto, int quantidade) {
        System.out.println("\n--- Venda no Mercado " + this.nome + " ---");
        // A venda é uma remoção do estoque local
        this.estoqueLocal.removerProduto(codigoProduto, quantidade);
    }

    public void solicitarAbastecimento(Estoque depositoCentral, int codigoProduto, int quantidade) {
        System.out.println("\n" + this.nome + " solicitando " + quantidade + " un de cód " + codigoProduto + " do Depósito Central.");
        // O depósito transfere PARA o estoque local deste mercado
        depositoCentral.transferirProduto(this.estoqueLocal, codigoProduto, quantidade);
    }

    public void verificarEstoqueLocal() {
        this.estoqueLocal.listarItens();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public Estoque getEstoqueLocal() {
        return estoqueLocal;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Mercado [ID=" + id + ", Nome=" + nome + ", Endereço=" + endereco + "]";
    }
}
