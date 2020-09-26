/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionamentoNparaN;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Stefano
 */

@Entity
@Table(name="Ator")
public class Ator {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    
    public String Nome; 
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Ator_Filme",
            joinColumns = {@JoinColumn(name= "IDFK_ATOR")},
            inverseJoinColumns = {@JoinColumn(name= "IDFK_FILME")}
    )
    public Set<Filme> Filmes = new HashSet<>();
}
