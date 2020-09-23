/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulabancodedadosdao;

import java.util.List;

/**
 *
 * @author Stefano
 */
public class AulaBancoDeDadosDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
        Cliente c1 = new Cliente();
        c1.nome = "Stefano";
        c1.contato = "12988888888";
        
        Cliente c2 = new Cliente();
        c2.nome = "Stefano 2";
        c2.contato = "12988888888";
        
        IBancoDAO banco = new SqlServerDAO(); //new ();
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
