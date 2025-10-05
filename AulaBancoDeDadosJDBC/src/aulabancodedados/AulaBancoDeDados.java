/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulabancodedados;

import java.util.List;

/**
 *
 * @author Stefano
 */
public class AulaBancoDeDados {

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
