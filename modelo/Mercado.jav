    package modelo;
    public class Mercado{
        private int id;
        private String nome;
        private String endereco;
        ArrayList<Estoque> estoques = new ArrayList<>();

        public Mercado(String nome, String endereco, int id){
            this.nome = nome;
            this.endereco = endereco;
            this.id = id;
        }
        public int getId(){
            return id;
        }
        
        public String getNome(){
            return nome;
        }

        public String getEndereco(){
            return endereco;
        }

        public void setNome(String nome){
            this.nome = nome;
        }

        public void setEndereco(String endereco){
            this.endereco = endereco;
        }
        public void adicionarEstoque(Estoque estoque){
            estoques.add(estoque);
        }
        public ArrayList<Estoque> getEstoques(){
            return estoques;
        }

        
    }