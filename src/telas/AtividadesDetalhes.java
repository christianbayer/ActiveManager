/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import apoio.Masks;
import classes.Issue;
import classes.User;
import dao.IssueDAO;
import dao.IssuePriorityDAO;
import dao.IssueStatusDAO;
import dao.IssueTypeDAO;
import dao.JournalDAO;
import dao.UserProjectDAO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author christian
 */
public class AtividadesDetalhes extends javax.swing.JPanel {


    CardLayout layoutController;
    JPanel cardPanel;
    JLabel btnBack;
    JLabel lblWindow;
    User user;
    Issue issue;
    Atividades atividades;

    /**
     * Creates new form Usuario
     */
    public AtividadesDetalhes(JLabel btnBack, JLabel lblWindow, CardLayout lController, JPanel cardPanel, Issue issue, User user) {
        initComponents();

        // Seta o título da janela
        lblWindow.setText("DETALHES DA ATIVIDADE");

        // Troca o action do botão "Voltar"
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                atividades = new Atividades(btnBack, lblWindow, layoutController, cardPanel, user);
                cardPanel.add(atividades, "atividades");
                layoutController = ((CardLayout) cardPanel.getLayout());
                layoutController.show(cardPanel, "atividades");
            }
        });

        // Inicializa as variáveis de tela
        this.btnBack = btnBack;
        this.lblWindow = lblWindow;
        this.cardPanel = cardPanel;
        this.layoutController = lController;
        this.user = user;
        this.issue = issue;

    
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
        jScrollPane1 = new javax.swing.JScrollPane();
        panIssues = new javax.swing.JPanel();

        setBackground(new java.awt.Color(254, 254, 254));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(254, 254, 254));
        basePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panIssues.setBackground(new java.awt.Color(254, 254, 254));
        panIssues.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(panIssues);

        basePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 740, 450));

        add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panIssues;
    // End of variables declaration//GEN-END:variables
}
