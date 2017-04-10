/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableseeder;

import classes.Project;
import dao.ProjectDAO;

/**
 *
 * @author christian
 */
public class ProjectTableSeeder {

    public static void seed() {
        ProjectDAO projectDAO = new ProjectDAO();

        Project activeManager = new Project("ActiveManager", "Projeto do ActiveManager, sendo desenvolvido na cadeira de Programação de Aplicações", 1, 2, 0);

        projectDAO.save(activeManager);
    }

}
