/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tableseeder;

/**
 *
 * @author christian
 */
public class DatabaseTableSeeder {

    public static void seed() {
        RoleTableSeeder.seed();
        UserTableSeeder.seed();
        ProjectTypeTableSeeder.seed();
        ProjectTableSeeder.seed();
        IssueTypeTableSeeder.seed();
        IssueStatusTableSeeder.seed();
        IssuePriorityTableSeeder.seed();
    }
    
}
