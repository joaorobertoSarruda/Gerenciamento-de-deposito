package modelo;

public class EstoqueLocal extends Estoque implements Imprimivel {
    private double valorTotalPatrimonio;

    //construtor
    public EstoqueLocal(String nomeLocal, double valorTotalPatrimonio) {
        super(nomeLocal);
        this.valorTotalPatrimonio = valorTotalPatrimonio;
    }

    // Implementação obrigatória da interface Imprimivel
    @Override
    public void exibirInfo() {
        System.out.println("=== Detalhes do Estoque Local ===");
        System.out.println("Local: " + this.nomeLocal);
        System.out.println("Qtd Tipos de Produtos: " + this.itens.size());
        System.out.println("Valor Patrimônio Inicial: R$ " + this.valorTotalPatrimonio);
    }
}