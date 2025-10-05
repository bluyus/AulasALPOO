/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulabancodedadosdao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Stefano
 */
public class MemoriaClienteDAO implements IBancoDAO {
    
    private List<Cliente> bancoMemoria;
    
    public MemoriaClienteDAO()
    {
        bancoMemoria = new ArrayList<Cliente>();
    }

    public void SalvarVenda(Venda v) {
        //bancoMemoria.add(c);
    }
    
    @Override
    public void SalvarCliente(Cliente c) {
        bancoMemoria.add(c);
    }

    @Override
    public void ExcluirCliente(Cliente c) {
        bancoMemoria.remove(c);
    }

    @Override
    public List<Cliente> ListarCliente() {
        return bancoMemoria;
    }   
}
