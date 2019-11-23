package biblioteca;

public abstract class  Locatario {
    private int matricula;
    private String nome;
    private String senha;

    public Locatario(int matricula, String nome, String senha) {
        this.matricula = matricula;
        this.nome = nome;
        this.senha = senha;
    }
    public abstract void locarLivro(Livro livro);
    public abstract void devolverLivro(Livro livro);

}
