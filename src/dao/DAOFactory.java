/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;

/**
 *
 * @author christian
 */
public interface DAOFactory {
    
    public boolean save(Object obj);

    public boolean update(Object obj);

    public boolean delete(int id);

    public ArrayList<Object> getAll();

    public Object getById(int id);
    
}
