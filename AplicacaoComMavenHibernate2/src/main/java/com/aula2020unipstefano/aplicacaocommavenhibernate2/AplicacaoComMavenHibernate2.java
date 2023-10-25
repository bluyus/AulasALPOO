/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.aula2020unipstefano.aplicacaocommavenhibernate2;


import exemplo1.Cliente;
import exemplo1.Endereco;
import exemplo2.Pessoa;
import exemplo3.Item;
import exemplo3.Venda;
import exemplo4.ItemPedido;
import exemplo4.Pedido;
import exemplo5.Ator;
import exemplo5.Filme;
import exemplo6.Loja;
import exemplo6.Produto;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Stefano
 */
public class AplicacaoComMavenHibernate2 {

    public static void main(String[] args) {
        try
        {   
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
            EntityManager entityManager = entityManagerFactory.createEntityManager();

            DuasClassesMesmaTabela(entityManager);
            //RelacionamentoUmParaUm(entityManager);
            //RelacionamentoUmParaMuitosCom2Tabelas(entityManager);
            //RelacionamentoUmParaMuitosCom3Tabelas(entityManager);
            //RelacionamentoMuitosParaMuitos(entityManager);
            //RelacionamentoUmParaMuitosBidirecional(entityManager);

            entityManagerFactory.close();   
        }
        catch(Exception e)
        {          
            System.out.println("erro: " + e.getMessage());  
        }
    }
    
    public static void DuasClassesMesmaTabela(EntityManager entityManager)
    {
        Cliente cliente = new Cliente();
        cliente.Nome = "João";
        
        Endereco e = new Endereco();
        e.Bairro = "Centro";
        e.Cidade = "São José";
        e.Rua = "Rua A";  
        cliente.setEndereco(e);   
        
        System.out.println("Iniciando Transação.");
        entityManager.getTransaction().begin();
        
        System.out.println("Salvando o Cliente no banco de dados");

        entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        System.out.println("O cliente foi salvo com o ID = " + cliente.Id);  
    }
    
    public static void RelacionamentoUmParaUm(EntityManager entityManager)
    {
        Pessoa pessoa = new Pessoa();
        pessoa.Nome = "Maria";
        pessoa.Cpf.Numero = "1224534";
        
        System.out.println("Iniciando Transação.");
        entityManager.getTransaction().begin();
        
        System.out.println("Salvando a Pessoa no banco de dados");

        entityManager.persist(pessoa);
        entityManager.getTransaction().commit();
        System.out.println("A pessoa foi salva com o ID = " + pessoa.Id); 
        System.out.println("O Cpf foi salva com o ID = " + pessoa.Cpf.Id);
    }
    
    public static void RelacionamentoUmParaMuitosCom2Tabelas(EntityManager entityManager)
    {
        Venda venda = new Venda();            

        Item item = new Item();
        item.Produto = "Fanta";

        venda.Item.add(item);

        Item item2 = new Item();
        item2.Produto = "Sprite";

        venda.Item.add(item2);
        
        System.out.println("Iniciando Transação.");
        entityManager.getTransaction().begin();
        
        System.out.println("Salvando a Venda no banco de dados");

        entityManager.persist(venda);
        entityManager.getTransaction().commit();
        System.out.println("A Venda foi salva com o ID = " + venda.Id); 
        System.out.println("O Item 1 foi salvo com o ID = " + venda.Item.get(0).Id);
        System.out.println("O Item 2 foi salvo com o ID = " + venda.Item.get(1).Id);
    }
    
    public static void RelacionamentoUmParaMuitosCom3Tabelas(EntityManager entityManager)
    {
        Pedido pedido = new Pedido();            
            
        ItemPedido item = new ItemPedido();
        item.Produto = "Fanta";
            
        pedido.Item.add(item);
            
        ItemPedido item2 = new ItemPedido();
        item2.Produto = "Sprite";
            
        pedido.Item.add(item2);  
        
        System.out.println("Iniciando Transação.");
        entityManager.getTransaction().begin();
        
        System.out.println("Salvando a Venda no banco de dados");

        entityManager.persist(pedido);
        entityManager.getTransaction().commit();
        System.out.println("O Pedido foi salvo com o ID = " + pedido.Id); 
        System.out.println("O Item 1 foi salvo com o ID = " + pedido.Item.get(0).Id);
        System.out.println("O Item 2 foi salvo com o ID = " + pedido.Item.get(1).Id);
    }
    
    public static void RelacionamentoMuitosParaMuitos(EntityManager entityManager)
    {
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
        
        System.out.println("Iniciando Transação.");
        entityManager.getTransaction().begin();
        
        System.out.println("Salvando os atores e filmes no banco de dados");

        entityManager.persist(ator);
        entityManager.persist(ator2);
        
        entityManager.getTransaction().commit();
        
        System.out.println("O Ator 1 foi salvo com o ID = " + ator.Id); 
        System.out.println("O Ator 2 foi salvo com o ID = " + ator2.Id);
        
        System.out.println("O Filme 1 foi salvo com o ID = " + filme.Id);
        System.out.println("O Filme 2 foi salvo com o ID = " + filme2.Id);
    }  
    
    public static void RelacionamentoUmParaMuitosBidirecional(EntityManager entityManager)
    {
        Loja loja = new Loja();            
        loja.Nome = "Loja centro";
        
        Produto produto = new Produto();
        produto.Nome = "Sapato";
        
        Produto produto2 = new Produto();
        produto2.Nome = "Camiseta";
        
        loja.addProduto(produto);
        loja.addProduto(produto2); 
        
        System.out.println("Iniciando Transação.");
        entityManager.getTransaction().begin();
        
        System.out.println("Salvando os lojas e produtos no banco de dados");

        entityManager.persist(loja);
        
        entityManager.getTransaction().commit();
        
        System.out.println("A loja foi salva com o ID = " + loja.Id); 
        System.out.println("O Produto 1 foi salvo com o ID = " + produto.Id); 
        System.out.println("O Produto 2 foi salvo com o ID = " + produto2.Id); 
    }   
    
}
