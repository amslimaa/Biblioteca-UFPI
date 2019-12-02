package Connections.dao;

import Connections.ConnectionFactory;
import biblioteca.Professor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {
    private Connection con;

    public ProfessorDAO(){
        con = new ConnectionFactory().getConexao();
    }
    public void inserir(Professor professor){


        String sql = "INSERT INTO professores (matricula, nome, senha) VALUES (?,?,?)";
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, professor.getMatricula());
            stmt.setString(2, professor.getNome());
            stmt.setString(3, professor.getSenha());
            stmt.executeUpdate();
            stmt.close();
        }catch (Exception erro){
            throw new RuntimeException("Erro: "+ erro);
        }
    }

    public List<Professor> buscar() {
        String sql = "SELECT * FROM biblioteca_ufpi.professores";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            List<Professor> professors = new ArrayList<Professor>();
            while (rs.next()){
                professors.add(new Professor(
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                ));
            }
            return professors;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
