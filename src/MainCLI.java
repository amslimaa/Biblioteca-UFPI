import biblioteca.Biblioteca;
import biblioteca.Locatario;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainCLI {



    public static void main(String[] args) {
        Biblioteca biblioteca_ufpi = new Biblioteca();

        biblioteca_ufpi.addAluno(20179135666L, "Amós Lima", "486215loko");
        //biblioteca_ufpi.listarUsuarios();

        biblioteca_ufpi.addLivro(001,20,1998,"O pequeno principe","Antonie de sá exuperi");
        //biblioteca_ufpi.listarAcervo();


        biblioteca_ufpi.emprestimo(biblioteca_ufpi.getAcervo().get(0),biblioteca_ufpi.getUsuarios().get(0));
        biblioteca_ufpi.reserva(biblioteca_ufpi.getAcervo().get(0), biblioteca_ufpi.getUsuarios().get(0));
        //biblioteca_ufpi.listarEmprestimo();
        biblioteca_ufpi.listarAcervo();
        biblioteca_ufpi.listarReservas();
        /*biblioteca_ufpi.reserva(1,biblioteca_ufpi.getAcervo().get(0));
        biblioteca_ufpi.listarReservas();*/

    }
}
