/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aulabancodedados;

import java.util.List;

/**
 *
 * @author Stefano
 */
public class AulaBancoDeDadosJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Cliente c1 = new Cliente();
        c1.nome = "João da Silva";
        c1.contato = "12988888888";
        
        Cliente c2 = new Cliente();
        c2.nome = "Maria de Souza";
        c2.contato = "12988888888";
        
        //JDBC_SqlServer banco = new JDBC_SqlServer();
        JDBC_MySql banco = new JDBC_MySql();
        
        banco.SalvarCliente(c2);     
        banco.ExcluirCliente(c1);
        
         List<Cliente> clientes = banco.ListarCliente();
         
         for (int i = 0; i <= clientes.size()-1; i++)
         {
             System.out.println(clientes.get(i).nome);
             System.out.println(clientes.get(i).contato);
         }
    }
    
}
