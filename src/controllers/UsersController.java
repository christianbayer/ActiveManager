/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import classes.User;
import dao.UserDAO;
import java.util.ArrayList;
import javax.swing.JTable;

/**
 *
 * @author christian
 */
public class UsersController {

    private UserDAO userDAO = new UserDAO();

    public boolean login(String username, String password) {

        String query = "SELECT * FROM users WHERE username=\"" + username + "\"";
        User user = (User) userDAO.getQuery(query);
        if (user == null) {
            return false;
        } else {
            return user.getPassword().equals(password);
        }
    }

//    public ArrayList<User> popularTabela() {
//        ArrayList<Object> users = userDAO.getAll();
//
//        for(Object o : users) {
//            ((User) o).getFirstName();
//        }
        
//        ArrayList<User> users = new ArrayList();
//        for (int i = 0; i < objUsers.size(); i++) {
//            users.add((User) objUsers.get(i));
//        }

//        System.out.println(users.get(1).getFirstName());
//        return users;

//    }

}
