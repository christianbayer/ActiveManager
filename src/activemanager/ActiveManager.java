/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activemanager;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
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

        try {
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("JosefinSans-Thin.ttf")));
        } catch (IOException | FontFormatException e) {
            //
        }

        Login login = new Login();
        Main main = new Main();

//        login.setVisible(true);
        main.setVisible(true);
    }

}
