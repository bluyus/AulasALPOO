/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sqlserver;

import aulabancodedadosdao.IBancoDAO;
import entidades.Cliente;
import entidades.ItemVenda;
import entidades.Venda;
import java.sql.Connection;
import java.sql.DriverManager;
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
public class SqlServerDAO implements IBancoDAO {

    public Connection connection = null;
    public Statement smt;
    
     public SqlServerDAO()
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
    
    @Override
    public void SalvarVenda(Venda v) {       
        
 
        ResultSet resultSet;
        try {
            
            connection.setAutoCommit(false);   
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String data = formatter.format(v.Data);
            
            resultSet = smt.executeQuery("insert into venda "
                    + "(data, idfk_cliente) values ('" + data +
                    "'," + v.Cliente.Id.toString() + "); select SCOPE_IDENTITY() as ID;");
            
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
                Logger.getLogger(SqlServerDAO.class.getName()).log(Level.SEVERE, null, ex1);
            }
            Logger.getLogger(SqlServerDAO.class.getName()).log(Level.SEVERE, null, ex);          
        }
        finally
        {
            try {    
                connection.setAutoCommit(true);
            } catch (SQLException ex) {
                Logger.getLogger(SqlServerDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
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
        List<Cliente> resultado = new ArrayList<Cliente>();
        
        try{
        //Statement smt = connection.createStatement();
        ResultSet resultSet = smt.executeQuery("EXEC LISTAR_CLIENTE");
        
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
