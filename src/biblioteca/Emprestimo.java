package biblioteca;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Emprestimo {
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z");

    private int numero = 0;
    private Livro livro;
    private Locatario locatario;
    private Date data_emp, data_dev;

    public Emprestimo(Livro livro, Locatario locatario) {
        this.numero = ++numero;
        this.livro = livro;
        this.locatario = locatario;

        Date date = new Date(System.currentTimeMillis());
        Calendar c = Calendar.getInstance();

        this.data_emp = date;

        c.setTime(date);
        c.add(Calendar.DATE, +7);// por enquanto 7 dias para todos os usuarios, mas tenho que mudar de acordo com o config//
        this.data_dev = c.getTime();

        System.out.println("Fim do emprestimo: " + this.data_dev);
    }

    public SimpleDateFormat getFormatter() {
        return formatter;
    }


    public int getNumero() {
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

    public Locatario getLocatario() {
        return locatario;
    }

    public void setLocatario(Locatario locatario) {
        this.locatario = locatario;
    }

    public String getData_emp() {
        return formatter.format(this.data_emp);
    }

    public void setData_emp(Date data_emp) {
        this.data_emp = data_emp;
    }

    public String getData_dev() {
        return formatter.format(this.data_dev);
    }

    public void setData_dev(Date data_dev) {
        this.data_dev = data_dev;
    }

    @Override
    public String toString() {
        return "Emprestimo{" +
                "numero=" + numero +
                ", livro=" + livro +
                ", locatario=" + locatario +
                ", data_emp=" + formatter.format(data_emp)  +
                ", data_dev=" + formatter.format(data_dev)  +
                '}';
    }
}