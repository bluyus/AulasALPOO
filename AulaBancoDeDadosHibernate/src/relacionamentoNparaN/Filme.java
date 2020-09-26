/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionamentoNparaN;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import org.hibernate.annotations.ManyToAny;

/**
 *
 * @author Stefano
 */

@Entity
@Table(name="Filme")
public class Filme {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    
    public String Nome; 
    
    @ManyToMany(mappedBy = "Filmes")
    private Set<Ator> Atores = new HashSet<>();
}
