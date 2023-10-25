/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exemplo1;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Stefano
 */

@Embeddable
public class Endereco {
    
    @Column(length=30, nullable=false)
    public String Rua;
    
    @Column(length=30, nullable=true)
    public String Bairro;
    
    @Column(length=30, nullable=true)
    public String Cidade;
}