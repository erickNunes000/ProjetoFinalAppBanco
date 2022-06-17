/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.Bank.telas;

/**
 *
 * @author USER
 */
import java.sql.*;
import br.com.Bank.dal.ModuloConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
public class TelaExtrato extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaExtrato
     */
    Connection conexao = null;
    PreparedStatement pst =null;
    ResultSet rs = null;
    
    public TelaExtrato() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    //inicio do metodo de Consulta de extrato
    private void consultaExtrato(){
        
        //String sql = "select operacao,valor, detalhes from historico where numConta=?";
        String sql = "select operacao, valor as 'valor R$', DATE_FORMAT(detalhes, '%d/%m/%Y') as 'Data' from historico where numConta=?";
        try {
             pst=conexao.prepareStatement(sql); 
             pst.setString(1, textoExtratoNumConta.getText());
             rs = pst.executeQuery(); 
             
            tabelaExtrato.setModel(DbUtils.resultSetToTableModel(rs));
                
                
        } catch (Exception e) {  
            
            JOptionPane.showMessageDialog(null, e);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textoExtratoNumConta = new javax.swing.JTextField();
        btnExtratoConfirma = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaExtrato = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consulta Extrato");
        setPreferredSize(new java.awt.Dimension(364, 350));

        jLabel1.setText("Nº Conta:");

        textoExtratoNumConta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoExtratoNumContaActionPerformed(evt);
            }
        });
        textoExtratoNumConta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textoExtratoNumContaKeyReleased(evt);
            }
        });

        btnExtratoConfirma.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Bank/icones/seek.png"))); // NOI18N
        btnExtratoConfirma.setToolTipText("Consultar");
        btnExtratoConfirma.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExtratoConfirma.setPreferredSize(new java.awt.Dimension(50, 50));
        btnExtratoConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtratoConfirmaActionPerformed(evt);
            }
        });

        tabelaExtrato.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Operacao", "Valor R$", "Data"
            }
        ));
        tabelaExtrato.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaExtrato);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(textoExtratoNumConta, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(btnExtratoConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(textoExtratoNumConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnExtratoConfirma, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        setBounds(0, 0, 364, 350);
    }// </editor-fold>//GEN-END:initComponents

    private void textoExtratoNumContaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoExtratoNumContaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textoExtratoNumContaActionPerformed
    
    private void textoExtratoNumContaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoExtratoNumContaKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_textoExtratoNumContaKeyReleased
    
    private void btnExtratoConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtratoConfirmaActionPerformed
        // TODO add your handling code here:
        consultaExtrato();   
    }//GEN-LAST:event_btnExtratoConfirmaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExtratoConfirma;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaExtrato;
    private javax.swing.JTextField textoExtratoNumConta;
    // End of variables declaration//GEN-END:variables
}