package dao;

import apoio.JComboBoxItem;
import classes.ProjectType;
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
public class ProjectTypeDAO implements DAOFactory {

    private static final String INSERT = "INSERT INTO projects_types (description, created_by, updated_by) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE projects_types SET description=?, updated_by=? WHERE id=?";
    private static final String DELETE = "UPDATE projects_types SET active=0 WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM projects_types";
    private static final String GET_BY_ID = "SELECT * FROM projects_types WHERE id=?";

    @Override
    public boolean save(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(INSERT);

            // Faz o parse do object para User //
            ProjectType projectType = (ProjectType) obj;

            // Seta os valores //
            ps.setString(1, projectType.getDescription());
            ps.setInt(2, projectType.getCreatedBy());
            ps.setInt(3, projectType.getUpdatedBy());

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
            System.out.println("Error while saving ProjectType: " + e);
        }
        return false;
    }

    @Override
    public boolean update(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(UPDATE);

            // Faz o parse do object para Role //
            ProjectType projectType = (ProjectType) obj;

            // Seta os valores //
            ps.setString(1, projectType.getDescription());
            ps.setInt(2, projectType.getUpdatedBy());
            ps.setInt(3, projectType.getId());

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
            System.out.println("Error while updating ProjectType: " + e);
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
            System.out.println("Error while updating ProjectType: " + e);
        }
        return false;
    }

    @Override
    public ArrayList<Object> getAll() {
        // Inicia o objeto como null //
        ArrayList<Object> projectsTypes = new ArrayList<>();

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_ALL);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            ProjectType projectType = null;

            while (resultSet.next()) {
                projectType = new ProjectType();
                projectType.setId(resultSet.getInt("id"));
                projectType.setDescription(resultSet.getString("description"));
                projectType.setCreatedAt(resultSet.getDate("created_at"));
                projectType.setCreatedBy(resultSet.getInt("created_by"));
                projectType.setUpdatedAt(resultSet.getDate("updated_at"));
                projectType.setUpdatedBy(resultSet.getInt("updated_by"));
                projectType.setActive(resultSet.getBoolean("active"));

                projectsTypes.add(projectType);
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return projectsTypes;
    }

    @Override
    public Object getById(int id) {
        // Inicia o objeto como null //
        ProjectType projectType = null;

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_BY_ID);

            // Seta os valores //
            ps.setInt(1, id);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                projectType = new ProjectType();
                projectType.setId(resultSet.getInt("id"));
                projectType.setDescription(resultSet.getString("description"));
                projectType.setCreatedAt(resultSet.getDate("created_at"));
                projectType.setCreatedBy(resultSet.getInt("created_by"));
                projectType.setUpdatedAt(resultSet.getDate("updated_at"));
                projectType.setUpdatedBy(resultSet.getInt("updated_by"));
                projectType.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return projectType;
    }

    public Object getQuery(String query) {
        ProjectType projectType = null;
        try {
            // Cria o statement //
            Statement stmt = ConnectionFactory.getInstance().getConnection().createStatement();
            System.out.println(query);
            // Executa a query e pega o objeto //
            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                projectType = new ProjectType();
                projectType.setId(resultSet.getInt("id"));
                projectType.setDescription(resultSet.getString("description"));
                projectType.setCreatedAt(resultSet.getDate("created_at"));
                projectType.setCreatedBy(resultSet.getInt("created_by"));
                projectType.setUpdatedAt(resultSet.getDate("updated_at"));
                projectType.setUpdatedBy(resultSet.getInt("updated_by"));
                projectType.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            stmt.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return projectType;
    }

    public void lists(JComboBox combobox, String defaultItem) {

        combobox.removeAllItems();

        JComboBoxItem item = new JComboBoxItem(0, defaultItem);
        combobox.addItem(item);

        ArrayList<Object> projectsTypes = this.getAll();

        Iterator<Object> iterator = projectsTypes.iterator();
        while (iterator.hasNext()) {
            ProjectType projectType = (ProjectType) iterator.next();
            item = new JComboBoxItem(projectType.getId(), projectType.getDescription());
            combobox.addItem(item);
        }

    }
    
}
