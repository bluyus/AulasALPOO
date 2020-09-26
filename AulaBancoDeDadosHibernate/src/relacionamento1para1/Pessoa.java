/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionamento1para1;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Stefano
 */

@Entity
@Table(name="Pessoa")
public class Pessoa {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ID_PESSOA")
   public Integer Id;
   
   @Column(length=80, nullable=false)
   public String Nome; 
  
   @OneToOne(cascade = javax.persistence.CascadeType.ALL)
   @JoinColumn(name = "IDFK_RG", referencedColumnName = "ID_RG")
   public Rg Rg = new Rg();
}
