/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo6;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Stefano
 */
@Entity
@Table(name="Loja")
public class Loja {  
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ID_LOJA")
   public Integer Id;
   
   @Column(length=80, nullable=false)
   public String Nome;
   
    @OneToMany(
    mappedBy = "Loja",
    cascade = javax.persistence.CascadeType.ALL,
    orphanRemoval = true
    )
    public List<Produto> produto = new ArrayList<>();
    
    public void addProduto(Produto produto)
    {
        this.produto.add(produto);
        produto.Loja= this;
    }
    
    public void removerProduto(Produto produto)
    {
        this.produto.remove(produto);
        produto.Loja= null;
    }
}
