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
import variasclassesunicatabela.Cliente;

/**
 *
 * @author Stefano
 */
public class Hibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try
        { 
             
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernatePU");
            EntityManager em = emf.createEntityManager();      

            // Mesma tabela
            em.getTransaction().begin();   

            Cliente cliente = new Cliente();
            cliente.Nome = "Stefano";
            cliente.Endereco.Bairro = "Centro";
            cliente.Endereco.Cidade = "São José";
            cliente.Endereco.Rua = "Rua A";                       

            em.persist(cliente);
            em.getTransaction().commit(); 
            
            // Relacionamento 1 para 1
            em.getTransaction().begin(); 
            
            Pessoa pessoa = new Pessoa();
            pessoa.Nome = "Maria";
            pessoa.Rg.Numero = "1224534";
            
            em.persist(pessoa);
            em.getTransaction().commit();

            // Relacionamento 1 para muitos (com 2 tabelas)
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
                  
            em.close();
            emf.close();
        }
        catch(Exception e){
            System.out.println("Problemas ao criar a base: " + e);
        }
           
           
     
           
    }
    
}
