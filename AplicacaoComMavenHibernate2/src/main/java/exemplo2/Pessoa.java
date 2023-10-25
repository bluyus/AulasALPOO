/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo2;

import javax.persistence.*;

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
   @JoinColumn(name = "IDFK_CPF", referencedColumnName = "ID_CPF")
   public Cpf Cpf = new Cpf();
}
