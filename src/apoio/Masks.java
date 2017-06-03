/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author christian
 */
public class Masks {

    public void integer(JTextField jTextField) {
        jTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!(Character.isDigit(c)) && (c != '\b')) {
                    ke.consume();
                } else if (jTextField.getText().length() > 7) {
                    ke.consume();
                }
            }
        });
    }

    public void date(JTextField jTextField) {
        jTextField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent ke) {
                char c = ke.getKeyChar();
                if (!(Character.isDigit(c)) && (c != '\b')) {
                    ke.consume();
                } else {
                    int size = jTextField.getText().length();
                    if (size == 2) {
                        jTextField.setText(jTextField.getText() + "/");
                    } else if ((size == 3 || size == 6) && c == '\b') {
                        jTextField.setText("" + jTextField.getText().substring(0, jTextField.getText().length() - 1));
                    } else if (size == 5) {
                        jTextField.setText(jTextField.getText() + "/");
                    } else if (size > 9) {
                        ke.consume();
                    }
                }
            }
        });
    }

}
