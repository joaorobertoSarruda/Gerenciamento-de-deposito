package modelo;

public class Fornecedor{
    private int id;
    private String nomeFornecedor;
    private String cnpj;
    private String telefone;

    public Fornecedor(int id, String nomeFornecedor, String cnpj, String telefone){
        this.id = id;
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
        this.telefone = telefone;
    }
    public void atualizarTelefone (String novoTelefone){
        this.telefone = novoTelefone;
         System.out.println("Telefone de " + nomeFornecedor + "Atualizado para: " + novoTelefone);
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
      public String getDetalhes(){
        String detalhes =   "Id: " + id + "\n" +
                            "Nome: " + nomeFornecedor + "\n" +
                            "CNPJ: " + cnpj + "\n" +
                            "Telefone: " + telefone + "\n";
        return detalhes;
                      
}