/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.aula2020unipstefano.aplicacaocommaven;

import java.sql.SQLException;

/**
 *
 * @author Stefano
 */
public class AplicacaoComMaven {

    public static void main(String[] args) throws SQLException {
        Ator ator = new Ator();
        ator.Nome = "Fernanda Montenegro";
        ator.Sexo = "F";
        ator.Id = 10;
        
        JDBC_MySql banco = new JDBC_MySql(); 
        banco.Salvar(ator); 
    }
}
