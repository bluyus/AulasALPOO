/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulajasonreports;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Stefano
 */
public class AulaJasonReports {

    public static void ExemploRelatorioComGrupo(Connection con)
    {
        String rel = "ListagemClientes.jasper";
        JasperPrint jp = null;

        try {
            jp = JasperFillManager.fillReport(rel, null, con);
        } catch (JRException ex) {
            System.out.println(ex);
        }
        
        JasperViewer view = new JasperViewer(jp, false); 
        view.setVisible(true); 
    }
    
    public static void ExemploRelatorioSimples(Connection con)
    {
        String rel = "report1.jasper";
        JasperPrint jp = null;

        try {
            jp = JasperFillManager.fillReport(rel, null, con);
        } catch (JRException ex) {
            System.out.println(ex);
        }
        
        JasperViewer view = new JasperViewer(jp, false); 
        view.setVisible(true);
    }
    
    
    public static void ExemploRelatorioComParametro(Connection con) throws SQLException
    {
          
        Map parameters = new HashMap();
        parameters.put("parameter1", 1002);
        
        String rel = "Cliente.jasper";
        JasperPrint jp = null;

        try {
            jp = JasperFillManager.fillReport(rel, parameters, con);
        } catch (JRException ex) {
            System.out.println(ex);
        }
        
        JasperViewer view = new JasperViewer(jp, false); 
        view.setVisible(true); 
    }
    
    public static void ExemploRelatorioPDF(Connection con) throws JRException
    {
        String rel = "report1.jasper";
        JasperPrint jp = null;

        try {
            jp = JasperFillManager.fillReport(rel, null, con);
        } catch (JRException ex) {
            System.out.println(ex);
        }
        
        JasperExportManager.exportReportToPdfFile(jp, "d:\\arquivo.pdf");
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, JRException {
        // TODO code application logic here
        
        ConexaoBancoDeDados cbd = new ConexaoBancoDeDados();        
        Connection con = cbd.criarConexao();
        
        ExemploRelatorioSimples(con);
        ExemploRelatorioComGrupo(con);
        ExemploRelatorioComParametro(con);
        ExemploRelatorioPDF(con);   
    }
    
}
