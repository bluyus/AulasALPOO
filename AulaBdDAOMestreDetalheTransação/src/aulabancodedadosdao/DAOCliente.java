/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulabancodedadosdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Stefano
 */
public class DAOCliente implements IDAOGenerico {

    public Connection connection = null;
    public Statement smt;
    
    public DAOCliente()
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
    public void Salvar(Object o) {
        
        Cliente c = (Cliente)o;
        
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
    public void Excluir(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> Listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
