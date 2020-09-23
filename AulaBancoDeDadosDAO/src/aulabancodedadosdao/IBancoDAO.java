/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulabancodedadosdao;

import java.util.List;

/**
 *
 * @author Stefano
 */
public interface IBancoDAO {
    
    void SalvarCliente(Cliente c);
    
    void ExcluirCliente(Cliente c);
    
    List<Cliente> ListarCliente();
    
}
