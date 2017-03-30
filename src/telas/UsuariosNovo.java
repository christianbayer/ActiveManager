/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.User;
import controllers.UsersController;
import dao.UserDAO;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import tablemodel.UsersTableModel;

/**
 *
 * @author christian
 */
public class UsuariosNovo extends javax.swing.JPanel {

    UsersController controller;
    UserDAO userDAO;
    Color errorColor;
    Color normalColor;

    /**
     * Creates new form Usuario
     */
    public UsuariosNovo() {
        initComponents();

        // Seta o tamanho do frame
        this.setSize(800, 500);

        errorColor = new Color(255, 0, 0);
        normalColor = new Color(60, 60, 60);

        userDAO = new UserDAO();

//        ArrayList<Object> users = userDAO.getAll();
//        
//        System.out.println(users);
//        
//        this.tableUsuarios.setModel(new UsersTableModel(users));
        // Seta o tamano do panel
//        tabPanUsuarios.setSize(200, 200);
//        tabPanUsuarios.setBounds(10, 200, 100, 100);
//        System.out.println(this.getSize());
//        System.out.println(tabPanUsuarios.getSize());
        controller = new UsersController();
//        ArrayList<User> users = controller.popularTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sepF = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnExit = new javax.swing.JLabel();
        lblImagemUsuario = new javax.swing.JLabel();
        lblProjetos = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JLabel();
        lblNomeUsuario = new javax.swing.JLabel();
        inpFirstName = new javax.swing.JTextField();
        sepFirstName = new javax.swing.JSeparator();
        inpLastName = new javax.swing.JTextField();
        sepLastName = new javax.swing.JSeparator();
        inpEmail = new javax.swing.JTextField();
        sepEmail = new javax.swing.JSeparator();
        selRole = new javax.swing.JComboBox<>();
        inpUsername = new javax.swing.JTextField();
        sepUsername = new javax.swing.JSeparator();
        inpPasswordConfirmation = new javax.swing.JPasswordField();
        sepPasswordConfirmation = new javax.swing.JSeparator();
        inpPassword = new javax.swing.JPasswordField();
        sepPassword = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtBiography = new javax.swing.JTextArea();
        btnSalvarUsuario = new javax.swing.JButton();
        lblErrorNome = new javax.swing.JLabel();
        lblSaveError1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 254, 254));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sepF.setBackground(new java.awt.Color(254, 254, 254));
        sepF.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(254, 254, 254));
        jPanel3.setFont(new java.awt.Font("Ubuntu Light", 0, 30)); // NOI18N
        jPanel3.setPreferredSize(new java.awt.Dimension(900, 500));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnExit.setFont(new java.awt.Font("Ubuntu", 0, 22)); // NOI18N
        btnExit.setText("x");
        btnExit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExitMouseClicked(evt);
            }
        });
        jPanel3.add(btnExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 0, -1, -1));

        lblImagemUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/user.png"))); // NOI18N
        jPanel3.add(lblImagemUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, -1));

        lblProjetos.setFont(new java.awt.Font("NanumGothic", 0, 24)); // NOI18N
        lblProjetos.setText("NOVO USUÁRIO");
        jPanel3.add(lblProjetos, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/back.png"))); // NOI18N
        jPanel3.add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lblNomeUsuario.setFont(new java.awt.Font("NanumGothic", 0, 18)); // NOI18N
        lblNomeUsuario.setText("Christian Bayer");
        jPanel3.add(lblNomeUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 35, -1, -1));

        sepF.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 90));

        inpFirstName.setBackground(new java.awt.Color(254, 254, 254));
        inpFirstName.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        inpFirstName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inpFirstName.setText("Nome");
        inpFirstName.setBorder(null);
        inpFirstName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inpFirstName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpFirstNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpFirstNameFocusLost(evt);
            }
        });
        sepF.add(inpFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 350, 20));

        sepFirstName.setBackground(new java.awt.Color(103, 103, 103));
        sepFirstName.setForeground(new java.awt.Color(29, 29, 29));
        sepFirstName.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        sepF.add(sepFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 350, 1));

        inpLastName.setBackground(new java.awt.Color(254, 254, 254));
        inpLastName.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        inpLastName.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inpLastName.setText("Sobrenome");
        inpLastName.setBorder(null);
        inpLastName.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inpLastName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpLastNameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpLastNameFocusLost(evt);
            }
        });
        sepF.add(inpLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 350, 20));

        sepLastName.setBackground(new java.awt.Color(103, 103, 103));
        sepLastName.setForeground(new java.awt.Color(29, 29, 29));
        sepLastName.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        sepF.add(sepLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 350, 1));

        inpEmail.setBackground(new java.awt.Color(254, 254, 254));
        inpEmail.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        inpEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inpEmail.setText("Email");
        inpEmail.setBorder(null);
        inpEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inpEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpEmailFocusLost(evt);
            }
        });
        sepF.add(inpEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 350, 20));

        sepEmail.setBackground(new java.awt.Color(103, 103, 103));
        sepEmail.setForeground(new java.awt.Color(29, 29, 29));
        sepEmail.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        sepF.add(sepEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 350, 1));

        selRole.setBackground(new java.awt.Color(254, 254, 254));
        selRole.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        selRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Papel" }));
        selRole.setToolTipText("");
        selRole.setBorder(null);
        selRole.setOpaque(false);
        sepF.add(selRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 350, -1));

        inpUsername.setBackground(new java.awt.Color(254, 254, 254));
        inpUsername.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        inpUsername.setHorizontalAlignment(javax.swing.JTextField.LEFT);
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
        sepF.add(inpUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 350, 20));

        sepUsername.setBackground(new java.awt.Color(103, 103, 103));
        sepUsername.setForeground(new java.awt.Color(29, 29, 29));
        sepUsername.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        sepF.add(sepUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 350, 1));

        inpPasswordConfirmation.setBackground(new java.awt.Color(254, 254, 254));
        inpPasswordConfirmation.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        inpPasswordConfirmation.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inpPasswordConfirmation.setText("password");
        inpPasswordConfirmation.setToolTipText("Senha");
        inpPasswordConfirmation.setBorder(null);
        inpPasswordConfirmation.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpPasswordConfirmationFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpPasswordConfirmationFocusLost(evt);
            }
        });
        sepF.add(inpPasswordConfirmation, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 250, 350, 20));

        sepPasswordConfirmation.setBackground(new java.awt.Color(103, 103, 103));
        sepPasswordConfirmation.setForeground(new java.awt.Color(29, 29, 29));
        sepPasswordConfirmation.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        sepF.add(sepPasswordConfirmation, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 270, 350, 1));

        inpPassword.setBackground(new java.awt.Color(254, 254, 254));
        inpPassword.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        inpPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inpPassword.setText("password");
        inpPassword.setToolTipText("Senha");
        inpPassword.setBorder(null);
        inpPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpPasswordFocusLost(evt);
            }
        });
        sepF.add(inpPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 350, 20));

        sepPassword.setBackground(new java.awt.Color(103, 103, 103));
        sepPassword.setForeground(new java.awt.Color(29, 29, 29));
        sepPassword.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        sepF.add(sepPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 350, 1));

        txtBiography.setBackground(new java.awt.Color(254, 254, 254));
        txtBiography.setColumns(20);
        txtBiography.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtBiography.setRows(5);
        txtBiography.setText("Biografia");
        txtBiography.setBorder(null);
        txtBiography.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBiographyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBiographyFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtBiography);

        sepF.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 730, 136));

        btnSalvarUsuario.setBackground(new java.awt.Color(52, 100, 127));
        btnSalvarUsuario.setFont(new java.awt.Font("NanumGothic", 0, 14)); // NOI18N
        btnSalvarUsuario.setForeground(new java.awt.Color(254, 254, 254));
        btnSalvarUsuario.setText("SALVAR");
        btnSalvarUsuario.setToolTipText("");
        btnSalvarUsuario.setBorderPainted(false);
        btnSalvarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSalvarUsuario.setDefaultCapable(false);
        btnSalvarUsuario.setName(""); // NOI18N
        btnSalvarUsuario.setOpaque(true);
        btnSalvarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarUsuarioActionPerformed(evt);
            }
        });
        sepF.add(btnSalvarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 540, 90, 40));

        lblErrorNome.setFont(new java.awt.Font("NanumGothic", 0, 14)); // NOI18N
        lblErrorNome.setText("Por favor, revise os campos!");
        sepF.add(lblErrorNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, -1, -1));

        lblSaveError1.setFont(new java.awt.Font("NanumGothic", 0, 14)); // NOI18N
        lblSaveError1.setText("Por favor, revise os campos!");
        sepF.add(lblSaveError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 480, -1, -1));

        add(sepF, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 600));
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btnExitMouseClicked

    private void inpFirstNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpFirstNameFocusGained
        if (inpFirstName.getText().trim().equals("Nome")) {
            inpFirstName.setText("");
            setTextFieldNormal(inpFirstName, sepFirstName);
        }
    }//GEN-LAST:event_inpFirstNameFocusGained

    private void inpFirstNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpFirstNameFocusLost
        validateFirstName();
    }//GEN-LAST:event_inpFirstNameFocusLost

    private void inpLastNameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpLastNameFocusGained
        if (inpLastName.getText().trim().equals("Sobrenome")) {
            inpLastName.setText("");
        }
    }//GEN-LAST:event_inpLastNameFocusGained

    private void inpLastNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpLastNameFocusLost
        if (inpLastName.getText().trim().isEmpty()) {
            inpLastName.setText("Sobrenome");
        }
    }//GEN-LAST:event_inpLastNameFocusLost

    private void inpEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpEmailFocusGained
        if (inpEmail.getText().trim().equals("Email")) {
            inpEmail.setText("");
            setTextFieldNormal(inpEmail, sepEmail);
        }
    }//GEN-LAST:event_inpEmailFocusGained

    private void inpEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpEmailFocusLost
        String email = inpEmail.getText().trim();
        if (email.isEmpty() || email.equals("Email")) {
            inpEmail.setText("Email");
            setTextFieldError(inpEmail, sepEmail);
        }
    }//GEN-LAST:event_inpEmailFocusLost

    private void inpUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpUsernameFocusGained
        if (inpUsername.getText().trim().equals("Usuário")) {
            inpUsername.setText("");
            setTextFieldNormal(inpUsername, sepUsername);
        }
    }//GEN-LAST:event_inpUsernameFocusGained

    private void inpUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpUsernameFocusLost
        String username = inpUsername.getText().trim();
        if (username.isEmpty() || username.equals("Usuário")) {
            inpUsername.setText("Usuário");
            setTextFieldError(inpUsername, sepUsername);
        }
    }//GEN-LAST:event_inpUsernameFocusLost

    private void inpPasswordConfirmationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpPasswordConfirmationFocusGained
        if (new String(inpPasswordConfirmation.getPassword()).equals("password")) {
            inpPasswordConfirmation.setText("");
            setTextFieldNormal(inpPasswordConfirmation, sepPasswordConfirmation);
        }
    }//GEN-LAST:event_inpPasswordConfirmationFocusGained

    private void inpPasswordConfirmationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpPasswordConfirmationFocusLost
        String passwordConfirmation = new String(inpPasswordConfirmation.getPassword()).trim();
        String password = new String(inpPassword.getPassword()).trim();
        if (passwordConfirmation.equals("password") || passwordConfirmation.equals("")) {
            inpPasswordConfirmation.setText("password");
            setTextFieldError(inpPasswordConfirmation, sepPasswordConfirmation);
        } else if (!passwordConfirmation.equals(password)) {
            setTextFieldError(inpPasswordConfirmation, sepPasswordConfirmation);
        } else {
            setTextFieldNormal(inpPasswordConfirmation, sepPasswordConfirmation);
        }
    }//GEN-LAST:event_inpPasswordConfirmationFocusLost

    private void inpPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpPasswordFocusGained
        if (new String(inpPassword.getPassword()).equals("password")) {
            inpPassword.setText("");
            setTextFieldNormal(inpPassword, sepPassword);
        }
    }//GEN-LAST:event_inpPasswordFocusGained
    private void inpPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpPasswordFocusLost
        String passwordConfirmation = new String(inpPasswordConfirmation.getPassword()).trim();
        String password = new String(inpPassword.getPassword()).trim();
        if (password.equals("password") || password.equals("")) {
            inpPassword.setText("password");
            setTextFieldError(inpPassword, sepPassword);
        }
        if (!passwordConfirmation.equals("password")) {
            if (!passwordConfirmation.equals(password)) {
                setTextFieldError(inpPasswordConfirmation, sepPasswordConfirmation);
            } else {
                setTextFieldNormal(inpPasswordConfirmation, sepPasswordConfirmation);
            }
        }
    }//GEN-LAST:event_inpPasswordFocusLost

    private void btnSalvarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuarioActionPerformed
        String username = inpUsername.getText();
        String password = new String(inpPassword.getPassword());
        String email = inpEmail.getText();
        String firstName = inpFirstName.getText();
        String lastName = inpLastName.getText();
        int roleId = 1;
        String biography = txtBiography.getText();

        if(!validateFirstName()){
            
        }
        
        if (username.equals("Usuário") || username.trim().isEmpty()) {
            inpUsername.setForeground(errorColor);
            sepUsername.setForeground(errorColor);
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setRoleId(roleId);
        user.setBiography(biography);

//        userDAO.save(user);
    }//GEN-LAST:event_btnSalvarUsuarioActionPerformed

    private void txtBiographyFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBiographyFocusGained
        if (txtBiography.getText().trim().equals("Biografia")) {
            txtBiography.setText("");
        }
    }//GEN-LAST:event_txtBiographyFocusGained

    private void txtBiographyFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBiographyFocusLost
        if (txtBiography.getText().trim().isEmpty()) {
            txtBiography.setText("Biografia");
        }
    }//GEN-LAST:event_txtBiographyFocusLost

    private void setTextFieldError(JTextField textField, JSeparator separator) {
        textField.setForeground(errorColor);
        separator.setForeground(errorColor);
    }

    private void setTextFieldNormal(JTextField textField, JSeparator separator) {
        textField.setForeground(normalColor);
        separator.setForeground(normalColor);
    }

    private boolean validateFirstName() {
        String firstName = inpFirstName.getText().trim();
        if (firstName.isEmpty() || firstName.equals("Nome")) {
            inpFirstName.setText("Nome");
            setTextFieldError(inpFirstName, sepFirstName);
            return false;
        }
        return true;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnExit;
    private javax.swing.JButton btnSalvarUsuario;
    private javax.swing.JLabel btnVoltar;
    private javax.swing.JTextField inpEmail;
    private javax.swing.JTextField inpFirstName;
    private javax.swing.JTextField inpLastName;
    private javax.swing.JPasswordField inpPassword;
    private javax.swing.JPasswordField inpPasswordConfirmation;
    private javax.swing.JTextField inpUsername;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErrorNome;
    private javax.swing.JLabel lblImagemUsuario;
    private javax.swing.JLabel lblNomeUsuario;
    private javax.swing.JLabel lblProjetos;
    private javax.swing.JLabel lblSaveError1;
    private javax.swing.JComboBox<String> selRole;
    private javax.swing.JSeparator sepEmail;
    private javax.swing.JPanel sepF;
    private javax.swing.JSeparator sepFirstName;
    private javax.swing.JSeparator sepLastName;
    private javax.swing.JSeparator sepPassword;
    private javax.swing.JSeparator sepPasswordConfirmation;
    private javax.swing.JSeparator sepUsername;
    private javax.swing.JTextArea txtBiography;
    // End of variables declaration//GEN-END:variables
}