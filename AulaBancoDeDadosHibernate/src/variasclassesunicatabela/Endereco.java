/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package variasclassesunicatabela;

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
