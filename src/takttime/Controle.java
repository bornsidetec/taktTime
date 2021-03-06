/*
 * Controle.java
 *
 * Created on August 20, 2007, 6:13 AM
 */

package takttime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.text.AttributeSet;  
import javax.swing.text.BadLocationException;  
import javax.swing.text.PlainDocument;
import takttime.FixedLengthDocument;

/**
 *
 * @author  root
 */
public class Controle extends javax.swing.JInternalFrame {
    //DecimalFormat formato = new DecimalFormat("00");
    
    boolean ok = true;
    
    /** Creates new form Controle */
    public Controle() {
        initComponents();
        //setLocationRelativeTo(null);        
        
        Timer t = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e){
                mostraData();
                mostraHora();
                //atualizarHoras();
            }
            
        });
        t.setInitialDelay(0);
        t.setRepeats(true);
        t.start();
        
        jTxtCodigoBarra.setDocument(new FixedLengthDocument(13));
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C?digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLblImage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTxtCodigoBarra = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jTxtData = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTxtHora = new javax.swing.JTextField();
        jBtnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("TAKT TIME");
        jLblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/takttime/form.jpg")));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("C\u00f3digo de Barras");

        jTxtCodigoBarra.setFont(new java.awt.Font("Tahoma", 1, 14));
        jTxtCodigoBarra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtCodigoBarraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtCodigoBarraKeyTyped(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/week_f224.png")));
        jLabel2.setText("Data");

        jTxtData.setEditable(false);
        jTxtData.setFont(new java.awt.Font("Dialog", 1, 14));
        jTxtData.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/day_f224.png")));
        jLabel3.setText("Hora");

        jTxtHora.setEditable(false);
        jTxtHora.setFont(new java.awt.Font("Dialog", 1, 14));
        jTxtHora.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTxtHora, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(jTxtData, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTxtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTxtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jBtnFechar.setFont(new java.awt.Font("Tahoma", 1, 14));
        jBtnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit16.png")));
        jBtnFechar.setMnemonic('F');
        jBtnFechar.setText("Fechar");
        jBtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(183, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jTxtCodigoBarra, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jBtnFechar)))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtCodigoBarra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnFechar))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFecharActionPerformed
// TODO adicione seu c?digo de manipula??o aqui:
        System.exit(0);
    }//GEN-LAST:event_jBtnFecharActionPerformed

    private void jTxtCodigoBarraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtCodigoBarraKeyTyped
// TODO add your handling code here:
        if (!ok){  
            evt.consume();  
        }  
    }//GEN-LAST:event_jTxtCodigoBarraKeyTyped

    private void jTxtCodigoBarraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtCodigoBarraKeyPressed
// TODO add your handling code here:
        int code = evt.getKeyCode();        
        JValidacao validacao = new JValidacao(jTxtCodigoBarra.getText());
        
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){

            if (!validacao.validVazio()){
                
            
            JConexao con = new JConexao();
            con.conect();
            GregorianCalendar grava = new GregorianCalendar();
            
            try{
                //int setorValido = new JValidacao().validSetor(jTxtCodigoBarra.getText());
                int setorValido = validacao.validSetor();
                if (setorValido == 0){
                    
                    mensagem("ERRO: Terceiro Registro da OF!", 1500);
                    
                } else if (setorValido == 1){
                    
                    con.getStatment().executeUpdate("insert into takttime " +
                            "(codebarof, data, setor) " +
                            "values('"+ jTxtCodigoBarra.getText() +"', '" +
                            grava.getTime() + "', 2)");
                    
                    mensagem("OF Registrada! - Setor 1", 750);                    
                } else if (setorValido == 2){
                    
                    con.getStatment().executeUpdate("insert into takttime " +
                            "(codebarof,data,setor) " +
                            "values('"+ jTxtCodigoBarra.getText() +"','" +
                            grava.getTime() + "',4)");
                    
                    mensagem("OF Registrada! - Setor 2", 750);
                }
                
                
            }catch (/*SQLException*/ Exception e) {                
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "ERRO: " + e.getMessage());
            }

            con.disconect();

            jTxtCodigoBarra.setText("");
            jTxtCodigoBarra.setFocusable(true);
            } else {
                JOptionPane.showMessageDialog(null, "C?digo de Barras Vazio!");
            }
        }

        if ((code>95 && code<106) || (code==8) || (code>47 && code<58)) {
            ok = true;
        } else {
            ok = false;
        }

    }//GEN-LAST:event_jTxtCodigoBarraKeyPressed

    public void mostraData(){
        GregorianCalendar data = new GregorianCalendar();        
        try{	 
            SimpleDateFormat dtFormat = new SimpleDateFormat("dd/MM/yyyy");
            jTxtData.setText(dtFormat.format(data.getTime()));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
         }        
    }

    
    public void mostraHora(){
        GregorianCalendar hora = new GregorianCalendar();
        try{	 
            SimpleDateFormat hrFormat = new SimpleDateFormat("HH:mm:ss");
            jTxtHora.setText(hrFormat.format(hora.getTime()));
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
         }        
    }    
    
    /*
    private void atualizarHoras(){
        // Cria uma instância de Calendar
        Calendar agora = Calendar.getInstance();    

        // horas, minutos e segundos
        int horas = agora.get(Calendar.HOUR_OF_DAY);  
        int minutos = agora.get(Calendar.MINUTE);
        int segundos = agora.get(Calendar.SECOND);
        jTxtHora.setText(formato.format(horas) + ":" + 
            formato.format(minutos) + ":" + 
            formato.format(segundos));
    }
    */
    

    public void mensagem(String msg, int tempo){
        
        JOptionPane pane = new JOptionPane(msg);
        final JDialog dialog = pane.createDialog(null, "TaktTime");
        dialog.setModal(true);             
        Timer timer = new Timer(tempo, new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                dialog.dispose();                     
            }
        });
        timer.setRepeats(false);
        timer.start();
        dialog.setVisible(true);
        timer.stop();
        
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Controle().setVisible(true);
            }
        });
    }
    
    // Declara??o de vari?veis - n?o modifique//GEN-BEGIN:variables
    private javax.swing.JButton jBtnFechar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLblImage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTxtCodigoBarra;
    private javax.swing.JTextField jTxtData;
    private javax.swing.JTextField jTxtHora;
    // Fim da declara??o de vari?veis//GEN-END:variables
    
}
