/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableseeder;

import classes.Role;
import dao.RoleDAO;

/**
 *
 * @author christian
 */
public class RoleTableSeeder {

    public static void seed() {
        RoleDAO roleDAO = new RoleDAO();

        Role administrador = new Role("Administrador", 0);
        Role gerente = new Role("Gerente", 0);
        Role desenvolvedor = new Role("Desenvolvedor", 0);
        Role designer = new Role("Designer", 0);
        
        roleDAO.save(administrador);
        roleDAO.save(gerente);
        roleDAO.save(desenvolvedor);
        roleDAO.save(designer);
    }
    
}
