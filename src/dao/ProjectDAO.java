package dao;

import classes.Project;
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
public class ProjectDAO implements DAOFactory {

    private static final String INSERT = "INSERT INTO projects (title, description, project_type_id, manager_id, created_by, updated_by) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE projects SET title=?, description=?, project_type_id=?, manager_id=?, updated_by=? WHERE id=?";
    private static final String DELETE = "UPDATE projects SET active=0 WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM projects";
    private static final String GET_BY_ID = "SELECT * FROM projects WHERE id = ?";

    @Override
    public boolean save(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(INSERT);

            // Faz o parse do object para User //
            Project project = (Project) obj;

            // Seta os valores //
            ps.setString(1, project.getTitle());
            ps.setString(2, project.getDescription());
            ps.setInt(3, project.getProjectTypeId());
            ps.setInt(4, project.getManagerId());
            ps.setInt(5, project.getCreatedBy());
            ps.setInt(6, project.getUpdatedBy());

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
            System.out.println("Error while saving Project: " + e);
        }
        return false;
    }

    @Override
    public boolean update(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(UPDATE);

            // Faz o parse do object para Role //
            Project project = (Project) obj;

            // Seta os valores //
            ps.setString(1, project.getTitle());
            ps.setString(2, project.getDescription());
            ps.setInt(3, project.getProjectTypeId());
            ps.setInt(4, project.getManagerId());
            ps.setInt(5, project.getUpdatedBy());
            ps.setInt(6, project.getId());

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
            System.out.println("Error while updating Project: " + e);
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
            System.out.println("Error while updating Project: " + e);
        }
        return false;
    }

    @Override
    public ArrayList<Object> getAll() {
        // Inicia o objeto como null //
        ArrayList<Object> projects = new ArrayList<>();

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_ALL);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            Project project = null;

            while (resultSet.next()) {
                project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setTitle(resultSet.getString("title"));
                project.setDescription(resultSet.getString("description"));
                project.setProjectTypeId(resultSet.getInt("project_type_id"));
                project.setManagerId(resultSet.getInt("manager_id"));
                project.setCreatedAt(resultSet.getDate("created_at"));
                project.setCreatedBy(resultSet.getInt("created_by"));
                project.setUpdatedAt(resultSet.getDate("updated_at"));
                project.setUpdatedBy(resultSet.getInt("updated_by"));
                project.setActive(resultSet.getBoolean("active"));

                projects.add(project);
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return projects;
    }

    @Override
    public Object getById(int id) {
        // Inicia o objeto como null //
        Project project = null;

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_BY_ID);

            // Seta os valores //
            ps.setInt(1, id);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setTitle(resultSet.getString("title"));
                project.setDescription(resultSet.getString("description"));
                project.setProjectTypeId(resultSet.getInt("project_type_id"));
                project.setManagerId(resultSet.getInt("manager_id"));
                project.setCreatedAt(resultSet.getDate("created_at"));
                project.setCreatedBy(resultSet.getInt("created_by"));
                project.setUpdatedAt(resultSet.getDate("updated_at"));
                project.setUpdatedBy(resultSet.getInt("updated_by"));
                project.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return project;
    }

    public Object getQuery(String query) {
        Project project = null;
        try {
            // Cria o statement //
            Statement stmt = ConnectionFactory.getInstance().getConnection().createStatement();
            System.out.println(query);
            // Executa a query e pega o objeto //
            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setTitle(resultSet.getString("title"));
                project.setDescription(resultSet.getString("description"));
                project.setProjectTypeId(resultSet.getInt("project_type_id"));
                project.setManagerId(resultSet.getInt("manager_id"));
                project.setCreatedAt(resultSet.getDate("created_at"));
                project.setCreatedBy(resultSet.getInt("created_by"));
                project.setUpdatedAt(resultSet.getDate("updated_at"));
                project.setUpdatedBy(resultSet.getInt("updated_by"));
                project.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            stmt.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return project;
    }

}
