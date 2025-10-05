/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulabancodedadosdao;

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
public class MySqlDAO implements IBancoDAO {

    public Connection connection = null;
    public Statement smt;
    
     public MySqlDAO()
    {
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
    
    
    @Override
    public void SalvarCliente(Cliente c) {
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

    @Override
    public void ExcluirCliente(Cliente c) {
        try{
        
        smt.executeUpdate("delete from cliente where nome = '" + c.nome + "'");
        System.out.println("Excluiu um cliente");
        }
        catch(SQLException ex)
        {
          System.out.println(ex.getMessage());  
        }
    }

    @Override
    public List<Cliente> ListarCliente() {
        List<Cliente> resultado = new ArrayList<>();
        
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
