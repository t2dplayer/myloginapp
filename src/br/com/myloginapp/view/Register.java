/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.myloginapp.view;

import br.com.myloginapp.dao.UserDAO;
import br.com.myloginapp.model.User;
import br.com.myloginapp.utils.TextComponentValidator;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/**
 *
 * @author sergi
 */
public class Register extends javax.swing.JFrame {

    /**
     * Creates new form Register
     */
    public Register() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        UserLabel = new javax.swing.JLabel();
        UserField = new javax.swing.JTextField();
        PassLabel = new javax.swing.JLabel();
        LoginButton = new javax.swing.JButton();
        PassField = new javax.swing.JPasswordField();
        ConfirmPassLabel = new javax.swing.JLabel();
        ConfirmPassField = new javax.swing.JPasswordField();
        CancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(244, 88, 82));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        UserLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 28)); // NOI18N
        UserLabel.setForeground(new java.awt.Color(255, 255, 255));
        UserLabel.setText("Nome do Usuário");

        UserField.setFont(new java.awt.Font("Trebuchet MS", 0, 22)); // NOI18N
        UserField.setToolTipText("Nome do Usuário");

        PassLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 28)); // NOI18N
        PassLabel.setForeground(new java.awt.Color(255, 255, 255));
        PassLabel.setText("Senha");

        LoginButton.setBackground(new java.awt.Color(255, 255, 255));
        LoginButton.setFont(new java.awt.Font("Trebuchet MS", 0, 22)); // NOI18N
        LoginButton.setText("CONFIRMAR");
        LoginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoginButtonActionPerformed(evt);
            }
        });

        PassField.setToolTipText("Senha");

        ConfirmPassLabel.setFont(new java.awt.Font("Trebuchet MS", 0, 28)); // NOI18N
        ConfirmPassLabel.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmPassLabel.setText("Confirmar Senha");

        ConfirmPassField.setToolTipText("Confirmar Senha");

        CancelButton.setBackground(new java.awt.Color(255, 255, 255));
        CancelButton.setFont(new java.awt.Font("Trebuchet MS", 0, 22)); // NOI18N
        CancelButton.setText("CANCELAR");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(logo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(LoginButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(CancelButton))
                            .addComponent(PassLabel)
                            .addComponent(UserLabel)
                            .addComponent(UserField)
                            .addComponent(PassField)
                            .addComponent(ConfirmPassLabel)
                            .addComponent(ConfirmPassField, javax.swing.GroupLayout.DEFAULT_SIZE, 326, Short.MAX_VALUE))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(logo)
                .addGap(39, 39, 39)
                .addComponent(UserLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(UserField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PassLabel)
                .addGap(2, 2, 2)
                .addComponent(PassField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConfirmPassLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ConfirmPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LoginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
                dispose();
            }
        });
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void LoginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoginButtonActionPerformed
        List<JTextComponent> list = Arrays.asList(
                UserField,
                PassField,
                ConfirmPassField
        );
        if (TextComponentValidator.checkIsEmptyTextComponent(this, list) 
                &&  TextComponentValidator.checkIsEqualsTextComponent(this, PassField, ConfirmPassField)) {
            User user = new User();
            user.setUsername(UserField.getText());
            user.setPassword(Arrays.toString(PassField.getPassword()));
            if (!UserDAO.insert(user)) {
                JOptionPane.showMessageDialog(this, "Erro ao inserir usuário", "Mensagem de Erro", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Usuário registrado!");
                java.awt.EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        new Login().setVisible(true);
                        dispose();
                    }
                });                
            }
        }
    }//GEN-LAST:event_LoginButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JPasswordField ConfirmPassField;
    private javax.swing.JLabel ConfirmPassLabel;
    private javax.swing.JButton LoginButton;
    private javax.swing.JPasswordField PassField;
    private javax.swing.JLabel PassLabel;
    private javax.swing.JTextField UserField;
    private javax.swing.JLabel UserLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    // End of variables declaration//GEN-END:variables
}
