/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;

import java.util.List;

/**
 *
 * @author Usuario
 */
public interface IBancoDeDadosCliente {
    public List<Cliente> Listar();
    public void Salvar(Cliente c);
}
