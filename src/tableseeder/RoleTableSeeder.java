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

        Role admin = new Role("Admin", 0);
        Role gerente = new Role("Gerente", 0);
        Role desenvolvedor = new Role("Desenvolvedor", 0);
        
        roleDAO.save(admin);
        roleDAO.save(gerente);
        roleDAO.save(desenvolvedor);
    }
    
}
