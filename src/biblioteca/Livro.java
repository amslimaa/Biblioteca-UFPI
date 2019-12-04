package biblioteca;

import java.sql.Date;

public class Livro {
    private int codigo, quanditade;
    private int ano;
    private String titulo, autor;

    public Livro(int codigo, int quanditade, int ano, String titulo, String autor) {
        this.codigo = codigo;
        this.quanditade = quanditade;
        this.ano = ano;
        this.titulo = titulo;
        this.autor = autor;
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuanditade() {
        return quanditade;
    }

    public void setQuanditade(int quanditade) {
        this.quanditade = quanditade;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "codigo=" + codigo +
                ", quanditade=" + quanditade +
                ", ano=" + ano +
                ", titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
