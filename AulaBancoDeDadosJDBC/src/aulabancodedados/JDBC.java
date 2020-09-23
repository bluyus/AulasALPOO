/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulabancodedados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefano
 */
public class JDBC {
    
    public Connection connection = null;
    public Statement smt;
    
    public JDBC()
    {
        // configurações do banco de dados
        
        String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=ExercicioJDBC";

        try {
            Class.forName(DRIVER); // Carrega o Driver

            // Obtém a conexão com a base de dados
            connection = DriverManager.getConnection(DATABASE_URL, "sa", "masterkey");
            smt = connection.createStatement();
            System.out.println("Conectou com o banco de dados");

        } catch (SQLException|ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }  
    }
    
    
    public void SalvarCliente(Cliente c)
    {
        try{
        //Statement smt = connection.createStatement();
        smt.executeUpdate("insert into cliente (nome, contato) values ('" +  c.nome + "','" + c.contato + "')");
        System.out.println("Inseriu um cliente");
        }
        catch(SQLException ex)
        {
          System.out.println(ex.getMessage());  
        }
    }
    
    public void ExcluirCliente(Cliente c)
    {
        try{
        
        smt.executeUpdate("delete from cliente where nome = '" + c.nome + "'");
        System.out.println("Excluiu um cliente");
        }
        catch(SQLException ex)
        {
          System.out.println(ex.getMessage());  
        }
    }
    
    public List<Cliente> ListarCliente()
    {
        List<Cliente> resultado = new ArrayList<Cliente>();
        
        try{
        //Statement smt = connection.createStatement();
        ResultSet resultSet = smt.executeQuery("select * from cliente");
        
        while (resultSet.next()) {
           // System.out.println(resultSet.getString("NOME"));
            
            Cliente c = new Cliente();
            c.nome = resultSet.getString("NOME");
            c.contato = resultSet.getString("CONTATO");
            
            resultado.add(c);
        }

        return resultado;
        
        }
        catch(SQLException ex)
        {
          System.out.println(ex.getMessage());  
          return null;
        }
    }
    
}
