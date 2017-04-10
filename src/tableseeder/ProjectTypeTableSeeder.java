/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableseeder;

import classes.ProjectType;
import dao.ProjectTypeDAO;

/**
 *
 * @author christian
 */
public class ProjectTypeTableSeeder {

    public static void seed() {
        ProjectTypeDAO projectTypeDAO = new ProjectTypeDAO();

        ProjectType softwareDesktop = new ProjectType("Software Desktop", 0);
        ProjectType softwareWeb = new ProjectType("Software Web", 0);
        ProjectType site = new ProjectType("Site", 0);

        projectTypeDAO.save(softwareDesktop);
        projectTypeDAO.save(softwareWeb);
        projectTypeDAO.save(site);
    }

}
