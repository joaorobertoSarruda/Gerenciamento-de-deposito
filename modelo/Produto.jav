package modelo;

public class Produto{
    private int codigo;
    private String nomeProduto;
    private String descricao;
    private double precoCusto;
    private double precoVenda;
    Fornecedor f1;

    public Produto(int codigo, String nomeProduto, String descricao, double precoCusto, double precoVenda){
    this.codigo = codigo;
    this. nomeProduto = nomeProduto;
    this.descricao = descricao;
    this.precoCusto = precoCusto;
    this.precoVenda = precoVenda;
}

    public void atualizarPrecoVenda(double novoPreco){
        if (novoPreco > this.precoCusto){
            this.precoVenda = novoPreco;
            System.out.println("Preço atualizado para: "+novoPreco);

        } else {
            System.out.println("ERRO! Novo preço de venda deve ser maior que o preço de custo.");
        }
    }

    public String getDetalhes(){
        String detalhes = "Código: " + codigo + "\n" +
                          "Nome: " + nomeProduto + "\n" +
                          "Descrição: " + descricao + "\n" +
                          "Preço Custo: R$" + precoCusto + "\n" +
                          "Preço Venda: R$" + precoVenda + "\n" +
                          "Fornecedor: " + (fornecedor != null ? fornecedor.getNomeFornecedor() : "N/A")
        return detalhes;
    }

    public void setFornecedor(Fornecedor f1){
        this.fornecedor = f1;
    }
}