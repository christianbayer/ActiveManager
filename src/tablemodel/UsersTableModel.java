/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tablemodel;

import classes.User;
import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author christian
 */
public class UsersTableModel implements TableModel{

    ArrayList<User> users;

    public UsersTableModel(ArrayList<User> users) {
        this.users = users;
    }
    
    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public String getColumnName(int columnIndex) {
        String[] columns = {"ID", "Nome", "Sobrenome", "Email", "Papel", "Ativo"};
        return columns[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return users.get(rowIndex).getId();
            case 1:
                return users.get(rowIndex).getFirstName();
            case 2:
                return users.get(rowIndex).getLastName();
            case 3:
                return users.get(rowIndex).getEmail();
            case 4:
                return users.get(rowIndex).getRoleId();
            case 5:
                return users.get(rowIndex).isActive();
            default:
                break;
        }
        return "xx";
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
    }
    
}
