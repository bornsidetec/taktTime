/*
 * contaRegistro.java
 *
 * Created on 23 de Julho de 2007, 16:34
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package takttime;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author administrator
 */
public class contaRegistro {
    private ResultSet rst;
    public int quant = 0;
    
    /** Creates a new instance of contaRegistro */
    public contaRegistro(ResultSet rst) {
        setRst(rst);
    }
    
    public int contar() {
        try{
            if (!rst.next()){
                quant = 0;
            }else {
                rst.first();
                while(!rst.isAfterLast()){
                    quant += 1;
                    rst.next();
                };
            }
        }catch (Exception ex){
            JOptionPane.showMessageDialog(null, "ERRO: " + ex.getMessage());
        }
        return quant;
    }
    
    public ResultSet getRst() {
        return rst;
    }

    public void setRst(ResultSet rst) {
        this.rst = rst;
    }
    
    
}
