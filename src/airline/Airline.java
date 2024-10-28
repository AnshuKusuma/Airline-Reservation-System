/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package airline;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


 class Airline extends JFrame{
    private JFrame frame;
    

    public static void main(String[] args) {
        new Airline();
    }

    public Airline() {
        initialize();
    }

    public void initialize() {
        
        
        frame = new JFrame("HOME");
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 21));
                frame.setBounds(100, 100, 866, 452);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
                 JLabel NewLabel = new JLabel("");
      NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/home.png")));
	NewLabel.setBounds(350, 60, 400, 258); 
	frame.getContentPane().add(NewLabel); 
		
		JButton Login = new JButton("Login");
		Login.setFont(new Font("Tahoma", Font.PLAIN, 19));
		Login.setBounds(140, 120, 80, 30);
		frame.getContentPane().add(Login);
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().add(Login);
		
		
		
		Label label = new Label("AIRLINE RESERVATION SYSTEM");
		label.setFont(new Font("Dialog", Font.PLAIN, 40));
		label.setBounds(80, 20, 800, 44);
		frame.getContentPane().add(label);
		
		/*JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\Mithun\\Downloads\\20171109195143.jpg"));
		label_1.setBounds(435, 115, 382, 258);
		frame.getContentPane().add(label_1);*/

	
		Login.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				frame.dispose();
				new Login();
			}
		});
		
		JLabel signup = new JLabel("New Customer Sign Up");
		signup.setFont(new Font("Tahoma", Font.PLAIN,15));
		signup.setBounds(100, 170, 200, 35);
		frame.getContentPane().add(signup);

               JButton SignUp = new JButton("SignUp");
		SignUp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		SignUp.setBounds(100, 220, 180, 35);
		frame.getContentPane().add(SignUp);
		
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().add(SignUp);
          
           SignUp.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				frame.dispose();
				new SignUp();
			}
		});
		
		frame.setSize(750,406);
                frame.setLocation(400,200);
		frame.setVisible(true);
	}
}
