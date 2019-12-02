package Connections.dao;
import Connections.ConnectionFactory;
import biblioteca.Aluno;
import biblioteca.Locatario;
import biblioteca.Professor;
import biblioteca.TecAdministrativo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LocatarioDAO {

    private Connection conn = null;


    public LocatarioDAO(){
        conn = new ConnectionFactory().getConexao();
    }
    public void inserir(Locatario l, String tipo){
        String queryTipo = "";
        if(tipo == "Aluno") queryTipo = "alunos";
        if(tipo == "Professor") queryTipo = "professores";
        if(tipo == "TecAdministrativo") queryTipo = "tecadministrativos";

        String sql = "INSERT INTO "+queryTipo+" (matricula, nome, senha) VALUES (?,?,?)";
        PreparedStatement stmt = null;

        try{
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, l.getMatricula());
            stmt.setString(2, l.getNome());
            stmt.setString(3, l.getSenha());
            stmt.executeUpdate();
            stmt.close();
        }catch (Exception erro){
            throw new RuntimeException("Erro: "+ erro);
        }
    }


    public List<Locatario> findAll(String tipo){

        String queryTipo = "";

        if(tipo == "Aluno") queryTipo = "alunos";
        if(tipo == "Professor") queryTipo = "professores";
        if(tipo == "TecAdministrativo") queryTipo = "tecadministrativos";

        String sql = "SELECT * FROM biblioteca_ufpi."+queryTipo;

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Locatario> locatarios = new ArrayList<Locatario>();

        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            if(tipo == "Aluno"){
                while(rs.next()){
                    Aluno aluno = new Aluno(
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4)
                    );
                    locatarios.add(aluno);
                    return locatarios;
                }
            }else if(tipo == "Professor"){
                while(rs.next()){
                    Professor professor = new Professor(
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)
                    );
                    locatarios.add(professor);
                    return locatarios;
                }

            }else  if(tipo == "TecAdministrativo"){
                while(rs.next()){
                    TecAdministrativo tecAdministrativo = new TecAdministrativo(
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)
                    );
                    locatarios.add(tecAdministrativo);
                    return locatarios;

                }
            }
            stmt.close();
            return locatarios;
        } catch (SQLException e) {
            e.printStackTrace();
            return locatarios;
        }
    }

}
