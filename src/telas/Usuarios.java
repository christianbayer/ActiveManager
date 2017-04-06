/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.User;
import controllers.UsersController;
import dao.UserDAO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author christian
 */
public class Usuarios extends javax.swing.JPanel {

    JLabel lblWindow;
    JLabel btnBack;
    UsersController controller;
    UserDAO userDAO;
    CardLayout layoutController;
    JPanel cardPanel;
    Dashboard dashboard;
    UsuariosNovo usuariosNovo;

    /**
     * Creates new form Usuario
     */
    public Usuarios(JLabel btnBack, JLabel lblWindow, CardLayout lController, JPanel cardPanel) {
        initComponents();

        // Seta o título da janela
        lblWindow.setText("USUÁRIOS");

        // Troca o action do botão "Voltar"
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboard = new Dashboard(lblWindow);
                cardPanel.add(dashboard, "dashboard");
                layoutController = ((CardLayout) cardPanel.getLayout());
                layoutController.show(cardPanel, "dashboard");
            }
        });

        // Inicializa as variáveis de tela
        this.btnBack = btnBack;
        this.lblWindow = lblWindow;
        this.cardPanel = cardPanel;
        this.layoutController = lController;

        userDAO = new UserDAO();
        ArrayList<Object> users = userDAO.getAll();
        Iterator<Object> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            listUser(user);
        }
        
        lblFound.setText(users.size() + " usuários encontrados:");

        row1.setVisible(false);
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
        lblFound = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        inpPesquisar = new javax.swing.JTextField();
        sepPesquisar = new javax.swing.JSeparator();
        btnNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panUsers = new javax.swing.JPanel();
        row1 = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblUser = new javax.swing.JLabel();
        btnTrash = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        panCabecalho = new javax.swing.JPanel();
        lblCabecalhoNome = new javax.swing.JLabel();
        lblCabecalhoUsuario = new javax.swing.JLabel();
        lblCabecalhoAcoes = new javax.swing.JLabel();
        lblCabecalhoEmail = new javax.swing.JLabel();
        lblCabecalhoPapel = new javax.swing.JLabel();
        lblCabecalhoNome1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 254, 254));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(254, 254, 254));
        basePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFound.setFont(new java.awt.Font("NanumGothic", 0, 18)); // NOI18N
        lblFound.setText("1 usuários encontrados:");
        basePanel.add(lblFound, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        btnPesquisar.setBackground(new java.awt.Color(52, 100, 127));
        btnPesquisar.setFont(new java.awt.Font("NanumGothic", 0, 14)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(254, 254, 254));
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/search.png"))); // NOI18N
        btnPesquisar.setToolTipText("");
        btnPesquisar.setBorderPainted(false);
        btnPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPesquisar.setDefaultCapable(false);
        btnPesquisar.setName(""); // NOI18N
        btnPesquisar.setOpaque(true);
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });
        basePanel.add(btnPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 10, 40, 40));

        inpPesquisar.setBackground(new java.awt.Color(254, 254, 254));
        inpPesquisar.setFont(new java.awt.Font("NanumGothic", 0, 14)); // NOI18N
        inpPesquisar.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inpPesquisar.setText("Pesquisar");
        inpPesquisar.setBorder(null);
        inpPesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inpPesquisar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpPesquisarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpPesquisarFocusLost(evt);
            }
        });
        basePanel.add(inpPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, 230, 20));

        sepPesquisar.setBackground(new java.awt.Color(103, 103, 103));
        sepPesquisar.setForeground(new java.awt.Color(29, 29, 29));
        sepPesquisar.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepPesquisar, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 230, 1));

        btnNew.setBackground(new java.awt.Color(52, 100, 127));
        btnNew.setFont(new java.awt.Font("NanumGothic", 0, 14)); // NOI18N
        btnNew.setForeground(new java.awt.Color(254, 254, 254));
        btnNew.setText("NOVO");
        btnNew.setToolTipText("");
        btnNew.setBorderPainted(false);
        btnNew.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNew.setDefaultCapable(false);
        btnNew.setName(""); // NOI18N
        btnNew.setOpaque(true);
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        basePanel.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 440, 90, 40));

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panUsers.setBackground(new java.awt.Color(254, 254, 254));
        panUsers.setBorder(null);
        panUsers.setOpaque(false);
        panUsers.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        row1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setFont(new java.awt.Font("NanumGothic", 0, 12)); // NOI18N
        lblId.setText("1");
        row1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, -1, -1));

        lblEmail.setFont(new java.awt.Font("NanumGothic", 0, 12)); // NOI18N
        lblEmail.setText("christian@oxigennio.com.br");
        row1.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 8, -1, -1));

        lblRole.setFont(new java.awt.Font("NanumGothic", 0, 12)); // NOI18N
        lblRole.setText("Administrador");
        row1.add(lblRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 8, -1, -1));

        lblName.setFont(new java.awt.Font("NanumGothic", 0, 12)); // NOI18N
        lblName.setText("Christian Bayer");
        row1.add(lblName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 8, -1, -1));

        lblUser.setFont(new java.awt.Font("NanumGothic", 0, 12)); // NOI18N
        lblUser.setText("christian");
        row1.add(lblUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 8, -1, -1));

        btnTrash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        row1.add(btnTrash, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 5, -1, -1));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        row1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 5, -1, -1));

        panUsers.add(row1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 30));

        jScrollPane1.setViewportView(panUsers);

        basePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 740, 330));

        panCabecalho.setBackground(new java.awt.Color(209, 209, 209));
        panCabecalho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCabecalhoNome.setFont(new java.awt.Font("NanumGothic", 0, 12)); // NOI18N
        lblCabecalhoNome.setText("NOME");
        panCabecalho.add(lblCabecalhoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 8, -1, -1));

        lblCabecalhoUsuario.setFont(new java.awt.Font("NanumGothic", 0, 12)); // NOI18N
        lblCabecalhoUsuario.setText("USUÁRIO");
        panCabecalho.add(lblCabecalhoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 8, -1, -1));

        lblCabecalhoAcoes.setFont(new java.awt.Font("NanumGothic", 0, 12)); // NOI18N
        lblCabecalhoAcoes.setText("AÇÕES");
        panCabecalho.add(lblCabecalhoAcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 8, -1, -1));

        lblCabecalhoEmail.setFont(new java.awt.Font("NanumGothic", 0, 12)); // NOI18N
        lblCabecalhoEmail.setText("EMAIL");
        panCabecalho.add(lblCabecalhoEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 8, -1, -1));

        lblCabecalhoPapel.setFont(new java.awt.Font("NanumGothic", 0, 12)); // NOI18N
        lblCabecalhoPapel.setText("PAPEL");
        panCabecalho.add(lblCabecalhoPapel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 8, -1, -1));

        lblCabecalhoNome1.setFont(new java.awt.Font("NanumGothic", 0, 12)); // NOI18N
        lblCabecalhoNome1.setText("ID");
        panCabecalho.add(lblCabecalhoNome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, -1, -1));

        basePanel.add(panCabecalho, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 740, 30));

        add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void inpPesquisarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpPesquisarFocusGained
        if (inpPesquisar.getText().trim().equals("Usuário")) {
            inpPesquisar.setText("");
        }
    }//GEN-LAST:event_inpPesquisarFocusGained

    private void inpPesquisarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpPesquisarFocusLost
        if (inpPesquisar.getText().trim().isEmpty()) {
            inpPesquisar.setText("Usuário");
        }
    }//GEN-LAST:event_inpPesquisarFocusLost

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        usuariosNovo = new UsuariosNovo(btnBack, lblWindow, layoutController, cardPanel);
        cardPanel.add(usuariosNovo, "usuariosNovo");
        layoutController = ((CardLayout) cardPanel.getLayout());
        layoutController.show(cardPanel, "usuariosNovo");
    }//GEN-LAST:event_btnNewActionPerformed

    private int panY = 0;
    private Color panColorA = new Color(194, 228, 253);
    private Color panColorB = new Color(254, 254, 254);
    private int panRowCount = 1;

    private void listUser(User user) {
        System.out.println(panRowCount % 2);
        JPanel userPanel;
        userPanel = new JPanel();
        userPanel.setBackground(panRowCount % 2 == 0 ? panColorB : panColorA);
        userPanel.setLayout(new AbsoluteLayout());

        JLabel lblId = new JLabel();
        JLabel lblName = new JLabel();
        JLabel btnTrash = new JLabel();
        JLabel btnEdit = new JLabel();
        JLabel lblRole = new JLabel();
        JLabel lblEmail = new JLabel();
        JLabel lblUsername = new JLabel();

        userPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setFont(new Font("NanumGothic", 0, 12)); // NOI18N
        lblId.setText(String.valueOf(user.getId()));
        userPanel.add(lblId, new AbsoluteConstraints(10, 8, -1, -1));
        
        lblName.setFont(new Font("NanumGothic", 0, 12)); // NOI18N
        lblName.setText(user.getFirstName() + " " + user.getLastName());
        userPanel.add(lblName, new AbsoluteConstraints(40, 8, -1, -1));

        lblEmail.setFont(new Font("NanumGothic", 0, 12)); // NOI18N
        lblEmail.setText(user.getEmail());
        userPanel.add(lblEmail, new AbsoluteConstraints(200, 8, -1, -1));

        lblRole.setFont(new Font("NanumGothic", 0, 12)); // NOI18N
        lblRole.setText(String.valueOf(user.getRoleId()));
        userPanel.add(lblRole, new AbsoluteConstraints(550, 8, -1, -1));

        lblUsername.setFont(new Font("NanumGothic", 0, 12)); // NOI18N
        lblUsername.setText(user.getUsername());
        userPanel.add(lblUsername, new AbsoluteConstraints(420, 8, -1, -1));

        btnTrash.setIcon(new ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        userPanel.add(btnTrash, new AbsoluteConstraints(700, 5, -1, -1));

        btnEdit.setIcon(new ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        userPanel.add(btnEdit, new AbsoluteConstraints(670, 5, -1, -1));

        panUsers.add(userPanel, new AbsoluteConstraints(0, panY, 740, 30));

        panRowCount++;
        panY += 30;
        basePanel.revalidate();
        basePanel.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel btnTrash;
    private javax.swing.JTextField inpPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCabecalhoAcoes;
    private javax.swing.JLabel lblCabecalhoEmail;
    private javax.swing.JLabel lblCabecalhoNome;
    private javax.swing.JLabel lblCabecalhoNome1;
    private javax.swing.JLabel lblCabecalhoPapel;
    private javax.swing.JLabel lblCabecalhoUsuario;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFound;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblUser;
    private javax.swing.JPanel panCabecalho;
    private javax.swing.JPanel panUsers;
    private javax.swing.JPanel row1;
    private javax.swing.JSeparator sepPesquisar;
    // End of variables declaration//GEN-END:variables
}
