/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.util.Date;

/**
 *
 * @author christian
 */
public class IssueHistoric {

    private int id;
    private int issueId;
    private int journalId;
    private int oldIssueTypeId;
    private int oldIssueStatusId;
    private int oldIssuePriorityId;
    private int oldAssignedUserId;
    private String oldDoneRatio;
    private Date oldDueDate;
    private Date oldStartDate;
    private Date oldEndDate;
    private int oldEstimatedHours;
    private int oldSpentHours;
    private int oldParentIssueId;
    private int newIssueTypeId;
    private int newIssueStatusId;
    private int newIssuePriorityId;
    private int newAssignedUserId;
    private String newDoneRatio;
    private Date newDueDate;
    private Date newStartDate;
    private Date newEndDate;
    private int newEstimatedHours;
    private int newSpentHours;
    private int newParentIssueId;
    private Date createdAt;
    private int createdBy;
    private Date updatedAt;
    private int updatedBy;
    private boolean active;

    public IssueHistoric() {
    }

    public IssueHistoric(int id, int issueId, int journalId, int oldIssueTypeId, int oldIssueStatusId, int oldIssuePriorityId, int oldAssignedUserId, String oldDoneRatio, Date oldDueDate, Date oldStartDate, Date oldEndDate, int oldEstimatedHours, int oldSpentHours, int oldParentIssueId, int newIssueTypeId, int newIssueStatusId, int newIssuePriorityId, int newAssignedUserId, String newDoneRatio, Date newDueDate, Date newStartDate, Date newEndDate, int newEstimatedHours, int newSpentHours, int newParentIssueId, Date createdAt, int createdBy, Date updatedAt, int updatedBy, boolean active) {
        this.id = id;
        this.issueId = issueId;
        this.journalId = journalId;
        this.oldIssueTypeId = oldIssueTypeId;
        this.oldIssueStatusId = oldIssueStatusId;
        this.oldIssuePriorityId = oldIssuePriorityId;
        this.oldAssignedUserId = oldAssignedUserId;
        this.oldDoneRatio = oldDoneRatio;
        this.oldDueDate = oldDueDate;
        this.oldStartDate = oldStartDate;
        this.oldEndDate = oldEndDate;
        this.oldEstimatedHours = oldEstimatedHours;
        this.oldSpentHours = oldSpentHours;
        this.oldParentIssueId = oldParentIssueId;
        this.newIssueTypeId = newIssueTypeId;
        this.newIssueStatusId = newIssueStatusId;
        this.newIssuePriorityId = newIssuePriorityId;
        this.newAssignedUserId = newAssignedUserId;
        this.newDoneRatio = newDoneRatio;
        this.newDueDate = newDueDate;
        this.newStartDate = newStartDate;
        this.newEndDate = newEndDate;
        this.newEstimatedHours = newEstimatedHours;
        this.newSpentHours = newSpentHours;
        this.newParentIssueId = newParentIssueId;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
        this.active = active;
    }

    public int getOldIssueTypeId() {
        return oldIssueTypeId;
    }

    public void setOldIssueTypeId(int oldIssueTypeId) {
        this.oldIssueTypeId = oldIssueTypeId;
    }

    public int getOldIssueStatusId() {
        return oldIssueStatusId;
    }

    public void setOldIssueStatusId(int oldIssueStatusId) {
        this.oldIssueStatusId = oldIssueStatusId;
    }

    public int getOldIssuePriorityId() {
        return oldIssuePriorityId;
    }

    public void setOldIssuePriorityId(int oldIssuePriorityId) {
        this.oldIssuePriorityId = oldIssuePriorityId;
    }

    public int getOldAssignedUserId() {
        return oldAssignedUserId;
    }

    public void setOldAssignedUserId(int oldAssignedUserId) {
        this.oldAssignedUserId = oldAssignedUserId;
    }

    public String getOldDoneRatio() {
        return oldDoneRatio;
    }

    public void setOldDoneRatio(String oldDoneRatio) {
        this.oldDoneRatio = oldDoneRatio;
    }

    public Date getOldDueDate() {
        return oldDueDate;
    }

    public void setOldDueDate(Date oldDueDate) {
        this.oldDueDate = oldDueDate;
    }

    public Date getOldStartDate() {
        return oldStartDate;
    }

    public void setOldStartDate(Date oldStartDate) {
        this.oldStartDate = oldStartDate;
    }

    public Date getOldEndDate() {
        return oldEndDate;
    }

    public void setOldEndDate(Date oldEndDate) {
        this.oldEndDate = oldEndDate;
    }

    public int getOldEstimatedHours() {
        return oldEstimatedHours;
    }

    public void setOldEstimatedHours(int oldEstimatedHours) {
        this.oldEstimatedHours = oldEstimatedHours;
    }

    public int getOldSpentHours() {
        return oldSpentHours;
    }

    public void setOldSpentHours(int oldSpentHours) {
        this.oldSpentHours = oldSpentHours;
    }

    public int getOldParentIssueId() {
        return oldParentIssueId;
    }

    public void setOldParentIssueId(int oldParentIssueId) {
        this.oldParentIssueId = oldParentIssueId;
    }

    public int getNewIssueTypeId() {
        return newIssueTypeId;
    }

    public void setNewIssueTypeId(int newIssueTypeId) {
        this.newIssueTypeId = newIssueTypeId;
    }

    public int getNewIssueStatusId() {
        return newIssueStatusId;
    }

    public void setNewIssueStatusId(int newIssueStatusId) {
        this.newIssueStatusId = newIssueStatusId;
    }

    public int getNewIssuePriorityId() {
        return newIssuePriorityId;
    }

    public void setNewIssuePriorityId(int newIssuePriorityId) {
        this.newIssuePriorityId = newIssuePriorityId;
    }

    public int getNewAssignedUserId() {
        return newAssignedUserId;
    }

    public void setNewAssignedUserId(int newAssignedUserId) {
        this.newAssignedUserId = newAssignedUserId;
    }

    public String getNewDoneRatio() {
        return newDoneRatio;
    }

    public void setNewDoneRatio(String newDoneRatio) {
        this.newDoneRatio = newDoneRatio;
    }

    public Date getNewDueDate() {
        return newDueDate;
    }

    public void setNewDueDate(Date newDueDate) {
        this.newDueDate = newDueDate;
    }

    public Date getNewStartDate() {
        return newStartDate;
    }

    public void setNewStartDate(Date newStartDate) {
        this.newStartDate = newStartDate;
    }

    public Date getNewEndDate() {
        return newEndDate;
    }

    public void setNewEndDate(Date newEndDate) {
        this.newEndDate = newEndDate;
    }

    public int getNewEstimatedHours() {
        return newEstimatedHours;
    }

    public void setNewEstimatedHours(int newEstimatedHours) {
        this.newEstimatedHours = newEstimatedHours;
    }

    public int getNewSpentHours() {
        return newSpentHours;
    }

    public void setNewSpentHours(int newSpentHours) {
        this.newSpentHours = newSpentHours;
    }

    public int getNewParentIssueId() {
        return newParentIssueId;
    }

    public void setNewParentIssueId(int newParentIssueId) {
        this.newParentIssueId = newParentIssueId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIssueId() {
        return issueId;
    }

    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public int getJournalId() {
        return journalId;
    }

    public void setJournalId(int journalId) {
        this.journalId = journalId;
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