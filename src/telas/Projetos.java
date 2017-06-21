/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.Project;
import classes.User;
import connection.ConnectionFactory;
import dao.ProjectDAO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
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
public class Projetos extends javax.swing.JPanel {

    JLabel lblWindow;
    JLabel btnBack;
    CardLayout layoutController;
    JPanel cardPanel;
    ProjetosNovo projetosNovo;
    ProjetoUsuarios projetoUsuarios;
    Dashboard dashboard;
    User user;
    ProjectDAO projectDAO;

    /**
     * Creates new form Usuario
     */
    public Projetos(JLabel btnBack, JLabel lblWindow, CardLayout lController, JPanel cardPanel, User user) {
        initComponents();

        // Seta o título da janela
        lblWindow.setText("PROJETOS");

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

        projectDAO = new ProjectDAO();

        listProjects();

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
        btnNovoProjeto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panProjects = new javax.swing.JPanel();
        row1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextArea();
        btnTrash = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        btnUsers = new javax.swing.JLabel();
        lblManager = new javax.swing.JLabel();
        lblAndamento = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblTeste = new javax.swing.JLabel();
        lblAberta = new javax.swing.JLabel();
        lblCreatedAt = new javax.swing.JLabel();
        lblGerente = new javax.swing.JLabel();
        lblCriadoEm = new javax.swing.JLabel();
        btnEdit = new javax.swing.JLabel();
        btnMore = new javax.swing.JLabel();
        inpPesquisar = new javax.swing.JTextField();
        sepPesquisar = new javax.swing.JSeparator();
        btnImprimir = new javax.swing.JButton();
        btnImprimir1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(254, 254, 254));
        setFont(new java.awt.Font("Ubuntu Light", 0, 30)); // NOI18N
        setPreferredSize(new java.awt.Dimension(900, 500));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(254, 254, 254));
        basePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFound.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        lblFound.setText("2 projetos encontrados:");
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

        btnNovoProjeto.setBackground(new java.awt.Color(52, 100, 127));
        btnNovoProjeto.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnNovoProjeto.setForeground(new java.awt.Color(254, 254, 254));
        btnNovoProjeto.setText("NOVO");
        btnNovoProjeto.setToolTipText("");
        btnNovoProjeto.setBorderPainted(false);
        btnNovoProjeto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNovoProjeto.setDefaultCapable(false);
        btnNovoProjeto.setName(""); // NOI18N
        btnNovoProjeto.setOpaque(true);
        btnNovoProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProjetoActionPerformed(evt);
            }
        });
        basePanel.add(btnNovoProjeto, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 440, 90, 40));

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panProjects.setBackground(new java.awt.Color(254, 254, 254));
        panProjects.setBorder(null);
        panProjects.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        row1.setBackground(new java.awt.Color(194, 228, 253));
        row1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitulo.setFont(new java.awt.Font("Ubuntu Light", 0, 16)); // NOI18N
        lblTitulo.setText("ActiveManager");
        row1.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtDescricao.setEditable(false);
        txtDescricao.setBackground(new java.awt.Color(194, 228, 253));
        txtDescricao.setColumns(40);
        txtDescricao.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        txtDescricao.setLineWrap(true);
        txtDescricao.setRows(5);
        txtDescricao.setText("Projeto do ActiveManager, sendo desenvolvido na cadeira de Programação de Aplicações");
        txtDescricao.setWrapStyleWord(true);
        row1.add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 330, 50));

        btnTrash.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
        row1.add(btnTrash, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 20, -1, -1));

        separador.setOrientation(javax.swing.SwingConstants.VERTICAL);
        row1.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 10, 90));

        btnUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/users.png"))); // NOI18N
        row1.add(btnUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, -1, -1));

        lblManager.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblManager.setText("Christian Bayer");
        row1.add(lblManager, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 30, -1, -1));

        lblAndamento.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblAndamento.setText("Andamento: 4");
        row1.add(lblAndamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        lblTotal.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblTotal.setText("Total: 17");
        row1.add(lblTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, -1));

        lblTeste.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblTeste.setText("Teste: 7");
        row1.add(lblTeste, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        lblAberta.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblAberta.setText("Aberta: 6");
        row1.add(lblAberta, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, -1, -1));

        lblCreatedAt.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCreatedAt.setText("24/03/2017");
        row1.add(lblCreatedAt, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 70, -1, -1));

        lblGerente.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblGerente.setText("Gerente:");
        row1.add(lblGerente, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        lblCriadoEm.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCriadoEm.setText("Criado em:");
        row1.add(lblCriadoEm, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, -1, -1));

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
        row1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        btnMore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/more.png"))); // NOI18N
        row1.add(btnMore, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, -1, -1));

        panProjects.add(row1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 90));

        jScrollPane1.setViewportView(panProjects);

        basePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 740, 360));

        inpPesquisar.setBackground(new java.awt.Color(254, 254, 254));
        inpPesquisar.setFont(new java.awt.Font("Ubuntu Light", 0, 12)); // NOI18N
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

        btnImprimir.setBackground(new java.awt.Color(52, 100, 127));
        btnImprimir.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnImprimir.setForeground(new java.awt.Color(254, 254, 254));
        btnImprimir.setText("IMPRIMIR");
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
        basePanel.add(btnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 140, 40));

        btnImprimir1.setBackground(new java.awt.Color(52, 100, 127));
        btnImprimir1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnImprimir1.setForeground(new java.awt.Color(254, 254, 254));
        btnImprimir1.setText("IMPRIMIR ATIVIDADES");
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
        basePanel.add(btnImprimir1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 180, 40));

        add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnNovoProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProjetoActionPerformed
        projetosNovo = new ProjetosNovo(btnBack, lblWindow, layoutController, cardPanel, new Project(), user);
        cardPanel.add(projetosNovo, "projetosNovo");
        layoutController = ((CardLayout) cardPanel.getLayout());
        layoutController.show(cardPanel, "projetosNovo");
    }//GEN-LAST:event_btnNovoProjetoActionPerformed

    private void inpPesquisarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpPesquisarFocusGained
        if (inpPesquisar.getText().trim().equals("Pesquisar")) {
            inpPesquisar.setText("");
        }
    }//GEN-LAST:event_inpPesquisarFocusGained

    private void inpPesquisarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpPesquisarFocusLost
        if (inpPesquisar.getText().trim().isEmpty()) {
            inpPesquisar.setText("Pesquisar");
        }
    }//GEN-LAST:event_inpPesquisarFocusLost

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        try {
            // Compila o relatorio
            JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/ListagemProjetos.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map params = new HashMap();

            // Executa relatoio
            JasperPrint print = JasperFillManager.fillReport(report, params, ConnectionFactory.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnImprimir1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimir1ActionPerformed
        int project_id = Integer.valueOf(JOptionPane.showInputDialog("ID do Projeto"));
        System.out.println(project_id);
        try {
            // Compila o relatorio
            JasperReport report = JasperCompileManager.compileReport(getClass().getResourceAsStream("/reports/ListagemAtividadesProjeto.jrxml"));

            // Mapeia campos de parametros para o relatorio, mesmo que nao existam
            Map params = new HashMap();

            params.put("project_id", project_id);

            // Executa relatoio
            JasperPrint print = JasperFillManager.fillReport(report, params, ConnectionFactory.getInstance().getConnection());

            // Exibe resultado em video
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao gerar relatório: " + e);
        }
    }//GEN-LAST:event_btnImprimir1ActionPerformed

    private Color panColorA = new Color(194, 228, 253);
    private Color panColorB = new Color(254, 254, 254);
    private int panY;
    private int panRowCount;

    private void listProject(Project project) {
        try {
            JPanel projectPanel = new JPanel();
            projectPanel.setBackground(panRowCount % 2 == 0 ? panColorB : panColorA);
            projectPanel.setLayout(new AbsoluteLayout());
            Statement st = ConnectionFactory.getInstance().getConnection().createStatement();
            ResultSet resSet;

            JLabel lblTitulo = new JLabel();
            JTextArea txtDescricao = new JTextArea();
            JLabel lblAberta = new JLabel();
            JLabel lblAndamento = new JLabel();
            JLabel lblTeste = new JLabel();
            JLabel lblTotal = new JLabel();
            JLabel lblGerente = new JLabel();
            JLabel lblManager = new JLabel();
            JLabel lblCriadoEm = new JLabel();
            JLabel lblCreatedAt = new JLabel();
            JLabel btnTrash = new JLabel();
            JLabel btnEdit = new JLabel();
            JLabel btnUsers = new JLabel();
            JLabel btnMore = new JLabel();
            JSeparator separador = new JSeparator();

            if (!project.isActive()) {
                lblTitulo.setForeground(new Color(172, 172, 172));
                txtDescricao.setForeground(new Color(172, 172, 172));
                lblAberta.setForeground(new Color(172, 172, 172));
                lblAndamento.setForeground(new Color(172, 172, 172));
                lblTeste.setForeground(new Color(172, 172, 172));
                lblTotal.setForeground(new Color(172, 172, 172));
                lblGerente.setForeground(new Color(172, 172, 172));
                lblManager.setForeground(new Color(172, 172, 172));
                lblCriadoEm.setForeground(new Color(172, 172, 172));
                lblCreatedAt.setForeground(new Color(172, 172, 172));
            }

            lblTitulo.setFont(new Font("Ubuntu Light", 0, 16)); // NOI18N
            lblTitulo.setText(project.getTitle());
            projectPanel.add(lblTitulo, new AbsoluteConstraints(10, 10, -1, -1));

            txtDescricao.setEditable(false);
            txtDescricao.setBackground(panRowCount % 2 == 0 ? panColorB : panColorA);
            txtDescricao.setColumns(40);
            txtDescricao.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
            txtDescricao.setLineWrap(true);
            txtDescricao.setRows(5);
            txtDescricao.setText(project.getDescription());
            txtDescricao.setWrapStyleWord(true);
            projectPanel.add(txtDescricao, new AbsoluteConstraints(10, 30, 330, 50));

            separador.setOrientation(SwingConstants.VERTICAL);
            projectPanel.add(separador, new AbsoluteConstraints(350, 0, 10, 90));

            btnTrash.setIcon(new ImageIcon(getClass().getResource("/icons/trash.png"))); // NOI18N
            btnTrash.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    int res = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir este projeto? Esta ação não poderá ser desfeita!");
                    if (res == 0) {
                        projectDAO.delete(project.getId());
                        listProjects();
                    }
                }
            });
            projectPanel.add(btnTrash, new AbsoluteConstraints(660, 20, -1, -1));

            btnEdit.setIcon(new ImageIcon(getClass().getResource("/icons/edit.png"))); // NOI18N
            btnEdit.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    projetosNovo = new ProjetosNovo(btnBack, lblWindow, layoutController, cardPanel, project, user);
                    cardPanel.add(projetosNovo, "projetosNovo");
                    layoutController = ((CardLayout) cardPanel.getLayout());
                    layoutController.show(cardPanel, "projetosNovo");
                }
            });
            projectPanel.add(btnEdit, new AbsoluteConstraints(690, 20, -1, -1));

            btnUsers.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/users.png"))); // NOI18N
            btnUsers.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent evt) {
                    projetoUsuarios = new ProjetoUsuarios(btnBack, lblWindow, layoutController, cardPanel, project, user);
                    cardPanel.add(projetoUsuarios, "projetoUsuarios");
                    layoutController = ((CardLayout) cardPanel.getLayout());
                    layoutController.show(cardPanel, "projetoUsuarios");
                }
            });
            projectPanel.add(btnUsers, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, -1, -1));

            btnMore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/more.png"))); // NOI18N
            projectPanel.add(btnMore, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, -1, -1));

            lblManager.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
            lblManager.setText("Xablau");
            projectPanel.add(lblManager, new AbsoluteConstraints(520, 30, -1, -1));

            resSet = st.executeQuery("select count(id) as count from issues where project_id = " + project.getId() + " and issue_status_id = 2");
            while (resSet.next()) {
                lblAndamento.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                lblAndamento.setText("Andamento: " + resSet.getString("count"));
                projectPanel.add(lblAndamento, new AbsoluteConstraints(370, 30, -1, -1));
            }

            resSet = st.executeQuery("select count(id) as count from issues where project_id = " + project.getId());
            while (resSet.next()) {
                lblTotal.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                lblTotal.setText("Total: " + resSet.getString("count"));
                projectPanel.add(lblTotal, new AbsoluteConstraints(370, 70, -1, -1));
            }

            resSet = st.executeQuery("select count(id) as count from issues where project_id = " + project.getId() + " and issue_status_id = 5");
            while (resSet.next()) {
                lblTeste.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                lblTeste.setText("Fechada: " + resSet.getString("count"));
                projectPanel.add(lblTeste, new AbsoluteConstraints(370, 50, -1, -1));
            }

            resSet = st.executeQuery("select count(id) as count from issues where project_id = " + project.getId() + " and issue_status_id = 1");
            while (resSet.next()) {
                lblAberta.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                lblAberta.setText("Aberta: " + resSet.getString("count"));
                projectPanel.add(lblAberta, new AbsoluteConstraints(370, 10, -1, -1));
            }

            lblCreatedAt.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
            lblCreatedAt.setText(project.getCreatedAt().toString());
            projectPanel.add(lblCreatedAt, new AbsoluteConstraints(520, 70, -1, -1));

            lblGerente.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
            lblGerente.setText("Gerente:");
            projectPanel.add(lblGerente, new AbsoluteConstraints(520, 10, -1, -1));

            lblCriadoEm.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
            lblCriadoEm.setText("Criado em:");
            projectPanel.add(lblCriadoEm, new AbsoluteConstraints(520, 50, -1, -1));

            panProjects.add(projectPanel, new AbsoluteConstraints(0, panY, 740, 90));

            panRowCount++;
            panY += 90;
            basePanel.revalidate();
            basePanel.repaint();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void listProjects() {
        panY = 0;
        panRowCount = 1;
        panProjects.removeAll();
        panProjects.updateUI();
        ArrayList<Object> projects = projectDAO.getAll();
        Iterator<Object> iterator = projects.iterator();
        while (iterator.hasNext()) {
            Project project = (Project) iterator.next();
            listProject(project);
        }
        lblFound.setText(projects.size() + " projetos encontrados:");
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JLabel btnEdit;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnImprimir1;
    private javax.swing.JLabel btnMore;
    private javax.swing.JButton btnNovoProjeto;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel btnTrash;
    private javax.swing.JLabel btnUsers;
    private javax.swing.JTextField inpPesquisar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAberta;
    private javax.swing.JLabel lblAndamento;
    private javax.swing.JLabel lblCreatedAt;
    private javax.swing.JLabel lblCriadoEm;
    private javax.swing.JLabel lblFound;
    private javax.swing.JLabel lblGerente;
    private javax.swing.JLabel lblManager;
    private javax.swing.JLabel lblTeste;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JPanel panProjects;
    private javax.swing.JPanel row1;
    private javax.swing.JSeparator sepPesquisar;
    private javax.swing.JSeparator separador;
    private javax.swing.JTextArea txtDescricao;
    // End of variables declaration//GEN-END:variables
}
