/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

/**
 *
 * @author christian
 */
public class ProjetosNovo extends javax.swing.JPanel {

    /**
     * Creates new form ProjetosListagem
     */
    public ProjetosNovo() {
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

        inpUsername = new javax.swing.JTextField();
        sepUsername = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(254, 254, 254));
        setPreferredSize(new java.awt.Dimension(800, 540));

        inpUsername.setBackground(new java.awt.Color(254, 254, 254));
        inpUsername.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        inpUsername.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inpUsername.setText("Usuário");
        inpUsername.setBorder(null);
        inpUsername.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inpUsername.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpUsernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpUsernameFocusLost(evt);
            }
        });
        inpUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inpUsernameActionPerformed(evt);
            }
        });

        sepUsername.setBackground(new java.awt.Color(103, 103, 103));
        sepUsername.setForeground(new java.awt.Color(29, 29, 29));
        sepUsername.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inpUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sepUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(418, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(inpUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(sepUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(482, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void inpUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpUsernameFocusGained
        if (inpUsername.getText().trim().equals("Usuário")) {
            inpUsername.setText("");
        }
    }//GEN-LAST:event_inpUsernameFocusGained

    private void inpUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpUsernameFocusLost
        if (inpUsername.getText().trim().isEmpty()) {
            inpUsername.setText("Usuário");
        }
    }//GEN-LAST:event_inpUsernameFocusLost

    private void inpUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inpUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inpUsernameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField inpUsername;
    private javax.swing.JSeparator sepUsername;
    // End of variables declaration//GEN-END:variables
}
