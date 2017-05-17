package dao;

import apoio.JComboBoxItem;
import classes.User;
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
public class UserDAO implements DAOFactory {

    private static final String INSERT = "INSERT INTO users (username, password, email, first_name, last_name, biography, role_id, created_by, updated_by) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE users SET username=?, password=?, email=?, first_name=?, last_name=?, biography=?, role_id=?, updated_by=? WHERE id=?";
    private static final String DELETE = "UPDATE users SET active=0 WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM users WHERE active=1";
    private static final String GET_ALL_TRASHED = "SELECT * FROM users";
    private static final String GET_BY_ID = "SELECT * FROM users WHERE id = ?";

    @Override
    public boolean save(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(INSERT);

            // Faz o parse do object para User //
            User user = (User) obj;

            // Seta os valores //
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getLastName());
            ps.setString(6, user.getBiography());
            ps.setInt(7, user.getRoleId());
            ps.setInt(8, user.getCreatedBy());
            ps.setInt(9, user.getUpdatedBy());

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
            System.out.println("Error while saving User: " + e);
        }
        return false;
    }

    @Override
    public boolean update(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(UPDATE);

            // Faz o parse do object para Role //
            User user = (User) obj;

            // Seta os valores //
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getFirstName());
            ps.setString(5, user.getLastName());
            ps.setString(6, user.getBiography());
            ps.setInt(7, user.getRoleId());
            ps.setInt(8, user.getUpdatedBy());
            ps.setInt(9, user.getId());

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
            System.out.println("Error while updating User: " + e);
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
            System.out.println("Error while updating User: " + e);
        }
        return false;
    }

    @Override
    public ArrayList<Object> getAll() {
        // Inicia o objeto como null //
        ArrayList<Object> users = new ArrayList<>();

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_ALL);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            User user = null;

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setBiography(resultSet.getString("biography"));
                user.setRoleId(resultSet.getInt("role_id"));
                user.setCreatedAt(resultSet.getDate("created_at"));
                user.setCreatedBy(resultSet.getInt("created_by"));
                user.setUpdatedAt(resultSet.getDate("updated_at"));
                user.setUpdatedBy(resultSet.getInt("updated_by"));
                user.setActive(resultSet.getBoolean("active"));
                users.add(user);
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return users;
    }
    
    public ArrayList<Object> getAll(boolean trashed) {
        // Inicia o objeto como null //
        ArrayList<Object> users = new ArrayList<>();

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(trashed ? GET_ALL_TRASHED : GET_ALL);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            User user = null;

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setBiography(resultSet.getString("biography"));
                user.setRoleId(resultSet.getInt("role_id"));
                user.setCreatedAt(resultSet.getDate("created_at"));
                user.setCreatedBy(resultSet.getInt("created_by"));
                user.setUpdatedAt(resultSet.getDate("updated_at"));
                user.setUpdatedBy(resultSet.getInt("updated_by"));
                user.setActive(resultSet.getBoolean("active"));
                users.add(user);
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public Object getById(int id) {
        // Inicia o objeto como null //
        User user = null;

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_BY_ID);

            // Seta os valores //
            ps.setInt(1, id);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setBiography(resultSet.getString("biography"));
                user.setRoleId(resultSet.getInt("role_id"));
                user.setCreatedAt(resultSet.getDate("created_at"));
                user.setCreatedBy(resultSet.getInt("created_by"));
                user.setUpdatedAt(resultSet.getDate("updated_at"));
                user.setUpdatedBy(resultSet.getInt("updated_by"));
                user.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return user;
    }

    public Object getQuery(String query) {
        User user = null;
        try {
            // Cria o statement //
            Statement stmt = ConnectionFactory.getInstance().getConnection().createStatement();
            System.out.println(query);
            // Executa a query e pega o objeto //
            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setBiography(resultSet.getString("biography"));
                user.setRoleId(resultSet.getInt("role_id"));
                user.setCreatedAt(resultSet.getDate("created_at"));
                user.setCreatedBy(resultSet.getInt("created_by"));
                user.setUpdatedAt(resultSet.getDate("updated_at"));
                user.setUpdatedBy(resultSet.getInt("updated_by"));
                user.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            stmt.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return user;
    }

    public void lists(JComboBox combobox, String defaultItem) {

        combobox.removeAllItems();

        JComboBoxItem item = new JComboBoxItem(0, defaultItem);
        combobox.addItem(item);

        ArrayList<Object> users = this.getAll();

        Iterator<Object> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = (User) iterator.next();
            item = new JComboBoxItem(user.getId(), user.getFirstName() + " " + user.getLastName());
            combobox.addItem(item);
        }

    }
}
