/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulabancodedadosdao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Stefano
 */
public class Venda {
    
    public Integer Id;
    
    public Cliente Cliente;
    
    public Date Data;
    
    public List<ItemVenda> ItemVenda = new ArrayList<>();   
}
