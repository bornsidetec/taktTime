/*
 * exportTxt.java
 *
 * Created on 18 de Julho de 2007, 08:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package takttime;
import java.io.*;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author administrator
 */
public class exportCodeBar {
    
    private String local;
    private String ano;
    private int inicio;
    private int fim;
    
    DecimalFormat codeBar = new DecimalFormat("000000");    
    
    /** Creates a new instance of exportTxt */
    public exportCodeBar(String local, int inicio, int fim, String ano) {
        setLocal(local);
        setInicio(inicio);
        setFim(fim);
        setAno(ano);
    }
    
    public void exporta(){
        char aspas = '\"';
        String codeBarra = "";
        
        try{
            FileWriter escreve = new FileWriter(local,true);
            PrintWriter saida = new PrintWriter(escreve,true);
            
            saida.println("codigoBarra;numero");
            
            for (int i = inicio; i <= fim; i++) {
                codeBarra = "0000" + ano + codeBar.format(i);
                saida.println(
                        aspas + codeBarra + aspas +  ";" +
                        aspas + codeBarra + digVerEAN13(codeBarra) + aspas);
            }
            
            saida.close();
            escreve.close();
                
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Escrita do Arquivo " + ex.getMessage());
        }
    }

    
    public int digVerEAN13(String codeBar){
        int dig = 0;
        int pesos[] = new int[12];
        Integer numero = 0;
        Integer soma = 0;
        int fim = 0;
        
        pesos[0] = 1;
        pesos[1] = 3;
        pesos[2] = 1;
        pesos[3] = 3;
        pesos[4] = 1;
        pesos[5] = 3;
        pesos[6] = 1;
        pesos[7] = 3;
        pesos[8] = 1;
        pesos[9] = 3;
        pesos[10] = 1;
        pesos[11] = 3;
        
        for (int i=0; i<=11; i++){
            numero = numero.parseInt(codeBar.substring(i,i+1));
            soma += numero * pesos[i];
        }
        
        fim = soma.parseInt(soma.toString().substring(soma.toString().length()-1, soma.toString().length()));
        if (fim==0){
            dig=0;
        }else {
            dig = 10 - fim;
        }
        
        return dig;
    }
    
    
    public String getLocal() {
        return local;
    }    
    
    public void setLocal(String local) {
        this.local = local;
    }
    
    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public void setFim(int fim) {
        this.fim = fim;
    }
    
    public void setAno(String ano) {
        this.ano = ano;
    }
       
}