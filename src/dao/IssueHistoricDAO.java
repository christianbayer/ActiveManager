package dao;

import classes.IssueHistoric;
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
public class IssueHistoricDAO implements DAOFactory {

    private static final String INSERT = "INSERT INTO issues_historics (issue_id, journal_id, issue_type_id, issue_status_id, issue_priority_id, assigned_user_id, done_ratio, due_date, start_date, end_date, estimated_hours, spent_hours, parent_issue_id, created_by, updated_by) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String DELETE = "UPDATE issues_historics SET active=0 WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM issues_historics";
    private static final String GET_BY_ID = "SELECT * FROM issues_historics WHERE id=?";

    @Override
    public boolean save(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(INSERT);

            // Faz o parse do object para IssueType //
            IssueHistoric issueHistoric = (IssueHistoric) obj;

            // Seta os valores //
            ps.setInt(1, issueHistoric.getIssueId());
            if (issueHistoric.getJournalId() == 0) {
                ps.setString(2, null);
            } else {
                ps.setInt(2, issueHistoric.getJournalId());
            }
            if (issueHistoric.getIssueTypeId() == 0) {
                ps.setString(3, null);
            } else {
                ps.setInt(3, issueHistoric.getIssueTypeId());
            }
            if (issueHistoric.getIssueStatusId() == 0) {
                ps.setString(4, null);
            } else {
                ps.setInt(4, issueHistoric.getIssueStatusId());
            }
            if (issueHistoric.getIssuePriorityId() == 0) {
                ps.setString(5, null);
            } else {
                ps.setInt(5, issueHistoric.getIssuePriorityId());
            }
            if (issueHistoric.getAssignedUserId() == 0) {
                ps.setString(6, null);
            } else {
                ps.setInt(6, issueHistoric.getAssignedUserId());
            }
            ps.setString(7, issueHistoric.getDoneRatio());
            ps.setDate(8, issueHistoric.getDueDate() != null ? new Date(issueHistoric.getDueDate().getTime()) : null);
            ps.setDate(9, issueHistoric.getStartDate() != null ? new Date(issueHistoric.getStartDate().getTime()) : null);
            ps.setDate(10, issueHistoric.getEndDate() != null ? new Date(issueHistoric.getEndDate().getTime()) : null);
            if (issueHistoric.getEstimatedHours() == 0) {
                ps.setString(11, null);
            } else {
                ps.setInt(11, issueHistoric.getEstimatedHours());
            }
            if (issueHistoric.getSpentHours() == 0) {
                ps.setString(12, null);
            } else {
                ps.setInt(12, issueHistoric.getSpentHours());
            }
            if (issueHistoric.getParentIssueId() == 0) {
                ps.setString(13, null);
            } else {
                ps.setInt(13, issueHistoric.getParentIssueId());
            }
            ps.setInt(14, issueHistoric.getCreatedBy());
            ps.setInt(15, issueHistoric.getUpdatedBy());

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
            System.out.println("Error while saving IssueHistoric: " + e);
        }
        return false;
    }

    @Override
    public boolean update(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        ArrayList<Object> issuesHistorics = new ArrayList<>();

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_ALL);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            IssueHistoric issueHistoric = null;

            while (resultSet.next()) {
                issueHistoric = new IssueHistoric();
                issueHistoric.setId(resultSet.getInt("id"));
                issueHistoric.setIssueId(resultSet.getInt("issue_id"));
                issueHistoric.setIssueTypeId(resultSet.getInt("issue_type_id"));
                issueHistoric.setIssueStatusId(resultSet.getInt("issue_status_id"));
                issueHistoric.setIssuePriorityId(resultSet.getInt("issue_priority_id"));
                issueHistoric.setAssignedUserId(resultSet.getInt("assigned_user_id"));
                issueHistoric.setDoneRatio(resultSet.getString("done_ratio"));
                issueHistoric.setDueDate(resultSet.getDate("due_date"));
                issueHistoric.setStartDate(resultSet.getDate("start_date"));
                issueHistoric.setEndDate(resultSet.getDate("end_date"));
                issueHistoric.setEstimatedHours(resultSet.getInt("estimated_hours"));
                issueHistoric.setSpentHours(resultSet.getInt("spent_hours"));
                issueHistoric.setParentIssueId(resultSet.getInt("parent_issue_id"));
                issueHistoric.setCreatedAt(resultSet.getDate("created_at"));
                issueHistoric.setCreatedBy(resultSet.getInt("created_by"));
                issueHistoric.setUpdatedAt(resultSet.getDate("updated_at"));
                issueHistoric.setUpdatedBy(resultSet.getInt("updated_by"));
                issueHistoric.setActive(resultSet.getBoolean("active"));
                issuesHistorics.add(issueHistoric);
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return issuesHistorics;
    }

    @Override
    public Object getById(int id) {
        // Inicia o objeto como null //
        IssueHistoric issueHistoric = null;

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_BY_ID);

            // Seta os valores //
            ps.setInt(1, id);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                issueHistoric = new IssueHistoric();
                issueHistoric.setId(resultSet.getInt("id"));
                issueHistoric.setIssueId(resultSet.getInt("issue_id"));
                issueHistoric.setIssueTypeId(resultSet.getInt("issue_type_id"));
                issueHistoric.setIssueStatusId(resultSet.getInt("issue_status_id"));
                issueHistoric.setIssuePriorityId(resultSet.getInt("issue_priority_id"));
                issueHistoric.setAssignedUserId(resultSet.getInt("assigned_user_id"));
                issueHistoric.setDoneRatio(resultSet.getString("done_ratio"));
                issueHistoric.setDueDate(resultSet.getDate("due_date"));
                issueHistoric.setStartDate(resultSet.getDate("start_date"));
                issueHistoric.setEndDate(resultSet.getDate("end_date"));
                issueHistoric.setEstimatedHours(resultSet.getInt("estimated_hours"));
                issueHistoric.setSpentHours(resultSet.getInt("spent_hours"));
                issueHistoric.setParentIssueId(resultSet.getInt("parent_issue_id"));
                issueHistoric.setCreatedAt(resultSet.getDate("created_at"));
                issueHistoric.setCreatedBy(resultSet.getInt("created_by"));
                issueHistoric.setUpdatedAt(resultSet.getDate("updated_at"));
                issueHistoric.setUpdatedBy(resultSet.getInt("updated_by"));
                issueHistoric.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return issueHistoric;
    }

    public Object getQuery(String query) {
        IssueHistoric issueHistoric = null;
        try {
            // Cria o statement //
            Statement stmt = ConnectionFactory.getInstance().getConnection().createStatement();
            System.out.println(query);
            // Executa a query e pega o objeto //
            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                issueHistoric = new IssueHistoric();
                issueHistoric.setId(resultSet.getInt("id"));
                issueHistoric.setIssueId(resultSet.getInt("issue_id"));
                issueHistoric.setIssueTypeId(resultSet.getInt("issue_type_id"));
                issueHistoric.setIssueStatusId(resultSet.getInt("issue_status_id"));
                issueHistoric.setIssuePriorityId(resultSet.getInt("issue_priority_id"));
                issueHistoric.setAssignedUserId(resultSet.getInt("assigned_user_id"));
                issueHistoric.setDoneRatio(resultSet.getString("done_ratio"));
                issueHistoric.setDueDate(resultSet.getDate("due_date"));
                issueHistoric.setStartDate(resultSet.getDate("start_date"));
                issueHistoric.setEndDate(resultSet.getDate("end_date"));
                issueHistoric.setEstimatedHours(resultSet.getInt("estimated_hours"));
                issueHistoric.setSpentHours(resultSet.getInt("spent_hours"));
                issueHistoric.setParentIssueId(resultSet.getInt("parent_issue_id"));
                issueHistoric.setCreatedAt(resultSet.getDate("created_at"));
                issueHistoric.setCreatedBy(resultSet.getInt("created_by"));
                issueHistoric.setUpdatedAt(resultSet.getDate("updated_at"));
                issueHistoric.setUpdatedBy(resultSet.getInt("updated_by"));
                issueHistoric.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            stmt.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return issueHistoric;
    }

}
