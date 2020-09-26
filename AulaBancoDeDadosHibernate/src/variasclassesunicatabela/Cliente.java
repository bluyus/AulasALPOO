/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variasclassesunicatabela;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Stefano
 */

@Entity
@Table(name="Cliente")
public class Cliente {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   public Integer Id;
   
   @Column(length=80, nullable=false)
   public String Nome;
   
   public Endereco Endereco = new Endereco();
    
}
