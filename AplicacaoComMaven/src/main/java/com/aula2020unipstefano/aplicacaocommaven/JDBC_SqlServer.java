/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aula2020unipstefano.aplicacaocommaven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Stefano
 */
public class JDBC_SqlServer {
    
    private String EnderecoBanco = "jdbc:sqlserver://localhost:1433;databaseName=ExercicioCinema;trustServerCertificate=true";
    
    private String Driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    
    public Statement smt;
    
    private Connection connection;
    
    private Connection retornarConexao()
    {
        try {
            Class.forName(Driver); // Carrega o Driver

            // Obtém a conexão com a base de dados
            connection = DriverManager.getConnection(EnderecoBanco, "sa", "masterkey");
            smt = connection.createStatement();
            System.out.println("Conectou com o banco de dados");

        } catch (SQLException|ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }       
        return connection;
    }
    
    public Connection getConnection() {
        return retornarConexao(); 
    }
    
    public JDBC_SqlServer(){   
        this.connection = retornarConexao();
    } 

    public void Salvar(Ator ator) throws SQLException
    {
        smt.executeUpdate("INSERT INTO ATOR (Sexo, Nome) values ('" + ator.Sexo + "','" + ator.Nome + "')");
        System.out.println("Salvou um ator");
    }  
}
