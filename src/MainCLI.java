import Connections.dao.EmprestimoDAO;
import Connections.dao.LivroDAO;
import Connections.dao.LocatarioDAO;
import biblioteca.*;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.*;

public class MainCLI {

    public static void menu(){
        Scanner scanner = new Scanner(System.in);

        int resp;
        System.out.println("MENU BIBLIOTECA - UFPI");
        System.out.println("1 - Cadastrar usuario");
        System.out.println("2 - Cadastrar Livro");
        System.out.println("3 - Fazer emprestimo");
        System.out.println("4 - Fazer Reserva");
        System.out.println("5 - Relatórios");
        System.out.println("0 - Sair");
        resp = scanner.nextInt();
        if(resp == 1) cadastraUsuario();
        if(resp == 2) cadastroLivro();
        if(resp == 3) fazerEmprestimo();
        if(resp == 5) menuRelatorios();

        if (resp == 0) System.exit(0);

    }

    private static void menuRelatorios() {
        System.out.println("MENU RELATÓRIO");
        System.out.println("1 - Listar Locatários");
        System.out.println("2 - Listar Acervo");
        System.out.println("0 - Menu principal");

        int resp;
        Scanner scanner = new Scanner(System.in);
        resp = scanner.nextInt();
        if(resp == 1) {System.out.println(getLocatarios()); menuRelatorios();}
        if(resp == 2) {System.out.println(getLivros()); menuRelatorios();}
        if(resp == 0) menu();

    }


    private static List<Livro> getLivros(){
        LivroDAO livroDAO = new LivroDAO();
        List<Livro> livros = livroDAO.buscar();
        return livros;
    }
    public static List<Locatario> getLocatarios(){
        LocatarioDAO dao = new LocatarioDAO();
        List<Locatario> locatarios = dao.buscar();

        return locatarios;
    }
    private static void fazerEmprestimo() {
        List<Locatario> locatarios = getLocatarios();
        List<Livro> livros = getLivros();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o codigo do livro");
        String codigo = scanner.nextLine();
        System.out.println("Digite o a matricula do usuario: ");
        String matricula = scanner.nextLine();

        for (Livro livro: livros) {
                if(livro.getCodigo() == Integer.parseInt(codigo)){
                    for (Locatario locatario: locatarios) {
                        if (locatario.getMatricula().equals(matricula)){
                            EmprestimoDAO dao = new EmprestimoDAO();
                            dao.inserir( new Emprestimo(livro,locatario));
                            menu();
                        }
                    }
                }
        }





    }

    private static void cadastroLivro() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o código:");
        int codigo = scanner.nextInt();
        System.out.println("Digite a quantidade de livros:");
        int qtd = scanner.nextInt();
        System.out.println("Digite o ano: ");
        int ano = scanner.nextInt();
        System.out.println("Digite o titulo: ");
        scanner.nextLine();
        String titulo = scanner.nextLine();
        System.out.println("Digite o nome do autor: ");
        String autor = scanner.nextLine();

        LivroDAO dao = new LivroDAO();
        dao.inserir(new Livro(
                codigo,
                qtd,
                ano,
                titulo,
                autor
        ));

        System.out.println("Livro cadastrado!");
        menu();

    }

    private static void cadastraUsuario() {
        System.out.println("MENU CADASTRO");
        System.out.println("1 - Locatário");
        System.out.println("0 - Menu");
        Scanner scanner = new Scanner(System.in);
        int resp = scanner.nextInt();

        if(resp == 1) cadastroAluno();
        if(resp == 0) menu();
    }





    private static void cadastroAluno() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite no nome");
        String nome = scanner.nextLine();
        System.out.println("Digite a matricula");
        String matricula = scanner.nextLine();
        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();
        System.out.println("Digite o tipo: ");
        String tipo = scanner.nextLine();
        LocatarioDAO dao = new LocatarioDAO();
        dao.inserir(new Locatario(matricula,nome,senha, tipo));
        System.out.println("Locatário cadastrado com sucesso!");
        cadastraUsuario();
    }

    public static void main(String[] args) {
        menu();
    }
}
