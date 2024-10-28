/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package airline;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Login extends JFrame{
    
    private JTextField t1;
    private JPasswordField t2;

    public static void main(String[] args) {
        new Login();
    }

    public Login() {
        initialize();
    }

    public void initialize() {
      getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
            setTitle("LOGIN");
		 
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
            
             JLabel l3 = new JLabel("LOGIN FORM");
            l3.setForeground(Color.BLUE);
            l3.setFont(new Font("Tahoma", Font.PLAIN, 30));
            l3.setBounds(120, 30, 250, 27);
            add(l3);

             JLabel NewLabel = new JLabel("");
             NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/login.png")));
	    NewLabel.setBounds(100, 50, 300, 200); 
	     add(NewLabel); 
          
            JLabel l1 = new JLabel("NAME");
            l1.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l1.setBounds(60, 250, 150, 27);
            add(l1);
			
            t1 = new JTextField();
            t1.setBounds(240, 250, 150, 27);
            add(t1);
            
            JLabel l2 = new JLabel("PASSWORD");
            l2.setFont(new Font("Tahoma", Font.PLAIN, 17));
            l2.setBounds(60, 300, 150, 27);
            add(l2);
			
            t2 = new JPasswordField();
            t2.setBounds(240, 300, 150, 27);
            add(t2);

             JButton b1= new JButton("Reset");
            b1.setBounds(50, 350, 100, 30);
            //b1.setBackground(Color.BLACK);
            //b1.setForeground(Color.WHITE);
            add(b1);
            
              JButton b2 = new JButton("Submit");
            b2.setBounds(170, 350, 100, 30);
            //b2.setBackground(Color.BLACK);
            //b2.setForeground(Color.WHITE);
            add(b2);

             JButton b3 = new JButton("Cancel");
            b3.setBounds(290, 350, 100, 30);
            //b3.setBackground(Color.BLACK);
            //b3.setForeground(Color.WHITE);
            add(b3);

          
          
        
       b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
            t1.setText("");  
            t2.setText(""); 
	}
     });
b3.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
           System.exit(0); 
 
	}
});
b2.addActionListener(new ActionListener(){
         public void actionPerformed(ActionEvent ae){
        
            try{
                conn c1 = new conn();
                
                String s1 = t1.getText();
                String s2 = t2.getText();
            
                String str = "select username,password from login where username = '"+s1+"' and password = '"+s2+"'";
                ResultSet rs = c1.s.executeQuery(str);  
                
                if(rs.next()){
                    new Mainframe().setVisible(true);
                    //setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null,"Invalid Login");
                    //this.setVisible(false); 
                }
            
            }catch(Exception e){}
            
	}
});
  setVisible(true);   
        setSize(450,500); 
        setLocation(400,200);
    }
}


