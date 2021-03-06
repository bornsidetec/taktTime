/*
 * ConsultaOF.java
 *
 * Created on 30 de Agosto de 2007, 10:41
 */

package takttime;

import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author  administrator
 */
public class ConsultaOF extends javax.swing.JFrame {
    boolean ok = true;
    SimpleDateFormat dtFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat hrFormat = new SimpleDateFormat("HH:mm:ss");
    
    /** Creates new form ConsultaOF */
    public ConsultaOF() {
        initComponents();
        setLocationRelativeTo(null);        
        
        jTxtCodigoFind.setDocument(new FixedLengthDocument(13));
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(SwingConstants.CENTER);
        jTblFindOF.getColumnModel().getColumn(0).setCellRenderer(renderer);
        jTblFindOF.getColumnModel().getColumn(1).setCellRenderer(renderer);
        jTblFindOF.getColumnModel().getColumn(2).setCellRenderer(renderer);        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" C?digo Gerado ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jBtnFind = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTxtCodigoFind = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTblFindOF = new javax.swing.JTable();
        jBtnFechar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLblImage = new javax.swing.JLabel();

        setTitle("Triagem de OF");
        jBtnFind.setFont(new java.awt.Font("Tahoma", 1, 14));
        jBtnFind.setText("...");
        jBtnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFindActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Codigo de Barra OF:");

        jTxtCodigoFind.setFont(new java.awt.Font("Tahoma", 1, 14));
        jTxtCodigoFind.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        jTxtCodigoFind.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTxtCodigoFindKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTxtCodigoFindKeyTyped(evt);
            }
        });

        jTblFindOF.setFont(new java.awt.Font("Tahoma", 1, 14));
        jTblFindOF.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data", "Hora", "Setor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblFindOF.setEnabled(false);
        jTblFindOF.setShowHorizontalLines(false);
        jTblFindOF.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTblFindOF);

        jBtnFechar.setFont(new java.awt.Font("Tahoma", 1, 14));
        jBtnFechar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exit24.png")));
        jBtnFechar.setMnemonic('F');
        jBtnFechar.setText("Fechar");
        jBtnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnFecharActionPerformed(evt);
            }
        });

        jLblImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/takttime/form.jpg")));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLblImage, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLblImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTxtCodigoFind, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnFind, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jBtnFechar)
                .addContainerGap(297, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jBtnFind)
                    .addComponent(jTxtCodigoFind, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFecharActionPerformed
// TODO adicione seu c?digo de manipula??o aqui:
        dispose();
    }//GEN-LAST:event_jBtnFecharActionPerformed

    private void jBtnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnFindActionPerformed
// TODO adicione seu c?digo de manipula??o aqui:
        find();
    }//GEN-LAST:event_jBtnFindActionPerformed

    private void jTxtCodigoFindKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtCodigoFindKeyPressed
// TODO adicione seu c?digo de manipula??o aqui:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER){
            find();
        }
        int code = evt.getKeyCode();
        if ((code>95 && code<106) || (code==8) || (code>47 && code<58)) {
            ok = true;
        } else {
            ok = false;
        }                
    }//GEN-LAST:event_jTxtCodigoFindKeyPressed

    private void jTxtCodigoFindKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTxtCodigoFindKeyTyped
// TODO adicione seu c?digo de manipula??o aqui:
        if (!ok){  
            evt.consume();
        }        
    }//GEN-LAST:event_jTxtCodigoFindKeyTyped

    public void find(){
        limpaTabela();
        JConexao c = new JConexao();
        c.conect();
        try{
            ResultSet rs = c.getStatment().executeQuery("select * from takttime " +
                    "inner join setores on takttime.setor = setores.id " +
                    "where codebarof = '" + jTxtCodigoFind.getText() + "';");
            
            if(rs.next()){
                while(!rs.isAfterLast()){
                    int idSetor = rs.getInt(4);
                    String data = dtFormat.format(rs.getDate("data"));
                    String hora = hrFormat.format(rs.getTime("data"));
                    String setor = rs.getString("nome");
                    
                    DefaultTableModel tblFind = (DefaultTableModel)jTblFindOF.getModel();
                    tblFind.addRow( new String [] {data,hora,setor});
                    rs.next();
                }
            }else {
                JOptionPane.showMessageDialog(null, "OF n?o Registrada");
            }
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "N?o Foi Poss?vel Realizar a Consulta, Contate o Analista!");
            ex.printStackTrace();
        }
        c.disconect();
        jTxtCodigoFind.selectAll();
    }
    
    public void limpaTabela(){
        DefaultTableModel tblRemove = (DefaultTableModel)jTblFindOF.getModel();
        
        //tblRemove.fireTableRowsDeleted(0,0);
        
        if (tblRemove.getRowCount() > 0){
            for (int i=0;i<=tblRemove.getRowCount();i++){
                tblRemove.removeRow(0);
            }            
        }        
    }
          
    /**
     * @param args the command line arguments
     */
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConsultaOF().setVisible(true);
            }
        });
    }
    
    // Declara??o de vari?veis - n?o modifique//GEN-BEGIN:variables
    private javax.swing.JButton jBtnFechar;
    private javax.swing.JButton jBtnFind;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblImage;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTblFindOF;
    private javax.swing.JTextField jTxtCodigoFind;
    // Fim da declara??o de vari?veis//GEN-END:variables
    
}
