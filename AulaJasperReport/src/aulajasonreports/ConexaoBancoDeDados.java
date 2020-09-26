/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulajasonreports;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Stefano
 */
public class ConexaoBancoDeDados {
    
    public Connection criarConexao() {
        final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        final String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=Seguradora";
        Connection connection = null;
        try {
            Class.forName(DRIVER); // Carrega o Driver
// Obtém a conexão com a base de dados
            connection = DriverManager.getConnection(DATABASE_URL, "sa", "masterkey");
               System.out.println("DB Connection started"); 
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } finally {
          
        }
        return connection;
    }
    
}
