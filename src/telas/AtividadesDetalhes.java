/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import apoio.Masks;
import classes.Issue;
import classes.User;
import classes.UserProject;
import connection.ConnectionFactory;
import dao.IssueDAO;
import dao.IssuePriorityDAO;
import dao.IssueStatusDAO;
import dao.IssueTypeDAO;
import dao.JournalDAO;
import dao.UserProjectDAO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
        String query = "select journals.description as journal_description, "
                + "issues_types.description as issue_type_description, "
                + "issues_status.description as issue_status_description, "
                + "issues_priorities.description as issue_priority_description, "
                + "CONCAT(users.first_name, ' ', users.last_name) as user_name, "
                + "issues_historics.done_ratio, "
                + "issues_historics.due_date, "
                + "issues_historics.start_date, "
                + "issues_historics.end_date, "
                + "issues_historics.estimated_hours, "
                + "issues_historics.spent_hours, "
                + "issues_historics.parent_issue_id "
                + "from issues_historics "
                + "left join journals on issues_historics.journal_id = journals.id "
                + "left join issues_types on issues_historics.issue_type_id = issues_types.id "
                + "left join issues_status on issues_historics.issue_status_id = issues_status.id "
                + "left join issues_priorities on issues_historics.issue_priority_id = issues_priorities.id "
                + "left join users_projects on issues_historics.assigned_user_id = users_projects.id "
                + "left join users on users_projects.user_id = users.id "
                + "where issue_id = 1 order by issues_historics.id;";
        try {
            Statement stmt = ConnectionFactory.getInstance().getConnection().createStatement();
            System.out.println(query);
            // Executa a query e pega o objeto //
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                String journal_description = resultSet.getString("journal_description");
                String issue_type_description = resultSet.getString("issue_type_description");
                String issue_status_description = resultSet.getString("issue_status_description");
                String issue_priority_description = resultSet.getString("issue_priority_description");
                String user_name = resultSet.getString("user_name");
                String done_ratio = resultSet.getString("done_ratio");
                String due_date = resultSet.getString("due_date");
                String start_date = resultSet.getString("start_date");
                String end_date = resultSet.getString("end_date");
                String estimated_hours = resultSet.getString("estimated_hours");
                String spent_hours = resultSet.getString("spent_hours");
                String parent_issue_id = resultSet.getString("parent_issue_id");

                JPanel panel = new JPanel();
                panel.setBackground(panRowCount % 2 == 0 ? panColorB : panColorA);
                panel.setLayout(new AbsoluteLayout());
                int x = 10;
                int y = 5;
                int count = 1;
                      

                if (journal_description != null && !journal_description.isEmpty()) {
                    JLabel lblJournalDescription = new JLabel();
                    lblJournalDescription.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblJournalDescription.setText("Descrição: " + journal_description);
                    panel.add(lblJournalDescription, new AbsoluteConstraints(10, y, -1, -1));
                    y += 20;
                }

                if (issue_type_description != null && !issue_type_description.isEmpty()) {
                    JLabel lblIssueTypeDescription = new JLabel();
                    lblIssueTypeDescription.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblIssueTypeDescription.setText("Tipo de Atividade: " + issue_type_description);
                    panel.add(lblIssueTypeDescription, new AbsoluteConstraints(10, y, -1, -1));
                    y += 20;
                }

                if (issue_status_description != null && !issue_status_description.isEmpty()) {
                    JLabel lblIssueStatusDescription = new JLabel();
                    lblIssueStatusDescription.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblIssueStatusDescription.setText("Status da Atividade: " + issue_status_description);
                    panel.add(lblIssueStatusDescription, new AbsoluteConstraints(10, y, -1, -1));
                    y += 20;
                }

                if (issue_priority_description != null && !issue_priority_description.isEmpty()) {
                    JLabel lblIssuePriorityDescription = new JLabel();
                    lblIssuePriorityDescription.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblIssuePriorityDescription.setText("Prioridade: " + issue_priority_description);
                    panel.add(lblIssuePriorityDescription, new AbsoluteConstraints(10, y, -1, -1));
                    y += 20;
                }

                if (user_name != null && !user_name.isEmpty()) {
                    JLabel lblUserName = new JLabel();
                    lblUserName.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblUserName.setText("Atribuído para: " + user_name);
                    panel.add(lblUserName, new AbsoluteConstraints(10, y, -1, -1));
                    y += 20;
                }

                if (done_ratio != null && !done_ratio.isEmpty()) {
                    JLabel lblDoneRatio = new JLabel();
                    lblDoneRatio.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblDoneRatio.setText("% Concluído: " + done_ratio);
                    panel.add(lblDoneRatio, new AbsoluteConstraints(10, y, -1, -1));
                    y += 20;
                }

                if (due_date != null && !due_date.isEmpty()) {
                    JLabel lblDueDate = new JLabel();
                    lblDueDate.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblDueDate.setText("Data Estimada: " + due_date);
                    panel.add(lblDueDate, new AbsoluteConstraints(10, y, -1, -1));
                    y += 20;
                }

                if (start_date != null && !start_date.isEmpty()) {
                    JLabel lblStartDate = new JLabel();
                    lblStartDate.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblStartDate.setText("Data de Início: " + start_date);
                    panel.add(lblStartDate, new AbsoluteConstraints(10, y, -1, -1));
                    y += 20;
                }

                if (end_date != null && !end_date.isEmpty()) {
                    JLabel lblEndDate = new JLabel();
                    lblEndDate.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblEndDate.setText("Data de Conclusão: " + end_date);
                    panel.add(lblEndDate, new AbsoluteConstraints(10, y, -1, -1));
                    y += 20;
                }

                if (estimated_hours != null && !estimated_hours.isEmpty()) {
                    JLabel lblEstimatedHours = new JLabel();
                    lblEstimatedHours.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblEstimatedHours.setText("Horas Estimadas: " + estimated_hours);
                    panel.add(lblEstimatedHours, new AbsoluteConstraints(10, y, -1, -1));
                    y += 20;
                }

                if (spent_hours != null && !spent_hours.isEmpty()) {
                    JLabel lblSpentHours = new JLabel();
                    lblSpentHours.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblSpentHours.setText("Horas Gastas: " + spent_hours);
                    panel.add(lblSpentHours, new AbsoluteConstraints(10, y, -1, -1));
                    y += 20;
                }

                if (parent_issue_id != null && !parent_issue_id.isEmpty()) {
                    JLabel lblParentIssueId = new JLabel();
                    lblParentIssueId.setFont(new Font("Ubuntu", 0, 12)); // NOI18N
                    lblParentIssueId.setText("Tarefa Pai: " + parent_issue_id);
                    panel.add(lblParentIssueId, new AbsoluteConstraints(10, y, -1, -1));
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

        basePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 740, 450));

        add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));
    }// </editor-fold>//GEN-END:initComponents

    private Color panColorA = new Color(194, 228, 253);
    private Color panColorB = new Color(254, 254, 254);
    private int panY = 0;
    private int panRowCount = 1;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panJournals;
    // End of variables declaration//GEN-END:variables
}
