package biblioteca;

public class  Locatario {
    private int Id;
    private String matricula;
    private String nome;
    private String senha;
    private String tipo;
    public Locatario(String matricula, String nome, String senha, String tipo) {
        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void locarLivro(Livro livro){

    };
    public void devolverLivro(Livro livro){

    };



    public int compareTo(Locatario o) {
        if(this.nome.compareTo(o.getNome() )==1) return -1;
        if (o.getNome().compareTo(this.nome) == -1) return 1;
        return 0;
    }

    @Override
    public String toString() {
        return "Locatario{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
