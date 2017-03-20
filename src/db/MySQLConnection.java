/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author christian
 */
public class MySQLConnection {

    public static String status = "Não conectou...";

    //Método Construtor da Classe//
    public MySQLConnection() {
       getMySQLConnection();
        System.out.println(connectionStatus());
    }

    // Método de Conexão//
    public static java.sql.Connection getMySQLConnection() {
        Connection connection = null; // atributo do tipo Connection
        try {
            // Carregando o JDBC Driver padrão //
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
            // Configurando a nossa conexão com um banco de dados //
            String serverName = "localhost"; // caminho do servidor do BD
            String database = "active_manager"; // nome do seu banco de dados
            String url = "jdbc:mysql://" + serverName + "/" + database;
            String username = "root"; // nome de um usuário de seu BD      
            String password = "b99d41"; // sua senha de acesso
            connection = DriverManager.getConnection(url, username, password);

            //Testa sua conexão//  
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão");
            }
            return connection;
        } catch (ClassNotFoundException e) {
            // Driver não encontrado //
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            // Não conseguindo se conectar ao banco //
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");
            return null;
        }
    }

    // Método que retorna o status da sua conexão //
    public static String connectionStatus() {
        return status;
    }

    // Método que fecha sua conexão //
    public static boolean closeConnection() {
        try {
            MySQLConnection.getMySQLConnection().close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    // Método que reinicia sua conexão //
    public static java.sql.Connection reloadConnection() {
        closeConnection();
        return MySQLConnection.getMySQLConnection();
    }
}
