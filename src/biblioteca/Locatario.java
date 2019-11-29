package biblioteca;

public abstract class  Locatario {
    private long matricula;
    private String nome;
    private String senha;

    public Locatario(){

    }

    public Locatario(long matricula, String nome, String senha) {
        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
    }
    public abstract void locarLivro(Livro livro);
    public abstract void devolverLivro(Livro livro);

    public Long getMatricula() {
        return matricula;
    }

    public void setMatricula(long matricula) {
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

    @Override
    public String toString() {
        return "Locatario{" +
                "matricula=" + matricula +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
