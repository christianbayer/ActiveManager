package dao;

import apoio.JComboBoxItem;
import classes.UserProject;
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
public class UserProjectDAO implements DAOFactory {

    private static final String INSERT = "INSERT INTO users_projects (user_id, project_id, created_by, updated_by) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE users_projects SET user_id=?, project_id=?, updated_by=? WHERE id=?";
    private static final String DELETE = "UPDATE users_projects SET active=0 WHERE id=?";
    private static final String DELETE_BY_USER_ID = "UPDATE users_projects SET active=0 WHERE user_id=? AND project_id=? AND active=1";
    private static final String GET_ALL = "SELECT * FROM users_projects";
    private static final String GET_BY_ID = "SELECT * FROM users_projects WHERE id=?";

    @Override
    public boolean save(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(INSERT);

            // Faz o parse do object para User //
            UserProject userProject = (UserProject) obj;

            // Seta os valores //
            ps.setInt(1, userProject.getUserId());
            ps.setInt(2, userProject.getProjectId());
            ps.setInt(3, userProject.getCreatedBy());
            ps.setInt(4, userProject.getUpdatedBy());

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
            System.out.println("Error while saving UserProject: " + e);
        }
        return false;
    }

    @Override
    public boolean update(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(UPDATE);

            // Faz o parse do object para Role //
            UserProject userProject = (UserProject) obj;

            // Seta os valores //
            ps.setInt(1, userProject.getUserId());
            ps.setInt(2, userProject.getProjectId());
            ps.setInt(3, userProject.getUpdatedBy());
            ps.setInt(4, userProject.getId());

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
            System.out.println("Error while updating UserProject: " + e);
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
            System.out.println("Error while updating UserProject: " + e);
        }
        return false;
    }

    @Override
    public ArrayList<Object> getAll() {
        // Inicia o objeto como null //
        ArrayList<Object> usersProjects = new ArrayList<>();

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_ALL);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            UserProject userProject = null;

            while (resultSet.next()) {
                userProject = new UserProject();
                userProject.setId(resultSet.getInt("id"));
                userProject.setUserId(resultSet.getInt("user_id"));
                userProject.setProjectId(resultSet.getInt("project_id"));
                userProject.setCreatedAt(resultSet.getDate("created_at"));
                userProject.setCreatedBy(resultSet.getInt("created_by"));
                userProject.setUpdatedAt(resultSet.getDate("updated_at"));
                userProject.setUpdatedBy(resultSet.getInt("updated_by"));
                userProject.setActive(resultSet.getBoolean("active"));

                usersProjects.add(userProject);
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return usersProjects;
    }

    @Override
    public Object getById(int id) {
        // Inicia o objeto como null //
        UserProject userProject = null;

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_BY_ID);

            // Seta os valores //
            ps.setInt(1, id);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                userProject = new UserProject();
                userProject.setId(resultSet.getInt("id"));
                userProject.setUserId(resultSet.getInt("user_id"));
                userProject.setProjectId(resultSet.getInt("project_id"));
                userProject.setCreatedAt(resultSet.getDate("created_at"));
                userProject.setCreatedBy(resultSet.getInt("created_by"));
                userProject.setUpdatedAt(resultSet.getDate("updated_at"));
                userProject.setUpdatedBy(resultSet.getInt("updated_by"));
                userProject.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return userProject;
    }

    public Object getQuery(String query) {
        UserProject userProject = null;
        try {
            // Cria o statement //
            Statement stmt = ConnectionFactory.getInstance().getConnection().createStatement();
            System.out.println(query);
            // Executa a query e pega o objeto //
            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                userProject = new UserProject();
                userProject.setId(resultSet.getInt("id"));
                userProject.setUserId(resultSet.getInt("user_id"));
                userProject.setProjectId(resultSet.getInt("project_id"));
                userProject.setCreatedAt(resultSet.getDate("created_at"));
                userProject.setCreatedBy(resultSet.getInt("created_by"));
                userProject.setUpdatedAt(resultSet.getDate("updated_at"));
                userProject.setUpdatedBy(resultSet.getInt("updated_by"));
                userProject.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            stmt.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return userProject;
    }
    
    
    public boolean delete(int userId, int projectId) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(DELETE_BY_USER_ID);

            // Seta os valores //
            ps.setInt(1, userId);
            ps.setInt(2, projectId);

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
            System.out.println("Error while updating UserProject: " + e);
        }
        return false;
    }
            
    public ArrayList<Object> getQuerys(String query) {
        // Inicia o objeto como null //
        ArrayList<Object> usersProjects = new ArrayList<>();

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(query);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            UserProject userProject = null;

            while (resultSet.next()) {
                userProject = new UserProject();
                userProject.setId(resultSet.getInt("id"));
                userProject.setUserId(resultSet.getInt("user_id"));
                userProject.setProjectId(resultSet.getInt("project_id"));
                userProject.setCreatedAt(resultSet.getDate("created_at"));
                userProject.setCreatedBy(resultSet.getInt("created_by"));
                userProject.setUpdatedAt(resultSet.getDate("updated_at"));
                userProject.setUpdatedBy(resultSet.getInt("updated_by"));
                userProject.setActive(resultSet.getBoolean("active"));

                usersProjects.add(userProject);
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return usersProjects;
    }
    
    public void lists(JComboBox combobox, int projectId) {

        combobox.removeAllItems();
        
        ArrayList<Object> usersProjects = this.getQuerys("SELECT * FROM users_projects WHERE project_id=" + projectId + " AND active=1;");

        JComboBoxItem item = new JComboBoxItem(0, "Atribuído Para");
        combobox.addItem(item);

        Iterator<Object> iterator = usersProjects.iterator();
        while (iterator.hasNext()) {
            UserProject userProject = (UserProject) iterator.next();
            if(userProject.isActive()){
                item = new JComboBoxItem(userProject.getId(), userProject.getUserName());
                combobox.addItem(item);
            }
        }

    }

}
