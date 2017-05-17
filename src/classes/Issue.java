/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import dao.IssuePriorityDAO;
import dao.IssueStatusDAO;
import dao.IssueTypeDAO;
import dao.ProjectDAO;
import dao.UserDAO;
import dao.UserProjectDAO;
import java.util.Date;

/**
 *
 * @author christian
 */
public class Issue {

    private int id;
    private int projectId;
    private String title;
    private String description;
    private int issueTypeId;
    private int issueStatusId;
    private int issuePriorityId;
    private int assignedUserId;
    private int doneRatio;
    private Date dueDate;
    private Date startDate;
    private Date endDate;
    private float estimatedHours;
    private float spentHours;
    private int parentIssueId;
    private Date createdAt;
    private int createdBy;
    private Date updatedAt;
    private int updatedBy;
    private boolean active;

    public Issue() {
    }

    public Issue(int id, int projectId, String title, String description, int issueTypeId, int issueStatusId, int issuePriorityId, int assignedUserId, int doneRatio, Date dueDate, Date startDate, Date endDate, float estimatedHours, float spentHours, int parentIssueId, Date createdAt, int createdBy, Date updatedAt, int updatedBy, boolean active) {
        this.id = id;
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.issueTypeId = issueTypeId;
        this.issueStatusId = issueStatusId;
        this.issuePriorityId = issuePriorityId;
        this.assignedUserId = assignedUserId;
        this.doneRatio = doneRatio;
        this.dueDate = dueDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.estimatedHours = estimatedHours;
        this.spentHours = spentHours;
        this.parentIssueId = parentIssueId;
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

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectTitle() {
        ProjectDAO projectDAO = new ProjectDAO();
        Project project = (Project) projectDAO.getById(issueTypeId);
        return project.getTitle();
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

    public int getIssueTypeId() {
        return issueTypeId;
    }

    public void setIssueTypeId(int issueTypeId) {
        this.issueTypeId = issueTypeId;
    }

    public String getIssueTypeDescription() {
        IssueTypeDAO issueTypeDAO = new IssueTypeDAO();
        IssueType issueType = (IssueType) issueTypeDAO.getById(issueTypeId);
        return issueType.getDescription();
    }

    public int getIssueStatusId() {
        return issueStatusId;
    }

    public void setIssueStatusId(int issueStatusId) {
        this.issueStatusId = issueStatusId;
    }

    public String getIssueStatusDescription() {
        IssueStatusDAO issueStatusDAO = new IssueStatusDAO();
        IssueStatus issueStatus = (IssueStatus) issueStatusDAO.getById(issueStatusId);
        return issueStatus.getDescription();
    }

    public int getIssuePriorityId() {
        return issuePriorityId;
    }

    public void setIssuePriorityId(int issuePriorityId) {
        this.issuePriorityId = issuePriorityId;
    }

    public String getIssuePriorityDescription() {
        IssuePriorityDAO issuePriorityDAO = new IssuePriorityDAO();
        IssuePriority issuePriority = (IssuePriority) issuePriorityDAO.getById(issuePriorityId);
        return issuePriority.getDescription();
    }

    public int getAssignedUserId() {
        return assignedUserId;
    }

    public void setAssignedUserId(int assignedUserId) {
        this.assignedUserId = assignedUserId;
    }

    public String getAssignedUserName() {
        UserProjectDAO userProjectDAO= new UserProjectDAO();
        UserDAO userDAO = new UserDAO();
        UserProject userProject = (UserProject) userProjectDAO.getById(assignedUserId);
        User user = (User) userDAO.getById(userProject.getUserId());
        return user.getFirstName() + " " + user.getLastName();
    }

    public int getDoneRatio() {
        return doneRatio;
    }

    public void setDoneRatio(int doneRatio) {
        this.doneRatio = doneRatio;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public float getEstimatedHours() {
        return estimatedHours;
    }

    public void setEstimatedHours(float estimatedHours) {
        this.estimatedHours = estimatedHours;
    }

    public float getSpentHours() {
        return spentHours;
    }

    public void setSpentHours(float spentHours) {
        this.spentHours = spentHours;
    }

    public int getParentIssueId() {
        return parentIssueId;
    }

    public void setParentIssueId(int parentIssueId) {
        this.parentIssueId = parentIssueId;
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

}
