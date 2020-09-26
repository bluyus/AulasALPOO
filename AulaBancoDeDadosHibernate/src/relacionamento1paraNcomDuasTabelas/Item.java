/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relacionamento1paraNcomDuasTabelas;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Stefano
 */

@Entity
@Table(name="ItemVenda")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer Id;
    
    public String Produto;  
}
