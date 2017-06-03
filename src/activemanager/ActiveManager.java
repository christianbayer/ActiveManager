/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activemanager;

import classes.User;
import tableseeder.DatabaseTableSeeder;
import telas.Login;
import telas.Main;

/**
 *
 * @author christian
 */
public class ActiveManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Para popular o banco, descomentar a linha abaixo:
//         DatabaseTableSeeder.seed();
        
        Login login = new Login();
        login.setVisible(true);

//        User user = new User("christian", "123456", "teste", "Christian", "Bayer", "", 0, 0);
//        Main main = new Main(user);
//        main.setVisible(true);

//select journals.description as journal_description, 
//issues_types.description as issue_type_description, 
//issues_status.description as issue_status_description, 
//issues_priorities.description as issue_priority_description, 
//CONCAT(users.first_name, ' ', users.last_name) as user_name,
//issues_historics.done_ratio,
//issues_historics.due_date,
//issues_historics.start_date,
//issues_historics.end_date,
//issues_historics.estimated_hours,
//issues_historics.spent_hours,
//issues_historics.parent_issue_id
//from issues_historics 
//left join journals on issues_historics.journal_id = journals.id 
//left join issues_types on issues_historics.issue_type_id = issues_types.id
//left join issues_status on issues_historics.issue_status_id = issues_status.id
//left join issues_priorities on issues_historics.issue_priority_id = issues_priorities.id
//left join users_projects on issues_historics.assigned_user_id = users_projects.id
//left join users on users_projects.user_id = users.id
//where issue_id = 1 order by issues_historics.id;
    }

}
