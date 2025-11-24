package modelo;

public class Mercado implements Imprimivel {
    private int id;
    private String nome;
    private String endereco;

    public Mercado(int id, String nome, String endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    @Override
    public void exibirInfo() {
        System.out.println("=== Detalhes do Mercado ===");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("Endereço: " + endereco);
    }

    public String getNome() { return nome; }
}