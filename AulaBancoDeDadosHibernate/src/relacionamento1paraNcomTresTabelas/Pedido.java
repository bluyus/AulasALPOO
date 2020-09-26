/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionamento1paraNcomTresTabelas;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import relacionamento1paraNcomDuasTabelas.Item;

/**
 *
 * @author Stefano
 */

@Entity
@Table(name="Pedido")
public class Pedido {
    
    public Pedido()
    {
        this.Item = new ArrayList<>();
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    
    public Date Data;
    
    @OneToMany(
    cascade = CascadeType.ALL,
    orphanRemoval = true
    )
 
    public List<ItemPedido> Item; 
}
