/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dao.ProjectDAO;
import java.util.Date;

/**
 *
 * @author christian
 */
public class Project {
    
    private int id;
    private String title;
    private String description;
    private int projectTypeId;
    private int managerId;
    private Date createdAt;
    private int createdBy;
    private Date updatedAt;
    private int updatedBy;
    private boolean active;

    public Project() {}

    public Project(String title, String description, int projectTypeId, int managerId, int createdBy) {
        this.title = title;
        this.description = description;
        this.projectTypeId = projectTypeId;
        this.managerId = managerId;
        this.createdBy = createdBy;
        this.updatedBy = createdBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(int projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(int updatedBy) {
        this.updatedBy = updatedBy;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    public boolean checkTitleInUse(String title) {
        ProjectDAO projectDAO = new ProjectDAO();
        String query = "SELECT * FROM projects WHERE title=\"" + title + "\" AND active=1";
        Project project = (Project) projectDAO.getQuery(query);
        return project != null;
    }

}
