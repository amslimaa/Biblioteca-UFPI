import Connections.dao.AlunoDAO;
import Connections.dao.LivroDAO;
import Connections.dao.ProfessorDAO;
import Connections.dao.TecAdministrativoDAO;
import biblioteca.*;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        System.out.println("1 - Listar Alunos");
        System.out.println("2 - Listar Professores");
        System.out.println("3 - Listar Tec. Administrativos");
        System.out.println("4 - Listar Acervo");
        System.out.println("0 - Menu principal");

        int resp;
        Scanner scanner = new Scanner(System.in);
        resp = scanner.nextInt();
        if(resp == 1) {System.out.println(getAlunos()); menuRelatorios();}
        if(resp == 2) {System.out.println(getProfessores()); menuRelatorios();}
        if(resp == 3) {System.out.println(getTecAdm()); menuRelatorios();}
        if(resp == 4) {System.out.println(getLivros()); menuRelatorios();}
        if(resp == 0) menu();

    }

    private static List<Aluno> getAlunos(){
        AlunoDAO alunoDAO = new AlunoDAO();
        List<Aluno> alunos = alunoDAO.buscar();
        return  alunos;
    }

    private static List<Professor> getProfessores(){
        ProfessorDAO professorDAO = new ProfessorDAO();
        List<Professor> professors = professorDAO.buscar();
        return professors;
    }
    private static List<TecAdministrativo> getTecAdm(){
        TecAdministrativoDAO tecAdministrativoDAO = new TecAdministrativoDAO();
        List<TecAdministrativo> tecAdministrativos = tecAdministrativoDAO.buscar();
        return tecAdministrativos;

    }
    private static List<Livro> getLivros(){
        LivroDAO livroDAO = new LivroDAO();
        List<Livro> livros = livroDAO.buscar();
        return livros;
    }
    public static List<Locatario> getLocatarios(){
        List<Aluno> alunos = getAlunos();
        List<Professor> professors = getProfessores();
        List<TecAdministrativo> tecAdministrativos = getTecAdm();

        List<Locatario> locatarios = new ArrayList<Locatario>();
        locatarios.addAll(alunos);
        locatarios.addAll(professors);
        locatarios.addAll(tecAdministrativos);
        return locatarios;
    }
    private static void fazerEmprestimo() {
        List<Locatario> locatarios = getLocatarios();

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
        System.out.println("1 - Aluno");
        System.out.println("2 - Professor");
        System.out.println("3 - Tec Adm.");
        System.out.println("0 - Menu");
        Scanner scanner = new Scanner(System.in);
        int resp = scanner.nextInt();

        if(resp == 1) cadastroAluno();
        if(resp == 2) cadastroProfesor();
        if(resp == 3) cadastroTecAdm();
        if(resp == 0) menu();
    }

    private static void cadastroTecAdm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome");
        String nome = scanner.nextLine();
        System.out.println("Digite a matricula");
        String matricula = scanner.nextLine();
        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();
        TecAdministrativoDAO dao = new TecAdministrativoDAO();
        dao.inserir(new TecAdministrativo(matricula,nome,senha));
        System.out.println("Tec cadastrado com sucesso!");
        cadastraUsuario();
    }

    private static void cadastroProfesor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome");
        String nome = scanner.nextLine();
        System.out.println("Digite a matricula");
        String matricula = scanner.nextLine();
        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();
        ProfessorDAO dao = new ProfessorDAO();
        dao.inserir(new Professor(matricula,nome,senha));
        System.out.println("Professor cadastrado com sucesso!");
        cadastraUsuario();
    }

    private static void cadastroAluno() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite no nome");
        String nome = scanner.nextLine();
        System.out.println("Digite a matricula");
        String matricula = scanner.nextLine();
        System.out.println("Digite a senha: ");
        String senha = scanner.nextLine();
        AlunoDAO dao = new AlunoDAO();
        dao.inserir(new Aluno(matricula,nome,senha));
        System.out.println("Aluno cadastrado com sucesso!");
        cadastraUsuario();
    }

    public static void main(String[] args) {
        menu();
    }
}
