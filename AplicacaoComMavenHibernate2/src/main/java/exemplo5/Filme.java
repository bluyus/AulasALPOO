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
@Table(name="Filme")
public class Filme {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer Id;
    
    public String Nome; 
    
    @ManyToMany(mappedBy = "Filmes")
    private Set<Ator> Atores = new HashSet<>();
}

