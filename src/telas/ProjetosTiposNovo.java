/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import classes.ProjectType;
import dao.ProjectTypeDAO;
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
public class ProjetosTiposNovo extends javax.swing.JPanel {

    ProjectTypeDAO projectTypeDAO;
    Color errorColor;
    Color normalColor;
    ArrayList errorsList;
    CardLayout layoutController;
    JPanel cardPanel;
    ProjetosTipos projetosTipos;
    JLabel btnBack;
    JLabel lblWindow;
    ProjectType projectType;

    /**
     * Creates new form Usuario
     */
    public ProjetosTiposNovo(JLabel btnBack, JLabel lblWindow, CardLayout lController, JPanel cardPanel, ProjectType projectType) {
        initComponents();

        // Seta o título da janela
        lblWindow.setText("NOVO TIPO DE PROJETO");

        // Troca o action do botão "Voltar"
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projetosTipos = new ProjetosTipos(btnBack, lblWindow, layoutController, cardPanel);
                cardPanel.add(projetosTipos, "projetosTipos");
                layoutController = ((CardLayout) cardPanel.getLayout());
                layoutController.show(cardPanel, "projetosTipos");
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
        projectTypeDAO = new ProjectTypeDAO();

        errorsList = new ArrayList();

        // Edição
        if (projectType.getDescription() != null) {
            this.projectType = projectType;

            // Seta o título da janela
            lblWindow.setText("EDITAR TIPO DE PROJETO");

            // Inicializa os campos
            inpDescription.setText(projectType.getDescription());
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
        inpDescription = new javax.swing.JTextField();
        sepDescription = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listErrors = new javax.swing.JList<>();

        setBackground(new java.awt.Color(254, 254, 254));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(254, 254, 254));
        basePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        inpDescription.setBackground(new java.awt.Color(254, 254, 254));
        inpDescription.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        inpDescription.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inpDescription.setText("Descrição");
        inpDescription.setBorder(null);
        inpDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        inpDescription.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                inpDescriptionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                inpDescriptionFocusLost(evt);
            }
        });
        basePanel.add(inpDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 730, 20));

        sepDescription.setBackground(new java.awt.Color(103, 103, 103));
        sepDescription.setForeground(new java.awt.Color(29, 29, 29));
        sepDescription.setFont(new java.awt.Font("Ubuntu", 0, 3)); // NOI18N
        basePanel.add(sepDescription, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 730, 1));

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

        basePanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 640, 140));

        add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void inpDescriptionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpDescriptionFocusGained
        if (inpDescription.getText().trim().equals("Descrição")) {
            inpDescription.setText("");
            setTextFieldNormal(inpDescription, sepDescription);
        }
    }//GEN-LAST:event_inpDescriptionFocusGained

    private void inpDescriptionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_inpDescriptionFocusLost
        validateDescription();
    }//GEN-LAST:event_inpDescriptionFocusLost

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // Inicia a lista de erros
        errorsList = new ArrayList();

        // Cria uma lista padrão
        DefaultListModel listModel = new DefaultListModel();

        // Valida os campos
        validateDescription();

        if (!errorsList.isEmpty()) {
            for (int i = 0; i < errorsList.size(); i++) {
                listModel.add(i, errorsList.get(i));
            }
            listErrors.setModel(listModel);
        } else {
            ProjectType projectType = new ProjectType();
            projectType.setDescription(inpDescription.getText());
            if (this.projectType != null) {
                projectType.setId(this.projectType.getId());
                projectTypeDAO.update(projectType);
            } else {
                projectTypeDAO.save(projectType);
            }

            projetosTipos = new ProjetosTipos(btnBack, lblWindow, layoutController, cardPanel);
            cardPanel.add(projetosTipos, "projetosTipos");
            layoutController = ((CardLayout) cardPanel.getLayout());
            layoutController.show(cardPanel, "projetosTipos");
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void setTextFieldError(JTextField textField, JSeparator separator) {
        textField.setForeground(errorColor);
        separator.setForeground(errorColor);
    }

    private void setTextFieldNormal(JTextField textField, JSeparator separator) {
        textField.setForeground(normalColor);
        separator.setForeground(normalColor);
    }

    private void validateDescription() {
        String description = inpDescription.getText().trim();
        if (description.isEmpty() || description.equals("Descrição")) {
            inpDescription.setText("Descrição");
            setTextFieldError(inpDescription, sepDescription);
            errorsList.add("O campo \"Descrição\" é obrigatório!");
        } else if (new ProjectType().checkDescriptionInUse(description)) {
            if (this.projectType == null) {
                setTextFieldError(inpDescription, sepDescription);
                errorsList.add("Este tipo de projeto já está cadastrado!");
            } else if (this.projectType.getDescription().equals(description)) {
                setTextFieldNormal(inpDescription, sepDescription);
            } else {
                setTextFieldError(inpDescription, sepDescription);
                errorsList.add("Este tipo de projeto já está cadastrado!");
            }
        } else {
            setTextFieldNormal(inpDescription, sepDescription);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JButton btnSave;
    private javax.swing.JTextField inpDescription;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listErrors;
    private javax.swing.JSeparator sepDescription;
    // End of variables declaration//GEN-END:variables
}
