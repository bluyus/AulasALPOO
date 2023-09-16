/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula;

/**
 *
 * @author Usuario
 */
public class AulaInterfaceGrafica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IBancoDeDadosCliente dao = new DaoMemoria();
        
        frmTelaPrincipal tela = new frmTelaPrincipal();
        tela.setVisible(true);
        tela.dao = dao;
        tela.show();
        
        
        
   
        
        dao.Listar();
        
        
    }
    
}
