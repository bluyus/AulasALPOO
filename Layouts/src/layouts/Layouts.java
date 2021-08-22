/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package layouts;

import java.awt.*;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;


/**
 *
 * @author Stefano
 */
public class Layouts {

    /**
     * @param args the command line arguments
     */
    
    public static void BorderLayout()
    {
        JFrame janela = new JFrame("BorderLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        janela.add(new JButton("Norte"), BorderLayout.PAGE_START);
        janela.add(new JButton("Oeste"), BorderLayout.LINE_START);
        janela.add(new JButton("Centro"), BorderLayout.CENTER);
        janela.add(new JButton("Leste"), BorderLayout.LINE_END);
        janela.add(new JButton("Sul"), BorderLayout.PAGE_END);
        
        janela.setBounds(300, 300, 400, 400);
        
        janela.setVisible(true);
    }
    
    public static void BorderLayout2()
    {
        JFrame janela = new JFrame("BorderLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        janela.add(new JButton("Norte"));
        janela.add(new JButton("Oeste"));
        janela.add(new JButton("Centro"));
        janela.add(new JButton("Leste"));
        janela.add(new JButton("Sul"));
        
        janela.setBounds(300, 300, 400, 400);
        
        janela.setVisible(true);
    }
    
    public static void BorderLayout3()
    {
        JFrame janela = new JFrame("BorderLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        janela.add(new JButton("Norte"), BorderLayout.PAGE_START);
        janela.add(new JButton("Oeste"), BorderLayout.LINE_START);
        janela.add(new JButton("Centro"), BorderLayout.CENTER);
        janela.add(new JButton("Sul"), BorderLayout.PAGE_END);
        
        janela.setBounds(300, 300, 400, 400);
        
        janela.setVisible(true);
    }
    
    public static void BorderLayout4()
    {
        JFrame janela = new JFrame("BorderLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        janela.add(new JButton("Norte"), BorderLayout.PAGE_START);
        janela.add(new JButton("Oeste"), BorderLayout.LINE_START);
        janela.add(new JButton("Centro"), BorderLayout.CENTER);
        janela.add(new JButton("Leste"), BorderLayout.LINE_END);
        janela.add(new JButton("Sul"), BorderLayout.PAGE_END);
        
        janela.pack();
        
        janela.setVisible(true);
    }
    
    public static void BorderLayout5()
    {
        JFrame janela = new JFrame("BorderLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JButton jb1 = new JButton("Norte");
        jb1.setPreferredSize(new Dimension(100, 15));
        janela.add(jb1, BorderLayout.PAGE_START);
        
        JButton jb2 = new JButton("Oeste");
        jb2.setPreferredSize(new Dimension(100, 20));
        janela.add(jb2, BorderLayout.LINE_START);
        
        JButton jb3 = new JButton("Centro");
        jb3.setPreferredSize(new Dimension(100, 20));
        janela.add(jb3, BorderLayout.CENTER);
        
        JButton jb4 = new JButton("Leste");
        jb4.setPreferredSize(new Dimension(100, 20));
        janela.add(jb4, BorderLayout.LINE_END);
        
        JButton jb5 = new JButton("Sul");
        jb5.setPreferredSize(new Dimension(120, 50));
        janela.add(jb5, BorderLayout.PAGE_END);
        
        janela.pack();        
        janela.setVisible(true);
    }
    
     public static void FlowLayout()
    {
        JFrame janela = new JFrame("FlowLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setLayout(new FlowLayout());
        
        JButton jb1 = new JButton("Norte");
        jb1.setPreferredSize(new Dimension(100, 15));
        janela.add(jb1);
        
        JButton jb2 = new JButton("Oeste");
        jb2.setPreferredSize(new Dimension(100, 20));
        janela.add(jb2);
        
        JButton jb3 = new JButton("Centro");
        jb3.setPreferredSize(new Dimension(100, 20));
        janela.add(jb3);
        
        JButton jb4 = new JButton("Leste");
        jb4.setPreferredSize(new Dimension(100, 20));
        janela.add(jb4);
        
        JButton jb5 = new JButton("Sul");
        jb5.setPreferredSize(new Dimension(120, 50));
        janela.add(jb5);
        
        janela.pack();        
        janela.setVisible(true);
    }
     
    public static void FlowLayout2()
    {
        JFrame janela = new JFrame("FlowLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setLayout(new FlowLayout());
        
        JButton jb1 = new JButton("Norte");
        jb1.setPreferredSize(new Dimension(100, 15));
        janela.add(jb1);
        
        janela.add(Box.createRigidArea(new Dimension(50, 0)));
        
        JButton jb2 = new JButton("Oeste");
        jb2.setPreferredSize(new Dimension(100, 20));
        janela.add(jb2);
        
        JButton jb3 = new JButton("Centro");
        jb3.setPreferredSize(new Dimension(100, 20));
        janela.add(jb3);
        
        JButton jb4 = new JButton("Leste");
        jb4.setPreferredSize(new Dimension(100, 20));
        janela.add(jb4);
        
        JButton jb5 = new JButton("Sul");
        jb5.setPreferredSize(new Dimension(120, 50));
        janela.add(jb5);
        
        janela.pack();        
        janela.setVisible(true);
    }
    
    public static void FlowLayout3()
    {
        JFrame janela = new JFrame("FlowLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.getContentPane().setLayout(new FlowLayout());
        
        JButton jb1 = new JButton("Norte");
        jb1.setPreferredSize(new Dimension(100, 15));
        janela.add(jb1);        
        
        JButton jb2 = new JButton("Oeste");
        jb2.setPreferredSize(new Dimension(100, 20));
        janela.add(jb2);
        
        JButton jb3 = new JButton("Centro");
        jb3.setPreferredSize(new Dimension(100, 20));
        janela.add(jb3);
        
        JButton jb4 = new JButton("Leste");
        jb4.setPreferredSize(new Dimension(100, 20));
        janela.add(jb4);
        
        JButton jb5 = new JButton("Sul");
        jb5.setPreferredSize(new Dimension(120, 50));
        janela.add(jb5);
        
        janela.setBounds(100, 100, 300, 150);
        janela.setVisible(true);
    }
    
    public static void FlowLayout4()
    {
        JFrame janela = new JFrame("FlowLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        FlowLayout fl = new FlowLayout();
        fl.setAlignment(FlowLayout.LEFT);
        
        janela.getContentPane().setLayout(fl);
        
        JButton jb1 = new JButton("Norte");
        jb1.setPreferredSize(new Dimension(100, 15));
        janela.add(jb1);        
        
        JButton jb2 = new JButton("Oeste");
        jb2.setPreferredSize(new Dimension(100, 20));
        janela.add(jb2);
        
        JButton jb3 = new JButton("Centro");
        jb3.setPreferredSize(new Dimension(100, 20));
        janela.add(jb3);
        
        JButton jb4 = new JButton("Leste");
        jb4.setPreferredSize(new Dimension(100, 20));
        janela.add(jb4);
        
        JButton jb5 = new JButton("Sul");
        jb5.setPreferredSize(new Dimension(120, 50));
        janela.add(jb5);
        
        janela.setBounds(100, 100, 300, 150);
        janela.setVisible(true);
    }
    
    public static void GridLayout()
    {
        JFrame janela = new JFrame("GridLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
        janela.getContentPane().setLayout(new GridLayout(1, 0));
        
        JButton jb1 = new JButton("Norte");
        jb1.setPreferredSize(new Dimension(100, 15));
        janela.add(jb1);        
        
        JButton jb2 = new JButton("Oeste");
        jb2.setPreferredSize(new Dimension(100, 20));
        janela.add(jb2);
        
        JButton jb3 = new JButton("Centro");
        jb3.setPreferredSize(new Dimension(100, 20));
        janela.add(jb3);
        
        JButton jb4 = new JButton("Leste");
        jb4.setPreferredSize(new Dimension(100, 20));
        janela.add(jb4);
        
        JButton jb5 = new JButton("Sul");
        jb5.setPreferredSize(new Dimension(120, 50));
        janela.add(jb5);
        
        janela.pack();
        janela.setVisible(true);
    }
    
    public static void GridLayout2()
    {
        JFrame janela = new JFrame("GridLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
        GridLayout gl = new GridLayout(2, 3);
        gl.setHgap(15);
        gl.setVgap(15);
        
        janela.getContentPane().setLayout(gl);
        
        JButton jb1 = new JButton("Norte");
        jb1.setPreferredSize(new Dimension(100, 15));
        janela.add(jb1);        
        
        JButton jb2 = new JButton("Oeste");
        jb2.setPreferredSize(new Dimension(100, 20));
        janela.add(jb2);
        
        JButton jb3 = new JButton("Centro");
        jb3.setPreferredSize(new Dimension(100, 20));
        janela.add(jb3);
        
        JButton jb4 = new JButton("Leste");
        jb4.setPreferredSize(new Dimension(100, 20));
        janela.add(jb4);
        
        JButton jb5 = new JButton("Sul");
        jb5.setPreferredSize(new Dimension(120, 50));
        janela.add(jb5);
        
        janela.pack();
        janela.setVisible(true);
    }
    
    public static void GridBagLayout()
    {
        JFrame janela = new JFrame("GridBagLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();        
        janela.getContentPane().setLayout(gbl);  
        
        JButton jb1 = new JButton("Norte");
        jb1.setPreferredSize(new Dimension(100, 15));
        gbc.gridx = 0; gbc.gridy = 0;
        janela.add(jb1, gbc);        
        
        JButton jb2 = new JButton("Oeste");
        jb2.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 1; gbc.gridy = 0;
        janela.add(jb2, gbc);
        
        JButton jb3 = new JButton("Centro");
        jb3.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 2; gbc.gridy = 0;
        janela.add(jb3, gbc);
        
        JButton jb4 = new JButton("Leste");
        jb4.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 0; gbc.gridy = 1;
        janela.add(jb4, gbc);
        
        JButton jb5 = new JButton("Sul");
        jb5.setPreferredSize(new Dimension(120, 50));
        gbc.gridx = 1; gbc.gridy = 1;
        janela.add(jb5, gbc);
        
        janela.pack();
        janela.setVisible(true);
    }
    
    public static void GridBagLayout2()
    {
        JFrame janela = new JFrame("GridBagLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();        
        janela.getContentPane().setLayout(gbl);
        
        gbc.fill = GridBagConstraints.BOTH;
        
        JButton jb1 = new JButton("Norte");
        jb1.setPreferredSize(new Dimension(100, 15));
        gbc.gridx = 0; gbc.gridy = 0;
        janela.add(jb1, gbc);        
        
        JButton jb2 = new JButton("Oeste");
        jb2.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 1; gbc.gridy = 0;
        janela.add(jb2, gbc);
        
        JButton jb3 = new JButton("Centro");
        jb3.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 2; gbc.gridy = 0;
        janela.add(jb3, gbc);
        
        JButton jb4 = new JButton("Leste");
        jb4.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 0; gbc.gridy = 1;
        janela.add(jb4, gbc);
        
        JButton jb5 = new JButton("Sul");
        jb5.setPreferredSize(new Dimension(120, 50));
        gbc.gridx = 1; gbc.gridy = 1;
        janela.add(jb5, gbc);
        
        janela.pack();
        janela.setVisible(true);
    }
    
    public static void GridBagLayout3()
    {
        JFrame janela = new JFrame("GridBagLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();        
        janela.getContentPane().setLayout(gbl);
        
        gbc.anchor = GridBagConstraints.CENTER;
        
        JButton jb1 = new JButton("Norte");
        jb1.setPreferredSize(new Dimension(100, 15));
        gbc.gridx = 0; gbc.gridy = 0;
        janela.add(jb1, gbc);        
        
        JButton jb2 = new JButton("Oeste");
        jb2.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 1; gbc.gridy = 0;
        janela.add(jb2, gbc);
        
        JButton jb3 = new JButton("Centro");
        jb3.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 2; gbc.gridy = 0;
        janela.add(jb3, gbc);
        
        JButton jb4 = new JButton("Leste");
        jb4.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 0; gbc.gridy = 1;
        janela.add(jb4, gbc);
        
        JButton jb5 = new JButton("Sul");
        jb5.setPreferredSize(new Dimension(120, 50));
        gbc.gridx = 1; gbc.gridy = 1;
        janela.add(jb5, gbc);
        
        janela.pack();
        janela.setVisible(true);
    }
    
    public static void GridBagLayout4()
    {
        JFrame janela = new JFrame("GridBagLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();        
        janela.getContentPane().setLayout(gbl);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JButton jb1 = new JButton("Norte");
        jb1.setPreferredSize(new Dimension(100, 15));
        gbc.gridx = 0; gbc.gridy = 0;
        janela.add(jb1, gbc);        
        
        JButton jb2 = new JButton("Oeste");
        jb2.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 1; gbc.gridy = 0;
        janela.add(jb2, gbc);
        
        JButton jb3 = new JButton("Centro");
        jb3.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 2; gbc.gridy = 0;
        janela.add(jb3, gbc);
        
        JButton jb4 = new JButton("Leste");
        jb4.setPreferredSize(new Dimension(100, 20));                
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2;       
        janela.add(jb4, gbc);
        
        JButton jb5 = new JButton("Sul");
        jb5.setPreferredSize(new Dimension(120, 50));        
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.gridwidth = 1;
        janela.add(jb5, gbc);
        
        janela.pack();
        janela.setVisible(true);
    }
    
    public static void GridBagLayout5()
    {
        JFrame janela = new JFrame("GridBagLayout");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();        
        janela.getContentPane().setLayout(gbl);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JButton jb1 = new JButton("Norte");
        jb1.setPreferredSize(new Dimension(100, 15));
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.insets = new Insets(5,5,5,5);
        janela.add(jb1, gbc);        
        
        JButton jb2 = new JButton("Oeste");
        jb2.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 1; gbc.gridy = 0;
        gbc.insets = new Insets(5,50,10,10);
        janela.add(jb2, gbc);
        
        JButton jb3 = new JButton("Centro");
        jb3.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 2; gbc.gridy = 0;
        janela.add(jb3, gbc);
        
        JButton jb4 = new JButton("Leste");
        jb4.setPreferredSize(new Dimension(100, 20));                
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2;       
        janela.add(jb4, gbc);
        
        JButton jb5 = new JButton("Sul");
        jb5.setPreferredSize(new Dimension(120, 50));        
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.gridwidth = 1;
        janela.add(jb5, gbc);
        
        janela.pack();
        janela.setVisible(true);
    }
    
    public static void main(String[] args) {   
        GridBagLayout5();
    }
    
}
