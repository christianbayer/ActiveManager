package dao;

import classes.Journal;
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
public class JournalDAO implements DAOFactory {

    private static final String INSERT = "INSERT INTO journals (description, created_by, updated_by) VALUES (?, ?, ?)";
    private static final String DELETE = "UPDATE journals SET active=0 WHERE id=?";
    private static final String GET_ALL = "SELECT * FROM journals";
    private static final String GET_BY_ID = "SELECT * FROM journals WHERE id=?";

    @Override
    public boolean save(Object obj) {
        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(INSERT);

            // Faz o parse do object para Journal //
            Journal journal = (Journal) obj;

            // Seta os valores //
            ps.setString(1, journal.getDescription());
            ps.setInt(2, journal.getCreatedBy());
            ps.setInt(3, journal.getUpdatedBy());

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
            System.out.println("Error while saving Journal: " + e);
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
            System.out.println("Error while updating IssuePriority: " + e);
        }
        return false;
    }

    @Override
    public ArrayList<Object> getAll() {
        // Inicia o objeto como null //
        ArrayList<Object> journals = new ArrayList<>();

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_ALL);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            Journal journal = null;

            while (resultSet.next()) {
                journal = new Journal();
                journal.setId(resultSet.getInt("id"));
                journal.setDescription(resultSet.getString("description"));
                journal.setCreatedAt(resultSet.getDate("created_at"));
                journal.setCreatedBy(resultSet.getInt("created_by"));
                journal.setUpdatedAt(resultSet.getDate("updated_at"));
                journal.setUpdatedBy(resultSet.getInt("updated_by"));
                journal.setActive(resultSet.getBoolean("active"));

                journals.add(journal);
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }

        return journals;
    }

    @Override
    public Object getById(int id) {
        // Inicia o objeto como null //
        Journal journal = null;

        try {
            // Cria o statement //
            PreparedStatement ps = ConnectionFactory.getInstance().getConnection().prepareStatement(GET_BY_ID);

            // Seta os valores //
            ps.setInt(1, id);

            // Executa a query e pega o objeto //
            ResultSet resultSet = ps.executeQuery();

            if (resultSet.next()) {
                journal = new Journal();
                journal.setId(resultSet.getInt("id"));
                journal.setDescription(resultSet.getString("description"));
                journal.setCreatedAt(resultSet.getDate("created_at"));
                journal.setCreatedBy(resultSet.getInt("created_by"));
                journal.setUpdatedAt(resultSet.getDate("updated_at"));
                journal.setUpdatedBy(resultSet.getInt("updated_by"));
                journal.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            ps.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return journal;
    }

    public Object getQuery(String query) {
        Journal journal = null;
        try {
            // Cria o statement //
            Statement stmt = ConnectionFactory.getInstance().getConnection().createStatement();
            System.out.println(query);
            // Executa a query e pega o objeto //
            ResultSet resultSet = stmt.executeQuery(query);

            if (resultSet.next()) {
                journal = new Journal();
                journal.setId(resultSet.getInt("id"));
                journal.setDescription(resultSet.getString("description"));
                journal.setCreatedAt(resultSet.getDate("created_at"));
                journal.setCreatedBy(resultSet.getInt("created_by"));
                journal.setUpdatedAt(resultSet.getDate("updated_at"));
                journal.setUpdatedBy(resultSet.getInt("updated_by"));
                journal.setActive(resultSet.getBoolean("active"));
            }

            // Encerra o statement //
            resultSet.close();
            stmt.close();

        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return journal;
    }


}
