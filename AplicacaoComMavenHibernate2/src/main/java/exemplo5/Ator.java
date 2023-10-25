/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo5;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Stefano
 */
@Entity
@Table(name="Ator")
public class Ator {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer Id;
    
    public String Nome; 
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "Ator_Filme",
            joinColumns = {@JoinColumn(name= "IDFK_ATOR")},
            inverseJoinColumns = {@JoinColumn(name= "IDFK_FILME")}
    )
    public Set<Filme> Filmes = new HashSet<>();
}