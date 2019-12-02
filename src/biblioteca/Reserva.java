package biblioteca;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Reserva {

    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z");

    private int numero = 0;
    private Livro livro;
    private Locatario locatario;
    private Date data_inicio_reserva;
    private Date data_fim_reserva;

    public Reserva(Livro livro, Locatario locatario) {
        this.locatario = locatario;
        this.numero = ++numero;
        this.livro = livro;
        Date date = new Date(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();

        this.data_inicio_reserva = date;
        c.setTime(date);
        c.add(Calendar.DATE, +7);// por enquanto 7 dias para todos os usuarios, mas tenho que mudar de acordo com o config//
        this.data_fim_reserva = c.getTime();
        System.out.println("Fim da reserva:     "+ this.data_fim_reserva);
    }
    public long getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Livro getLivro() {
        return livro;
    }

    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public String getData_inicio_reserva() {
        return formatter.format(data_inicio_reserva);

    }

    public void setData_inicio_reserva(Date data_inicio_reserva) {
        this.data_inicio_reserva = data_inicio_reserva;
    }

    public String getData_fim_reserva() {
        return formatter.format(data_fim_reserva);
    }

    public void setData_fim_reserva(Date data_fim_reserva) {
        this.data_fim_reserva = data_fim_reserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "numero=" + numero +
                ", livro=" + livro +
                ", data_inicio_reserva=" + formatter.format(data_inicio_reserva)  +
                ", data_fim_reserva=" + formatter.format(data_fim_reserva)  +
                '}';
    }
}
