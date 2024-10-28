/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline;
//package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;


public class Cancel extends JFrame { //Sixth
    
    private JTextField textField,textField_1,textField_2,textField_3,textField_4;
    String Quantity1,fare;
    public static void main(String[] args) {
        new Cancel();
    }
    
    public Cancel() {
        initialize();
    }
    
    private void initialize() {
        setTitle("CANCELLATION");
	getContentPane().setBackground(Color.WHITE);
	setBounds(100, 100, 801, 472);
	setLayout(null);
		
	JLabel Cancellation = new JLabel("CANCELLATION");
	Cancellation.setFont(new Font("Tahoma", Font.PLAIN, 31));
	Cancellation.setBounds(185, 24, 259, 38);
	add(Cancellation);
		
	
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/cancel.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(470, 100, 250, 250);
	add(NewLabel);
		
	JLabel PassportNo = new JLabel("PASSPORT NO");
	PassportNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
	PassportNo.setBounds(60, 100, 132, 26);
	add(PassportNo);
		
	JLabel FlightNumber = new JLabel("FLIGHT NO");
	FlightNumber.setFont(new Font("Tahoma", Font.PLAIN, 17));
	FlightNumber.setBounds(60, 150, 150, 27);
	add(FlightNumber);
		
	JLabel NoOfTickets = new JLabel("NO OF TICKETS");
	 NoOfTickets.setFont(new Font("Tahoma", Font.PLAIN, 17));
	 NoOfTickets.setBounds(60, 200, 180, 27);
	add( NoOfTickets);
		
	/*JLabel Ticketid = new JLabel("TICKET_ID");
	Ticketid.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Ticketid.setBounds(60, 250, 150, 27);
	add(Ticketid);
		
	JLabel Flightcode = new JLabel("FLIGHT_CODE");
	Flightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Flightcode.setBounds(60, 300, 150, 27);
	add(Flightcode);*/
		
	JButton Cancel = new JButton("CANCEL");
	Cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
	Cancel.setBounds(250, 350, 150, 30);
	add(Cancel);
		
	textField = new JTextField();
	textField.setBounds(250, 100, 150, 27);
	add(textField);
	
        textField_1 = new JTextField();
	textField_1.setBounds(250, 150, 150, 27);
	add(textField_1);
		
	textField_2 = new JTextField();
	textField_2.setBounds(250, 200, 150, 27);
	add(textField_2);
	
        /*textField_3 = new JTextField();
	textField_3.setBounds(250, 250, 150, 27);
	add(textField_3);
		
	textField_4 = new JTextField();
	textField_4.setBounds(250, 300, 150, 27);
	add(textField_4);*/
	
        Cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
                String passport_no = textField.getText();
		String flightNumber = textField_1.getText();
		String Tickets= textField_2.getText();
                
           
					
	try{
            
                  conn c1=new conn();
                
                  //  String str = "INSERT INTO cancellation values('"+passenger_no+"', '"+cancellation_no+"', '"+cancellation_date+"', '"+ticket_id+"', '"+flight_code+"')";
		  String str1="select Quantity from BookedTickets where flightNumber='"+flightNumber+"'";
                  ResultSet rs=c1.s.executeQuery(str1);
                  if(rs.next())
                  {
                      Quantity1=rs.getString(1);
                      System.out.println(Quantity1);
                  }
                  if(Integer.parseInt(Tickets)<=Integer.parseInt(Quantity1))
                  {
                  String str ="Update flights set availableseats=availableSeats+'"+ Tickets+"' where flightNumber='"+flightNumber+"'";
                    c1.s.executeUpdate(str);
                    String str2 ="Update BookedTickets set Quantity=Quantity-'"+Tickets+"' where Passport_NO='"+passport_no+"' and flightNumber='"+flightNumber+"'";
                    c1.s.executeUpdate(str2);
                    String str3="select fare from flights where flightNumber='"+flightNumber+"'";
                    ResultSet rs1=c1.s.executeQuery(str3);
                    if(rs1.next())
                    {
                        fare=rs1.getString(1);
                    }
                    String n=textField_2.getText();
                    Float cost=Float.parseFloat(fare)*Integer.parseInt(n);
                    String str4="Update BookedTickets set cost=cost-'"+cost+"' where flightNumber='"+flightNumber+"' and Passport_NO='"+passport_no+"'";
                    c1.s.executeUpdate(str4);
                    JOptionPane.showMessageDialog(null,"Ticket Canceled");
                  
                    setVisible(false);
                    new Mainframe().setVisible(true);
                    
                  }
                  else
                  {
                      JOptionPane.showMessageDialog(null,"You have booked only '"+Quantity1+"' tickets");
                      
                  }
                  
						
		}catch (Exception e) {
                    e.printStackTrace();
                }
            }
            
        });
			
	setSize(860,500);
	setVisible(true);
        setLocation(400,200);
    }
}

