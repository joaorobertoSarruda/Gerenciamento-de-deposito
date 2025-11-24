package modelo;

import exceções.ValorInvalidoException;

public class Produto {
    private int codigo;
    private String nomeProduto;
    private String descricao;
    private double precoCusto;
    private double precoVenda;
    private Fornecedor fornecedor;

    public Produto(int codigo, String nomeProduto, String descricao, double precoCusto, double precoVenda) throws ValorInvalidoException {
        if (precoCusto < 0 || precoVenda < 0) {
            throw new ValorInvalidoException("Preço de custo ou venda não podem ser negativos.");
        }
        
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    public void atualizarPrecoVenda(double novoPreco) throws ValorInvalidoException {
        if (novoPreco < 0) {
            throw new ValorInvalidoException("O preço não pode ser negativo.");
        }
        
        if (novoPreco > this.precoCusto) {
            this.precoVenda = novoPreco;
            System.out.println("Preço de '" + this.nomeProduto + "' atualizado para: R$" + novoPreco);
        } else {
            throw new ValorInvalidoException("Novo preço (R$" + novoPreco + ") deve ser maior que o custo (R$" + this.precoCusto + ").");
        }
    }

    public String getDetalhes() {
        String detalhes = "Código: " + codigo + "\n" +
                "Nome: " + nomeProduto + "\n" +
                "Descrição: " + descricao + "\n" +
                "Preço Custo: R$" + precoCusto + "\n" +
                "Preço Venda: R$" + precoVenda + "\n" + 
                "Fornecedor: " + (fornecedor != null ? fornecedor.getNomeFornecedor() : "N/A");
        return detalhes;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public void setFornecedor(Fornecedor f1) {
        this.fornecedor = f1;
    }
}