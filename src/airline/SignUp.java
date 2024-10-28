 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline;

//package airline.management.system;

import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class SignUp extends JFrame{ //Third Frame

    
	JTextField textField_1,textField_2,textField_3,textField_4,textField_5;
        public SignUp(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(Color.WHITE);
            setTitle("SIGN UP");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
			
            /*JLabel Passportno = new JLabel("PASSPORT NO");
            Passportno.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Passportno.setBounds(60, 80, 150, 27);
            add(Passportno);
            
            textField = new JTextField();
            textField.setBounds(200, 80, 150, 27);
            add(textField);*/
			
            JButton Next = new JButton("SAVE");
            Next.setBounds(200, 420, 150, 30);
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
			
            JLabel l1 = new JLabel("NAME");
            l1.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l1.setBounds(60, 120, 150, 27);
            add(l1);
			
            textField_1 = new JTextField();
            textField_1.setBounds(200, 120, 150, 27);
            add(textField_1);
            
            JLabel l2 = new JLabel("PASSPORT NO");
            l2.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l2.setBounds(60, 170, 150, 27);
            add(l2);
			
            textField_2 = new JTextField();
            textField_2.setBounds(200, 170, 150, 27);
            add(textField_2);
            		
            JLabel l3 = new JLabel("PHONE NO");
            l3.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l3.setBounds(60, 220, 150, 27);
            add(l3);
			
            textField_3 = new JTextField();
            textField_3.setBounds(200, 220, 150, 27);
            add(textField_3);
	
            JLabel l4 = new JLabel("Address");
            l4.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l4.setBounds(60, 270, 150, 27);
            add(l4);
	
            textField_4 = new JTextField();
            textField_4.setBounds(200, 270, 150, 27);
            add(textField_4);
	
            JLabel Gender = new JLabel("GENDER");
            Gender.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Gender.setBounds(60, 320, 150, 27);
            add(Gender);
		
            JRadioButton NewRadioButton = new JRadioButton("MALE");
            NewRadioButton.setBackground(Color.WHITE);
            NewRadioButton.setBounds(200, 320, 70, 27);
            add(NewRadioButton);
	
            JRadioButton Female = new JRadioButton("FEMALE");
            Female.setBackground(Color.WHITE);
            Female.setBounds(280, 320, 70, 27);
            add(Female);
            
            JLabel l5 = new JLabel("PASSWORD");
            l5.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l5.setBounds(60, 370, 150, 27);
            add(l5);
			
            textField_5 = new JTextField();
            textField_5.setBounds(200, 370, 150, 27);
            add(textField_5);
	
            setVisible(true);
	
            JLabel AddPassengers = new JLabel("SIGN UP");
            AddPassengers.setForeground(Color.BLUE);
            AddPassengers.setFont(new Font("Tahoma", Font.PLAIN, 31));
            AddPassengers.setBounds(200, 24, 442, 35);
            add(AddPassengers);
			
    
           /* JLabel Flightcode = new JLabel("FLIGHT CODE");
            Flightcode.setFont(new Font("Tahoma", Font.PLAIN, 17));
            Flightcode.setBounds(60, 30, 150, 27);
            add(Flightcode);

            textField_6 = new JTextField();
            textField_6.setBounds(200, 30, 150, 27);
            add(textField_6);*/
            
            
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Images/emp.png"));
            JLabel image = new JLabel(i1);
            image.setBounds(450,80,280,410);
            add(image);

            
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String name = textField_1.getText();
                    String passport_no = textField_2.getText();
                    String phone_no=  textField_3.getText();
                    String address = textField_4.getText();
                   
                    String gender = null;
                    String password = textField_5.getText();
                    
                    if( NewRadioButton.isSelected()){
                        gender = "male";
                    
                    }else if(Female.isSelected()){
                        gender = "female";
                    }
                    
                    try {
                        conn c = new conn();
                        String str = "INSERT INTO passenger values( '"+name+"', '"+passport_no+"', '"+phone_no+"','"+address+"', '"+gender+"')";
                        String str1="Insert into login values('"+name+"','"+password+"')";
                        c.s.executeUpdate(str);
                        c.s.executeUpdate(str1);
                        JOptionPane.showMessageDialog(null,"Signed up successfully");
                        setVisible(false);
                        new Login().setVisible(true);
                    
                    } catch (Exception e) {
                        e.printStackTrace();
        	    }
		}
            });
			
            setSize(900,600);
            setVisible(true);
            setLocation(400,200);
			
	}
        
    public static void main(String[] args){
        new SignUp();
    }   
}