/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionamento1para1;

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
@Table(name="Rg")
public class Rg {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RG")
    Integer Id;
    
    @Column(length=10, nullable=false)
    public String Numero;
    
    @Column(length=10, nullable=true)
    public String OrgaoEmissor;
}
