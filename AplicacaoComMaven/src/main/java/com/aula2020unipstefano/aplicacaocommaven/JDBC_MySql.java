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
public class JDBC_MySql {
    
    private String EnderecoBanco = "jdbc:mysql://localhost:3306/teste";
    
    private String Driver = "com.mysql.cj.jdbc.Driver"; 
    
    public Statement smt;
    
    private Connection connection;
    
    private Connection retornarConexao()
    {
        try 
        {
            // Opcional: carregar explicitamente o driver
            Class.forName(Driver);

            String user = "root";                             
            String password = "admin"; 
            
            // Criar a conexão
            connection = DriverManager.getConnection(EnderecoBanco, user, password);
            smt = connection.createStatement();
            System.out.println("Conectou com o banco de dados");


        } catch (ClassNotFoundException ex) 
        {
            System.out.println("Driver JDBC não encontrado!");
            System.out.println(ex.getMessage());
        } catch (SQLException ex) 
        {
            System.out.println("Erro ao conectar no banco de dados!");
            System.out.println(ex.getMessage());
        }     
        return connection;
    }
    
    public Connection getConnection() {
        return retornarConexao(); 
    }
    
    public JDBC_MySql(){   
        this.connection = retornarConexao();
    } 

    public void Salvar(Ator ator) throws SQLException
    {
        smt.executeUpdate("INSERT INTO ATOR (Sexo, Nome) values ('" + ator.Sexo + "','" + ator.Nome + "')");
        System.out.println("Salvou um ator");
    }  
}
