/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;
import java.sql.*;
/**
 *
 * @author 82NC00FRIN
 */
public class SearchFlight extends JFrame{
    JTable table;
    JLabel ReservationDetails,Pnrno,Ticketid,Fcode,Jnydate,Jnytime,Source,Destination,label,label1,FlightNumber;
    JButton Show,Book;
    JTextField textField;

    public static void main(String[] args){
        new SearchFlight();
    }
    
    public SearchFlight(){
        
        setTitle("SEARCH A FLIGHT");
	getContentPane().setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setLayout(null);
		
	Source = new JLabel("SOURCE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Source.setBounds(60, 100, 150, 27);
	add(Source);
	
        Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 19));
	Destination.setBounds(350, 100, 150, 27);
	add(Destination);
		
	
		
	Show = new JButton("Check Availability");
	Show.setBounds(680, 100, 200, 30);
	add(Show);

	setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	ReservationDetails = new JLabel("FLIGHT AVAILABLE DETAILS");
	ReservationDetails.setForeground(Color.BLUE);
	ReservationDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	ReservationDetails.setBounds(280, 27, 500, 31);
	add(ReservationDetails);
		
	Pnrno = new JLabel("Flight_NO");
	Pnrno.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Pnrno.setBounds(79, 270, 83, 20);
	add(Pnrno);
		
	Ticketid = new JLabel("Source");
	Ticketid.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Ticketid.setBounds(172, 270, 71, 20);
	add(Ticketid);
		
	Fcode = new JLabel("Destination");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Fcode.setBounds(297, 270, 103, 20);
	add(Fcode);
		
	Jnydate = new JLabel("Departure TIme");
	Jnydate.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Jnydate.setBounds(390, 270, 94, 20);
	add(Jnydate);
		
	Jnytime = new JLabel("Fare");
	Jnytime.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Jnytime.setBounds(494, 270, 83, 20);
	add(Jnytime);
		
	Source = new JLabel("Available Seats");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Source.setBounds(613, 270, 94, 20);
	add(Source);
		
	
	String[] items1 =  {"Rajahmundry", "Hyderabad", "Vijayawada", "Bangalore","Chennai"};
	JComboBox comboBox = new JComboBox(items1);
	comboBox.setBounds(150, 100, 150, 27);
	add(comboBox);
		
		
	String[] items2 =  {"Rajahmundry", "Hyderabad", "Vijayawada", "Bangalore","Chennai"};
	JComboBox comboBox_1 = new JComboBox(items2);
	comboBox_1.setBounds(500, 100, 150, 27);
	add(comboBox_1);
        
        table = new JTable();
	table.setBounds(38, 310, 770, 130);
	add(table);
	
		
		
	Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		try{
                    String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
                    
                    conn c = new conn();
                    //System.out.println("This is for Testing Outside");
                    
                    String str1 = "select source,destination from flights where source = '"+src+"' and destination = '"+dst+"'";
                    ResultSet rs1=c.s.executeQuery(str1);
                    if(rs1.next())
                    {
                    String str = "select flightNumber,source,destination,departureTime,fare,availableSeats from flights where source = '"+src+"' and destination = '"+dst+"'";
                    ResultSet rs=c.s.executeQuery(str);
                     table.setModel(DbUtils.resultSetToTableModel(rs));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"No Flights between Source and Destination");
                    }
                    
					
		}catch(Exception e){}
            }
	});
		
	setSize(900,600);
        setLocation(400,200);
	setVisible(true);
        
         
		
	JLabel Fcode = new JLabel("FLIGHT CODE");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Fcode.setBounds(100, 500, 200, 30);
	add(Fcode);
        
        textField = new JTextField();
        textField.setBounds(220, 500, 200, 30);
	add(textField);
        
        Book = new JButton("Book");
	Book.setBounds(500, 500, 200, 30);
	add(Book);
        
        Book.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
                               setVisible(false);
				new BookTicket();
			}
		});
		
    } 
         
    }
