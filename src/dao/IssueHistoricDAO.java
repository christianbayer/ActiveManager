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

    private static final String INSERT = "INSERT INTO issues_historics (issue_id, journal_id, old_issue_type_id, old_issue_status_id, old_issue_priority_id, old_assigned_user_id, old_done_ratio, old_due_date, old_start_date, old_end_date, old_estimated_hours, old_spent_hours, old_parent_issue_id, new_issue_type_id, new_issue_status_id, new_issue_priority_id, new_assigned_user_id, new_done_ratio, new_due_date, new_start_date, new_end_date, new_estimated_hours, new_spent_hours, new_parent_issue_id, created_by, updated_by) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

            if (issueHistoric.getOldIssueTypeId() == 0) {
                ps.setString(3, null);
            } else {
                ps.setInt(3, issueHistoric.getOldIssueTypeId());
            }

            if (issueHistoric.getOldIssueStatusId() == 0) {
                ps.setString(4, null);
            } else {
                ps.setInt(4, issueHistoric.getOldIssueStatusId());
            }

            if (issueHistoric.getOldIssuePriorityId() == 0) {
                ps.setString(5, null);
            } else {
                ps.setInt(5, issueHistoric.getOldIssuePriorityId());
            }

            if (issueHistoric.getOldAssignedUserId() == 0) {
                ps.setString(6, null);
            } else {
                ps.setInt(6, issueHistoric.getOldAssignedUserId());
            }

            ps.setString(7, issueHistoric.getOldDoneRatio());

            ps.setDate(8, issueHistoric.getOldDueDate() != null ? new Date(issueHistoric.getOldDueDate().getTime()) : null);

            ps.setDate(9, issueHistoric.getOldStartDate() != null ? new Date(issueHistoric.getOldStartDate().getTime()) : null);

            ps.setDate(10, issueHistoric.getOldEndDate() != null ? new Date(issueHistoric.getOldEndDate().getTime()) : null);

            if (issueHistoric.getOldEstimatedHours() == 0) {
                ps.setString(11, null);
            } else {
                ps.setInt(11, issueHistoric.getOldEstimatedHours());
            }

            if (issueHistoric.getOldSpentHours() == 0) {
                ps.setString(12, null);
            } else {
                ps.setInt(12, issueHistoric.getOldSpentHours());
            }

            if (issueHistoric.getOldParentIssueId() == 0) {
                ps.setString(13, null);
            } else {
                ps.setInt(13, issueHistoric.getOldParentIssueId());
            }

            if (issueHistoric.getNewIssueTypeId() == 0) {
                ps.setString(14, null);
            } else {
                ps.setInt(14, issueHistoric.getNewIssueTypeId());
            }
            
            if (issueHistoric.getNewIssueStatusId() == 0) {
                ps.setString(15, null);
            } else {
                ps.setInt(15, issueHistoric.getNewIssueStatusId());
            }
            
            if (issueHistoric.getNewIssuePriorityId() == 0) {
                ps.setString(16, null);
            } else {
                ps.setInt(16, issueHistoric.getNewIssuePriorityId());
            }
            
            if (issueHistoric.getNewAssignedUserId() == 0) {
                ps.setString(17, null);
            } else {
                ps.setInt(17, issueHistoric.getNewAssignedUserId());
           }
           
            ps.setString(18, issueHistoric.getNewDoneRatio());
            
            ps.setDate(19, issueHistoric.getNewDueDate() != null ? new Date(issueHistoric.getNewDueDate().getTime()) : null);
            
            ps.setDate(20, issueHistoric.getNewStartDate() != null ? new Date(issueHistoric.getNewStartDate().getTime()) : null);
            
            ps.setDate(21, issueHistoric.getNewEndDate() != null ? new Date(issueHistoric.getNewEndDate().getTime()) : null);
            
            if (issueHistoric.getNewEstimatedHours() == 0) {
                ps.setString(22, null);
            } else {
                ps.setInt(22, issueHistoric.getNewEstimatedHours());
            }
            
            if (issueHistoric.getNewSpentHours() == 0) {
                ps.setString(23, null);
            } else {
                ps.setInt(23, issueHistoric.getNewSpentHours());
            }
            
            if (issueHistoric.getNewParentIssueId() == 0) {
                ps.setString(24, null);
            } else {
                ps.setInt(24, issueHistoric.getNewParentIssueId());
            }
            
            ps.setInt(25, issueHistoric.getCreatedBy());
            
            ps.setInt(26, issueHistoric.getUpdatedBy());

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        try {
//            // Cria o statement //
//            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(DELETE);
//
//            // Seta os valores //
//            ps.setInt(1, id);
//
//            // Echo da query //
//            System.out.println("Query : " + ps);
//
//            // Executa a query //
//            int result = ps.executeUpdate();
//
//            // Encerra o statement //
//            ps.close();
//
//            // Retorna boolean //
//            if (result != 0) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            System.out.println("Error while deleting Issue: " + e);
//        }
//        return false;
    }

    @Override
    public ArrayList<Object> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        // Inicia o objeto como null //
//        ArrayList<Object> issuesHistorics = new ArrayList<>();
//
//        try {
//            // Cria o statement //
//            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_ALL);
//
//            // Executa a query e pega o objeto //
//            ResultSet resultSet = ps.executeQuery();
//
//            IssueHistoric issueHistoric = null;
//
//            while (resultSet.next()) {
//                issueHistoric = new IssueHistoric();
//                issueHistoric.setId(resultSet.getInt("id"));
//                issueHistoric.setIssueId(resultSet.getInt("issue_id"));
//                issueHistoric.setIssueTypeId(resultSet.getInt("issue_type_id"));
//                issueHistoric.setIssueStatusId(resultSet.getInt("issue_status_id"));
//                issueHistoric.setIssuePriorityId(resultSet.getInt("issue_priority_id"));
//                issueHistoric.setAssignedUserId(resultSet.getInt("assigned_user_id"));
//                issueHistoric.setDoneRatio(resultSet.getString("done_ratio"));
//                issueHistoric.setDueDate(resultSet.getDate("due_date"));
//                issueHistoric.setStartDate(resultSet.getDate("start_date"));
//                issueHistoric.setEndDate(resultSet.getDate("end_date"));
//                issueHistoric.setEstimatedHours(resultSet.getInt("estimated_hours"));
//                issueHistoric.setSpentHours(resultSet.getInt("spent_hours"));
//                issueHistoric.setParentIssueId(resultSet.getInt("parent_issue_id"));
//                issueHistoric.setCreatedAt(resultSet.getDate("created_at"));
//                issueHistoric.setCreatedBy(resultSet.getInt("created_by"));
//                issueHistoric.setUpdatedAt(resultSet.getDate("updated_at"));
//                issueHistoric.setUpdatedBy(resultSet.getInt("updated_by"));
//                issueHistoric.setActive(resultSet.getBoolean("active"));
//                issuesHistorics.add(issueHistoric);
//            }
//
//            // Encerra o statement //
//            resultSet.close();
//            ps.close();
//
//        } catch (SQLException e) {
//            //e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//
//        return issuesHistorics;
    }

    @Override
    public Object getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        // Inicia o objeto como null //
//        IssueHistoric issueHistoric = null;
//
//        try {
//            // Cria o statement //
//            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_BY_ID);
//
//            // Seta os valores //
//            ps.setInt(1, id);
//
//            // Executa a query e pega o objeto //
//            ResultSet resultSet = ps.executeQuery();
//
//            if (resultSet.next()) {
//                issueHistoric = new IssueHistoric();
//                issueHistoric.setId(resultSet.getInt("id"));
//                issueHistoric.setIssueId(resultSet.getInt("issue_id"));
//                issueHistoric.setIssueTypeId(resultSet.getInt("issue_type_id"));
//                issueHistoric.setIssueStatusId(resultSet.getInt("issue_status_id"));
//                issueHistoric.setIssuePriorityId(resultSet.getInt("issue_priority_id"));
//                issueHistoric.setAssignedUserId(resultSet.getInt("assigned_user_id"));
//                issueHistoric.setDoneRatio(resultSet.getString("done_ratio"));
//                issueHistoric.setDueDate(resultSet.getDate("due_date"));
//                issueHistoric.setStartDate(resultSet.getDate("start_date"));
//                issueHistoric.setEndDate(resultSet.getDate("end_date"));
//                issueHistoric.setEstimatedHours(resultSet.getInt("estimated_hours"));
//                issueHistoric.setSpentHours(resultSet.getInt("spent_hours"));
//                issueHistoric.setParentIssueId(resultSet.getInt("parent_issue_id"));
//                issueHistoric.setCreatedAt(resultSet.getDate("created_at"));
//                issueHistoric.setCreatedBy(resultSet.getInt("created_by"));
//                issueHistoric.setUpdatedAt(resultSet.getDate("updated_at"));
//                issueHistoric.setUpdatedBy(resultSet.getInt("updated_by"));
//                issueHistoric.setActive(resultSet.getBoolean("active"));
//            }
//
//            // Encerra o statement //
//            resultSet.close();
//            ps.close();
//
//        } catch (SQLException e) {
//            //e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return issueHistoric;
    }

    public Object getQuery(String query) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        IssueHistoric issueHistoric = null;
//        try {
//            // Cria o statement //
//            Statement stmt = ConnectionFactory.getInstance().getConnection().createStatement();
//            System.out.println(query);
//            // Executa a query e pega o objeto //
//            ResultSet resultSet = stmt.executeQuery(query);
//
//            if (resultSet.next()) {
//                issueHistoric = new IssueHistoric();
//                issueHistoric.setId(resultSet.getInt("id"));
//                issueHistoric.setIssueId(resultSet.getInt("issue_id"));
//                issueHistoric.setIssueTypeId(resultSet.getInt("issue_type_id"));
//                issueHistoric.setIssueStatusId(resultSet.getInt("issue_status_id"));
//                issueHistoric.setIssuePriorityId(resultSet.getInt("issue_priority_id"));
//                issueHistoric.setAssignedUserId(resultSet.getInt("assigned_user_id"));
//                issueHistoric.setDoneRatio(resultSet.getString("done_ratio"));
//                issueHistoric.setDueDate(resultSet.getDate("due_date"));
//                issueHistoric.setStartDate(resultSet.getDate("start_date"));
//                issueHistoric.setEndDate(resultSet.getDate("end_date"));
//                issueHistoric.setEstimatedHours(resultSet.getInt("estimated_hours"));
//                issueHistoric.setSpentHours(resultSet.getInt("spent_hours"));
//                issueHistoric.setParentIssueId(resultSet.getInt("parent_issue_id"));
//                issueHistoric.setCreatedAt(resultSet.getDate("created_at"));
//                issueHistoric.setCreatedBy(resultSet.getInt("created_by"));
//                issueHistoric.setUpdatedAt(resultSet.getDate("updated_at"));
//                issueHistoric.setUpdatedBy(resultSet.getInt("updated_by"));
//                issueHistoric.setActive(resultSet.getBoolean("active"));
//            }
//
//            // Encerra o statement //
//            resultSet.close();
//            stmt.close();
//
//        } catch (SQLException e) {
//            //e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//        return issueHistoric;
    }

}
