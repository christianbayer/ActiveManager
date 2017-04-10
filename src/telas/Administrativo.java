/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import dao.UserDAO;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author christian
 */
public class Administrativo extends javax.swing.JPanel {

    JLabel lblWindow;
    JLabel btnBack;
    UserDAO userDAO;
    CardLayout layoutController;
    JPanel cardPanel;
    Dashboard dashboard;
    UsuariosNovo usuariosNovo;
    Funcoes funcoes;
    ProjetosTipos projetosTipos;
    AtividadesTipos atividadesTipos;
    AtividadesPrioridades atividadesPrioridades;
    AtividadesStatus atividadesStatus;

    /**
     * Creates new form Usuario
     */
    public Administrativo(JLabel btnBack, JLabel lblWindow, CardLayout lController, JPanel cardPanel) {
        initComponents();

        // Seta o título da janela
        lblWindow.setText("ADMINISTRATIVO");

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
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 254, 254));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(254, 254, 254));
        basePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setBackground(new java.awt.Color(194, 228, 253));
        jLabel8.setFont(new java.awt.Font("NanumGothic", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Funções");
        jLabel8.setOpaque(true);
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        basePanel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 220, 160));

        jLabel9.setBackground(new java.awt.Color(194, 228, 253));
        jLabel9.setFont(new java.awt.Font("NanumGothic", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Prioridades de Atividades");
        jLabel9.setOpaque(true);
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        basePanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 220, 160));

        jLabel10.setBackground(new java.awt.Color(194, 228, 253));
        jLabel10.setFont(new java.awt.Font("NanumGothic", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Tipos de Projetos");
        jLabel10.setOpaque(true);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        basePanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 220, 160));

        jLabel11.setBackground(new java.awt.Color(194, 228, 253));
        jLabel11.setFont(new java.awt.Font("NanumGothic", 0, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Tipos de Atividades");
        jLabel11.setOpaque(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        basePanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 30, 220, 160));

        jLabel12.setBackground(new java.awt.Color(194, 228, 253));
        jLabel12.setFont(new java.awt.Font("NanumGothic", 0, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Status de Atividades");
        jLabel12.setOpaque(true);
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        basePanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 220, 160));

        add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        funcoes = new Funcoes(btnBack, lblWindow, layoutController, cardPanel);
        cardPanel.add(funcoes, "funcoes");
        layoutController = ((CardLayout) cardPanel.getLayout());
        layoutController.show(cardPanel, "funcoes");
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        projetosTipos = new ProjetosTipos(btnBack, lblWindow, layoutController, cardPanel);
        cardPanel.add(projetosTipos, "projetosTipos");
        layoutController = ((CardLayout) cardPanel.getLayout());
        layoutController.show(cardPanel, "projetosTipos");
    }//GEN-LAST:event_jLabel10MouseClicked

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        atividadesTipos = new AtividadesTipos(btnBack, lblWindow, layoutController, cardPanel);
        cardPanel.add(atividadesTipos, "atividadesTipos");
        layoutController = ((CardLayout) cardPanel.getLayout());
        layoutController.show(cardPanel, "atividadesTipos");
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        atividadesPrioridades = new AtividadesPrioridades(btnBack, lblWindow, layoutController, cardPanel);
        cardPanel.add(atividadesPrioridades, "atividadesPrioridades");
        layoutController = ((CardLayout) cardPanel.getLayout());
        layoutController.show(cardPanel, "atividadesPrioridades");
    }//GEN-LAST:event_jLabel9MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        atividadesStatus = new AtividadesStatus(btnBack, lblWindow, layoutController, cardPanel);
        cardPanel.add(atividadesStatus, "atividadesStatus");
        layoutController = ((CardLayout) cardPanel.getLayout());
        layoutController.show(cardPanel, "atividadesStatus");
    }//GEN-LAST:event_jLabel12MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
