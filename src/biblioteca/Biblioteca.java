package biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    Configuracao config;
    List<Livro> acervo = new ArrayList<Livro>();
    List<Locatario> usuarios = new ArrayList<Locatario>();
    List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
    List<Reserva> reservas = new ArrayList<Reserva>();

    public Biblioteca(Configuracao config) {
        this.config = config;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Livro> getAcervo() {
        return acervo;
    }

    public void setAcervo(List<Livro> acervo) {
        this.acervo = acervo;
    }

    public List<Locatario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Locatario> usuarios) {
        this.usuarios = usuarios;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    public void addLivro(int codigo, int quantidade, int ano, String titulo, String autor){
        this.getAcervo().add(new Livro(
                codigo,
                quantidade,
                ano,
                titulo,
                autor));
    }
    public void addAluno(String matricula, String nome, String senha){
        this.getUsuarios().add(new Aluno(
                matricula,
                nome,
                senha
        ));
    }
    public void addProfessor(String matricula, String nome, String senha){
        this.getUsuarios().add(new Professor(
                matricula,
                nome,
                senha
        ));
    }
    public void addTecnico(String matricula, String nome, String senha){
        this.getUsuarios().add( new TecAdministrativo(
                matricula,
                nome,
                senha
        ));
    }
    public void emprestimo(Livro livro, Locatario locatario ){
        this.getEmprestimos().add(new Emprestimo(
                livro,
                locatario
        ));
        for (Livro livrolacado: this.getAcervo()) {
            if (livrolacado.getCodigo() == livro.getCodigo()) livrolacado.setQuanditade(livrolacado.getQuanditade()-1);
        }
    }
    public void devolucao(long numero, Livro livro, Locatario locatario){
        livro.setQuanditade(livro.getQuanditade()+1);
    }
    public void reserva( Livro livro, Locatario locatario){
        this.getReservas().add(new Reserva(
                livro,
                locatario
        ));

        for (Livro livroReservado: this.getAcervo()){
            if(livroReservado.getCodigo() == livro.getCodigo()) livroReservado.setQuanditade(livroReservado.getQuanditade()-1);
        }
    }
    public void listarUsuarios(){
        for (Locatario usuario: this.getUsuarios()) {
            System.out.println(usuario.toString());
        }
    }
    public void listarAcervo(){
        for (Livro livro: this.getAcervo()) {
            System.out.println(livro.toString());
        }
    }
    public void listarEmprestimo(){
        for (Emprestimo emprestimo: this.getEmprestimos()) {
            System.out.println(emprestimo.toString());
        }
    }
    public void listarReservas(){
        for (Reserva reserva: this.getReservas()) {
            System.out.println(reserva.toString());
        }
    }



}