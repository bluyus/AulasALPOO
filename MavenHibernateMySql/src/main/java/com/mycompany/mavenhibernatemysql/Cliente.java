/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenhibernatemysql;

import javax.persistence.*;

/**
 *
 * @author Stefano
 */
@Entity
@Table(name="Cliente")
public class Cliente {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ClienteId")
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }
    
    @Column(name = "Nome", nullable = false, length = 100)
    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    @Column(name = "Telefone", nullable = false, length = 20)
    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }
    
    private Integer Id;
    private String Nome;
    private String Telefone;
}
