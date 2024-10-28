/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import net.proteanit.sql.DbUtils;


public class Mainframe extends JFrame{

    public static void main(String[] args) {
        new Mainframe().setVisible(true);
    }
    
    public Mainframe() {
        super("AIRLINE RESERVATION MANAGEMENT SYSTEM");
        initialize();
    }

    
    private void initialize() {
	
        setForeground(Color.CYAN);
        setLayout(null); 

      JLabel NewLabel = new JLabel("");
      NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/logo.jpg")));
	NewLabel.setBounds(0, 0, 1920, 990); 
	add(NewLabel); 
        
        JLabel AirlineManagementSystem = new JLabel("Airline Reservation System");
	AirlineManagementSystem.setForeground(Color.BLUE);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 36));
	AirlineManagementSystem.setBounds(500, 60, 1000, 55);
	NewLabel.add(AirlineManagementSystem);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu AirlineSystem = new JMenu("AIRLINE SYSTEM");
        AirlineSystem.setForeground(Color.BLUE);
	menuBar.add(AirlineSystem);
		
        JMenuItem FlightDetails = new JMenuItem("FLIGHT_INFO");
	AirlineSystem.add(FlightDetails);
		
	/*JMenuItem ReservationDetails = new JMenuItem("ADD_CUSTOMER_DETAILS");
	AirlineSystem.add(ReservationDetails);*/
	
        JMenuItem SearchFlight =new JMenuItem("SEARCH FLIGHT");
        AirlineSystem.add(SearchFlight);
        JMenuItem BookTicket =new JMenuItem("BOOK A TICKET");
        AirlineSystem.add(BookTicket);
	/*JMenuItem PassengerDetails = new JMenuItem("JOURNEY_DETAILS");
	AirlineSystem.add(PassengerDetails);
		
	JMenuItem SectorDetails_1 = new JMenuItem("PAYMENT_DETAILS");
	AirlineSystem.add(SectorDetails_1);*/
        JMenuItem ViewBookedFlights = new JMenuItem("VIEW BOOKED FLIGHTS");
	AirlineSystem.add(ViewBookedFlights);
		
	JMenuItem Cancellation = new JMenuItem("CANCELLATION");
	AirlineSystem.add(Cancellation);
        
        JMenuItem Logout = new JMenuItem("LOGOUT");
	AirlineSystem.add(Logout);
        
		
	/*JMenu Ticket = new JMenu("TICKET");
        Ticket.setForeground(Color.RED);
	menuBar.add(Ticket);
		
        JMenu List = new JMenu("LIST");
        List.setForeground(Color.BLUE);
	menuBar.add(List);
		
	JMenu Misc = new JMenu("MISC");
        Misc.setForeground(Color.RED);
	menuBar.add(Misc);*/
        
		
	FlightDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Flight_Info();
            }
	});
        
        SearchFlight.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new SearchFlight();
            }
	});
        
        BookTicket.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new BookTicket();
            }
	});
        
	/*ReservationDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Add_Customer();
		} catch (Exception e) {
                    e.printStackTrace();
		} 
            }
	});
		
        PassengerDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Journey_Details();
                } catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
      SectorDetails_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Payment_Details();
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});*/
      
      ViewBookedFlights.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent ae){
             new ViewBookedFlights();
         }
    });
		
        Cancellation.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Cancel();
            }
	});
        
       Logout.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent ae){
               //System.exit(0);
               setVisible(false);
               new Login().setVisible(true);
              
          }
    });	
        setSize(1950,1090);
	setVisible(true);
}
}


