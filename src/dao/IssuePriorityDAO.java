package dao;

import apoio.JComboBoxItem;
import classes.IssuePriority;
import classes.IssueStatus;
import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JComboBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author christian
 */
public class IssuePriorityDAO implements DAOFactory {

    private static final String INSERT = "INSERT INTO issues_priorities (description, created_by, updated_by) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE issues_priorities SET description=?, updated_by=? WHERE id=?";
    private static final String DELETE = "UPDATE issues_priorities SET active=0 WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM issues_priorities";
    private static final String GET_BY_ID = "SELECT * FROM issues_priorities WHERE id=?";

    @Override
    public boolean save(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(INSERT);

            // Faz o parse do object para IssuePriority //
            IssuePriority issuePriority = (IssuePriority) obj;

            // Seta os valores //
            ps.setString(1, issuePriority.getDescription());
            ps.setInt(2, issuePriority.getCreatedBy());
            ps.setInt(3, issuePriority.getUpdatedBy());

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
            System.out.println("Error while saving IssuePriority: " + e);
        }
        return false;
    }

    @Override
    public boolean update(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(UPDATE);

            // Faz o parse do object para IssuePriority //
            IssuePriority issuePriority = (IssuePriority) obj;

            // Seta os valores //
            ps.setString(1, issuePriority.getDescription());
            ps.setInt(2, issuePriority.getUpdatedBy());
            ps.setInt(3, issuePriority.getId());

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
            System.out.println("Error while updating IssuePriority: " + e);
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
            System.out.println("Error while updating IssuePriority: " + e);
        }
        return false;
    }

    @Override
    public ArrayList<Object> getAll() {
        // Inicia o objeto como null //
        ArrayList<Object> issuesPriorities = new ArrayList<>();

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_ALL);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            IssuePriority issuePriority = null;

            while (resultSet.next()) {
                issuePriority = new IssuePriority();
                issuePriority.setId(resultSet.getInt("id"));
                issuePriority.setDescription(resultSet.getString("description"));
                issuePriority.setCreatedAt(resultSet.getDate("created_at"));
                issuePriority.setCreatedBy(resultSet.getInt("created_by"));
                issuePriority.setUpdatedAt(resultSet.getDate("updated_at"));
                issuePriority.setUpdatedBy(resultSet.getInt("updated_by"));
                issuePriority.setActive(resultSet.getBoolean("active"));

                issuesPriorities.add(issuePriority);
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return issuesPriorities;
    }

    @Override
    public Object getById(int id) {
        // Inicia o objeto como null //
        IssuePriority issuePriority = null;

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_BY_ID);

            // Seta os valores //
            ps.setInt(1, id);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                issuePriority = new IssuePriority();
                issuePriority.setId(resultSet.getInt("id"));
                issuePriority.setDescription(resultSet.getString("description"));
                issuePriority.setCreatedAt(resultSet.getDate("created_at"));
                issuePriority.setCreatedBy(resultSet.getInt("created_by"));
                issuePriority.setUpdatedAt(resultSet.getDate("updated_at"));
                issuePriority.setUpdatedBy(resultSet.getInt("updated_by"));
                issuePriority.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return issuePriority;
    }

    public Object getQuery(String query) {
        IssuePriority issuePriority = null;
        try {
            // Cria o statement //
            Statement stmt = ConnectionFactory.getInstance().getConnection().createStatement();
            System.out.println(query);
            // Executa a query e pega o objeto //
            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                issuePriority = new IssuePriority();
                issuePriority.setId(resultSet.getInt("id"));
                issuePriority.setDescription(resultSet.getString("description"));
                issuePriority.setCreatedAt(resultSet.getDate("created_at"));
                issuePriority.setCreatedBy(resultSet.getInt("created_by"));
                issuePriority.setUpdatedAt(resultSet.getDate("updated_at"));
                issuePriority.setUpdatedBy(resultSet.getInt("updated_by"));
                issuePriority.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            stmt.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return issuePriority;
    }
    
        
    public void lists(JComboBox combobox) {

        combobox.removeAllItems();

        JComboBoxItem item = new JComboBoxItem(0, "Prioridade");
        combobox.addItem(item);

        ArrayList<Object> priorities = this.getAll();

        Iterator<Object> iterator = priorities.iterator();
        while (iterator.hasNext()) {
            IssuePriority issuePriority = (IssuePriority) iterator.next();
            if (issuePriority.isActive()) {
                item = new JComboBoxItem(issuePriority.getId(), issuePriority.getDescription());
                combobox.addItem(item);
            }
        }

    }

}
