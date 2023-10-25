/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo1;

import javax.persistence.*;

/**
 *
 * @author Stefano
 */
    
@Entity
@Table(name="Cliente")
public class Cliente {
    
    public Endereco getEndereco() {
        return Endereco;
    }

    public void setEndereco(Endereco Endereco) {
        this.Endereco = Endereco;
    }
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Integer Id;
   
   @Column(length=80, nullable=false)
   public String Nome;
   
   private Endereco Endereco;
   
   //public Endereco Endereco = new Endereco();
    
}
