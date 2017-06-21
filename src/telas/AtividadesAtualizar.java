/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import apoio.JComboBoxItem;
import apoio.Masks;
import classes.Issue;
import classes.IssueHistoric;
import classes.Journal;
import classes.User;
import dao.IssueDAO;
import dao.IssueHistoricDAO;
import dao.IssuePriorityDAO;
import dao.IssueStatusDAO;
import dao.IssueTypeDAO;
import dao.JournalDAO;
import dao.UserProjectDAO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

/**
 *
 * @author christian
 */
public class AtividadesAtualizar extends javax.swing.JPanel {

    IssueDAO issueDAO;
    IssueTypeDAO issueTypeDAO;
    IssueStatusDAO issueStatusDAO;
    IssuePriorityDAO issuePriorityDAO;
    UserProjectDAO userProjectDAO;
    JournalDAO journalDAO;
    IssueHistoricDAO issueHistoricDAO;
    Color errorColor;
    Color normalColor;
    ArrayList errorsList;
    CardLayout layoutController;
    JPanel cardPanel;
    Usuarios usuarios;
    JLabel btnBack;
    JLabel lblWindow;
    User user;
    Issue issue;
    Atividades atividades;
    Masks masks;

    /**
     * Creates new form Usuario
     */
    public AtividadesAtualizar(JLabel btnBack, JLabel lblWindow, CardLayout lController, JPanel cardPanel, Issue issue, User user) {
        initComponents();

        // Seta o título da janela
        lblWindow.setText("ATUALIZAR ATIVIDADE");

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

        // Inicializa as cores;
        errorColor = new Color(255, 0, 0);
        normalColor = new Color(60, 60, 60);

        // Inicializa os DAO's
        issueDAO = new IssueDAO();
        issueTypeDAO = new IssueTypeDAO();
        issueStatusDAO = new IssueStatusDAO();
        issuePriorityDAO = new IssuePriorityDAO();
        userProjectDAO = new UserProjectDAO();
        journalDAO = new JournalDAO();
        issueHistoricDAO = new IssueHistoricDAO();

        // Popula o combobox com os papéis
        issueTypeDAO.lists(selIssueType);
        issueStatusDAO.lists(selStatus);
        issuePriorityDAO.lists(selPriority);

        // Inicia a lista de erros
        errorsList = new ArrayList();

        this.issue = issue;

        masks = new Masks();

        // Inicializa os campos
        if (issue.getParentIssueId() != 0) {
            inpParentIssueId.setText(String.valueOf(issue.getParentIssueId()));
        }

        System.out.println("issue.getIssuePriorityId(): " + issue.getIssuePriorityId());
        System.out.println("issue.getAssignedUserId(): " + issue.getAssignedUserId());
        System.out.println("issue.getIssueTypeId(): " + issue.getIssueTypeId());
        System.out.println("issue.getIssueStatusId(): " + issue.getIssueStatusId());
        System.out.println("issue.getDoneRatio(): " + issue.getDoneRatio());
        userProjectDAO.lists(selAssignedUser, issue.getProjectId());
        new JComboBoxItem().setSelectedItem(selPriority, issue.getIssuePriorityId());

        new JComboBoxItem().setSelectedItem(selAssignedUser, issue.getAssignedUserId());
        new JComboBoxItem().setSelectedItem(selIssueType, issue.getIssueTypeId());
        new JComboBoxItem().setSelectedItem(selStatus, issue.getIssueStatusId());
        selDoneRatio.setSelectedItem(String.valueOf(issue.getDoneRatio()));
        if (issue.getEstimatedHours() != 0) {
            inpEstimatedHours.setText(String.valueOf(issue.getEstimatedHours()));
        }
        if (issue.getSpentHours() != 0) {
            inpSpentHours.setText(String.valueOf(issue.getSpentHours()));
        }
        if (issue.getDueDate() != null) {
            inpDueDate.setText(dateToString(issue.getDueDate()));
        }
        if (issue.getStartDate() != null) {
            inpStartDate.setText(dateToString(issue.getStartDate()));
        }
        if (issue.getEndDate() != null) {
            inpEndDate.setText(dateToString(issue.getEndDate()));
        }

        masks.integer(inpParentIssueId);
        masks.integer(inpEstimatedHours);
        masks.integer(inpSpentHours);
        masks.date(inpDueDate);
        masks.date(inpStartDate);
        masks.date(inpEndDate);
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
        inpEstimatedHours = new javax.swing.JTextField();
        sepEstimatedHours = new javax.swing.JSeparator();
        inpParentIssueId = new javax.swing.JTextField();
        selIssueType = new javax.swing.JComboBox<>();
        inpDueDate = new javax.swing.JTextField();
        sepDueDate = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnSave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listErrors = new javax.swing.JList<>();
        selAssignedUser = new javax.swing.JComboBox<>();
        selStatus = new javax.swing.JComboBox<>();
        selDoneRatio = new javax.swing.JComboBox<>();
        selPriority = new javax.swing.JComboBox<>();
        inpStartDate = new javax.swing.JTextField();
        sepStartDate = new javax.swing.JSeparator();
        inpEndDate = new javax.swing.JTextField();
        sepEndDate = new javax.swing.JSeparator();
        inpSpentHours = new javax.swing.JTextField();
        sepSpentHours = new javax.swing.JSeparator();
        sepParentIssueId = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(254, 254, 254));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(254, 254, 254));
        basePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inpEstimatedHours.setBackground(new java.awt.Color(254, 254, 254));
        inpEstimatedHours.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        inpEstimatedHours.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inpEstimatedHours.setText("Horas Estimadas");
        inpEstimatedHours.setToolTipText("Horas Estimadas");
        inpEstimatedHours.setBorder(null);
        inpEstimatedHours.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inpEstimatedHours.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpEstimatedHoursFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpEstimatedHoursFocusLost(evt);
            }
        });
        basePanel.add(inpEstimatedHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 110, 170, 20));

        sepEstimatedHours.setBackground(new java.awt.Color(103, 103, 103));
        sepEstimatedHours.setForeground(new java.awt.Color(29, 29, 29));
        sepEstimatedHours.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepEstimatedHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 130, 170, 1));

        inpParentIssueId.setBackground(new java.awt.Color(254, 254, 254));
        inpParentIssueId.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        inpParentIssueId.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inpParentIssueId.setText("Tarefa Pai");
        inpParentIssueId.setToolTipText("Tarefa Pai");
        inpParentIssueId.setBorder(null);
        inpParentIssueId.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inpParentIssueId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpParentIssueIdFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpParentIssueIdFocusLost(evt);
            }
        });
        basePanel.add(inpParentIssueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 350, 20));

        selIssueType.setBackground(new java.awt.Color(254, 254, 254));
        selIssueType.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        selIssueType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de Atividade" }));
        selIssueType.setToolTipText("Tipo de Atividade");
        selIssueType.setOpaque(false);
        selIssueType.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                selIssueTypeFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                selIssueTypeFocusLost(evt);
            }
        });
        basePanel.add(selIssueType, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 30, 170, -1));

        inpDueDate.setBackground(new java.awt.Color(254, 254, 254));
        inpDueDate.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        inpDueDate.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inpDueDate.setText("Data Estimada");
        inpDueDate.setToolTipText("Data Estimada");
        inpDueDate.setBorder(null);
        inpDueDate.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inpDueDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpDueDateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpDueDateFocusLost(evt);
            }
        });
        basePanel.add(inpDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 350, 20));

        sepDueDate.setBackground(new java.awt.Color(103, 103, 103));
        sepDueDate.setForeground(new java.awt.Color(29, 29, 29));
        sepDueDate.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepDueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 350, 1));

        jScrollPane1.setBorder(null);

        txtDescription.setBackground(new java.awt.Color(254, 254, 254));
        txtDescription.setColumns(20);
        txtDescription.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        txtDescription.setForeground(new java.awt.Color(29, 29, 29));
        txtDescription.setRows(5);
        txtDescription.setText("Descrição");
        txtDescription.setToolTipText("Descrição");
        txtDescription.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(29, 29, 29)));
        txtDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDescriptionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDescriptionFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescription);

        basePanel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 730, 110));

        btnSave.setBackground(new java.awt.Color(52, 100, 127));
        btnSave.setFont(new java.awt.Font("Ubuntu", 0, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(254, 254, 254));
        btnSave.setText("SALVAR");
        btnSave.setToolTipText("");
        btnSave.setBorderPainted(false);
        btnSave.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSave.setDefaultCapable(false);
        btnSave.setName(""); // NOI18N
        btnSave.setOpaque(true);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        basePanel.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 440, 90, 40));

        jScrollPane2.setBorder(null);

        listErrors.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        listErrors.setForeground(new java.awt.Color(255, 0, 0));
        listErrors.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listErrors.setToolTipText("");
        listErrors.setFocusable(false);
        listErrors.setRequestFocusEnabled(false);
        jScrollPane2.setViewportView(listErrors);

        basePanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 640, 120));

        selAssignedUser.setBackground(new java.awt.Color(254, 254, 254));
        selAssignedUser.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        selAssignedUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Atribuído Para" }));
        selAssignedUser.setToolTipText("Atribuído Para");
        selAssignedUser.setOpaque(false);
        selAssignedUser.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                selAssignedUserFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                selAssignedUserFocusLost(evt);
            }
        });
        basePanel.add(selAssignedUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 350, -1));

        selStatus.setBackground(new java.awt.Color(254, 254, 254));
        selStatus.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        selStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Status" }));
        selStatus.setToolTipText("Status");
        selStatus.setOpaque(false);
        selStatus.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                selStatusFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                selStatusFocusLost(evt);
            }
        });
        basePanel.add(selStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 170, -1));

        selDoneRatio.setBackground(new java.awt.Color(254, 254, 254));
        selDoneRatio.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        selDoneRatio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Concluído (%)", "0", "10", "20", "30", "40", "50", "60", "70", "80", "90", "100" }));
        selDoneRatio.setToolTipText("Concluído (%)");
        selDoneRatio.setOpaque(false);
        selDoneRatio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                selDoneRatioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                selDoneRatioFocusLost(evt);
            }
        });
        basePanel.add(selDoneRatio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 170, -1));

        selPriority.setBackground(new java.awt.Color(254, 254, 254));
        selPriority.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        selPriority.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Prioridade" }));
        selPriority.setToolTipText("Prioridade");
        selPriority.setOpaque(false);
        selPriority.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                selPriorityFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                selPriorityFocusLost(evt);
            }
        });
        basePanel.add(selPriority, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 170, -1));

        inpStartDate.setBackground(new java.awt.Color(254, 254, 254));
        inpStartDate.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        inpStartDate.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inpStartDate.setText("Data de Início");
        inpStartDate.setToolTipText("Data de Início");
        inpStartDate.setBorder(null);
        inpStartDate.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inpStartDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpStartDateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpStartDateFocusLost(evt);
            }
        });
        basePanel.add(inpStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 350, 20));

        sepStartDate.setBackground(new java.awt.Color(103, 103, 103));
        sepStartDate.setForeground(new java.awt.Color(29, 29, 29));
        sepStartDate.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 350, 1));

        inpEndDate.setBackground(new java.awt.Color(254, 254, 254));
        inpEndDate.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        inpEndDate.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inpEndDate.setText("Data de Conclusão");
        inpEndDate.setToolTipText("Data de Conclusão");
        inpEndDate.setBorder(null);
        inpEndDate.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inpEndDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpEndDateFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpEndDateFocusLost(evt);
            }
        });
        basePanel.add(inpEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 350, 20));

        sepEndDate.setBackground(new java.awt.Color(103, 103, 103));
        sepEndDate.setForeground(new java.awt.Color(29, 29, 29));
        sepEndDate.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 170, 350, 1));

        inpSpentHours.setBackground(new java.awt.Color(254, 254, 254));
        inpSpentHours.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        inpSpentHours.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inpSpentHours.setText("Horas Gastas");
        inpSpentHours.setToolTipText("Horas Gastas");
        inpSpentHours.setBorder(null);
        inpSpentHours.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inpSpentHours.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpSpentHoursFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpSpentHoursFocusLost(evt);
            }
        });
        basePanel.add(inpSpentHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 110, 170, 20));

        sepSpentHours.setBackground(new java.awt.Color(103, 103, 103));
        sepSpentHours.setForeground(new java.awt.Color(29, 29, 29));
        sepSpentHours.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepSpentHours, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 130, 170, 1));

        sepParentIssueId.setBackground(new java.awt.Color(103, 103, 103));
        sepParentIssueId.setForeground(new java.awt.Color(29, 29, 29));
        sepParentIssueId.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepParentIssueId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 350, 1));

        add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void inpEstimatedHoursFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpEstimatedHoursFocusGained
        if (inpEstimatedHours.getText().trim().equals("Horas Estimadas")) {
            inpEstimatedHours.setText("");
        }
    }//GEN-LAST:event_inpEstimatedHoursFocusGained

    private void inpEstimatedHoursFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpEstimatedHoursFocusLost
        if (inpEstimatedHours.getText().trim().isEmpty()) {
            inpEstimatedHours.setText("Horas Estimadas");
        }
    }//GEN-LAST:event_inpEstimatedHoursFocusLost

    private void inpParentIssueIdFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpParentIssueIdFocusGained
        if (inpParentIssueId.getText().trim().equals("Tarefa Pai")) {
            inpParentIssueId.setText("");
            setTextFieldNormal(inpParentIssueId, sepParentIssueId);
        }
    }//GEN-LAST:event_inpParentIssueIdFocusGained

    private void inpParentIssueIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpParentIssueIdFocusLost
        if (inpParentIssueId.getText().trim().isEmpty()) {
            inpParentIssueId.setText("Tarefa Pai");
        }
    }//GEN-LAST:event_inpParentIssueIdFocusLost

    private void inpDueDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpDueDateFocusGained
        if (inpDueDate.getText().trim().equals("Data Estimada")) {
            inpDueDate.setText("");
            setTextFieldNormal(inpDueDate, sepDueDate);
        }
    }//GEN-LAST:event_inpDueDateFocusGained

    private void inpDueDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpDueDateFocusLost
        if (inpDueDate.getText().trim().isEmpty()) {
            inpDueDate.setText("Data Estimada");
        }
    }//GEN-LAST:event_inpDueDateFocusLost

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Inicia a lista de erros
        errorsList = new ArrayList();

        // Cria uma lista padrão
        DefaultListModel listModel = new DefaultListModel();

        // Valida os campos
        validateAssignedUser();
        validateDoneRatio();
        validateIssueType();
        validatePriority();
        validateStatus();

        if (!errorsList.isEmpty()) {
            for (int i = 0; i < errorsList.size(); i++) {
                listModel.add(i, errorsList.get(i));
            }
            listErrors.setModel(listModel);
        } else {
            Issue issue = new Issue();
            IssueHistoric issueHistoric = new IssueHistoric();
            issueHistoric.setIssueId(this.issue.getId());
            issueHistoric.setCreatedBy(this.user.getId());
            issueHistoric.setUpdatedBy(this.user.getId());

            JComboBoxItem issueTypeItem = (JComboBoxItem) selIssueType.getSelectedItem();
            issue.setIssueTypeId(issueTypeItem.getKey());

            JComboBoxItem statusItem = (JComboBoxItem) selStatus.getSelectedItem();
            issue.setIssueStatusId(statusItem.getKey());

            JComboBoxItem priorityItem = (JComboBoxItem) selPriority.getSelectedItem();
            issue.setIssuePriorityId(priorityItem.getKey());

            JComboBoxItem assignedUserItem = (JComboBoxItem) selAssignedUser.getSelectedItem();
            issue.setAssignedUserId(assignedUserItem.getKey());

            issue.setDoneRatio(String.valueOf(selDoneRatio.getSelectedItem()));

            String strDueDate = inpDueDate.getText();
            if (!strDueDate.trim().equals("Data Estimada")) {
                issue.setDueDate(stringToDate(strDueDate));
            }

            String strStartDate = inpStartDate.getText();
            if (!strStartDate.trim().equals("Data de Início")) {
                issue.setStartDate(stringToDate(strStartDate));
            }

            String strEndDate = inpEndDate.getText();
            if (!strEndDate.trim().equals("Data de Conclusão")) {
                issue.setEndDate(stringToDate(strEndDate));
            }

            if (!inpEstimatedHours.getText().trim().equals("Horas Estimadas")) {
                issue.setEstimatedHours(Integer.parseInt(inpEstimatedHours.getText()));
            }

            if (!inpSpentHours.getText().trim().equals("Horas Gastas")) {
                issue.setSpentHours(Integer.parseInt(inpSpentHours.getText()));
            }

            if (!inpParentIssueId.getText().trim().equals("Tarefa Pai")) {
                issue.setParentIssueId(Integer.parseInt(inpParentIssueId.getText()));
            }

            issue.setId(this.issue.getId());
            issue.setProjectId(this.issue.getProjectId());
            issue.setTitle(this.issue.getTitle());
            issue.setDescription(this.issue.getDescription());
            issue.setUpdatedBy(this.user.getId());
            issueDAO.update(issue);

            if (!txtDescription.getText().trim().equals("Descrição")) {
                Journal journal = new Journal();
                journal.setDescription(txtDescription.getText());
                journal.setCreatedBy(this.user.getId());
                journal.setUpdatedBy(this.user.getId());
                journalDAO.save(journal);

                journal = (Journal) journalDAO.getQuery("SELECT * FROM journals WHERE description=\"" + journal.getDescription() + "\" AND updated_by=" + journal.getUpdatedBy());
                issueHistoric.setJournalId(journal.getId());
            }

            if (this.issue.getIssueTypeId() != issue.getIssueTypeId()) {
                issueHistoric.setOldIssueTypeId(this.issue.getIssueTypeId());
                issueHistoric.setNewIssueTypeId(issue.getIssueTypeId());
            }
            if (this.issue.getIssueStatusId() != issue.getIssueStatusId()) {
                issueHistoric.setOldIssueStatusId(this.issue.getIssueStatusId());
                issueHistoric.setNewIssueStatusId(issue.getIssueStatusId());
            }
            if (this.issue.getIssuePriorityId() != issue.getIssuePriorityId()) {
                issueHistoric.setOldIssuePriorityId(this.issue.getIssuePriorityId());
                issueHistoric.setNewIssuePriorityId(issue.getIssuePriorityId());
            }
            if (this.issue.getAssignedUserId() != issue.getAssignedUserId()) {
                issueHistoric.setOldAssignedUserId(this.issue.getAssignedUserId());
                issueHistoric.setNewAssignedUserId(issue.getAssignedUserId());
            }
            if (!this.issue.getDoneRatio().equals(issue.getDoneRatio())) {
                issueHistoric.setOldDoneRatio(this.issue.getDoneRatio());
                issueHistoric.setNewDoneRatio(issue.getDoneRatio());
            }

            if (dateToString(issue.getDueDate()) == null && dateToString(this.issue.getDueDate()) != null) {
                issueHistoric.setOldDueDate(this.issue.getDueDate());
                issueHistoric.setNewDueDate(issue.getDueDate());
            } else if (dateToString(issue.getDueDate()) != null && dateToString(this.issue.getDueDate()) == null) {
                issueHistoric.setOldDueDate(this.issue.getDueDate());
                issueHistoric.setNewDueDate(issue.getDueDate());
            } else if (!dateToString(this.issue.getDueDate()).equals(dateToString(issue.getDueDate()))) {
                issueHistoric.setOldDueDate(this.issue.getDueDate());
                issueHistoric.setNewDueDate(issue.getDueDate());
            }

            if (dateToString(issue.getStartDate()) == null && dateToString(this.issue.getStartDate()) != null) {
                issueHistoric.setOldStartDate(this.issue.getStartDate());
                issueHistoric.setNewStartDate(issue.getStartDate());
            } else if (dateToString(issue.getStartDate()) != null && dateToString(this.issue.getStartDate()) == null) {
                issueHistoric.setOldStartDate(this.issue.getStartDate());
                issueHistoric.setNewStartDate(issue.getStartDate());
            } else if (!dateToString(this.issue.getStartDate()).equals(dateToString(issue.getStartDate()))) {
                issueHistoric.setOldStartDate(this.issue.getStartDate());
                issueHistoric.setNewStartDate(issue.getStartDate());
            }

            if (dateToString(issue.getEndDate()) == null && dateToString(this.issue.getEndDate()) != null) {
                issueHistoric.setOldEndDate(this.issue.getEndDate());
                issueHistoric.setNewEndDate(issue.getEndDate());
            } else if (dateToString(issue.getEndDate()) != null && dateToString(this.issue.getEndDate()) == null) {
                issueHistoric.setOldEndDate(this.issue.getEndDate());
                issueHistoric.setNewEndDate(issue.getEndDate());
            } else if (!dateToString(this.issue.getEndDate()).equals(dateToString(issue.getEndDate()))) {
                issueHistoric.setOldEndDate(this.issue.getEndDate());
                issueHistoric.setNewEndDate(issue.getEndDate());
            }

            if (this.issue.getEstimatedHours() != issue.getEstimatedHours()) {
                issueHistoric.setOldEstimatedHours(this.issue.getEstimatedHours());
                issueHistoric.setNewEstimatedHours(issue.getEstimatedHours());
            }
            if (this.issue.getSpentHours() != issue.getSpentHours()) {
                issueHistoric.setOldSpentHours(this.issue.getSpentHours());
                issueHistoric.setNewSpentHours(issue.getSpentHours());
            }
            if (this.issue.getParentIssueId() != issue.getParentIssueId()) {
                issueHistoric.setOldParentIssueId(this.issue.getParentIssueId());
                issueHistoric.setNewParentIssueId(issue.getParentIssueId());
            }

            issueHistoricDAO.save(issueHistoric);

            atividades = new Atividades(btnBack, lblWindow, layoutController, cardPanel, user);
            cardPanel.add(atividades, "atividades");
            layoutController = ((CardLayout) cardPanel.getLayout());
            layoutController.show(cardPanel, "atividades");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void selIssueTypeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selIssueTypeFocusGained
        selIssueType.setForeground(normalColor);
    }//GEN-LAST:event_selIssueTypeFocusGained

    private void selIssueTypeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selIssueTypeFocusLost
        validateIssueType();
    }//GEN-LAST:event_selIssueTypeFocusLost

    private void selAssignedUserFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selAssignedUserFocusGained
        selAssignedUser.setForeground(normalColor);
    }//GEN-LAST:event_selAssignedUserFocusGained

    private void selAssignedUserFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selAssignedUserFocusLost
        validateAssignedUser();
    }//GEN-LAST:event_selAssignedUserFocusLost

    private void selStatusFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selStatusFocusGained
        selStatus.setForeground(normalColor);
    }//GEN-LAST:event_selStatusFocusGained

    private void selStatusFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selStatusFocusLost
        validateStatus();
    }//GEN-LAST:event_selStatusFocusLost

    private void selDoneRatioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selDoneRatioFocusGained
        selDoneRatio.setForeground(normalColor);
    }//GEN-LAST:event_selDoneRatioFocusGained

    private void selDoneRatioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selDoneRatioFocusLost
        validateDoneRatio();
    }//GEN-LAST:event_selDoneRatioFocusLost

    private void selPriorityFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selPriorityFocusGained
        selPriority.setForeground(normalColor);
    }//GEN-LAST:event_selPriorityFocusGained

    private void selPriorityFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_selPriorityFocusLost
        validatePriority();
    }//GEN-LAST:event_selPriorityFocusLost

    private void inpStartDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpStartDateFocusGained
        if (inpStartDate.getText().trim().equals("Data de Início")) {
            inpStartDate.setText("");
        }
    }//GEN-LAST:event_inpStartDateFocusGained

    private void inpStartDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpStartDateFocusLost
        if (inpStartDate.getText().trim().isEmpty()) {
            inpStartDate.setText("Data de Início");
        }
    }//GEN-LAST:event_inpStartDateFocusLost

    private void inpEndDateFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpEndDateFocusGained
        if (inpEndDate.getText().trim().equals("Data de Conclusão")) {
            inpEndDate.setText("");
        }
    }//GEN-LAST:event_inpEndDateFocusGained

    private void inpEndDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpEndDateFocusLost
        if (inpEndDate.getText().trim().isEmpty()) {
            inpEndDate.setText("Data de Conclusão");
        }
    }//GEN-LAST:event_inpEndDateFocusLost

    private void inpSpentHoursFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpSpentHoursFocusGained
        if (inpSpentHours.getText().trim().equals("Horas Gastas")) {
            inpSpentHours.setText("");
        }
    }//GEN-LAST:event_inpSpentHoursFocusGained

    private void inpSpentHoursFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpSpentHoursFocusLost
        if (inpSpentHours.getText().trim().isEmpty()) {
            inpSpentHours.setText("Horas Gastas");
        }
    }//GEN-LAST:event_inpSpentHoursFocusLost

    private void txtDescriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescriptionFocusGained
        if (txtDescription.getText().trim().equals("Descrição")) {
            txtDescription.setText("");
        }
    }//GEN-LAST:event_txtDescriptionFocusGained

    private void txtDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDescriptionFocusLost
        String description = txtDescription.getText().trim();
        if (description.isEmpty() || description.equals("Descrição")) {
            txtDescription.setText("Descrição");
        }
    }//GEN-LAST:event_txtDescriptionFocusLost

    private void setTextFieldError(JTextField textField, JSeparator separator) {
        textField.setForeground(errorColor);
        separator.setForeground(errorColor);
    }

    private void setTextFieldNormal(JTextField textField, JSeparator separator) {
        textField.setForeground(normalColor);
        separator.setForeground(normalColor);
    }

    private void validateIssueType() {
        int projectTypeId = selIssueType.getSelectedIndex();
        if (projectTypeId == 0) {
            selIssueType.setForeground(errorColor);
            errorsList.add("O campo \"Tipo de Atividade\" é obrigatório!");
        }
    }

    private void validateAssignedUser() {
        int assignedUserId = selAssignedUser.getSelectedIndex();
        if (assignedUserId == 0) {
            selAssignedUser.setForeground(errorColor);
            errorsList.add("O campo \"Atribuído Para\" é obrigatório!");
        }
    }

    private void validateStatus() {
        int statusId = selStatus.getSelectedIndex();
        if (statusId == 0) {
            selStatus.setForeground(errorColor);
            errorsList.add("O campo \"Status\" é obrigatório!");
        }
    }

    private void validateDoneRatio() {
        int doneRatio = selDoneRatio.getSelectedIndex();
        if (doneRatio == 0) {
            selDoneRatio.setForeground(errorColor);
            errorsList.add("O campo \"Concluído (%)\" é obrigatório!");
        }
    }

    private void validatePriority() {
        int priorityId = selPriority.getSelectedIndex();
        if (priorityId == 0) {
            selPriority.setForeground(errorColor);
            errorsList.add("O campo \"Prioridade\" é obrigatório!");
        }
    }

    private String dateToString(Date date) {
        String strDate = null;
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            strDate = formatter.format(date);
        }
        return strDate;
    }

    private Date stringToDate(String strDate) {
        Date date = null;
        if (strDate != null && !strDate.equals("")) {
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                date = formatter.parse(strDate);
            } catch (ParseException e) {
                System.out.println(e.toString());
                e.printStackTrace();
            }
        }
        return date;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField inpDueDate;
    private javax.swing.JTextField inpEndDate;
    private javax.swing.JTextField inpEstimatedHours;
    private javax.swing.JTextField inpParentIssueId;
    private javax.swing.JTextField inpSpentHours;
    private javax.swing.JTextField inpStartDate;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listErrors;
    private javax.swing.JComboBox<String> selAssignedUser;
    private javax.swing.JComboBox<String> selDoneRatio;
    private javax.swing.JComboBox<String> selIssueType;
    private javax.swing.JComboBox<String> selPriority;
    private javax.swing.JComboBox<String> selStatus;
    private javax.swing.JSeparator sepDueDate;
    private javax.swing.JSeparator sepEndDate;
    private javax.swing.JSeparator sepEstimatedHours;
    private javax.swing.JSeparator sepParentIssueId;
    private javax.swing.JSeparator sepSpentHours;
    private javax.swing.JSeparator sepStartDate;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration//GEN-END:variables
}
