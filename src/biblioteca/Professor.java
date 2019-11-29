package biblioteca;

public class Professor extends Locatario  {
    public Professor(long matricula, String nome, String senha) {
        super(matricula, nome, senha);
    }



    @Override
    public void locarLivro(Livro livro) {

    }

    @Override
    public void devolverLivro(Livro livro) {

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
