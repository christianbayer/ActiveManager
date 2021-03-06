/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableseeder;

import apoio.md5;
import classes.User;
import dao.UserDAO;

/**
 *
 * @author christian
 */
public class UserTableSeeder {

    public static void seed() {
        UserDAO userDAO = new UserDAO();

        User admin = new User("admin", new md5().md5("admin"), "admin@admin.com", "Admin", "", "", 1, 0);
        User christian = new User("christian", new md5().md5("123456"), "christian.bayer@universo.univates.br", "Christian", "Bayer", "", 1, 0);
        User jonathan = new User("jonathan", new md5().md5("123456"), "jonathan@teste.com.br", "Jonathan", "Testão", "", 1, 0);

        userDAO.save(admin);
        userDAO.save(christian);
        userDAO.save(jonathan);
    }
    
}
