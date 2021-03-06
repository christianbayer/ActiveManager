/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import apoio.md5;
import classes.User;
import dao.UserDAO;

/**
 *
 * @author christian
 */
public class Login extends javax.swing.JFrame {

    UserDAO userDAO;

    /**
     * Creates new form Logi
     */
    public Login() {

        initComponents();

        // Faz a tela poder ser arrastada
        FrameDragListener frameDragListener = new FrameDragListener(this);
        this.addMouseListener(frameDragListener);
        this.addMouseMotionListener(frameDragListener);

        // Seta o tamanho do frame
        this.setSize(420, 500);

        // Esconde o label de login inválido
        lblLoginError.setVisible(false);

        userDAO = new UserDAO();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        lblLoginError = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        inpUsername = new javax.swing.JTextField();
        sepUsername = new javax.swing.JSeparator();
        inpPassword = new javax.swing.JPasswordField();
        sepPassword = new javax.swing.JSeparator();
        exit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(254, 254, 254));
        setName("login"); // NOI18N
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel.setBackground(new java.awt.Color(254, 254, 254));
        panel.setPreferredSize(new java.awt.Dimension(500, 600));
        panel.setRequestFocusEnabled(false);
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logo_v1.jpg"))); // NOI18N
        panel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, -1));

        lblLoginError.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblLoginError.setText("Usuário e/ou Senha inválidos!");
        panel.add(lblLoginError, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 380, -1, -1));

        btnLogin.setBackground(new java.awt.Color(52, 100, 127));
        btnLogin.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(254, 254, 254));
        btnLogin.setText("ENTRAR");
        btnLogin.setToolTipText("");
        btnLogin.setBorderPainted(false);
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLogin.setDefaultCapable(false);
        btnLogin.setName(""); // NOI18N
        btnLogin.setOpaque(true);
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        panel.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 340, 40));

        inpUsername.setBackground(new java.awt.Color(254, 254, 254));
        inpUsername.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
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
        panel.add(inpUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 340, 20));

        sepUsername.setBackground(new java.awt.Color(103, 103, 103));
        sepUsername.setForeground(new java.awt.Color(29, 29, 29));
        sepUsername.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        panel.add(sepUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 340, 1));

        inpPassword.setBackground(new java.awt.Color(254, 254, 254));
        inpPassword.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        inpPassword.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        inpPassword.setText("password");
        inpPassword.setToolTipText("");
        inpPassword.setBorder(null);
        inpPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpPasswordFocusLost(evt);
            }
        });
        panel.add(inpPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 340, 20));

        sepPassword.setBackground(new java.awt.Color(103, 103, 103));
        sepPassword.setForeground(new java.awt.Color(29, 29, 29));
        panel.add(sepPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 340, 1));

        exit.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N
        exit.setText("x");
        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        panel.add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 0, -1, -1));

        getContentPane().add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        String username = inpUsername.getText();
        String password = new String(inpPassword.getPassword());

        String query = "SELECT * FROM users WHERE username=\"" + username + "\" AND active=1";
        User user = (User) userDAO.getQuery(query);

        if (user == null) {
            lblLoginError.setVisible(true);
        } else if (user.getPassword().equals(new md5().md5(password))) {
            Main main = new Main(user);
            main.setVisible(true);
            this.dispose();
            lblLoginError.setVisible(false);
        } else {
            lblLoginError.setVisible(true);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

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

    private void inpPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpPasswordFocusGained
        if (new String(inpPassword.getPassword()).equals("password")) {
            inpPassword.setText("");
        }
    }//GEN-LAST:event_inpPasswordFocusGained

    private void inpPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpPasswordFocusLost
        if (new String(inpPassword.getPassword()).equals("")) {
            inpPassword.setText("password");
        }
    }//GEN-LAST:event_inpPasswordFocusLost

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_exitMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel exit;
    private javax.swing.JPasswordField inpPassword;
    private javax.swing.JTextField inpUsername;
    private javax.swing.JLabel lblLoginError;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel panel;
    private javax.swing.JSeparator sepPassword;
    private javax.swing.JSeparator sepUsername;
    // End of variables declaration//GEN-END:variables
}
