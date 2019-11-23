package biblioteca;

public class Aluno extends Locatario {
    public Aluno(int matricula, String nome, String senha) {
        super(matricula, nome, senha);
    }

    @Override
    public void locarLivro(Livro livro) {

    }

    @Override
    public void devolverLivro(Livro livro) {

    }

}
