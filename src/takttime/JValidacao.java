/*
 * JValidacao.java
 *
 * Created on August 28, 2007, 1:13 PM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package takttime;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author root
 */
public class JValidacao {
    public String codeBar;
    /** Creates a new instance of JValidacao */
    public JValidacao(String codeBar) {
        setCodeBar(codeBar);
    }
    
    
    public boolean validHorario(){
        boolean ok = true;
        
        JConexao con = new JConexao();
        con.conect();
        try{
            ResultSet rs = con.getStatment().executeQuery("select * from takttime " +
                    "where codebarof='" + codeBar + "';" );
            
            rs.first();
            
            GregorianCalendar hoje = new GregorianCalendar();
            GregorianCalendar banco = new GregorianCalendar();
            banco.setTime(rs.getTimestamp("data"));
            
            long m1 = banco.getTimeInMillis();
            long m2 = hoje.getTimeInMillis();
            long dif = ((m2 - m1) / (1000));
            
            
            //validação de 15 segundos
            if (dif >= 15){
                ok = true;
            } else {
                ok = false;
            }
            
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
            ex.printStackTrace();
        }
        con.disconect();
        return ok;
    }
    

    public boolean validVazio(){
        boolean vazio = false;        
        if (codeBar.equals("")){
            vazio = true;
        } else {
            vazio = false;
        }
        
        return vazio;
    }
    
    public int validSetor(){
        int setor = 0;
        int quant = 0;
        
        JConexao c = new JConexao();
        c.conect();
        try {

            ResultSet rs = c.getStatment().executeQuery("SELECT COUNT(*) AS contador from takttime " +
                    "where codebarof='" + codeBar + "';" );
            rs.first();
            quant = rs.getInt("contador");
            
            if (quant == 2){
                setor = 0;
            }else if (quant == 1){
                
                if (validHorario()){
                    setor = 2;                    
                }else {
                    setor = 0;
                }
            }else if (quant == 0){                
                setor = 1;
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
        c.disconect();
        return setor;        
        
    }
    
    public String getCodeBar() {
        return codeBar;
    }

    public void setCodeBar(String codeBar) {
        this.codeBar = codeBar;
    }
    
    
}
