/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import javax.swing.JCheckBox;

/**
 *
 * @author christian
 */
public class JCheckBoxValue extends JCheckBox {
    private int value;

    public JCheckBoxValue() {
    }

    public JCheckBoxValue(String text) {
        super(text);
    }

    public JCheckBoxValue(String text, int value) {
        super(text);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
}
