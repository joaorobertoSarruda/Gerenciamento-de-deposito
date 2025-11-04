package modelo;

public class Estoque {
    private ArrayList<ItemEstoque> itens;  
    private String local; 
    public Estoque() {
        this.itens = new ArrayList<>();
        this.local=local;
    }     
    public String getLocal() {
        return this.local;
    }   
    public void setLocal(String local) {
        this.local = local;
    }  
    public void adicionarItem(ItemEstoque item) {
        itens.add(item);
    }   
    public void removerItem(Produto produto) {
        itens.removeIf(item -> item.getProduto().getId() == produto.getId());   

}
    public ItemEstoque buscarItem(Produto produto) {
        for (ItemEstoque item : itens) {
            if (item.getProduto().getId() == produto.getId()) {
                return item;
            }
        }
        return null;
    }   
    public ArrayList<ItemEstoque> getItens() {
        return itens;

    }
     
}
