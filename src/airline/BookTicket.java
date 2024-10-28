/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline;


import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class BookTicket extends JFrame{
    String quantity,availableSeats;
    
    public static void main(String[] args){
        new BookTicket();
    }
    
    public BookTicket(){
         setTitle("BOOK A TICKET");
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLayout(null);
	setVisible(true);
        
        JLabel l=new JLabel("TICKET BOOKING");
        l.setFont(new Font("Tahoma",Font.PLAIN,30));
        l.setBounds(150,60,300,30);
	add(l);
        
	JLabel l1= new JLabel("Name");
	l1.setFont(new Font("Tahoma", Font.PLAIN, 19));
	l1.setBounds(60, 120, 200, 27);
	add(l1);
        
        JTextField  t1 = new JTextField();
        t1.setBounds(250, 120, 200, 30);
	add(t1);
        
        JLabel l2= new JLabel("Passport Number");
	l2.setFont(new Font("Tahoma", Font.PLAIN, 19));
	l2.setBounds(60, 170, 200, 27);
	add(l2);
        
        JTextField  t2= new JTextField();
        t2.setBounds(250, 170, 200, 30);
	add(t2);
        
        JLabel l3= new JLabel("Flight Number");
	l3.setFont(new Font("Tahoma", Font.PLAIN, 19));
	l3.setBounds(60, 220, 200, 27);
	add(l3);
        
        JTextField  t3= new JTextField();
        t3.setBounds(250, 220, 200, 30);
	add(t3);
        
        JLabel l4= new JLabel("Number of Tickets");
	l4.setFont(new Font("Tahoma", Font.PLAIN, 19));
	l4.setBounds(60, 270, 200, 27);
	add(l4);
        
        JTextField  t4= new JTextField();
        t4.setBounds(250, 270, 200, 30);
	add(t4);
        
        JLabel NewLabel = new JLabel("");
             NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/proceed.jpg")));
	    NewLabel.setBounds(500, 90, 300, 170); 
	     add(NewLabel); 
        
        JButton Proceed = new JButton("Proceed");
	Proceed.setBounds(500, 270, 200, 30);
	add(Proceed);
        
        JLabel l6= new JLabel("Source");
	l6.setFont(new Font("Tahoma", Font.PLAIN, 19));
	l6.setBounds(60, 370, 200, 27);
	add(l6);
        
        JTextField  t6 = new JTextField();
        t6.setBounds(250, 370, 200, 30);
	add(t6);
        
        JLabel l7= new JLabel("Destination");
	l7.setFont(new Font("Tahoma", Font.PLAIN, 19));
	l7.setBounds(60, 420, 200, 27);
	add(l7);
        
        JTextField  t7 = new JTextField();
        t7.setBounds(250, 420, 200, 30);
	add(t7);
        
         JLabel l5= new JLabel("Cost");
	l5.setFont(new Font("Tahoma", Font.PLAIN, 19));
	l5.setBounds(60, 470, 200, 27);
	add(l5);
        
        JTextField  t5 = new JTextField();
        t5.setBounds(250, 470, 200, 30);
	add(t5);
        
         JLabel l8= new JLabel("Total Cost");
	l8.setFont(new Font("Tahoma", Font.PLAIN, 19));
	l8.setBounds(60, 520, 200, 27);
	add(l8);
        
        JTextField  t8= new JTextField();
        t8.setBounds(250, 520, 200, 30);
	add(t8);
        
        
         Proceed.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
              
                try {
                    conn c = new conn();
                    String str2="select availableSeats from flights where flightNumber='"+t3.getText()+"'";
                    ResultSet rs1=c.s.executeQuery(str2);
                    
                    if(rs1.next())
                    {
                        availableSeats=rs1.getString(1);
                       // System.out.println(availableSeats);
                    }
                    if(Integer.parseInt(availableSeats)>=Integer.parseInt(t4.getText()))
                    {
                    String str="select source,destination,fare from flights where flightNumber='"+t3.getText()+"'";
                    ResultSet rs=c.s.executeQuery(str);
                    if(rs.next()){
                        t6.setText(rs.getString(1));
                        t7.setText(rs.getString(2));
                        t5.setText(rs.getString(3));
                    }
                    }
                     else
                    {
                        JOptionPane.showMessageDialog(null, "'"+t4.getText()+"' seats not avilable check availability");
                        System.exit(0);
                     }
                
      
                }catch(SQLException e){
                    e.printStackTrace();
                }
        String c=t5.getText();
        String n=t4.getText();
        Float t=Float.parseFloat(c)*Integer.parseInt(n);
        t8.setText(Float.toString(t));
			}
		});
        
            JLabel NewLabel1 = new JLabel("");
             NewLabel1.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/book.jpg")));
	     NewLabel1.setBounds(500, 350, 300, 170); 
	     add(NewLabel1); 
        
         
        
        JButton Book = new JButton("Book");
	Book.setBounds(500, 520, 200, 30);
	add(Book);
        
        Book.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
                
                              String name = t1.getText();
                              String passport_no = t2.getText();
                              String flightNumber = t3.getText();
                              String source = t6.getText();
                              String destination= t7.getText();
                              String quantity= t4.getText();
                              String totalcost= t8.getText();
                
                try {
                    conn c = new conn();
                    String str = "insert into BookedTickets values('"+name+"','"+passport_no+"','"+flightNumber+"','"+source+"','"+destination+"','"+quantity+"','"+totalcost+"')";
                    c.s.executeUpdate(str);
                    
                  
                        String str1="Update flights set availableSeats=availableSeats-'"+quantity+"' where flightNumber='"+flightNumber+"'";
                        c.s.executeUpdate(str1);
                    
                     JOptionPane.showMessageDialog(null, "Ticket Booked Successfully");
                    
                     
      
                }catch(SQLException e){
                    e.printStackTrace();
                }
                new Mainframe().setVisible(true);
			}
		});
        
         setSize(800,650);
         setLocation(400,200);
    } 
     
}
