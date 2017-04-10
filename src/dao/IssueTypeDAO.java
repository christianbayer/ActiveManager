package dao;

import classes.IssueType;
import connection.ConnectionFactory;
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
public class IssueTypeDAO implements DAOFactory {

    private static final String INSERT = "INSERT INTO issues_types (description, created_by, updated_by) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE issues_types SET description=?, updated_by=? WHERE id=?";
    private static final String DELETE = "UPDATE issues_types SET active=0 WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM issues_types";
    private static final String GET_BY_ID = "SELECT * FROM issues_types WHERE id=?";

    @Override
    public boolean save(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(INSERT);

            // Faz o parse do object para IssueType //
            IssueType issueType = (IssueType) obj;

            // Seta os valores //
            ps.setString(1, issueType.getDescription());
            ps.setInt(2, issueType.getCreatedBy());
            ps.setInt(3, issueType.getUpdatedBy());

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
            System.out.println("Error while saving IssueType: " + e);
        }
        return false;
    }

    @Override
    public boolean update(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(UPDATE);

            // Faz o parse do object para IssueType //
            IssueType issueType = (IssueType) obj;

            // Seta os valores //
            ps.setString(1, issueType.getDescription());
            ps.setInt(2, issueType.getUpdatedBy());
            ps.setInt(3, issueType.getId());

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
            System.out.println("Error while updating IssueType: " + e);
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
            System.out.println("Error while updating IssueType: " + e);
        }
        return false;
    }

    @Override
    public ArrayList<Object> getAll() {
        // Inicia o objeto como null //
        ArrayList<Object> issuesTypes = new ArrayList<>();

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_ALL);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            IssueType issueType = null;

            while (resultSet.next()) {
                issueType = new IssueType();
                issueType.setId(resultSet.getInt("id"));
                issueType.setDescription(resultSet.getString("description"));
                issueType.setCreatedAt(resultSet.getDate("created_at"));
                issueType.setCreatedBy(resultSet.getInt("created_by"));
                issueType.setUpdatedAt(resultSet.getDate("updated_at"));
                issueType.setUpdatedBy(resultSet.getInt("updated_by"));
                issueType.setActive(resultSet.getBoolean("active"));

                issuesTypes.add(issueType);
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return issuesTypes;
    }

    @Override
    public Object getById(int id) {
        // Inicia o objeto como null //
        IssueType issueType = null;

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_BY_ID);

            // Seta os valores //
            ps.setInt(1, id);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                issueType = new IssueType();
                issueType.setId(resultSet.getInt("id"));
                issueType.setDescription(resultSet.getString("description"));
                issueType.setCreatedAt(resultSet.getDate("created_at"));
                issueType.setCreatedBy(resultSet.getInt("created_by"));
                issueType.setUpdatedAt(resultSet.getDate("updated_at"));
                issueType.setUpdatedBy(resultSet.getInt("updated_by"));
                issueType.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return issueType;
    }

    public Object getQuery(String query) {
        IssueType issueType = null;
        try {
            // Cria o statement //
            Statement stmt = ConnectionFactory.getInstance().getConnection().createStatement();
            System.out.println(query);
            // Executa a query e pega o objeto //
            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                issueType = new IssueType();
                issueType.setId(resultSet.getInt("id"));
                issueType.setDescription(resultSet.getString("description"));
                issueType.setCreatedAt(resultSet.getDate("created_at"));
                issueType.setCreatedBy(resultSet.getInt("created_by"));
                issueType.setUpdatedAt(resultSet.getDate("updated_at"));
                issueType.setUpdatedBy(resultSet.getInt("updated_by"));
                issueType.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            stmt.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return issueType;
    }

}
