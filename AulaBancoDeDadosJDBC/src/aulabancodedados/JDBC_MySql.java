/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

/* 
   DOWNLOAD DO BANCO DISPONIVEL EM: https://dev.mysql.com/downloads/file/?id=544661
   VERSAO: 8.0.43 

   DRIVER DO JDBC DISPONIVEL NO LINK: https://dev.mysql.com/downloads/connector/j/
   Escolher a opcao de plataforma independente. 
*/


public class JDBC_MySql {
   
    public Connection connection = null;
    public Statement smt;
    
    public JDBC_MySql(){
        try 
        {
            // Opcional: carregar explicitamente o driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/teste";
            String user = "root";                             
            String password = "admin"; 
            
            // Criar a conexão
            connection = DriverManager.getConnection(url, user, password);
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
        List<Cliente> resultado = new ArrayList<>();
        
        try{
        ResultSet resultSet = smt.executeQuery("select * from cliente");
        
        while (resultSet.next()) {       
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
