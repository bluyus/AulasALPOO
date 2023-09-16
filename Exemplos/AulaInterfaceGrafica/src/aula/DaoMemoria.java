/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class DaoMemoria implements IBancoDeDadosCliente {
    
    private List<Cliente> dados = new LinkedList();
    
    public void Salvar(Cliente c){
       dados.add(c);
    }
    
    public List<Cliente> Listar(){
        
        for (Cliente c: dados){
            System.out.println(c.getNome());
        }
        
        return dados;
    } 
}
