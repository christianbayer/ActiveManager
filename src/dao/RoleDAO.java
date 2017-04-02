package dao;

import apoio.ComboboxItem;
import classes.Role;
import connection.ConnectionFactory;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class RoleDAO implements DAOFactory {

    private static final String INSERT = "INSERT INTO roles (description, created_by, updated_by) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE roles SET description=?, updated_by=? WHERE id=?";
    private static final String DELETE = "DELETE FROM roles WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM roles";
    private static final String GET_BY_ID = "SELECT * FROM roles WHERE id = ?";

    @Override
    public boolean save(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(INSERT);

            // Faz o parse do object para Role //
            Role role = (Role) obj;

            // Seta os valores //
            ps.setString(1, role.getDescription());
            ps.setInt(2, role.getCreatedBy());
            ps.setInt(3, role.getUpdatedBy());

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
            System.out.println("Error while saving Role: " + e);
        }
        return false;
    }

    @Override
    public boolean update(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(UPDATE);

            // Faz o parse do object para Role //
            Role role = (Role) obj;

            // Seta os valores //
            ps.setString(1, role.getDescription());
            ps.setInt(2, role.getUpdatedBy());
            ps.setInt(3, role.getId());

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
            System.out.println("Error while updating Role: " + e);
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
        ArrayList<Object> roles = new ArrayList<>();

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_ALL);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            Role role = null;

            while (resultSet.next()) {
                role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setDescription(resultSet.getString("description"));
                role.setCreatedAt(resultSet.getDate("created_at"));
                role.setCreatedBy(resultSet.getInt("created_by"));
                role.setUpdatedAt(resultSet.getDate("updated_at"));
                role.setUpdatedBy(resultSet.getInt("updated_by"));
                role.setActive(resultSet.getBoolean("active"));

                roles.add(role);
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return roles;
    }

    @Override
    public Object getById(int id) {
        // Inicia o objeto como null //
        Role role = null;

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_BY_ID);

            // Seta os valores //
            ps.setInt(1, id);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                role = new Role();
                role.setId(resultSet.getInt("id"));
                role.setDescription(resultSet.getString("description"));
                role.setCreatedAt(resultSet.getDate("created_at"));
                role.setCreatedBy(resultSet.getInt("created_by"));
                role.setUpdatedAt(resultSet.getDate("updated_at"));
                role.setUpdatedBy(resultSet.getInt("updated_by"));
                role.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return role;
    }

    public void lists(JComboBox combobox) {

        combobox.removeAllItems();

        ComboboxItem item = new ComboboxItem(0, "Papel");
        combobox.addItem(item);

        ArrayList<Object> roles = this.getAll();

        Iterator<Object> iterator = roles.iterator();
        while (iterator.hasNext()) {
            Role role = (Role) iterator.next();
            item = new ComboboxItem(role.getId(), role.getDescription());
            combobox.addItem(item);
        }

    }

}
