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
@Table(name="Cpf")
public class Cpf {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CPF")
    public Integer Id;
    
    @Column(length=13, nullable=false)
    public String Numero;
}
