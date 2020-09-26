/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionamento1ParaNDuasTabelasBidirecional;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
