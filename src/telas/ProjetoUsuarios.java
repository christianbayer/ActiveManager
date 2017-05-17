/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telas;

import apoio.JCheckBoxValue;
import classes.Project;
import classes.User;
import classes.UserProject;
import dao.ProjectDAO;
import dao.ProjectTypeDAO;
import dao.UserDAO;
import dao.UserProjectDAO;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import org.netbeans.lib.awtextra.AbsoluteConstraints;

/**
 *
 * @author christian
 */
public class ProjetoUsuarios extends javax.swing.JPanel {

    ProjectDAO projectDAO;
    UserDAO userDAO;
    ProjectTypeDAO projectTypeDAO;
    Color errorColor;
    Color normalColor;
    ArrayList errorsList;
    CardLayout layoutController;
    JPanel cardPanel;
    JLabel btnBack;
    JLabel lblWindow;
    Projetos projetos;
    Project project;
    User user;
    UserProjectDAO userProjectDAO;

    /**
     * Creates new form ProjetosListagem
     */
    public ProjetoUsuarios(JLabel btnBack, JLabel lblWindow, CardLayout lController, JPanel cardPanel, Project project, User user) {
        initComponents();

        // Seta o título da janela
        lblWindow.setText("USUÁRIOS DO PROJETO");
        lblProject.setText(project.getTitle());

        // Troca o action do botão "Voltar"
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                projetos = new Projetos(btnBack, lblWindow, layoutController, cardPanel, user);
                cardPanel.add(projetos, "projetos");
                layoutController = ((CardLayout) cardPanel.getLayout());
                layoutController.show(cardPanel, "projetos");
            }
        });

        // Inicializa as variáveis de tela
        this.btnBack = btnBack;
        this.lblWindow = lblWindow;
        this.cardPanel = cardPanel;
        this.layoutController = lController;
        this.user = user;
        this.project = project;

        // Inicializa os DAO's
        projectDAO = new ProjectDAO();
        userDAO = new UserDAO();
        userProjectDAO = new UserProjectDAO();

        populate();

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
        btnSave = new javax.swing.JButton();
        lblProject = new javax.swing.JLabel();
        usersPanel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(254, 254, 254));
        setPreferredSize(new java.awt.Dimension(800, 540));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        basePanel.setBackground(new java.awt.Color(254, 254, 254));
        basePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        lblProject.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        lblProject.setText("ActiveManager");
        basePanel.add(lblProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        usersPanel.setBackground(new java.awt.Color(254, 254, 254));
        usersPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        basePanel.add(usersPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 730, 360));

        add(basePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        ArrayList<Integer> usersIds = new ArrayList();

        for (int i = 0; i < usersPanel.getComponentCount(); i++) {
            JCheckBoxValue checkBox = (JCheckBoxValue) usersPanel.getComponent(i);
            if (checkBox.isSelected()) {
                if (!usersProjectsUsersIds.contains(checkBox.getValue())) {
                    System.out.println(checkBox.getValue());
                    usersIds.add(checkBox.getValue());
                }
            } else {
                userProjectDAO.delete(checkBox.getValue(), project.getId());
            }
        }

        for (int i = 0; i < usersIds.size(); i++) {
            UserProject userProject = new UserProject();
            userProject.setUserId(usersIds.get(i));
            userProject.setProjectId(project.getId());
            userProjectDAO.save(userProject);
        }
        
        projetos = new Projetos(btnBack, lblWindow, layoutController, cardPanel, user);
        cardPanel.add(projetos, "projetos");
        layoutController = ((CardLayout) cardPanel.getLayout());
        layoutController.show(cardPanel, "projetos");
    }//GEN-LAST:event_btnSaveActionPerformed

    int columnCount = 0;
    int y = 1;
    ArrayList<Integer> usersProjectsUsersIds;

    private void makeCheckbox(User user) {
        int x;
        columnCount++;

        switch (columnCount) {
            case 1:
                x = 10;
                break;
            case 2:
                x = 240;
                break;
            default:
                x = 490;
                break;
        }

        JCheckBoxValue checkbox = new JCheckBoxValue();
        checkbox.setBackground(new Color(254, 254, 254));
        checkbox.setText(user.getFirstName() + " " + user.getLastName());
        checkbox.setValue(user.getId());
        if(user.getId() == project.getManagerId()) {
            checkbox.setSelected(true);
            checkbox.setEnabled(false);
        } else if (usersProjectsUsersIds.contains(user.getId())) {
            checkbox.setSelected(true);
        }
        
        usersPanel.add(checkbox, new AbsoluteConstraints(x, y, -1, -1));

        if (columnCount == 3) {
            columnCount = 0;
            y += 30;
        }

    }

    private void populate() {
        usersProjectsUsersIds = new ArrayList();
        ArrayList<Object> usersProjects = userProjectDAO.getQuerys("SELECT * FROM users_projects WHERE project_id=" + project.getId() + " AND active=1;");
        ArrayList<Object> users = userDAO.getAll();
        Iterator<Object> iterator = usersProjects.iterator();
        while (iterator.hasNext()) {
            UserProject userProject = (UserProject) iterator.next();
            usersProjectsUsersIds.add(userProject.getUserId());
        }
        iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            makeCheckbox(user);

        }
        basePanel.revalidate();
        basePanel.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel basePanel;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel lblProject;
    private javax.swing.JPanel usersPanel;
    // End of variables declaration//GEN-END:variables
}