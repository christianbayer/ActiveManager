/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableseeder;

import classes.IssueStatus;
import dao.IssueStatusDAO;

/**
 *
 * @author christian
 */
public class IssueStatusTableSeeder {

    public static void seed() {
        IssueStatusDAO projectStatusDAO = new IssueStatusDAO();

        IssueStatus nova = new IssueStatus("Nova", 0);
        IssueStatus emAndamento = new IssueStatus("Em andamento", 0);
        IssueStatus pausada = new IssueStatus("Pausada", 0);
        IssueStatus resolvida = new IssueStatus("Resolvida", 0);
        IssueStatus fechada = new IssueStatus("Fechada", 0);

        projectStatusDAO.save(nova);
        projectStatusDAO.save(emAndamento);
        projectStatusDAO.save(pausada);
        projectStatusDAO.save(resolvida);
        projectStatusDAO.save(fechada);
    }

}
