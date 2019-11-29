package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/biblioteca_ufpi?useTimezone=true&serverTimezone=UTC";


    static final String USER = "root";
    static final String PASS = "486215loko";

    public Connection getConexao(){
        try {
            return DriverManager.getConnection(DB_URL,USER,PASS);
        }catch (SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
            throw new RuntimeException("Erro 1" + ex);
        }
    }
}