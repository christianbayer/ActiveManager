/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import apoio.JComboBoxItem;
import classes.Issue;
import classes.User;
import classes.UserProject;
import connection.ConnectionFactory;
import dao.IssueDAO;
import dao.IssuePriorityDAO;
import dao.IssueStatusDAO;
import dao.IssueTypeDAO;
import dao.ProjectDAO;
import dao.UserDAO;
import dao.UserProjectDAO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author christian
 */
public class Atividades extends javax.swing.JPanel {
    
    JLabel lblWindow;
    JLabel btnBack;
    CardLayout layoutController;
    JPanel cardPanel;
    Dashboard dashboard;
    User user;
    AtividadesNovo atividadesNovo;
    AtividadesAtualizar atividadesAtualizar;
    AtividadesDetalhes atividadesDetalhes;
    IssueDAO issueDAO;
    IssueTypeDAO issueTypeDAO;
    IssueStatusDAO issueStatusDAO;
    IssuePriorityDAO issuePriorityDAO;
    ProjectDAO projectDAO;
    UserDAO userDAO;
    UserProjectDAO userProjectDAO;

    /**
     * Creates new form Usuario
     */
    public Atividades(JLabel btnBack, JLabel lblWindow, CardLayout lController, JPanel cardPanel, User user) {
        initComponents();

        // Seta o título da janela
        lblWindow.setText("ATIVIDADES");

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
        this.user = user;
        
        issueDAO = new IssueDAO();
        issueTypeDAO = new IssueTypeDAO();
        issueStatusDAO = new IssueStatusDAO();
        issuePriorityDAO = new IssuePriorityDAO();
        projectDAO = new ProjectDAO();
        userDAO = new UserDAO();
        userProjectDAO = new UserProjectDAO();
        
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filter();
            }
        };
        
        projectDAO.lists(selProject);
        issueTypeDAO.lists(selIssueType);
        issueStatusDAO.lists(selStatus);
        issuePriorityDAO.lists(selPriority);
        userDAO.lists(selAssignedUser, "Atribuído para");
        selIssueType.addActionListener(al);
        selProject.addActionListener(al);
        selStatus.addActionListener(al);
        selPriority.addActionListener(al);
        selAssignedUser.addActionListener(al);
        
        row1.setVisible(false);
        
        listIssues();
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
        inpTitle = new javax.swing.JTextField();
        sepTitle = new javax.swing.JSeparator();
        btnNew = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panIssues = new javax.swing.JPanel();
        row1 = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        lblAssignedUser = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblDone = new javax.swing.JLabel();
        btnTrash = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        lblType = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblPriority = new javax.swing.JLabel();
        btnMore = new javax.swing.JLabel();
        panCabecalho = new javax.swing.JPanel();
        lblCabecalhoTitulo = new javax.swing.JLabel();
        lblCabecalhoConcluido = new javax.swing.JLabel();
        lblCabecalhoAcoes = new javax.swing.JLabel();
        lblCabecalhoPrioridade = new javax.swing.JLabel();
        lblCabecalhoId = new javax.swing.JLabel();
        lblCabecalhoAtribuidoPara = new javax.swing.JLabel();
        lblCabecalhoTipo = new javax.swing.JLabel();
        lblCabecalhoStatus = new javax.swing.JLabel();
        btnImprimir = new javax.swing.JButton();
        btnImprimir1 = new javax.swing.JButton();
        selAssignedUser = new javax.swing.JComboBox<>();
        selPriority = new javax.swing.JComboBox<>();
        selProject = new javax.swing.JComboBox<>();
        selIssueType = new javax.swing.JComboBox<>();
        selStatus = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(254, 254, 254));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(254, 254, 254));
        basePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFound.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        lblFound.setText("1 projetos encontrados:");
        basePanel.add(lblFound, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        inpTitle.setBackground(new java.awt.Color(254, 254, 254));
        inpTitle.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        inpTitle.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inpTitle.setText("Título");
        inpTitle.setBorder(null);
        inpTitle.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inpTitle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpTitleFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpTitleFocusLost(evt);
            }
        });
        basePanel.add(inpTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 240, 20));

        sepTitle.setBackground(new java.awt.Color(103, 103, 103));
        sepTitle.setForeground(new java.awt.Color(29, 29, 29));
        sepTitle.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 240, 1));

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

        panIssues.setBackground(new java.awt.Color(254, 254, 254));
        panIssues.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        row1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblId.setText("1");
        row1.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, -1, -1));

        lblAssignedUser.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblAssignedUser.setText("Christian Bayer");
        row1.add(lblAssignedUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 8, -1, -1));

        lblTitle.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblTitle.setText("Cadastro de Usuários");
        row1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 8, -1, -1));

        lblDone.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblDone.setText("10");
        row1.add(lblDone, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 8, -1, -1));

        btnTrash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        row1.add(btnTrash, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 5, -1, -1));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        row1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 5, -1, -1));

        lblType.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblType.setText("Implementação");
        row1.add(lblType, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 8, -1, -1));

        lblStatus.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblStatus.setText("Em andamento");
        row1.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 8, -1, -1));

        lblPriority.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblPriority.setText("Alta");
        row1.add(lblPriority, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 8, -1, -1));

        btnMore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/more.png"))); // NOI18N
        row1.add(btnMore, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 5, -1, -1));

        panIssues.add(row1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 30));

        jScrollPane1.setViewportView(panIssues);

        basePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 740, 280));

        panCabecalho.setBackground(new java.awt.Color(209, 209, 209));
        panCabecalho.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCabecalhoTitulo.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCabecalhoTitulo.setText("TÍTULO");
        panCabecalho.add(lblCabecalhoTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 8, -1, -1));

        lblCabecalhoConcluido.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCabecalhoConcluido.setText("%");
        panCabecalho.add(lblCabecalhoConcluido, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 8, -1, -1));

        lblCabecalhoAcoes.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCabecalhoAcoes.setText("AÇÕES");
        panCabecalho.add(lblCabecalhoAcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 8, -1, -1));

        lblCabecalhoPrioridade.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCabecalhoPrioridade.setText("PRIORIDADE");
        panCabecalho.add(lblCabecalhoPrioridade, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 8, -1, -1));

        lblCabecalhoId.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCabecalhoId.setText("ID");
        panCabecalho.add(lblCabecalhoId, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 8, -1, -1));

        lblCabecalhoAtribuidoPara.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCabecalhoAtribuidoPara.setText("ATRIBUIDO PARA");
        panCabecalho.add(lblCabecalhoAtribuidoPara, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 8, -1, -1));

        lblCabecalhoTipo.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCabecalhoTipo.setText("TIPO");
        panCabecalho.add(lblCabecalhoTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 8, -1, -1));

        lblCabecalhoStatus.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCabecalhoStatus.setText("STATUS");
        panCabecalho.add(lblCabecalhoStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 8, -1, -1));

        basePanel.add(panCabecalho, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 740, 30));

        btnImprimir.setBackground(new java.awt.Color(52, 100, 127));
        btnImprimir.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(254, 254, 254));
        btnImprimir.setText("IMPRIMIR ID");
        btnImprimir.setToolTipText("");
        btnImprimir.setBorderPainted(false);
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnImprimir.setDefaultCapable(false);
        btnImprimir.setName(""); // NOI18N
        btnImprimir.setOpaque(true);
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        basePanel.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, 140, 40));

        btnImprimir1.setBackground(new java.awt.Color(52, 100, 127));
        btnImprimir1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnImprimir1.setForeground(new java.awt.Color(254, 254, 254));
        btnImprimir1.setText("IMPRIMIR");
        btnImprimir1.setToolTipText("");
        btnImprimir1.setBorderPainted(false);
        btnImprimir1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnImprimir1.setDefaultCapable(false);
        btnImprimir1.setName(""); // NOI18N
        btnImprimir1.setOpaque(true);
        btnImprimir1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimir1ActionPerformed(evt);
            }
        });
        basePanel.add(btnImprimir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 140, 40));

        selAssignedUser.setBackground(new java.awt.Color(254, 254, 254));
        selAssignedUser.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        selAssignedUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Atribuído Para" }));
        selAssignedUser.setToolTipText("");
        selAssignedUser.setOpaque(false);
        basePanel.add(selAssignedUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 240, -1));

        selPriority.setBackground(new java.awt.Color(254, 254, 254));
        selPriority.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        selPriority.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prioridade" }));
        selPriority.setToolTipText("");
        selPriority.setOpaque(false);
        basePanel.add(selPriority, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 240, -1));

        selProject.setBackground(new java.awt.Color(254, 254, 254));
        selProject.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        selProject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Projeto" }));
        selProject.setToolTipText("");
        selProject.setOpaque(false);
        selProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selProjectActionPerformed(evt);
            }
        });
        basePanel.add(selProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 240, -1));

        selIssueType.setBackground(new java.awt.Color(254, 254, 254));
        selIssueType.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        selIssueType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de Atividade" }));
        selIssueType.setToolTipText("");
        selIssueType.setOpaque(false);
        basePanel.add(selIssueType, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 240, -1));

        selStatus.setBackground(new java.awt.Color(254, 254, 254));
        selStatus.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        selStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Status" }));
        selStatus.setToolTipText("");
        selStatus.setOpaque(false);
        basePanel.add(selStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 240, -1));

        add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void inpTitleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpTitleFocusGained
        if (inpTitle.getText().trim().equals("Título")) {
            inpTitle.setText("");
        }
    }//GEN-LAST:event_inpTitleFocusGained

    private void inpTitleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpTitleFocusLost
        if (inpTitle.getText().trim().isEmpty()) {
            inpTitle.setText("Título");
        } else {
            filter();
        }
    }//GEN-LAST:event_inpTitleFocusLost

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        atividadesNovo = new AtividadesNovo(btnBack, lblWindow, layoutController, cardPanel, new Issue(), user);
        cardPanel.add(atividadesNovo, "atividadesNovo");
        layoutController = ((CardLayout) cardPanel.getLayout());
        layoutController.show(cardPanel, "atividadesNovo");
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        int issue_id = Integer.valueOf(JOptionPane.showInputDialog("ID da Atividade"));
        System.out.println(issue_id);
        try {
            // Compila o relatorio
            JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/ListagemAtividadesParam.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map params = new HashMap();
            
            params.put("issue_id", issue_id);

            // Executa relatoio
            JasperPrint print = JasperFillManager.fillReport(report, params, ConnectionFactory.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir1ActionPerformed
        try {
            // Compila o relatorio
            JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/ListagemAtividades.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map params = new HashMap();

            // Executa relatoio
            JasperPrint print = JasperFillManager.fillReport(report, params, ConnectionFactory.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_btnImprimir1ActionPerformed

    private void selProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selProjectActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selProjectActionPerformed
    
    private Color panColorA = new Color(194, 228, 253);
    private Color panColorB = new Color(254, 254, 254);
    private int panY;
    private int panRowCount;
    
    private void listIssue(Issue issue) {
        
        JPanel issuePanel = new JPanel();
        issuePanel.setBackground(panRowCount % 2 == 0 ? panColorB : panColorA);
        issuePanel.setLayout(new AbsoluteLayout());
        
        JLabel lblId = new JLabel();
        JLabel lblAssignedUser = new JLabel();
        JLabel lblTitle = new JLabel();
        JLabel lblDone = new JLabel();
        JLabel lblType = new JLabel();
        JLabel lblStatus = new JLabel();
        JLabel lblPriority = new JLabel();
        JLabel btnTrash = new JLabel();
        JLabel btnEdit = new JLabel();
        JLabel btnMore = new JLabel();
        
        if (!issue.isActive()) {
            lblId.setForeground(new Color(172, 172, 172));
            lblAssignedUser.setForeground(new Color(172, 172, 172));
            lblTitle.setForeground(new Color(172, 172, 172));
            lblDone.setForeground(new Color(172, 172, 172));
            lblType.setForeground(new Color(172, 172, 172));
            lblStatus.setForeground(new Color(172, 172, 172));
            lblPriority.setForeground(new Color(172, 172, 172));
        }
        
        lblId.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
        lblId.setText(String.valueOf(issue.getId()));
        issuePanel.add(lblId, new AbsoluteConstraints(10, 8, -1, -1));
        
        lblAssignedUser.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
        lblAssignedUser.setText(issue.getAssignedUserName());
        issuePanel.add(lblAssignedUser, new AbsoluteConstraints(480, 8, -1, -1));
        
        lblTitle.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
        lblTitle.setText(issue.getTitle());
        issuePanel.add(lblTitle, new AbsoluteConstraints(240, 8, -1, -1));
        
        lblDone.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
        lblDone.setText(String.valueOf(issue.getDoneRatio()));
        issuePanel.add(lblDone, new AbsoluteConstraints(600, 8, -1, -1));
        
        lblType.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
        lblType.setText(issue.getIssueTypeDescription());
        issuePanel.add(lblType, new AbsoluteConstraints(40, 8, -1, -1));
        
        lblStatus.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
        lblStatus.setText(issue.getIssueStatusDescription());
        issuePanel.add(lblStatus, new AbsoluteConstraints(140, 8, -1, -1));
        
        lblPriority.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
        lblPriority.setText(issue.getIssuePriorityDescription());
        issuePanel.add(lblPriority, new AbsoluteConstraints(400, 8, -1, -1));
        
        btnTrash.setIcon(new ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        btnTrash.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int res = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esta atividade? Esta ação não poderá ser desfeita!");
                if (res == 0) {
                    issueDAO.delete(issue.getId());
                    listIssues();
                }
            }
        });
        issuePanel.add(btnTrash, new AbsoluteConstraints(670, 5, -1, -1));
        
        btnEdit.setIcon(new ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        btnEdit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                atividadesAtualizar = new AtividadesAtualizar(btnBack, lblWindow, layoutController, cardPanel, issue, user);
                cardPanel.add(atividadesAtualizar, "atividadesAtualizar");
                layoutController = ((CardLayout) cardPanel.getLayout());
                layoutController.show(cardPanel, "atividadesAtualizar");
            }
        });
        issuePanel.add(btnEdit, new AbsoluteConstraints(640, 5, -1, -1));
        
        btnMore.setIcon(new ImageIcon(getClass().getResource("/icons/more.png"))); // NOI18N
        btnMore.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                atividadesDetalhes = new AtividadesDetalhes(btnBack, lblWindow, layoutController, cardPanel, issue, user);
                cardPanel.add(atividadesDetalhes, "atividadesDetalhes");
                layoutController = ((CardLayout) cardPanel.getLayout());
                layoutController.show(cardPanel, "atividadesDetalhes");
            }
        });
        issuePanel.add(btnMore, new AbsoluteConstraints(700, 5, -1, -1));
        
        panIssues.add(issuePanel, new AbsoluteConstraints(0, panY, 740, 30));
        
        panRowCount++;
        panY += 30;
        basePanel.revalidate();
        basePanel.repaint();
    }
    
    private void listIssues() {
        panY = 0;
        panRowCount = 1;
        panIssues.removeAll();
        panIssues.updateUI();
        ArrayList<Object> issues = issueDAO.getAll();
        Iterator<Object> iterator = issues.iterator();
        while (iterator.hasNext()) {
            Issue issue = (Issue) iterator.next();
            listIssue(issue);
        }
        lblFound.setText(issues.size() + " atividades encontradas:");
    }
    
    private void filter() {
        
        JComboBoxItem projectItem = (JComboBoxItem) selProject.getSelectedItem();
        int projectId = projectItem.getKey();
        
        JComboBoxItem issueTypeItem = (JComboBoxItem) selIssueType.getSelectedItem();
        int issueTypeId = issueTypeItem.getKey();
        
        JComboBoxItem statusItem = (JComboBoxItem) selStatus.getSelectedItem();
        int issueStatusId = statusItem.getKey();
        
        JComboBoxItem priorityItem = (JComboBoxItem) selPriority.getSelectedItem();
        int issuePriorityId = priorityItem.getKey();
        
        JComboBoxItem assignedUserItem = (JComboBoxItem) selAssignedUser.getSelectedItem();
        int assignedUserId = assignedUserItem.getKey();
        
        String title = inpTitle.getText();
        
        String query = "SELECT * FROM issues WHERE ";
        if (projectId != 0) {
            query += "project_id = " + projectId + " AND ";
        }
        if (issueTypeId != 0) {
            query += "issue_type_id = " + issueTypeId + " AND ";
        }
        if (issueStatusId != 0) {
            query += "issue_status_id = " + issueStatusId + " AND ";
        }
        if (issuePriorityId != 0) {
            query += "issue_priority_id = " + issuePriorityId + " AND ";
        }
        if (assignedUserId != 0) {
            ArrayList<Object> usersProjects = userProjectDAO.getQuerys("SELECT * FROM users_projects WHERE user_id = " + assignedUserId);
            Iterator<Object> iterator = usersProjects.iterator();
            ArrayList<String> arrUsersIds = new ArrayList();
            while (iterator.hasNext()) {
                UserProject userProject = (UserProject) iterator.next();
                arrUsersIds.add(String.valueOf(userProject.getId()));
                
            }
            
            String usersIds = "";
            for (int i = 0; i < arrUsersIds.size(); i++) {
                if (i == 0) {
                    usersIds += arrUsersIds.get(i);
                } else {
                    usersIds += ", " + arrUsersIds.get(i);
                }
            }
            
            if (!usersIds.isEmpty()) {
                query += "project_id IN (" + usersIds + ") AND ";
            } else {
                query += "project_id = 0 AND ";
            }
        }
        if (!title.isEmpty() && !title.equals("Título")) {
            query += "title like \"%" + title + "%\" AND ";
        }
        query += "id IS NOT NULL;";
        System.out.println(query);
        panY = 0;
        panRowCount = 1;
        panIssues.removeAll();
        panIssues.updateUI();
        ArrayList<Object> issues = issueDAO.getQuerys(query);
        Iterator<Object> iterator = issues.iterator();
        while (iterator.hasNext()) {
            Issue issue = (Issue) iterator.next();
            listIssue(issue);
        }
        lblFound.setText(issues.size() + " atividades encontradas:");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImprimir1;
    private javax.swing.JLabel btnMore;
    private javax.swing.JButton btnNew;
    private javax.swing.JLabel btnTrash;
    private javax.swing.JTextField inpTitle;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAssignedUser;
    private javax.swing.JLabel lblCabecalhoAcoes;
    private javax.swing.JLabel lblCabecalhoAtribuidoPara;
    private javax.swing.JLabel lblCabecalhoConcluido;
    private javax.swing.JLabel lblCabecalhoId;
    private javax.swing.JLabel lblCabecalhoPrioridade;
    private javax.swing.JLabel lblCabecalhoStatus;
    private javax.swing.JLabel lblCabecalhoTipo;
    private javax.swing.JLabel lblCabecalhoTitulo;
    private javax.swing.JLabel lblDone;
    private javax.swing.JLabel lblFound;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblPriority;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblType;
    private javax.swing.JPanel panCabecalho;
    private javax.swing.JPanel panIssues;
    private javax.swing.JPanel row1;
    private javax.swing.JComboBox<String> selAssignedUser;
    private javax.swing.JComboBox<String> selIssueType;
    private javax.swing.JComboBox<String> selPriority;
    private javax.swing.JComboBox<String> selProject;
    private javax.swing.JComboBox<String> selStatus;
    private javax.swing.JSeparator sepTitle;
    // End of variables declaration//GEN-END:variables
}
