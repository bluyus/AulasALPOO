/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo6;

import javax.persistence.*;

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
