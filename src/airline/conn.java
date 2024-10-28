/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline;


import java.sql.*;  

public class conn{
    Connection c;
    Statement s;
     conn(){  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tse25","root","root123");    
            s =c.createStatement(); 
           
          
            
        }catch(Exception e){ 
           // System.out.println(e);
           e.printStackTrace();
        }  
    } 
     public static void  main(String args[])
     {
         new conn();
     }
}  