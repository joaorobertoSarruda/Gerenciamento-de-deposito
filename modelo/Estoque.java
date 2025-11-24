package modelo;
import java.util.ArrayList;

public class Estoque {
    // Protected permite que as subclasses (EstoqueLocal) acessem esses atributos
    protected ArrayList<ItemEstoque> itens;
    protected String nomeLocal; 

    public Estoque(String nomeLocal) {
        this.nomeLocal = nomeLocal;
        this.itens = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto, int quantidade) {
        ItemEstoque itemExistente = buscarItem(produto.getCodigo());

        if (itemExistente != null) {
            itemExistente.adicionarQuantidade(quantidade);
        } else {
            ItemEstoque novoItem = new ItemEstoque(produto, quantidade);
            this.itens.add(novoItem);
        }
        System.out.println("Produto '" + produto.getNomeProduto() + "' adicionado ao " + this.nomeLocal);
    }

    public ItemEstoque buscarItem(int codigoProduto) {
        for (ItemEstoque item : itens) {
            if (item.getProduto().getCodigo() == codigoProduto) {
                return item;
            }
        }
        return null; 
    }
    
    // Método de listagem básico
    public void listarItens() {
        System.out.println("\n--- Itens no " + this.nomeLocal + " ---");
        if (itens.isEmpty()) {
            System.out.println("Estoque vazio.");
        } else {
            for (ItemEstoque item : itens) {
                System.out.println(item);
            }
        }
    }

    public String getNomeLocal() {
        return nomeLocal;
    }
}