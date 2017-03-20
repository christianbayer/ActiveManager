/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author christian
 */
public class ConnectionFactory {
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String SERVER = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "active_manager";
    private static final String URL = "jdbc:mysql://" + SERVER + ":" + PORT + "/" + DATABASE;
    private static final String USER = "root";
    private static final String PASSWORD = "b99d41";
    private static ConnectionFactory instance = null;
    private Connection connection = null;
    
    // Construtor da conexão
    public ConnectionFactory() {
        try {
            // Carrega Driver do Banco de Dados
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    
    // Retorna instância
    public static ConnectionFactory getInstance() {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }
    
    // Retorna conexão
    public Connection getConnection() {
        if (connection == null) {
            throw new RuntimeException("conexao==null");
        }
        return connection;
    }
    
    // Efetua fechamento da conexão
    public void closeConnection() {
        try {
            connection.close();
            instance = null;
            connection = null;
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
