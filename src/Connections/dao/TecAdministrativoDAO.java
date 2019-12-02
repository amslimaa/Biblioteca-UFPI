package Connections.dao;

import Connections.ConnectionFactory;
import biblioteca.TecAdministrativo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TecAdministrativoDAO {
    private Connection con;

    public TecAdministrativoDAO(){
        con = new ConnectionFactory().getConexao();
    }

    public void inserir(TecAdministrativo tecAdministrativo){
        String sql = "INSERT INTO tecadministrativos (matricula, nome, senha) VALUES (?,?,?)";
        PreparedStatement stmt = null;

        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, tecAdministrativo.getMatricula());
            stmt.setString(2, tecAdministrativo.getNome());
            stmt.setString(3, tecAdministrativo.getSenha());
            stmt.executeUpdate();
            stmt.close();
        }catch (Exception erro){
            throw new RuntimeException("Erro: "+ erro);
        }
    }
    public List<TecAdministrativo> buscar() {
        String sql = "SELECT * FROM biblioteca_ufpi.tecadministrativos";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();

            List<TecAdministrativo> tecAdministrativos = new ArrayList<TecAdministrativo>();
            while (rs.next()){
                tecAdministrativos.add(new TecAdministrativo(
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)
                ));
            }
            return tecAdministrativos;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
