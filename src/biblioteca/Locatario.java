package biblioteca;

public abstract class  Locatario {
    private int Id;
    private String matricula;
    private String nome;
    private String senha;

    public Locatario(String matricula, String nome, String senha) {
        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
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

    public abstract void locarLivro(Livro livro);
    public abstract void devolverLivro(Livro livro);


    @Override
    public String toString() {
        return "Locatario{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
