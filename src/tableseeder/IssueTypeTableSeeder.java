/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableseeder;

import classes.IssueType;
import dao.IssueTypeDAO;

/**
 *
 * @author christian
 */
public class IssueTypeTableSeeder {

    public static void seed() {
        IssueTypeDAO projectTypeDAO = new IssueTypeDAO();

        IssueType implementação = new IssueType("Implementação", 0);
        IssueType bug = new IssueType("Bug", 0);
        IssueType requisito = new IssueType("Requisito", 0);
        IssueType suporte = new IssueType("Suporte", 0);

        projectTypeDAO.save(implementação);
        projectTypeDAO.save(bug);
        projectTypeDAO.save(requisito);
        projectTypeDAO.save(suporte);
    }

}
