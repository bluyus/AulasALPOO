/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aulatabelas;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Action;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author Stefano
 */
public class AulaTabelas {

    /**
     * @param args the command line arguments
     */
    
    static JPopupMenu popup; 
    static JTable tabelaExemplo8;
    
    public static void Exemplo1()
    {
        JFrame janela = new JFrame("JTable");
        janela.getContentPane().setLayout(null);
                
        JTable tabela = new JTable(3, 4);
        tabela.setBounds(0, 100, 600, 200);        
        janela.add(tabela);
        
        janela.setBounds(0, 0, 600, 600);        
        janela.setVisible(true);
    }
    
    public static void Exemplo2()
    {
        JFrame janela = new JFrame("JTable");
        janela.getContentPane().setLayout(null);
                
        JTable tabela = new JTable(60, 4);
        
        JScrollPane scrolTabela = new JScrollPane(tabela);        
        scrolTabela.setBounds(0, 100, 580, 200);        
        janela.add(scrolTabela);
        
        janela.setBounds(0, 0, 600, 600);        
        janela.setVisible(true);
    }
    
    public static void Exemplo3()
    {
        JFrame janela = new JFrame("JTable");
        janela.getContentPane().setLayout(null);
         
        String[] cabecalho = {"UF", "Cidade", "Bairro", "Rua"};
        
        JTable tabela = new JTable(new Object[60][4], cabecalho);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                
        JScrollPane scrolTabela = new JScrollPane(tabela);        
        scrolTabela.setBounds(0, 100, 580, 200);        
        janela.add(scrolTabela);
        
        janela.setBounds(0, 0, 600, 600);        
        janela.setVisible(true);
    }
    
    public static void Exemplo4()
    {
        JFrame janela = new JFrame("JTable");
        janela.getContentPane().setLayout(null);
         
        String[] cabecalho = {"UF", "Cidade", "Bairro", "Rua"};
        String[][] conteudo = {{null, null, null, null},
                               {"SP", "São José dos Campos", "Centro", null}};
        
        JTable tabela = new JTable(conteudo, cabecalho);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                
        JScrollPane scrolTabela = new JScrollPane(tabela);        
        scrolTabela.setBounds(0, 100, 580, 200);        
        janela.add(scrolTabela);
        
        janela.setBounds(0, 0, 600, 600);        
        janela.setVisible(true);
    }
    
    public static void Exemplo5()
    {
        JFrame janela = new JFrame("JTable");
        janela.getContentPane().setLayout(null);
        
        DefaultTableModel dados = new DefaultTableModel();
        dados.addColumn("UF");
        dados.addColumn("Cidade");
        dados.addColumn("Bairro");
        dados.addColumn("Rua");       
        
        JTable tabela = new JTable(dados);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                
        JScrollPane scrolTabela = new JScrollPane(tabela);        
        scrolTabela.setBounds(0, 100, 580, 200);        
        janela.add(scrolTabela);
        
        janela.setBounds(0, 0, 600, 600);        
        janela.setVisible(true);
    }
    
    public static void Exemplo6()
    {
        JFrame janela = new JFrame("JTable");
        janela.getContentPane().setLayout(null);
        
        DefaultTableModel dados = new DefaultTableModel();
        dados.addColumn("UF");
        dados.addColumn("Cidade");
        dados.addColumn("Bairro");
        dados.addColumn("Rua");       
        
        JTable tabela = new JTable(dados);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                
        JScrollPane scrolTabela = new JScrollPane(tabela);        
        scrolTabela.setBounds(0, 100, 580, 200);        
        janela.add(scrolTabela);
        
        Object[] linha = {null, null, null, null};
        dados.addRow(linha);
        
        JLabel label = new JLabel("UF");
        label.setBounds(10, 50, 30, 30);        
        janela.add(label);
        
        JTextField edtEstado = new JTextField();
        edtEstado.setText("SP");
        edtEstado.setBounds(30, 50, 30, 30);        
        janela.add(edtEstado);
        
        Object[] linha2 = {edtEstado.getText(), "São José dos Campos", "Centro", null};
        dados.addRow(linha2);
        
        janela.setBounds(0, 0, 600, 600);        
        janela.setVisible(true);
    }
    
    public static void Exemplo7()
    {
        JFrame janela = new JFrame("JTable");
        janela.getContentPane().setLayout(null);
        
        DefaultTableModel dados = new DefaultTableModel();
        dados.addColumn("UF");
        dados.addColumn("Cidade");   
        
        JTable tabela = new JTable(dados);
        tabela.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                
        JScrollPane scrolTabela = new JScrollPane(tabela);        
        scrolTabela.setBounds(0, 100, 580, 200);        
        janela.add(scrolTabela);
        
        String[] estados = {"SP", "RJ", "MG"};
        TableColumn coluna = tabela.getColumnModel().getColumn(0);
        
        JComboBox combo = new JComboBox(estados);
        coluna.setCellEditor(new DefaultCellEditor(combo));
        
        Object[] linha = {null, null, null, null};
        dados.addRow(linha);      
     
        janela.setBounds(0, 0, 600, 600);        
        janela.setVisible(true);
    }
    
    public static void Exemplo8()
    {
        JFrame janela = new JFrame("JTable");
        janela.getContentPane().setLayout(null);
        
        DefaultTableModel dados = new DefaultTableModel();
        dados.addColumn("Id");
        dados.addColumn("Nome");   
        
        tabelaExemplo8 = new JTable(dados);
        tabelaExemplo8.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                
        JScrollPane scrolTabela = new JScrollPane(tabelaExemplo8);        
        scrolTabela.setBounds(0, 100, 580, 200);        
        janela.add(scrolTabela);
        
        Object[] linha = {1, "João"};
        dados.addRow(linha);   
        
        JMenuItem menu = new JMenuItem("Excluir");
        menu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              dados.removeRow(tabelaExemplo8.getSelectedRow());
            }
        });
        
        JMenuItem menu2 = new JMenuItem("Duplicar");
        menu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
              int qtdColunas = dados.getColumnCount();  
                
              Object[] temp = new Object[qtdColunas];  
              int linha = tabelaExemplo8.getSelectedRow();
              
                for (int i = 0; i <= qtdColunas-1; i++)
                   temp[i] = dados.getValueAt(linha, i);

              dados.insertRow(linha+1, temp);
            }
        });
        
        popup = new JPopupMenu();
        popup.add(menu);
        popup.add(menu2);
                
        tabelaExemplo8.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e) {
                ExibirPopup(e);
            }
        });
        
        janela.setBounds(0, 0, 600, 600);        
        janela.setVisible(true);
    }
    
    private static void ExibirPopup(MouseEvent e)
    {
        if (e.isPopupTrigger()){
        
        int posicao = tabelaExemplo8.rowAtPoint(new Point(e.getX(), e.getY())); 
        
        //Seleciona a linha da grade de onde aconteceu o clique do botão direito
        tabelaExemplo8.setRowSelectionInterval(posicao, posicao);
        
        popup.show(e.getComponent(), e.getX(), e.getY());}
    }
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        Exemplo8();
    }
    
}
