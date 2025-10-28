/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenhibernatemysql;

import java.sql.SQLException;
import javax.persistence.*;

/**
 *
 * @author Stefano
 */
public class MavenHibernateMySql {

    public static void main(String[] args) throws SQLException {
        
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        
        Cliente c = new Cliente();
        c.setNome("Fernanda Montenegro");
        c.setTelefone("12-922384488");
        
        try
        {
         Salvar(entityManager, c);   
        }
        catch(Exception e){
        System.out.println("Erro: " + e.getMessage());    
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
}
