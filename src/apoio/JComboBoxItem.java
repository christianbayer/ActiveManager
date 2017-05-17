/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import javax.swing.JComboBox;

/**
 *
 * @author christian
 */
public class JComboBoxItem {

    private int key;
    private String value;

    public JComboBoxItem() {
    }

    public JComboBoxItem(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public void setSelectedItem(JComboBox combobox, int key) {
        for (int i = 0; i < combobox.getItemCount(); i++) {
            if (((JComboBoxItem) combobox.getItemAt(i)).getKey() == key) {
                combobox.setSelectedIndex(i);
                return;
            }
        }
    }
}
