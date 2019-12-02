package Connections.dao;

import Connections.ConnectionFactory;
import biblioteca.Aluno;
import biblioteca.Locatario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {
    private Connection con;

    public AlunoDAO() {
        con = new ConnectionFactory().getConexao();
    }

    public void inserir(Aluno aluno) {


        String sql = "INSERT INTO alunos (matricula, nome, senha) VALUES (?,?,?)";
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, aluno.getMatricula());
            stmt.setString(2, aluno.getNome());
            stmt.setString(3, aluno.getSenha());
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception erro) {
            throw new RuntimeException("Erro: " + erro);
        }
    }

    public List<Aluno>  buscar() {
        String sql = "SELECT * FROM biblioteca_ufpi.alunos";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            List<Aluno> alunos = new ArrayList<Aluno>();
            while (rs.next()){
                alunos.add(new Aluno(
                   rs.getString(2),
                   rs.getString(3),
                   rs.getString(4)
                ));
            }
            return alunos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}