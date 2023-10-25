/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo4;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

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
    public Integer Id;
    
    public Date Data;
    
    @OneToMany(
    cascade = CascadeType.ALL,
    orphanRemoval = true
    )
 
    public List<ItemPedido> Item; 
}
