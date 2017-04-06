/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activemanager;

import classes.User;
import telas.Login;
import telas.Main;

/**
 *
 * @author christian
 */
public class ActiveManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

//        Login login = new Login();
//        login.setVisible(true);
        User user = new User("christian", "123456", "teste", "Christian", "Bayer", "", 0, 0);
        Main main = new Main(user);
        main.setVisible(true);
    }

}
