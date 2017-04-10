/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableseeder;

import classes.IssuePriority;
import dao.IssuePriorityDAO;

/**
 *
 * @author christian
 */
public class IssuePriorityTableSeeder {

    public static void seed() {
        IssuePriorityDAO projectPriorityDAO = new IssuePriorityDAO();

        IssuePriority implementação = new IssuePriority("Baixa", 0);
        IssuePriority bug = new IssuePriority("Normal", 0);
        IssuePriority requisito = new IssuePriority("Alta", 0);
        IssuePriority suporte = new IssuePriority("Urgente", 0);

        projectPriorityDAO.save(implementação);
        projectPriorityDAO.save(bug);
        projectPriorityDAO.save(requisito);
        projectPriorityDAO.save(suporte);
    }

}
