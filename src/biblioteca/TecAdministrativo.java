package biblioteca;

public class TecAdministrativo extends Locatario {
    public TecAdministrativo(int matricula, String nome, String senha) {
        super(matricula, nome, senha);
    }

    @Override
    public void locarLivro(Livro livro) {

    }

    @Override
    public void devolverLivro(Livro livro) {

    }


}