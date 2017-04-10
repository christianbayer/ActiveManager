/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dao.IssueTypeDAO;
import java.util.Date;

/**
 *
 * @author christian
 */
public class IssueType {

    private int id;
    private String description;
    private Date createdAt;
    private int createdBy;
    private Date updatedAt;
    private int updatedBy;
    private boolean active;

    public IssueType() {
    }

    public IssueType(String description, Date createdAt, int createdBy, Date updatedAt, int updatedBy, boolean active) {
        this.description = description;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public boolean checkDescriptionInUse(String description) {
        IssueTypeDAO roleDAO = new IssueTypeDAO();
        String query = "SELECT * FROM issues_types WHERE description=\"" + description + "\" AND active=1";
        IssueType issueType = (IssueType) roleDAO.getQuery(query);
        return issueType != null;
    }

}
