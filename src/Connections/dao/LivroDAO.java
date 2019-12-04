package Connections.dao;

import Connections.ConnectionFactory;
import biblioteca.Livro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
    private Connection con;

    public LivroDAO(){
            con = new ConnectionFactory().getConexao();
    }

    public void inserir(Livro livro){

        String sql = "INSERT INTO livros (codigo, quantidade, ano, titulo, autor) VALUES (?,?,?,?,?)";
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setInt(1,livro.getCodigo());
            stmt.setInt(2,livro.getQuanditade());
            stmt.setInt(3,livro.getAno());
            stmt.setString(4,livro.getTitulo());
            stmt.setString(5,livro.getAutor());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Livro> buscar() {
        String sql = "SELECT * FROM biblioteca_ufpi.livros";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            List<Livro> livros = new ArrayList<Livro>();
            while (rs.next()){
                livros.add(new Livro(
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6)
                ));
            }
            return livros;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
