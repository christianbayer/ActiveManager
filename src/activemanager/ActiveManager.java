/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activemanager;

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
        Login login = new Login();
        Main main = new Main();

//        login.setVisible(true);
        main.setVisible(true);
    }
    
}
