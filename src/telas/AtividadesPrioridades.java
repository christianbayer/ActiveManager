/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.IssuePriority;
import classes.User;
import dao.IssuePriorityDAO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author christian
 */
public class AtividadesPrioridades extends javax.swing.JPanel {

    JLabel lblWindow;
    JLabel btnBack;
    IssuePriorityDAO issuePriorityDAO;
    CardLayout layoutController;
    JPanel cardPanel;
    Administrativo administrativo;
    AtividadesPrioridadesNovo atividadesPrioridadesNovo;
    User user;

    /**
     * Creates new form Usuario
     */
    public AtividadesPrioridades(JLabel btnBack, JLabel lblWindow, CardLayout lController, JPanel cardPanel, User user) {
        initComponents();

        // Seta o título da janela
        lblWindow.setText("PRIORIDADES DE ATIVIDADES");

        // Troca o action do botão "Voltar"
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                administrativo = new Administrativo(btnBack, lblWindow, layoutController, cardPanel, user);
                cardPanel.add(administrativo, "administrativo");
                layoutController = ((CardLayout) cardPanel.getLayout());
                layoutController.show(cardPanel, "administrativo");
            }
        });

        // Inicializa as variáveis de tela
        this.btnBack = btnBack;
        this.lblWindow = lblWindow;
        this.cardPanel = cardPanel;
        this.layoutController = lController;
        this.user = user;

        issuePriorityDAO = new IssuePriorityDAO();

        inicializarLista();

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
        panIssuesTypes = new javax.swing.JPanel();
        row1 = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        lblDescription = new javax.swing.JLabel();
        btnTrash = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        panCabecalho = new javax.swing.JPanel();
        lblCabecalhoDescricao = new javax.swing.JLabel();
        lblCabecalhoAcoes = new javax.swing.JLabel();
        lblCabecalhoId = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 254, 254));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(254, 254, 254));
        basePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFound.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        lblFound.setText("1 tipos de projetos encontrados:");
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
        inpPesquisar.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
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
        btnNew.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
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

        panIssuesTypes.setBackground(new java.awt.Color(254, 254, 254));
        panIssuesTypes.setBorder(null);
        panIssuesTypes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        row1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblId.setText("1");
        row1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, -1, -1));

        lblDescription.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblDescription.setText("Administrador");
        row1.add(lblDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 8, -1, -1));

        btnTrash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        row1.add(btnTrash, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 5, -1, -1));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        row1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 5, -1, -1));

        panIssuesTypes.add(row1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 30));

        jScrollPane1.setViewportView(panIssuesTypes);

        basePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 740, 330));

        panCabecalho.setBackground(new java.awt.Color(209, 209, 209));
        panCabecalho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCabecalhoDescricao.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCabecalhoDescricao.setText("DESCRIÇÃO");
        panCabecalho.add(lblCabecalhoDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 8, -1, -1));

        lblCabecalhoAcoes.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCabecalhoAcoes.setText("AÇÕES");
        panCabecalho.add(lblCabecalhoAcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 8, -1, -1));

        lblCabecalhoId.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCabecalhoId.setText("ID");
        panCabecalho.add(lblCabecalhoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, -1, -1));

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
        atividadesPrioridadesNovo = new AtividadesPrioridadesNovo(btnBack, lblWindow, layoutController, cardPanel, new IssuePriority(), user);
        cardPanel.add(atividadesPrioridadesNovo, "atividadesPrioridadesNovo");
        layoutController = ((CardLayout) cardPanel.getLayout());
        layoutController.show(cardPanel, "atividadesPrioridadesNovo");
    }//GEN-LAST:event_btnNewActionPerformed

    private Color panColorA = new Color(194, 228, 253);
    private Color panColorB = new Color(254, 254, 254);
    private int panY;
    private int panRowCount;

    private void listIssuePriority(IssuePriority issuePriority) {
        JPanel issuePriorityPanel = new JPanel();
        issuePriorityPanel.setBackground(panRowCount % 2 == 0 ? panColorB : panColorA);
        issuePriorityPanel.setLayout(new AbsoluteLayout());

        JLabel lblId = new JLabel();
        JLabel lblDescription = new JLabel();
        JLabel btnTrash = new JLabel();
        JLabel btnEdit = new JLabel();

        if (!issuePriority.isActive()) {
            lblId.setForeground(new Color(172, 172, 172));
            lblDescription.setForeground(new Color(172, 172, 172));
        }

        issuePriorityPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
        lblId.setText(String.valueOf(issuePriority.getId()));
        issuePriorityPanel.add(lblId, new AbsoluteConstraints(10, 8, -1, -1));

        lblDescription.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
        lblDescription.setText(issuePriority.getDescription());
        issuePriorityPanel.add(lblDescription, new AbsoluteConstraints(40, 8, -1, -1));

        btnTrash.setIcon(new ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        btnTrash.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int res = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta prioridade de atividade? Esta ação não poderá ser desfeita!");
                if (res == 0) {
                    issuePriorityDAO.delete(issuePriority.getId());
                    inicializarLista();
                }
            }
        });
        issuePriorityPanel.add(btnTrash, new AbsoluteConstraints(700, 5, -1, -1));

        btnEdit.setIcon(new ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atividadesPrioridadesNovo = new AtividadesPrioridadesNovo(btnBack, lblWindow, layoutController, cardPanel, issuePriority, user);
                cardPanel.add(atividadesPrioridadesNovo, "atividadesPrioridadesNovo");
                layoutController = ((CardLayout) cardPanel.getLayout());
                layoutController.show(cardPanel, "atividadesPrioridadesNovo");
            }
        });
        issuePriorityPanel.add(btnEdit, new AbsoluteConstraints(670, 5, -1, -1));

        panIssuesTypes.add(issuePriorityPanel, new AbsoluteConstraints(0, panY, 740, 30));

        panRowCount++;
        panY += 30;
        basePanel.revalidate();
        basePanel.repaint();
    }

    private void inicializarLista() {
        panY = 0;
        panRowCount = 1;
        panIssuesTypes.removeAll();
        panIssuesTypes.updateUI();
        ArrayList<Object> projectsTypes = issuePriorityDAO.getAll();
        Iterator<Object> iterator = projectsTypes.iterator();
        while (iterator.hasNext()) {
            IssuePriority issuePriority = (IssuePriority) iterator.next();
            listIssuePriority(issuePriority);
        }
        lblFound.setText(projectsTypes.size() + " prioridades de atividades encontradas:");
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
    private javax.swing.JLabel lblCabecalhoDescricao;
    private javax.swing.JLabel lblCabecalhoId;
    private javax.swing.JLabel lblDescription;
    private javax.swing.JLabel lblFound;
    private javax.swing.JLabel lblId;
    private javax.swing.JPanel panCabecalho;
    private javax.swing.JPanel panIssuesTypes;
    private javax.swing.JPanel row1;
    private javax.swing.JSeparator sepPesquisar;
    // End of variables declaration//GEN-END:variables
}
