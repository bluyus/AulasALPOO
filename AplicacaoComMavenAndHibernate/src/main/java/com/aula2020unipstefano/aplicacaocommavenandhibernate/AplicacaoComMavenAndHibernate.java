/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.aula2020unipstefano.aplicacaocommavenandhibernate;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Stefano
 */
public class AplicacaoComMavenAndHibernate {

    public static void main(String[] args) {
        
        try
        {   
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            Cliente cliente = new Cliente();
            cliente.setNome("João");        

            Salvar(entityManager, cliente);

            Cliente cl = ConsultarPorId(entityManager, 100);

            ConsultarTodos(entityManager);

            Excluir(entityManager, cliente);

            entityManagerFactory.close();   
        }
        catch(Exception e)
        {          
            System.out.println("erro: " + e.getMessage());  
        }
    }
    
    public static void Salvar(EntityManager entityManager, Cliente cliente){
        System.out.println("Iniciando Transação.");
        entityManager.getTransaction().begin();
        
        System.out.println("Salvando o cliente no banco de dados");

        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        System.out.println("O cliente foi salvo com o ID = " + cliente.getId());    
    }
    
    public static Cliente ConsultarPorId(EntityManager entityManager, int id){
        // Buscar um cliente pela chave primária.
        Cliente clienteBusca = entityManager.find(Cliente.class, id);
        //System.out.println("Obteve o cliente " + clienteBusca.getNome()+ " " + clienteBusca.getId());
        return clienteBusca;      
    }
    
    public static void ConsultarTodos(EntityManager entityManager){
        @SuppressWarnings("unchecked")
        List<Cliente> listCliente = entityManager.createQuery("SELECT c FROM Cliente c").getResultList();

        if (listCliente == null)
                System.out.println("Nenhum cliente encontrado.");
        else 
        {
            for (Cliente c : listCliente) 
                System.out.println("Cliente [nome] = " + c.getNome()+ ", [id] " + c.getId());             
        }
    }
    
    public static void Excluir(EntityManager entityManager, Cliente c){
        entityManager.getTransaction().begin();
        System.out.println("Excluir o cliente com o ID = " + c.getId());
        entityManager.remove(c);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    
}
