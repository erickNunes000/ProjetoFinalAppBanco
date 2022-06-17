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
public class TelaConta extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaConta
     */
    Connection conexao = null;
    PreparedStatement pst =null;
    ResultSet rs = null;
      
    public TelaConta() { 
        initComponents();  
        conexao = ModuloConexao.conector(); 
    }
    private void consultarConta(){//metodo para consultar contas
        String sql = "select *from conta where cpf=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, textoNovaContaCpf.getText());
            rs = pst.executeQuery();
            
            if(rs.next()){
                textoNovaContaTitular.setText(rs.getString(1));
                textoNovaContaNumero.setText(rs.getString(2));
                textoNovaContaSaldo.setText(rs.getString(4)); 
                cboNovaContaTipoConta.setSelectedItem(rs.getString(5));
                cboNovaContaEmprestimo.setSelectedItem(rs.getString(6));
            } 
            else{ 
                JOptionPane.showMessageDialog(null,"Conta Inexistente");
                textoNovaContaTitular.setText(null);
                textoNovaContaNumero.setText(null);
                textoNovaContaSaldo.setText(null); 
                cboNovaContaTipoConta.setSelectedItem(null);
                cboNovaContaEmprestimo.setSelectedItem(null);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    //fim do metodo de consulta de contas
    
    //inicio do metodo de criacao de contas
    private void adicionarConta(){
        String sql = "insert into conta (titular,numConta,cpf,saldo,tipoConta,emprestimo) values (?,?,?,?,?,?)";
        
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, textoNovaContaTitular.getText());//titular
            pst.setString(2, textoNovaContaNumero.getText());//numConta
            pst.setString(3, textoNovaContaCpf.getText());//cpf
            pst.setString(4, textoNovaContaSaldo.getText());//saldo
            pst.setString(5, cboNovaContaTipoConta.getSelectedItem().toString());//tipoConta
            pst.setString(6, cboNovaContaEmprestimo.getSelectedItem().toString());//emprestimo
            
            int adicionado = pst.executeUpdate();   
              
            if(adicionado>0){
                JOptionPane.showMessageDialog(null,"Conta criada com cucesso");
                //limpando campos apos inclusao de novo registro de conta
                textoNovaContaTitular.setText(null); 
                textoNovaContaNumero.setText(null); 
                textoNovaContaSaldo.setText(null); 
                cboNovaContaTipoConta.setSelectedItem(null);
                cboNovaContaEmprestimo.setSelectedItem(null);
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
        
    }
    //fim do metodo de criacao de contas
     
    //inicio do metodo de alteracao de dados de uma conta
    private void alterarConta(){
        String sql = "update conta set titular=?, numConta=?, saldo=?, tipoConta=?,emprestimo=? where cpf=?";
         
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, textoNovaContaTitular.getText());
            pst.setString(2, textoNovaContaNumero.getText());
            pst.setString(3, textoNovaContaSaldo.getText());
            pst.setString(4, cboNovaContaTipoConta.getSelectedItem().toString());
            pst.setString(5, cboNovaContaEmprestimo.getSelectedItem().toString());
            pst.setString(6, textoNovaContaCpf.getText());//referencia para busca
            
            int alterado = pst.executeUpdate();
            
            if(alterado>0){
              JOptionPane.showMessageDialog(null,"Alteracoes realizadas com sucesso");
              textoNovaContaTitular.setText(null); 
              textoNovaContaNumero.setText(null); 
              textoNovaContaSaldo.setText(null);  
            }
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
            
        }
    }
    //fim do metodo de alterar dados de uma conta
    
    //inicio do metodo de deletar uma conta
    private void removerConta(){
         
        int confirma = JOptionPane.showConfirmDialog(null,"Deseja Realmente Excluir Esta Conta?","Atencao", JOptionPane.YES_NO_OPTION);
        
        if(confirma==JOptionPane.YES_OPTION){
            String sql = "delete from conta where cpf=?";
            
            try {  
                 pst=conexao.prepareStatement(sql);
                 pst.setString(1, textoNovaContaCpf.getText());//cpf
                 int apagado = pst.executeUpdate();
                 //testando a remocao de conta
                 if(apagado>0){
                     JOptionPane.showMessageDialog(null,"Remocao bem sucedida");
                     textoNovaContaTitular.setText(null); 
                     textoNovaContaNumero.setText(null); 
                     textoNovaContaSaldo.setText(null);  
                 }
                   
            } catch (Exception e) {
                 
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    //fim do metodo de remocao
         
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        textoNovaContaTitular = new javax.swing.JTextField();
        textoNovaContaNumero = new javax.swing.JTextField();
        textoNovaContaCpf = new javax.swing.JTextField();
        textoNovaContaSaldo = new javax.swing.JTextField();
        cboNovaContaTipoConta = new javax.swing.JComboBox<>();
        cboNovaContaEmprestimo = new javax.swing.JComboBox<>();
        btnNovaContaCreate = new javax.swing.JButton();
        btnNovaContaRead = new javax.swing.JButton();
        btnNovaContaUpdate = new javax.swing.JButton();
        btnNovaContaDelete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Nova Conta");
        setPreferredSize(new java.awt.Dimension(361, 362));

        jLabel1.setText("titular");

        jLabel2.setText("numConta");

        jLabel3.setText("cpf");

        jLabel4.setText("saldo");

        jLabel5.setText("tipoConta");

        jLabel6.setText("emprestimo");

        cboNovaContaTipoConta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Corrente", "Poupanca" }));

        cboNovaContaEmprestimo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sim", "nao" }));

        btnNovaContaCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Bank/icones/create.png"))); // NOI18N
        btnNovaContaCreate.setToolTipText("adicionar");
        btnNovaContaCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovaContaCreate.setPreferredSize(new java.awt.Dimension(65, 65));
        btnNovaContaCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaContaCreateActionPerformed(evt);
            }
        });

        btnNovaContaRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Bank/icones/read.png"))); // NOI18N
        btnNovaContaRead.setToolTipText("buscar");
        btnNovaContaRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovaContaRead.setPreferredSize(new java.awt.Dimension(65, 65));
        btnNovaContaRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaContaReadActionPerformed(evt);
            }
        });

        btnNovaContaUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Bank/icones/update.png"))); // NOI18N
        btnNovaContaUpdate.setToolTipText("alterar");
        btnNovaContaUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovaContaUpdate.setPreferredSize(new java.awt.Dimension(65, 65));
        btnNovaContaUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaContaUpdateActionPerformed(evt);
            }
        });

        btnNovaContaDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Bank/icones/delete.png"))); // NOI18N
        btnNovaContaDelete.setToolTipText("remover");
        btnNovaContaDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovaContaDelete.setPreferredSize(new java.awt.Dimension(65, 65));
        btnNovaContaDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaContaDeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(textoNovaContaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(textoNovaContaTitular, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(textoNovaContaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(textoNovaContaSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cboNovaContaTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cboNovaContaEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNovaContaCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovaContaRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovaContaUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovaContaDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(textoNovaContaTitular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(textoNovaContaNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(textoNovaContaCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(textoNovaContaSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboNovaContaTipoConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cboNovaContaEmprestimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovaContaCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovaContaRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovaContaUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovaContaDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        setBounds(0, 0, 362, 362);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovaContaReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaContaReadActionPerformed
        // TODO add your handling code here: 
        consultarConta();
    }//GEN-LAST:event_btnNovaContaReadActionPerformed

    private void btnNovaContaCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaContaCreateActionPerformed
        // TODO add your handling code here:
        adicionarConta(); 
    }//GEN-LAST:event_btnNovaContaCreateActionPerformed

    private void btnNovaContaUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaContaUpdateActionPerformed
        // TODO add your handling code here:
        alterarConta();  
    }//GEN-LAST:event_btnNovaContaUpdateActionPerformed

    private void btnNovaContaDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaContaDeleteActionPerformed
        // TODO add your handling code here:
        removerConta();  
    }//GEN-LAST:event_btnNovaContaDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovaContaCreate;
    private javax.swing.JButton btnNovaContaDelete;
    private javax.swing.JButton btnNovaContaRead;
    private javax.swing.JButton btnNovaContaUpdate;
    private javax.swing.JComboBox<String> cboNovaContaEmprestimo;
    private javax.swing.JComboBox<String> cboNovaContaTipoConta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField textoNovaContaCpf;
    private javax.swing.JTextField textoNovaContaNumero;
    private javax.swing.JTextField textoNovaContaSaldo;
    private javax.swing.JTextField textoNovaContaTitular;
    // End of variables declaration//GEN-END:variables
}
