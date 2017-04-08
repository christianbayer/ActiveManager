/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.User;
import dao.RoleDAO;
import dao.UserDAO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 *
 * @author christian
 */
public class UsuariosNovo extends javax.swing.JPanel {

    UserDAO userDAO;
    RoleDAO roleDAO;
    Color errorColor;
    Color normalColor;
    ArrayList errorsList;
    CardLayout layoutController;
    JPanel cardPanel;
    Usuarios usuarios;
    JLabel btnBack;
    JLabel lblWindow;
    User user;

    /**
     * Creates new form Usuario
     */
    public UsuariosNovo(JLabel btnBack, JLabel lblWindow, CardLayout lController, JPanel cardPanel, User user) {
        initComponents();

        // Seta o título da janela
        lblWindow.setText("NOVO USUÁRIO");

        // Troca o action do botão "Voltar"
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuarios = new Usuarios(btnBack, lblWindow, layoutController, cardPanel);
                cardPanel.add(usuarios, "usuarios");
                layoutController = ((CardLayout) cardPanel.getLayout());
                layoutController.show(cardPanel, "usuarios");
            }
        });

        // Inicializa as variáveis de tela
        this.btnBack = btnBack;
        this.lblWindow = lblWindow;
        this.cardPanel = cardPanel;
        this.layoutController = lController;

        // Inicializa as cores;
        errorColor = new Color(255, 0, 0);
        normalColor = new Color(60, 60, 60);

        // Inicializa os DAO's
        userDAO = new UserDAO();
        roleDAO = new RoleDAO();

        // Popula o combobox com os papéis
        roleDAO.lists(selRole);

        errorsList = new ArrayList();

        // Edição
        if (user.getFirstName() != null) {
            this.user = user;
            user.checkUsernameInUse("christian");
            // Seta o título da janela
            lblWindow.setText("EDITAR USUÁRIO");

            // Inicializa os campos
            inpFirstName.setText(user.getFirstName());
            inpLastName.setText(user.getLastName());
            inpEmail.setText(user.getEmail());
            selRole.setSelectedIndex(user.getRoleId());
            inpUsername.setText(user.getUsername());
            inpPassword.setText(user.getPassword());
            inpPasswordConfirmation.setText(user.getPassword());
            txtBiography.setText(user.getBiography());
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

        basePanel = new javax.swing.JPanel();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        listErrors = new javax.swing.JList<>();

        setBackground(new java.awt.Color(254, 254, 254));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(254, 254, 254));
        basePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        basePanel.add(inpFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 350, 20));

        sepFirstName.setBackground(new java.awt.Color(103, 103, 103));
        sepFirstName.setForeground(new java.awt.Color(29, 29, 29));
        sepFirstName.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 350, 1));

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
        basePanel.add(inpLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 350, 20));

        sepLastName.setBackground(new java.awt.Color(103, 103, 103));
        sepLastName.setForeground(new java.awt.Color(29, 29, 29));
        sepLastName.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 350, 1));

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
        basePanel.add(inpEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 350, 20));

        sepEmail.setBackground(new java.awt.Color(103, 103, 103));
        sepEmail.setForeground(new java.awt.Color(29, 29, 29));
        sepEmail.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 350, 1));

        selRole.setBackground(new java.awt.Color(254, 254, 254));
        selRole.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        selRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Papel" }));
        selRole.setToolTipText("");
        selRole.setOpaque(false);
        selRole.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                selRoleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                selRoleFocusLost(evt);
            }
        });
        basePanel.add(selRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 350, -1));

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
        basePanel.add(inpUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 350, 20));

        sepUsername.setBackground(new java.awt.Color(103, 103, 103));
        sepUsername.setForeground(new java.awt.Color(29, 29, 29));
        sepUsername.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 350, 1));

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
        basePanel.add(inpPasswordConfirmation, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 350, 20));

        sepPasswordConfirmation.setBackground(new java.awt.Color(103, 103, 103));
        sepPasswordConfirmation.setForeground(new java.awt.Color(29, 29, 29));
        sepPasswordConfirmation.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepPasswordConfirmation, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 350, 1));

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
        basePanel.add(inpPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 350, 20));

        sepPassword.setBackground(new java.awt.Color(103, 103, 103));
        sepPassword.setForeground(new java.awt.Color(29, 29, 29));
        sepPassword.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 350, 1));

        jScrollPane1.setBorder(null);

        txtBiography.setBackground(new java.awt.Color(254, 254, 254));
        txtBiography.setColumns(20);
        txtBiography.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        txtBiography.setForeground(new java.awt.Color(29, 29, 29));
        txtBiography.setRows(5);
        txtBiography.setText("Biografia");
        txtBiography.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 29, 29)));
        txtBiography.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBiographyFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBiographyFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtBiography);

        basePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 730, 136));

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
        basePanel.add(btnSalvarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 440, 90, 40));

        jScrollPane2.setBorder(null);

        listErrors.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        listErrors.setEnabled(false);
        listErrors.setFocusable(false);
        jScrollPane2.setViewportView(listErrors);

        basePanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 640, 140));

        add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));
    }// </editor-fold>//GEN-END:initComponents

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
        validateEmail();
    }//GEN-LAST:event_inpEmailFocusLost

    private void inpUsernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpUsernameFocusGained
        if (inpUsername.getText().trim().equals("Usuário")) {
            inpUsername.setText("");
            setTextFieldNormal(inpUsername, sepUsername);
        }
    }//GEN-LAST:event_inpUsernameFocusGained

    private void inpUsernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpUsernameFocusLost
        validateUsername();
    }//GEN-LAST:event_inpUsernameFocusLost

    private void inpPasswordConfirmationFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpPasswordConfirmationFocusGained
        if (new String(inpPasswordConfirmation.getPassword()).equals("password")) {
            inpPasswordConfirmation.setText("");
            setTextFieldNormal(inpPasswordConfirmation, sepPasswordConfirmation);
        }
    }//GEN-LAST:event_inpPasswordConfirmationFocusGained

    private void inpPasswordConfirmationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpPasswordConfirmationFocusLost
        validatePasswordConfirmation();
    }//GEN-LAST:event_inpPasswordConfirmationFocusLost

    private void inpPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpPasswordFocusGained
        if (new String(inpPassword.getPassword()).equals("password")) {
            inpPassword.setText("");
            setTextFieldNormal(inpPassword, sepPassword);
        }
    }//GEN-LAST:event_inpPasswordFocusGained
    private void inpPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpPasswordFocusLost
        validatePassword();
    }//GEN-LAST:event_inpPasswordFocusLost

    private void btnSalvarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarUsuarioActionPerformed
        // Inicia a lista de erros
        errorsList = new ArrayList();

        // Cria uma lista padrão
        DefaultListModel listModel = new DefaultListModel();

        validateFirstName();
        validateEmail();
        validateRole();
        validateUsername();
        validatePassword();
        validatePasswordConfirmation();

        if (!errorsList.isEmpty()) {
            for (int i = 0; i < errorsList.size(); i++) {
                listModel.add(i, errorsList.get(i));
            }
            listErrors.setModel(listModel);
        } else {
            User user = new User();
            user.setUsername(inpUsername.getText());
            user.setPassword(new String(inpPassword.getPassword()));
            user.setEmail(inpEmail.getText());
            user.setFirstName(inpFirstName.getText());
            user.setLastName(inpLastName.getText());
            user.setRoleId(selRole.getSelectedIndex());
            user.setBiography(txtBiography.getText());
            if (this.user != null) {
                user.setId(this.user.getId());
                userDAO.update(user);
            } else {
                userDAO.save(user);
            }

            usuarios = new Usuarios(btnBack, lblWindow, layoutController, cardPanel);
            cardPanel.add(usuarios, "usuarios");
            layoutController = ((CardLayout) cardPanel.getLayout());
            layoutController.show(cardPanel, "usuarios");
        }
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

    private void selRoleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selRoleFocusGained
        selRole.setForeground(normalColor);
    }//GEN-LAST:event_selRoleFocusGained

    private void selRoleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selRoleFocusLost
        validateRole();
    }//GEN-LAST:event_selRoleFocusLost

    private void setTextFieldError(JTextField textField, JSeparator separator) {
        textField.setForeground(errorColor);
        separator.setForeground(errorColor);
    }

    private void setTextFieldNormal(JTextField textField, JSeparator separator) {
        textField.setForeground(normalColor);
        separator.setForeground(normalColor);
    }

    private void validateFirstName() {
        String firstName = inpFirstName.getText().trim();
        if (firstName.isEmpty() || firstName.equals("Nome")) {
            inpFirstName.setText("Nome");
            setTextFieldError(inpFirstName, sepFirstName);
            errorsList.add("O campo \"Usuário\" é obrigatório!");
        }
    }

    private void validateEmail() {
        String email = inpEmail.getText().trim();
        if (email.isEmpty() || email.equals("Email")) {
            inpEmail.setText("Email");
            setTextFieldError(inpEmail, sepEmail);
            errorsList.add("O campo \"Email\" é obrigatório!");
        } else if (email.indexOf("@") < 3 || email.indexOf(".") < 3) {
            setTextFieldError(inpEmail, sepEmail);
            errorsList.add("O campo \"Email\" é inválido!");
        } else {
            setTextFieldNormal(inpEmail, sepEmail);
        }
    }

    private void validateRole() {
        int roleId = selRole.getSelectedIndex();
        if (roleId == 0) {
            selRole.setForeground(errorColor);
            errorsList.add("O campo \"Papel\" é obrigatório!");
        }
    }

    private void validateUsername() {
        String username = inpUsername.getText().trim();
        if (username.isEmpty() || username.equals("Usuário")) {
            inpUsername.setText("Usuário");
            setTextFieldError(inpUsername, sepUsername);
            errorsList.add("O campo \"Usuário\" é obrigatório!");
        } else if (new User().checkUsernameInUse(username)){
            setTextFieldError(inpUsername, sepUsername);
            errorsList.add("Este usuário já está em uso!");
        } else {
            setTextFieldNormal(inpUsername, sepUsername);
        }
    }

    private void validatePasswordConfirmation() {
        String passwordConfirmation = new String(inpPasswordConfirmation.getPassword()).trim();
        String password = new String(inpPassword.getPassword()).trim();
        if (passwordConfirmation.equals("password") || passwordConfirmation.equals("")) {
            inpPasswordConfirmation.setText("password");
            setTextFieldError(inpPasswordConfirmation, sepPasswordConfirmation);
            errorsList.add("O campo \"Confirmação de Senha\" é obrigatório!");
        } else if (!passwordConfirmation.equals(password)) {
            setTextFieldError(inpPasswordConfirmation, sepPasswordConfirmation);
            errorsList.add("A confirmação de senha é diferente da senha!");
        } else {
            setTextFieldNormal(inpPasswordConfirmation, sepPasswordConfirmation);
        }
    }

    private void validatePassword() {
        String passwordConfirmation = new String(inpPasswordConfirmation.getPassword()).trim();
        String password = new String(inpPassword.getPassword()).trim();
        if (password.equals("password") || password.equals("")) {
            inpPassword.setText("password");
            setTextFieldError(inpPassword, sepPassword);
            errorsList.add("O campo \"Senha\" é obrigatório!");
        }
        if (!passwordConfirmation.equals("password")) {
            if (!passwordConfirmation.equals(password)) {
                setTextFieldError(inpPasswordConfirmation, sepPasswordConfirmation);
                errorsList.add("A confirmação de senha é diferente da senha!");
            } else {
                setTextFieldNormal(inpPasswordConfirmation, sepPasswordConfirmation);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JButton btnSalvarUsuario;
    private javax.swing.JTextField inpEmail;
    private javax.swing.JTextField inpFirstName;
    private javax.swing.JTextField inpLastName;
    private javax.swing.JPasswordField inpPassword;
    private javax.swing.JPasswordField inpPasswordConfirmation;
    private javax.swing.JTextField inpUsername;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listErrors;
    private javax.swing.JComboBox<String> selRole;
    private javax.swing.JSeparator sepEmail;
    private javax.swing.JSeparator sepFirstName;
    private javax.swing.JSeparator sepLastName;
    private javax.swing.JSeparator sepPassword;
    private javax.swing.JSeparator sepPasswordConfirmation;
    private javax.swing.JSeparator sepUsername;
    private javax.swing.JTextArea txtBiography;
    // End of variables declaration//GEN-END:variables
}
