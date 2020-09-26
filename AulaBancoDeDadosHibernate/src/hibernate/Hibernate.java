/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernate;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.sf.ehcache.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import relacionamento1para1.Pessoa;
import relacionamento1paraNcomDuasTabelas.Item;
import relacionamento1paraNcomDuasTabelas.Venda;
import relacionamento1paraNcomTresTabelas.ItemPedido;
import relacionamento1paraNcomTresTabelas.Pedido;
import relacionamentoNparaN.Ator;
import relacionamentoNparaN.Filme;
import variasclassesunicatabela.Cliente;

/**
 *
 * @author Stefano
 */
public class Hibernate {

    /**
     * @param args the command line arguments
     */
    
    private static void MesmaTabela(EntityManager em)
    {
        em.getTransaction().begin();   

        Cliente cliente = new Cliente();
        cliente.Nome = "Stefano";
        cliente.Endereco.Bairro = "Centro";
        cliente.Endereco.Cidade = "São José";
        cliente.Endereco.Rua = "Rua A";                       

        em.persist(cliente);
        em.getTransaction().commit(); 
    }
    
    private static void Relacionamento1Para1(EntityManager em)
    {
        em.getTransaction().begin(); 
            
        Pessoa pessoa = new Pessoa();
        pessoa.Nome = "Maria";
        pessoa.Rg.Numero = "1224534";

        em.persist(pessoa);
        em.getTransaction().commit(); 
    }
    
    private static void Relacionamento1ParaN_2Tabelas(EntityManager em)
    {
        em.getTransaction().begin(); 
            
        Venda venda = new Venda();            

        Item item = new Item();
        item.Produto = "Fanta";

        venda.Item.add(item);

        Item item2 = new Item();
        item2.Produto = "Sprite";

        venda.Item.add(item2);           

        em.persist(venda);
        em.getTransaction().commit();  
    }
    
    private static void Relacionamento1ParaN_3Tabelas(EntityManager em)
    {
        em.getTransaction().begin(); 
            
        Pedido pedido = new Pedido();            
            
        ItemPedido item = new ItemPedido();
        item.Produto = "Fanta";
            
        pedido.Item.add(item);
            
        ItemPedido item2 = new ItemPedido();
        item2.Produto = "Sprite";
            
        pedido.Item.add(item2);           
              
        em.persist(pedido);
        em.getTransaction().commit();
    }
    
    private static void RelacionamentoNparaN(EntityManager em)
    {
        em.getTransaction().begin(); 
         
        Set<Filme> filmes = new HashSet<>();        
        
        Filme filme = new Filme(); 
        filme.Nome = "Iron Man 2";       
        
        Filme filme2 = new Filme(); 
        filme2.Nome = "Avengers";
        
        filmes.add(filme); 
        filmes.add(filme2);
        
        Ator ator = new Ator(); 
        ator.Nome = "Robert Downey Jr";
        ator.Filmes = filmes; 
        
        Ator ator2 = new Ator(); 
        ator2.Nome = "Scarlett Johansson";
        ator2.Filmes = filmes;         

        em.persist(ator);
        em.persist(ator2);
        
        em.getTransaction().commit();
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try
        { 
             
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernatePU");
            EntityManager em = emf.createEntityManager();      

            MesmaTabela(em);
            Relacionamento1Para1(em); 
            Relacionamento1ParaN_2Tabelas(em);
            Relacionamento1ParaN_3Tabelas(em);
            RelacionamentoNparaN(em);
                    
            em.close();
            emf.close();
        }
        catch(Exception e){
            System.out.println("Problemas ao criar a base: " + e);
        }
           
           
     
           
    }
    
}
