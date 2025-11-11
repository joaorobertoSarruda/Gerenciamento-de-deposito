package modelo;

public class Mercado {
    private int id;
    private String nome;
    private String endereco;

    public Mercado(int id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
     
    }

     public void exibirInfo() {
        System.out.println("Mercado ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
    }
    
    public void realizarVenda(int codigoProduto, int quantidade) {
        System.out.println("\n--- Venda no Mercado " + this.nome + " ---");
       
    }

    public void solicitarAbastecimento( int codigoProduto, int quantidade) {
        System.out.println("\n" + this.nome + " solicitando " + quantidade + " un de cód " + codigoProduto + " do Depósito Central.");
   
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
