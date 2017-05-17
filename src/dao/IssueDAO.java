package dao;

import classes.Issue;
import classes.IssueType;
import connection.ConnectionFactory;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author christian
 */
public class IssueDAO implements DAOFactory {

    private static final String INSERT = "INSERT INTO issues (project_id, title, description, issue_type_id, issue_status_id, issue_priority_id, assigned_user_id, done_ratio, due_date, start_date, end_date, estimated_hours, spent_hours, parent_issue_id, created_by, updated_by) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE issues SET project_id=?, title=?, description=?, issue_type_id=?, issue_status_id=?, issue_priority_id=?, assigned_user_id=?, done_ratio=?, due_date=?, start_date=?, end_date=?, estimated_hours=?, spent_hours=?, parent_issue_id=?, updated_by=? WHERE id=?";
    private static final String DELETE = "UPDATE issues SET active=0 WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM issues";
    private static final String GET_BY_ID = "SELECT * FROM issues WHERE id=?";

    @Override
    public boolean save(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(INSERT);

            // Faz o parse do object para IssueType //
            Issue issue = (Issue) obj;

            // Seta os valores //
            ps.setInt(1, issue.getProjectId());
            ps.setString(2, issue.getTitle());
            ps.setString(3, issue.getDescription());
            ps.setInt(4, issue.getIssueTypeId());
            ps.setInt(5, issue.getIssueStatusId());
            ps.setInt(6, issue.getIssuePriorityId());
            ps.setInt(7, issue.getAssignedUserId());
            ps.setInt(8, issue.getDoneRatio());
            ps.setDate(9, issue.getDueDate() != null ? new Date(issue.getDueDate().getTime()) : null);
            ps.setDate(10, issue.getStartDate() != null ? new Date(issue.getStartDate().getTime()) : null);
            ps.setDate(11, issue.getEndDate() != null ? new Date(issue.getEndDate().getTime()) : null);
            if (issue.getEstimatedHours() == 0) {
                ps.setString(12, null);
            } else {
                ps.setFloat(12, issue.getEstimatedHours());
            }
            if (issue.getSpentHours() == 0) {
                ps.setString(13, null);
            } else {
                ps.setFloat(13, issue.getSpentHours());
            }
            if (issue.getParentIssueId() == 0) {
                ps.setString(14, null);
            } else {
                ps.setInt(14, issue.getParentIssueId());
            }
            ps.setInt(15, issue.getCreatedBy());
            ps.setInt(16, issue.getUpdatedBy());

            // Echo da query //
            System.out.println("Query : " + ps);

            // Executa a query //
            int result = ps.executeUpdate();

            // Retorna boolean //
            if (result != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error while saving Issue: " + e);
        }
        return false;
    }

    @Override
    public boolean update(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(UPDATE);

            // Faz o parse do object para IssueType //
            Issue issue = (Issue) obj;

            // Seta os valores //
            ps.setInt(1, issue.getProjectId());
            ps.setString(2, issue.getDescription());
            ps.setInt(3, issue.getIssueTypeId());
            ps.setInt(4, issue.getIssueStatusId());
            ps.setInt(5, issue.getIssuePriorityId());
            ps.setInt(6, issue.getAssignedUserId());
            ps.setInt(7, issue.getDoneRatio());
            ps.setInt(8, issue.getDoneRatio());
            ps.setDate(9, issue.getDueDate() != null ? new Date(issue.getDueDate().getTime()) : null);
            ps.setDate(10, issue.getStartDate() != null ? new Date(issue.getStartDate().getTime()) : null);
            ps.setDate(11, issue.getEndDate() != null ? new Date(issue.getEndDate().getTime()) : null);
            if (issue.getEstimatedHours() == 0) {
                ps.setString(12, null);
            } else {
                ps.setFloat(12, issue.getEstimatedHours());
            }
            if (issue.getSpentHours() == 0) {
                ps.setString(13, null);
            } else {
                ps.setFloat(13, issue.getSpentHours());
            }
            if (issue.getParentIssueId() == 0) {
                ps.setString(14, null);
            } else {
                ps.setInt(14, issue.getParentIssueId());
            }
            ps.setInt(15, issue.getUpdatedBy());
            ps.setInt(16, issue.getId());

            // Echo da query //
            System.out.println("Query : " + ps);

            // Executa a query //
            int result = ps.executeUpdate();

            // Retorna boolean //
            if (result != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error while updating Issue: " + e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(DELETE);

            // Seta os valores //
            ps.setInt(1, id);

            // Echo da query //
            System.out.println("Query : " + ps);

            // Executa a query //
            int result = ps.executeUpdate();

            // Encerra o statement //
            ps.close();

            // Retorna boolean //
            if (result != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error while deleting Issue: " + e);
        }
        return false;
    }

    @Override
    public ArrayList<Object> getAll() {
        // Inicia o objeto como null //
        ArrayList<Object> issues = new ArrayList<>();

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_ALL);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            Issue issue = null;

            while (resultSet.next()) {
                issue = new Issue();
                issue.setId(resultSet.getInt("id"));
                issue.setProjectId(resultSet.getInt("project_id"));
                issue.setTitle(resultSet.getString("title"));
                issue.setDescription(resultSet.getString("description"));
                issue.setIssueTypeId(resultSet.getInt("issue_type_id"));
                issue.setIssueStatusId(resultSet.getInt("issue_status_id"));
                issue.setIssuePriorityId(resultSet.getInt("issue_priority_id"));
                issue.setAssignedUserId(resultSet.getInt("assigned_user_id"));
                issue.setDoneRatio(resultSet.getInt("done_ratio"));
                issue.setDueDate(resultSet.getDate("due_date"));
                issue.setStartDate(resultSet.getDate("start_date"));
                issue.setEndDate(resultSet.getDate("end_date"));
                issue.setEstimatedHours(resultSet.getInt("estimated_hours"));
                issue.setSpentHours(resultSet.getInt("spent_hours"));
                issue.setParentIssueId(resultSet.getInt("parent_issue_id"));
                issue.setCreatedAt(resultSet.getDate("created_at"));
                issue.setCreatedBy(resultSet.getInt("created_by"));
                issue.setUpdatedAt(resultSet.getDate("updated_at"));
                issue.setUpdatedBy(resultSet.getInt("updated_by"));
                issue.setActive(resultSet.getBoolean("active"));
                issues.add(issue);
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return issues;
    }

    @Override
    public Object getById(int id) {
        // Inicia o objeto como null //
        Issue issue = null;

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_BY_ID);

            // Seta os valores //
            ps.setInt(1, id);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                issue = new Issue();
                issue.setId(resultSet.getInt("id"));
                issue.setProjectId(resultSet.getInt("project_id"));
                issue.setTitle(resultSet.getString("title"));
                issue.setDescription(resultSet.getString("description"));
                issue.setIssueTypeId(resultSet.getInt("issue_type_id"));
                issue.setIssueStatusId(resultSet.getInt("issue_status_id"));
                issue.setIssuePriorityId(resultSet.getInt("issue_priority_id"));
                issue.setAssignedUserId(resultSet.getInt("assigned_user_id"));
                issue.setDoneRatio(resultSet.getInt("done_ratio"));
                issue.setDueDate(resultSet.getDate("due_date"));
                issue.setStartDate(resultSet.getDate("start_date"));
                issue.setEndDate(resultSet.getDate("end_date"));
                issue.setEstimatedHours(resultSet.getInt("estimated_hours"));
                issue.setSpentHours(resultSet.getInt("spent_hours"));
                issue.setParentIssueId(resultSet.getInt("parent_issue_id"));
                issue.setCreatedAt(resultSet.getDate("created_at"));
                issue.setCreatedBy(resultSet.getInt("created_by"));
                issue.setUpdatedAt(resultSet.getDate("updated_at"));
                issue.setUpdatedBy(resultSet.getInt("updated_by"));
                issue.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return issue;
    }

    public Object getQuery(String query) {
        Issue issue = null;
        try {
            // Cria o statement //
            Statement stmt = ConnectionFactory.getInstance().getConnection().createStatement();
            System.out.println(query);
            // Executa a query e pega o objeto //
            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                issue = new Issue();
                issue.setId(resultSet.getInt("id"));
                issue.setProjectId(resultSet.getInt("project_id"));
                issue.setTitle(resultSet.getString("title"));
                issue.setDescription(resultSet.getString("description"));
                issue.setIssueTypeId(resultSet.getInt("issue_type_id"));
                issue.setIssueStatusId(resultSet.getInt("issue_status_id"));
                issue.setIssuePriorityId(resultSet.getInt("issue_priority_id"));
                issue.setAssignedUserId(resultSet.getInt("assigned_user_id"));
                issue.setDoneRatio(resultSet.getInt("done_ratio"));
                issue.setDueDate(resultSet.getDate("due_date"));
                issue.setStartDate(resultSet.getDate("start_date"));
                issue.setEndDate(resultSet.getDate("end_date"));
                issue.setEstimatedHours(resultSet.getInt("estimated_hours"));
                issue.setSpentHours(resultSet.getInt("spent_hours"));
                issue.setParentIssueId(resultSet.getInt("parent_issue_id"));
                issue.setCreatedAt(resultSet.getDate("created_at"));
                issue.setCreatedBy(resultSet.getInt("created_by"));
                issue.setUpdatedAt(resultSet.getDate("updated_at"));
                issue.setUpdatedBy(resultSet.getInt("updated_by"));
                issue.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            stmt.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return issue;
    }

}
