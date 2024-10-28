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

public class ViewBookedFlights extends JFrame {
     private JTable table;
    private JTextField textField;
    
    public static void main(String[] args){		 
	new ViewBookedFlights();    
    }

public ViewBookedFlights(){
         setTitle("BOOKED FLIGHTS");
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	setLayout(null);
	setVisible(true);
     
       JPanel panel = new JPanel(new BorderLayout());
       
       JLabel l1= new JLabel("Passport Number");
	l1.setFont(new Font("Tahoma", Font.PLAIN, 19));
	l1.setBounds(60, 120, 200, 27);
	add(l1);
        
        JTextField  t1 = new JTextField();
        t1.setBounds(250, 120, 200, 30);
        add(t1);
        
         JButton Show = new JButton("Show");
	Show.setBounds(500, 120, 200, 30);
	add(Show);

       JTable table = new JTable();
       table.setBackground(Color.WHITE);
	table.setBounds(23, 250, 800, 300);
        
       JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);
        
       // panel.add(new JScrollPane(table), BorderLayout.CENTER);

    


          Show.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
              
                
        try {
            // Connect to the database and retrieve data
            conn c=new conn();
            String query = "SELECT * FROM BookedTickets where passport_no='"+t1.getText()+"'";
            ResultSet rs = c.s.executeQuery(query);
            table.setModel(DbUtils.resultSetToTableModel(rs));
            // Create a table model to hold the data
           /* DefaultTableModel tableModel = new DefaultTableModel();

            // Get the column names from the result set
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(metaData.getColumnName(i));
            }

            // Add rows to the table model
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }

            // Set the table model for the JTable
            table.setModel(tableModel);*/
        } catch (SQLException e) {
            e.printStackTrace();
        }
       }
     });
          setSize(900,700);
          setLocation(400,200);
  }
}
                        

                        
    
