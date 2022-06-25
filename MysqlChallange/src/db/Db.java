/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

import com.mysql.cj.MysqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import static javafx.application.Platform.exit;

/**
 *
 * @author yc_ke
 */

public class Db {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        Tools t = new Tools();
        try{
        Connection myConn = t.getConnection();
        Statement myStat =(Statement)myConn.createStatement();
        PreparedStatement myStat2 =null ;
        
        
      
        
        int select1=6,select2=15;
        Scanner myObj = new Scanner(System.in);
        while(select1!=5){
        System.out.println("\nDisplay-1 \nAdd Department-2\nModify the budget from the department table-3\nRemove The Department-4\nQuit-5");
        select1=myObj.nextInt();
        if(select1==1){
            System.out.println("Which Table do you want to see ?"); 
            System.out.println("advisor-1\nClassroom-2\nCourse-3\nDepartment-4\nInstructor-5\nPrereq-6\nSection-7\nStudent-8\nTakes-9\nTeaches-10\nTime Slot-11\nQuit-12");
            while(select2!=12){
                select2=myObj.nextInt();
                if(select2==1){
                 ResultSet myRs=myStat.executeQuery("select * from advisor");  
                 while(myRs.next()){
                     System.out.println("s_ID  :"+myRs.getString("s_ID")+" - i_ID  :"+myRs.getString("i_ID"));
                 }
                }
                if(select2==2){
                 ResultSet myRs=myStat.executeQuery("select * from classroom");  
                 while(myRs.next()){
                     System.out.println("building  :"+myRs.getString("building")+" - room_number  :"+myRs.getString("room_number")
                             +" - capacity  :"+myRs.getString("capacity"));
                 }
                }
                if(select2==3){
                 ResultSet myRs=myStat.executeQuery("select * from course");  
                 while(myRs.next()){
                     System.out.println("course_id  :"+myRs.getString("course_id")+" - title  :"+myRs.getString("title")
                             +" - dept_name  :"+myRs.getString("dept_name")+" - credits  :"+myRs.getString("credits"));
                 }
                }
                if(select2==4){
                 ResultSet myRs=myStat.executeQuery("select * from department");  
                 while(myRs.next()){
                     System.out.println("dept_name  :"+myRs.getString("dept_name")+" - building  :"+myRs.getString("building")
                             +" - budget  :"+myRs.getString("budget"));
                 }
                }
                if(select2==5){
                 ResultSet myRs=myStat.executeQuery("select * from instructor");  
                 while(myRs.next()){
                     System.out.println("ID  :"+myRs.getString("ID")+" - name  :"+myRs.getString("name")
                             +" - dept_name  :"+myRs.getString("dept_name")+" - salary  :"+myRs.getString("salary"));
                 }
                }
                if(select2==6){
                 ResultSet myRs=myStat.executeQuery("select * from prereq");  
                 while(myRs.next()){
                     System.out.println("course_id  :"+myRs.getString("course_id")+" - prereq_id  :"+myRs.getString("prereq_id"));
                 }
                }
                if(select2==7){
                 ResultSet myRs=myStat.executeQuery("select * from section");  
                 while(myRs.next()){
                     System.out.println("course_id  :"+myRs.getString("course_id")+" - sec_id  :"+myRs.getString("sec_id")
                     +" - semester  :"+myRs.getString("semester")+" - year  :"+myRs.getString("year")+" - building  :"+myRs.getString("building")
                     +" - room_number  :"+myRs.getString("room_number")+" - time_slot_id  :"+myRs.getString("time_slot_id"));
                 }
                }
                if(select2==8){
                 ResultSet myRs=myStat.executeQuery("select * from student");  
                 while(myRs.next()){
                     System.out.println("ID  :"+myRs.getString("ID")+" - name  :"+myRs.getString("name")
                     +" - dept_name  :"+myRs.getString("dept_name")+" - tot_cred  :"+myRs.getString("tot_cred"));
                 }
                }
                 if(select2==9){
                 ResultSet myRs=myStat.executeQuery("select * from takes");  
                 while(myRs.next()){
                     System.out.println("ID  :"+myRs.getString("ID")+" - course_id  :"+myRs.getString("course_id")
                     +" - sec_id  :"+myRs.getString("sec_id")+" - semester  :"+myRs.getString("semester")+" - year  :"+myRs.getString("year")
                     +" - grade  :"+myRs.getString("grade"));
                 }
                }
                 if(select2==10){
                 ResultSet myRs=myStat.executeQuery("select * from teaches");  
                 while(myRs.next()){
                     System.out.println("ID  :"+myRs.getString("ID")+" - course_id  :"+myRs.getString("course_id")
                     +" - sec_id  :"+myRs.getString("sec_id")+" - semester  :"+myRs.getString("semester")+" - year  :"+myRs.getString("year"));
                 }
                }
                 if(select2==11){
                 ResultSet myRs=myStat.executeQuery("select * from time_slot");  
                 while(myRs.next()){
                     System.out.println("time_slot_id  :"+myRs.getString("time_slot_id")+" - day  :"+myRs.getString("day")
                     +" - start_hr  :"+myRs.getString("start_hr")+" - start_min  :"+myRs.getString("start_min")+" - end_hr  :"+myRs.getString("end_hr")
                     +" - end_min  :"+myRs.getString("end_min"));
                 }
                }
                 if(select2==12){
                break;
                }
                 
            }
        }
        if(select1==2){
            System.out.println("You will create Departmant. Please enter value of Departmant table");
            System.out.println("departman Name :");
            String dept_name=myObj.next();
            System.out.println("Building :");
            String building=myObj.next();
            System.out.println("Budget :");
            double budget =myObj.nextDouble();
            myStat2 = myConn.prepareStatement("insert  into assignment.department (dept_name,building,budget) "+"values(?,?,?)");
            myStat2.setString(1, dept_name);
            myStat2.setString(2, building);
            myStat2.setDouble(3, budget);
            myStat2.executeUpdate();
        }
        if(select1==3){
             ResultSet myRs=myStat.executeQuery("select * from department");  
                 while(myRs.next()){
                     System.out.println("dept_name  :"+myRs.getString("dept_name")+" - building  :"+myRs.getString("building")
                             +" - budget  :"+myRs.getString("budget"));
                 }
            
            System.out.println("You will change budget of department. pls Enter deparment name : ");
            String DepartmentName=myObj.next();
            System.out.println("Pls write Budget");
            Double DepartmentBudget=myObj.nextDouble();
            myStat.executeUpdate("UPDATE department SET budget="+DepartmentBudget+" WHERE dept_name='"+DepartmentName+"' ");
            


        }
        if(select1==4){
            ResultSet myRs=myStat.executeQuery("select * from department");  
                 while(myRs.next()){
                     System.out.println("dept_name  :"+myRs.getString("dept_name")+" - building  :"+myRs.getString("building")
                             +" - budget  :"+myRs.getString("budget"));
                 }
                 
            System.out.println("Please write departmant name that You want to remove");
            String RemovedDepartman = myObj.next();
            System.out.println("Are you sure ? Yy/Nn");
            String Flag= myObj.next();
            if(Flag.equals("y")||Flag.equals("Y")||Flag.equals("yes")){
             myStat.executeUpdate("DELETE FROM department WHERE dept_name='"+RemovedDepartman+"' ");   
            }
        }
        if(select1==5){
            exit();
        }
        
        
        
        
        
        
        
    }
        }
        catch(SQLException exception){
            t.ShowError(exception);
        }
        
           }
    
    
}
