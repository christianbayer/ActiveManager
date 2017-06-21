/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.Issue;
import classes.User;
import connection.ConnectionFactory;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

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

        // Cria o statement //
        String query = "select * from issues_historics where issue_id = " + issue.getId() + " order by id;";
        try {
            Statement stmt = ConnectionFactory.getInstance().getConnection().createStatement();
            System.out.println(query);
            // Executa a query e pega o objeto //
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                String journal_id = resultSet.getString("journal_id");
                String old_issue_type_id = resultSet.getString("old_issue_type_id");
                String old_issue_status_id = resultSet.getString("old_issue_status_id");
                String old_issue_priority_id = resultSet.getString("old_issue_priority_id");
                String old_assigned_user_id = resultSet.getString("old_assigned_user_id");
                String old_done_ratio = resultSet.getString("old_done_ratio");
                String old_due_date = resultSet.getString("old_due_date");
                String old_start_date = resultSet.getString("old_start_date");
                String old_end_date = resultSet.getString("old_end_date");
                String old_estimated_hours = resultSet.getString("old_estimated_hours");
                String old_spent_hours = resultSet.getString("old_spent_hours");
                String old_parent_issue_id = resultSet.getString("old_parent_issue_id");
                String new_issue_type_id = resultSet.getString("new_issue_type_id");
                String new_issue_status_id = resultSet.getString("new_issue_status_id");
                String new_issue_priority_id = resultSet.getString("new_issue_priority_id");
                String new_assigned_user_id = resultSet.getString("new_assigned_user_id");
                String new_done_ratio = resultSet.getString("new_done_ratio");
                String new_due_date = resultSet.getString("new_due_date");
                String new_start_date = resultSet.getString("new_start_date");
                String new_end_date = resultSet.getString("new_end_date");
                String new_estimated_hours = resultSet.getString("new_estimated_hours");
                String new_spent_hours = resultSet.getString("new_spent_hours");
                String new_parent_issue_id = resultSet.getString("new_parent_issue_id");

                JPanel panel = new JPanel();
                panel.setBackground(panRowCount % 2 == 0 ? panColorB : panColorA);
                panel.setLayout(new AbsoluteLayout());
                int x = 10;
                int y = 5;
                int count = 1;

                Statement st = ConnectionFactory.getInstance().getConnection().createStatement();
                ResultSet resSet;

                if (journal_id != null && !journal_id.isEmpty()) {
                    resSet = st.executeQuery("select * from journals where id = " + journal_id);
                    while (resSet.next()) {
                        JLabel lblJournalDescription = new JLabel();
                        lblJournalDescription.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                        lblJournalDescription.setText("Descrição: " + resSet.getString("description"));
                        panel.add(lblJournalDescription, new AbsoluteConstraints(10, y, -1, -1));
                    }
                    y += 20;
                }

                if (old_issue_type_id != null && !old_issue_type_id.isEmpty()) {
                    resSet = st.executeQuery("select * from issues_types where id = " + old_issue_type_id);
                    while (resSet.next()) {
                        JLabel lblIssueTypeDescription = new JLabel();
                        lblIssueTypeDescription.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                        lblIssueTypeDescription.setText("Tipo de Atividade: " + resSet.getString("description"));
                        panel.add(lblIssueTypeDescription, new AbsoluteConstraints(10, y, -1, -1));
                    }
                    resSet = st.executeQuery("select * from issues_types where id = " + new_issue_type_id);
                    while (resSet.next()) {
                        JLabel lblNewIssueTypeDescription = new JLabel();
                        lblNewIssueTypeDescription.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                        lblNewIssueTypeDescription.setText("Tipo de Atividade: " + resSet.getString("description"));
                        panel.add(lblNewIssueTypeDescription, new AbsoluteConstraints(370, y, -1, -1));
                    }
                    y += 20;
                }

                if (old_issue_status_id != null && !old_issue_status_id.isEmpty()) {
                    resSet = st.executeQuery("select * from issues_status where id = " + old_issue_status_id);
                    while (resSet.next()) {
                        JLabel lblIssueStatusDescription = new JLabel();
                        lblIssueStatusDescription.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                        lblIssueStatusDescription.setText("Status da Atividade: " + resSet.getString("description"));
                        panel.add(lblIssueStatusDescription, new AbsoluteConstraints(10, y, -1, -1));
                    }
                    resSet = st.executeQuery("select * from issues_status where id = " + new_issue_status_id);
                    while (resSet.next()) {
                        JLabel lblNewIssueStatusDescription = new JLabel();
                        lblNewIssueStatusDescription.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                        lblNewIssueStatusDescription.setText("Status da Atividade: " + resSet.getString("description"));
                        panel.add(lblNewIssueStatusDescription, new AbsoluteConstraints(370, y, -1, -1));
                    }
                    y += 20;
                }

                if (old_issue_priority_id != null && !old_issue_priority_id.isEmpty()) {
                    resSet = st.executeQuery("select * from issues_priorities where id = " + old_issue_priority_id);
                    while (resSet.next()) {
                        JLabel lblIssuePriorityDescription = new JLabel();
                        lblIssuePriorityDescription.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                        lblIssuePriorityDescription.setText("Prioridade: " + resSet.getString("description"));
                        panel.add(lblIssuePriorityDescription, new AbsoluteConstraints(10, y, -1, -1));
                    }
                    resSet = st.executeQuery("select * from issues_priorities where id = " + new_issue_priority_id);
                    while (resSet.next()) {
                        JLabel lblNewIssuePriorityDescription = new JLabel();
                        lblNewIssuePriorityDescription.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                        lblNewIssuePriorityDescription.setText("Prioridade: " + resSet.getString("description"));
                        panel.add(lblNewIssuePriorityDescription, new AbsoluteConstraints(370, y, -1, -1));
                    }
                    y += 20;
                }

                if (old_assigned_user_id != null && !old_assigned_user_id.isEmpty()) {
                    JLabel lblUserName = new JLabel();
                    lblUserName.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblUserName.setText("Atribuído para: " + old_assigned_user_id);
                    panel.add(lblUserName, new AbsoluteConstraints(10, y, -1, -1));

                    JLabel lblNewUserName = new JLabel();
                    lblNewUserName.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblNewUserName.setText("Atribuído para: " + new_assigned_user_id);
                    panel.add(lblNewUserName, new AbsoluteConstraints(370, y, -1, -1));
                    y += 20;
                }

                if (old_done_ratio != null && !old_done_ratio.isEmpty()) {
                    JLabel lblDoneRatio = new JLabel();
                    lblDoneRatio.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblDoneRatio.setText("% Concluído: " + old_done_ratio);
                    panel.add(lblDoneRatio, new AbsoluteConstraints(10, y, -1, -1));

                    JLabel lblNewDoneRatio = new JLabel();
                    lblNewDoneRatio.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblNewDoneRatio.setText("% Concluído: " + new_done_ratio);
                    panel.add(lblNewDoneRatio, new AbsoluteConstraints(370, y, -1, -1));
                    y += 20;
                }

                if (old_due_date != null && !old_due_date.isEmpty()) {
                    JLabel lblDueDate = new JLabel();
                    lblDueDate.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblDueDate.setText("Data Estimada: " + old_due_date);
                    panel.add(lblDueDate, new AbsoluteConstraints(10, y, -1, -1));

                    JLabel lblNewDueDate = new JLabel();
                    lblNewDueDate.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblNewDueDate.setText("Data Estimada: " + new_due_date);
                    panel.add(lblNewDueDate, new AbsoluteConstraints(370, y, -1, -1));
                    y += 20;
                }

                if (old_start_date != null && !old_start_date.isEmpty()) {
                    JLabel lblStartDate = new JLabel();
                    lblStartDate.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblStartDate.setText("Data de Início: " + old_start_date);
                    panel.add(lblStartDate, new AbsoluteConstraints(10, y, -1, -1));

                    JLabel lblNewStartDate = new JLabel();
                    lblNewStartDate.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblNewStartDate.setText("Data de Início: " + new_start_date);
                    panel.add(lblNewStartDate, new AbsoluteConstraints(370, y, -1, -1));
                    y += 20;
                }

                if (old_end_date != null && !old_end_date.isEmpty()) {
                    JLabel lblEndDate = new JLabel();
                    lblEndDate.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblEndDate.setText("Data de Conclusão: " + old_end_date);
                    panel.add(lblEndDate, new AbsoluteConstraints(10, y, -1, -1));

                    JLabel lblNewEndDate = new JLabel();
                    lblNewEndDate.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblNewEndDate.setText("Data de Conclusão: " + new_end_date);
                    panel.add(lblNewEndDate, new AbsoluteConstraints(370, y, -1, -1));
                    y += 20;
                }

                if (old_estimated_hours != null && !old_estimated_hours.isEmpty()) {
                    JLabel lblEstimatedHours = new JLabel();
                    lblEstimatedHours.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblEstimatedHours.setText("Horas Estimadas: " + old_estimated_hours);
                    panel.add(lblEstimatedHours, new AbsoluteConstraints(10, y, -1, -1));

                    JLabel lblNewEstimatedHours = new JLabel();
                    lblNewEstimatedHours.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblNewEstimatedHours.setText("Horas Estimadas: " + new_estimated_hours);
                    panel.add(lblNewEstimatedHours, new AbsoluteConstraints(370, y, -1, -1));
                    y += 20;
                }

                if (old_spent_hours != null && !old_spent_hours.isEmpty()) {
                    JLabel lblSpentHours = new JLabel();
                    lblSpentHours.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblSpentHours.setText("Horas Gastas: " + old_spent_hours);
                    panel.add(lblSpentHours, new AbsoluteConstraints(10, y, -1, -1));

                    JLabel lblNewSpentHours = new JLabel();
                    lblNewSpentHours.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblNewSpentHours.setText("Horas Gastas: " + new_spent_hours);
                    panel.add(lblNewSpentHours, new AbsoluteConstraints(370, y, -1, -1));
                    y += 20;
                }

                if (old_parent_issue_id != null && !old_parent_issue_id.isEmpty()) {
                    JLabel lblParentIssueId = new JLabel();
                    lblParentIssueId.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblParentIssueId.setText("Tarefa Pai: " + old_parent_issue_id);
                    panel.add(lblParentIssueId, new AbsoluteConstraints(10, y, -1, -1));

                    JLabel lblNewParentIssueId = new JLabel();
                    lblNewParentIssueId.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblNewParentIssueId.setText("Tarefa Pai: " + new_parent_issue_id);
                    panel.add(lblNewParentIssueId, new AbsoluteConstraints(370, y, -1, -1));

                    y += 20;
                }
                panJournals.add(panel, new AbsoluteConstraints(0, panY, 740, y));
                panRowCount++;
                panY += y;
                basePanel.revalidate();
                basePanel.repaint();
            }

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        panJournals = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(254, 254, 254));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(254, 254, 254));
        basePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(254, 254, 254));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        panJournals.setBackground(new java.awt.Color(254, 254, 254));
        panJournals.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(panJournals);

        basePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 740, 430));

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel1.setText("Para:");
        basePanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, -1, -1));

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        jLabel2.setText("De:");
        basePanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, -1, -1));

        add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));
    }// </editor-fold>//GEN-END:initComponents

    private Color panColorA = new Color(194, 228, 253);
    private Color panColorB = new Color(254, 254, 254);
    private int panY = 0;
    private int panRowCount = 1;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panJournals;
    // End of variables declaration//GEN-END:variables
}
