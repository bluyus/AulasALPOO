/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionamento1ParaNDuasTabelasBidirecional;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Stefano
 */

@Entity(name="LojaProduto")
@Table(name="Produto")
public class Produto {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "ID_PRODUTO")
   public Integer Id;
   
   @Column(length=80, nullable=false)
   public String Nome;
    
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="IDFK_LOJA")
   public Loja Loja;
   
   @Override
   public boolean equals(Object o)
   {
       if (this == o) return true;
       if (!(o instanceof Produto)) return false;
       return Id != null && Id.equals(((Loja) o).Id);
   }
   
   @Override
   public int hashCode()
   {
       return 31;
   }
}
