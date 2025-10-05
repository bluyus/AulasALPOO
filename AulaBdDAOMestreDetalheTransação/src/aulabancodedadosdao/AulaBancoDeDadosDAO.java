/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulabancodedadosdao;

import sqlserver.SqlServerDAO;
import entidades.Cliente;
import entidades.ItemVenda;
import entidades.Venda;
import java.util.Date;
import mysql.MySqlDAO;

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
        c1.Id = 1;
        c1.nome = "joao";
        c1.contato = "12313123";
        
        ItemVenda iv1 = new ItemVenda();
        iv1.IdItemVenda = 1;
        iv1.NomeProduto = "Camiseta";
        iv1.Preco = 30f;
        iv1.Quantidade = 1;
        
        ItemVenda iv2 = new ItemVenda();
        iv2.IdItemVenda = 1;
        iv2.NomeProduto = "Camiseta";
        iv2.Preco = 12.29f;
        iv2.Quantidade = 1;        

        Venda v1 = new Venda();
        v1.Cliente = c1;
        v1.Data = new Date();
        v1.ItemVenda.add(iv1);
        v1.ItemVenda.add(iv2);      
        
        IBancoDAO banco = new MySqlDAO();//  SqlServerDAO();
        banco.SalvarCliente(c1);            
    }
    
}
