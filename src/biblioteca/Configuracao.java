package biblioteca;

public class Configuracao {
    private double valorMultaAluno;
    private int diasReservaAluno;
    private double valorMultaProfessor;
    private int diasReservaProfessor;
    private double valorMultaAlunoTecAdministrativo;
    private int diasReservaAlunoTecAdministrativo;

    public Configuracao(double valorMultaAluno, int diasReservaAluno, double valorMultaProfessor, int diasReservaProfessor, double valorMultaAlunoTecAdministrativo, int diasReservaAlunoTecAdministrativo) {

        this.valorMultaAluno = valorMultaAluno;
        this.diasReservaAluno = diasReservaAluno;

        this.valorMultaProfessor = valorMultaProfessor;
        this.diasReservaProfessor = diasReservaProfessor;

        this.valorMultaAlunoTecAdministrativo = valorMultaAlunoTecAdministrativo;
        this.diasReservaAlunoTecAdministrativo = diasReservaAlunoTecAdministrativo;
    }
}

