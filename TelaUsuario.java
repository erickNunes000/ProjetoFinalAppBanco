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
public class TelaUsuario extends javax.swing.JInternalFrame {

    /**  
     * Creates new form TelaUsuario
     */
    Connection conexao = null;
    PreparedStatement pst =null;
    ResultSet rs = null;
    
    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    
    private void consultar(){//Consulta no Banco->usuarios
        String sql = "select *from usuarios where cpf=?";
        try{
            
            pst=conexao.prepareStatement(sql);
            pst.setString(1, textoNovoUsuarioCpf.getText());
            rs = pst.executeQuery();
            
            if(rs.next()){
                textoNovoUsuarioNome.setText(rs.getString(3));
                textoNovoUsuarioSenha.setText(rs.getString(5));
                cboNovoUsuVinculo.setSelectedItem(rs.getString(4));  
            }
            else{
                JOptionPane.showMessageDialog(null,"Usuario nao cadastrado");
                textoNovoUsuarioCpf.setText(null);
                textoNovoUsuarioNome.setText(null); 
                textoNovoUsuarioSenha.setText(null);
                
            } 
            
        }catch(Exception e){
            
            JOptionPane.showMessageDialog(null, e);
            
        }
    }
    
    private void adicionar(){//inserir novo registro de usuario no banco de dados
        String sql = "insert into usuarios (cpf,nome,vinculo,senha) values (?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, textoNovoUsuarioCpf.getText());//cpf
            pst.setString(2, textoNovoUsuarioNome.getText());//nome
            pst.setString(3, cboNovoUsuVinculo.getSelectedItem().toString());//vinculo
            pst.setString(4, textoNovoUsuarioSenha.getText());//senha
            //a linha abaixo atualiza a tabela usuarios no banco de dados com um novo registro 
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0){
                JOptionPane.showMessageDialog(null,"Usuario adicionado com cucesso");
                textoNovoUsuarioCpf.setText(null);
                textoNovoUsuarioNome.setText(null); 
                textoNovoUsuarioSenha.setText(null);  
            }
            
        } catch (Exception e) {
        
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //Realizar update na tabela de usuarios no banco de dados
    private void alterar(){//Update na tabela usuarios
        String sql = "update usuarios set nome=?,vinculo=?,senha=? where cpf=?";
        
        try {
            pst=conexao.prepareStatement(sql);
            pst.setString(1, textoNovoUsuarioNome.getText());
            pst.setString(2, cboNovoUsuVinculo.getSelectedItem().toString());
            pst.setString(3, textoNovoUsuarioSenha.getText());
            pst.setString(4, textoNovoUsuarioCpf.getText());//Referencia
            //a linha abaixo realiza o update de algum registro na tabela de usuarios
            int adicionado = pst.executeUpdate();
            
            if(adicionado > 0){
                JOptionPane.showMessageDialog(null,"Alteracoes realizadas com sucesso");
                textoNovoUsuarioCpf.setText(null);
                textoNovoUsuarioNome.setText(null); 
                textoNovoUsuarioSenha.setText(null);  
            }
            
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
    }
    //fim do metodo de update
    
    //Realizar remocao de registros de usuarios 
    private void remover(){
        int confirma = JOptionPane.showConfirmDialog(null,"Deseja realmente excluir este usuario?","Atencao", JOptionPane.YES_NO_OPTION);
        if(confirma==JOptionPane.YES_OPTION){
            String sql = "delete from usuarios where cpf=?";
            try {
                pst=conexao.prepareStatement(sql);
                pst.setString(1,textoNovoUsuarioCpf.getText());
                int apagado = pst.executeUpdate();
                //tratamento da remocao
                if(apagado>0){
                    JOptionPane.showMessageDialog(null,"Remocao bem sucedida");
                    textoNovoUsuarioCpf.setText(null);
                    textoNovoUsuarioNome.setText(null); 
                    textoNovoUsuarioSenha.setText(null);  
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

        txtNovoUsuCpf = new javax.swing.JLabel();
        txtNovoUsuNome = new javax.swing.JLabel();
        txtNovoUsuVinculo = new javax.swing.JLabel();
        txtNovoUsuSenha = new javax.swing.JLabel();
        textoNovoUsuarioCpf = new javax.swing.JTextField();
        textoNovoUsuarioNome = new javax.swing.JTextField();
        textoNovoUsuarioSenha = new javax.swing.JTextField();
        cboNovoUsuVinculo = new javax.swing.JComboBox<>();
        btnNovoUsuCreate = new javax.swing.JButton();
        btnNovoUsuRead = new javax.swing.JButton();
        btnNovoUsuDelete = new javax.swing.JButton();
        btnNovoUsuUpdate = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Novo Usuario");
        setPreferredSize(new java.awt.Dimension(364, 364));

        txtNovoUsuCpf.setText("CPF:");

        txtNovoUsuNome.setText("NOME:");

        txtNovoUsuVinculo.setText("VINCULO:");

        txtNovoUsuSenha.setText("SENHA:");

        cboNovoUsuVinculo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gerente", "Diretor", "Cliente Corrente", "Cliente Poupanca", " " }));

        btnNovoUsuCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Bank/icones/create.png"))); // NOI18N
        btnNovoUsuCreate.setToolTipText("Adicionar");
        btnNovoUsuCreate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovoUsuCreate.setPreferredSize(new java.awt.Dimension(70, 70));
        btnNovoUsuCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoUsuCreateActionPerformed(evt);
            }
        });

        btnNovoUsuRead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Bank/icones/read.png"))); // NOI18N
        btnNovoUsuRead.setToolTipText("Buscar");
        btnNovoUsuRead.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovoUsuRead.setPreferredSize(new java.awt.Dimension(70, 70));
        btnNovoUsuRead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoUsuReadActionPerformed(evt);
            }
        });

        btnNovoUsuDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Bank/icones/delete.png"))); // NOI18N
        btnNovoUsuDelete.setToolTipText("Apagar");
        btnNovoUsuDelete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovoUsuDelete.setPreferredSize(new java.awt.Dimension(70, 70));
        btnNovoUsuDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoUsuDeleteActionPerformed(evt);
            }
        });

        btnNovoUsuUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/Bank/icones/update.png"))); // NOI18N
        btnNovoUsuUpdate.setToolTipText("Alterar");
        btnNovoUsuUpdate.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNovoUsuUpdate.setPreferredSize(new java.awt.Dimension(70, 70));
        btnNovoUsuUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoUsuUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNovoUsuCpf)
                            .addComponent(txtNovoUsuNome))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(textoNovoUsuarioCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(textoNovoUsuarioNome)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnNovoUsuCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovoUsuRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovoUsuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNovoUsuDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNovoUsuVinculo)
                            .addComponent(txtNovoUsuSenha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(textoNovoUsuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(cboNovoUsuVinculo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNovoUsuCpf)
                    .addComponent(textoNovoUsuarioCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(txtNovoUsuNome))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(textoNovoUsuarioNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNovoUsuVinculo)
                    .addComponent(cboNovoUsuVinculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNovoUsuSenha)
                    .addComponent(textoNovoUsuarioSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoUsuCreate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoUsuRead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoUsuUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNovoUsuDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        setBounds(0, 0, 364, 361);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoUsuReadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoUsuReadActionPerformed
        // TODO add your handling code here:
        consultar(); 
    }//GEN-LAST:event_btnNovoUsuReadActionPerformed

    private void btnNovoUsuCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoUsuCreateActionPerformed
        // TODO add your handling code here:
        adicionar(); 
        
    }//GEN-LAST:event_btnNovoUsuCreateActionPerformed

    private void btnNovoUsuUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoUsuUpdateActionPerformed
        // TODO add your handling code here:
        alterar(); 
    }//GEN-LAST:event_btnNovoUsuUpdateActionPerformed

    private void btnNovoUsuDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoUsuDeleteActionPerformed
        // TODO add your handling code here:
        remover(); 
    }//GEN-LAST:event_btnNovoUsuDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovoUsuCreate;
    private javax.swing.JButton btnNovoUsuDelete;
    private javax.swing.JButton btnNovoUsuRead;
    private javax.swing.JButton btnNovoUsuUpdate;
    private javax.swing.JComboBox<String> cboNovoUsuVinculo;
    private javax.swing.JTextField textoNovoUsuarioCpf;
    private javax.swing.JTextField textoNovoUsuarioNome;
    private javax.swing.JTextField textoNovoUsuarioSenha;
    private javax.swing.JLabel txtNovoUsuCpf;
    private javax.swing.JLabel txtNovoUsuNome;
    private javax.swing.JLabel txtNovoUsuSenha;
    private javax.swing.JLabel txtNovoUsuVinculo;
    // End of variables declaration//GEN-END:variables
}
