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
        this.telefone = telefone
    }

    public String getContato(){
        return "Nome: " + nomeFornecedor + " | Telefone: " + telefone;
    }

    public String atualizarTelefone (String novoTelefone){
        this.telefone = novoTelefone;
        System.out.println("Telefone de " + nomeFornecedor + "Atualizado para: " + novoTelefone);
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return nomeFornecedor;
    }

    public String getCnpj(){
        return cnpj;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
}