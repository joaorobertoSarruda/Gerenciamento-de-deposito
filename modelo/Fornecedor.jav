package modelo;

public class Fornecedor {
    private int id;
    private String nomeFornecedor;
    private String cnpj;
    private String telefone;

    public Fornecedor(int id, String nomeFornecedor, String cnpj, String telefone) {
        this.id = id;
        this.nomeFornecedor = nomeFornecedor;
        this.cnpj = cnpj;
        this.telefone = telefone;
    }

    public String getContato() {
        return "Nome: " + nomeFornecedor + " | Telefone: " + telefone;
    }

    public void atualizarTelefone(String novoTelefone) {
        this.telefone = novoTelefone;
        System.out.println("Telefone de " + nomeFornecedor + " atualizado para: " + novoTelefone);
    }

    public int getId() {
        return id;
    }

    public String getNomeFornecedor() {
        return nomeFornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Fornecedor [ID=" + id + ", Nome=" + nomeFornecedor + ", CNPJ=" + cnpj + ", Telefone=" + telefone + "]";
    }
}
