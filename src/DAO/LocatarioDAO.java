package DAO;


import biblioteca.Locatario;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LocatarioDAO {

    private Connection conn;
    private PreparedStatement stmt;


    public LocatarioDAO(){
        conn = new ConnectionFactory().getConexao();


    }
    public void inserir(Locatario l){
        String sql = "INSERT INTO locatario (matricula, nome, tipo, senha) VALUES (?,?,?,?)";
        try{
            /*stmt = conn.prepareStatement(sql);
            stmt.setInt(1, l.getMatricula());
            stmt.setString(2, l.getSenha());
            stmt.setString(3, l.getNome());
            stmt.setString(4, l.getTipo());
            stmt.execute();
            stmt.close();*/
        }catch (Exception erro){
            throw new RuntimeException("Erro: "+ erro);
        }

    }

    public void deletar(Locatario l){
        String sql = "";
        try{

        }catch (Exception erro){
            throw new RuntimeException("Erro: "+ erro);
        }

    }
    public void atualizar(Locatario l){
        String sql = "";
        try{

        }catch (Exception erro){
            throw new RuntimeException("Erro: "+ erro);
        }

    }

}
