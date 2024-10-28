/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline;

//package airline.management.system;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class Flight_Info extends JFrame{  //Second Frame

    private JTable table;
    private JTextField textField;
    
    public static void main(String[] args){		 
	new Flight_Info().setVisible(true);    
    }
    
    public Flight_Info(){
         setTitle("FLIGHT INFORMATION");
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	setLayout(null);
	setVisible(true);
		
	JLabel Fcode = new JLabel("FLIGHT CODE");
	Fcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Fcode.setBounds(50, 100, 200, 30);
	add(Fcode);
	
		
	JLabel FlightDetails = new JLabel("FLIGHT INFORMATION");
	FlightDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	FlightDetails.setForeground(new Color(100, 149, 237));
	FlightDetails.setBounds(50, 20, 570, 35);
	add(FlightDetails);
		
	JButton btnShow = new JButton("SHOW");
	btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
	
                String code = textField.getText();
                
                try {
                    conn c = new conn();
                    String str = "select flightNumber,source,destination,departureTime,fare,availableSeats from flights where flightNumber = '"+code+"'";
      
                    ResultSet rs = c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));	
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });

        btnShow.setBounds(220, 150, 120, 30);
	add(btnShow);
		
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(23, 250, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);
		
	textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
	add(textField);
		
	JLabel FlightNumber = new JLabel("FLIGHT NUMBER");
	FlightNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
        FlightNumber.setBounds(30, 220, 126, 14);
	add(FlightNumber);
		
	/*JLabel FlightName = new JLabel("FLIGHT NAME");
        FlightName.setFont(new Font("Tahoma", Font.PLAIN, 13));
	FlightName.setBounds(145, 220, 120, 14);
	add(FlightName);*/
		
	JLabel Source = new JLabel("SOURCE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Source.setBounds(200, 220, 104, 14);
	add(Source);
		
	JLabel Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Destination.setBounds(325, 220, 120, 14);
	add(Destination);
		
		
	JLabel DepartureTime = new JLabel("TIME");
	DepartureTime.setFont(new Font("Tahoma", Font.PLAIN, 13));
	DepartureTime.setBounds(450, 220, 111, 14);
	add(DepartureTime);
		
	JLabel Fare = new JLabel("COST");
	Fare.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Fare.setBounds(587, 220, 120, 14);
	add(Fare);
		
	JLabel AvailableSeats = new JLabel("AVAILABLE SEATS");
	AvailableSeats.setFont(new Font("Tahoma", Font.PLAIN, 13));
	AvailableSeats.setBounds(700, 220, 111, 14);
	add(AvailableSeats);
		
	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setSize(900,650);
        setVisible(true);
        setLocation(400,200);
		
    }
}