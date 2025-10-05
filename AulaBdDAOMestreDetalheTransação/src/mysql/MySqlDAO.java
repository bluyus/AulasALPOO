/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import aulabancodedadosdao.IBancoDAO;
import entidades.Cliente;
import entidades.ItemVenda;
import entidades.Venda;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Stefano
 */
public class MySqlDAO implements IBancoDAO {

    public Connection connection = null;

    public Statement smt;
    public PreparedStatement pstmt; 
    
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
    public void SalvarVenda(Venda v) {       
        
 
        ResultSet resultSet;
        try {
            
            connection.setAutoCommit(false);   
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String data = formatter.format(v.Data);
            
            resultSet = smt.executeQuery("insert into venda "
                    + "(data, idfk_cliente) values ('" + data +
                    "'," + v.Cliente.Id.toString() + "); SELECT LAST_INSERT_ID() AS ID;");
            
            resultSet.next();
            int codigoVenda = resultSet.getInt("ID");
            
            for (ItemVenda item: v.ItemVenda)
            {            
               smt.executeUpdate("insert into itemVenda (idfk_venda, produto, "
                       + "quantidade, precounitario) values (" + 
                       String.valueOf(codigoVenda) + ",'" + item.NomeProduto + "'," +
                       String.valueOf(item.Quantidade) + ", " + 
                       String.valueOf(item.Preco) + ")"); 
            }
             
            connection.commit();  
            
        } catch (Exception ex) {
            try {
                connection.rollback();
            } catch (SQLException ex1) {
                Logger.getLogger(MySqlDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(MySqlDAO.class.getName()).log(Level.SEVERE, null, ex);          
        }
        finally
        {
            try {    
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(MySqlDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public void SalvarCliente(Cliente c) {
       try
       {
           pstmt = connection.prepareStatement("insert into cliente (nome, contato) values (?,?)");
           pstmt.setString(1, c.nome);
           pstmt.setString(2, c.contato);
           
           pstmt.executeUpdate();
           
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
