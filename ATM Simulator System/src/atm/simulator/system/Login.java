
package atm.simulator.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton button1, button2, button3;
    JTextField textfield1;
    JPasswordField passwordfield1;
    
    Login(){

        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setTitle("AUTOMATED TELLER MACHINE");
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image img1 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img1);
        JLabel l1 = new JLabel(i2);
        l1.setBounds(70, 10, 100, 100);
        add(l1);
        
        JLabel text1 = new JLabel ("Welcome to ATM");
        text1.setFont(new Font("Times New Roman", Font.BOLD, 38));
        text1.setBounds(240, 40, 300, 40);
        add(text1);
        
        JLabel text2 = new JLabel ("Card No");
        text2.setFont(new Font("Arial", Font.BOLD, 19));
        text2.setBounds(120, 160, 120, 40);
        add(text2);
        
        textfield1 = new JTextField();
        textfield1.setBounds(280, 160, 300, 40);
        textfield1.setFont(new Font("Arial", Font.BOLD, 15));
        textfield1.addActionListener(this);
        add(textfield1);
        
        JLabel text3 = new JLabel ("PIN");
        text3.setFont(new Font("Arial", Font.BOLD, 19));
        text3.setBounds(120, 240, 300, 40);
        add(text3);
        
        passwordfield1 = new JPasswordField();
        passwordfield1.setBounds(280, 240, 300, 40);
        passwordfield1.setFont(new Font("Arial", Font.BOLD, 15));
        passwordfield1.addActionListener(this);
        add(passwordfield1);
        
        button1 = new JButton("SIGN IN");
        button1.setBounds(300, 300, 100, 30);
        button1.setBackground(Color.WHITE);
        button1.setForeground(Color.BLACK);
        button1.addActionListener(this);
        add(button1);
        
        button2 = new JButton("CLEAR");
        button2.setBounds(460, 300, 100, 30);
        button2.setBackground(Color.WHITE);
        button2.setForeground(Color.BLACK);
        button2.addActionListener(this);
        add(button2);
        
        button3 = new JButton("SIGN UP");
        button3.setBounds(380, 350, 100, 30);
        button3.setBackground(Color.WHITE);
        button3.setForeground(Color.BLACK);
        button3.addActionListener(this);
        add(button3);
        
        setSize(800,480);
        setLocation(350,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
        
        
        /*
        Best Practices - To ensure that all components are properly laid out and displayed, 
        it's generally a good practice to:
        1. Set the layout manager.
        2. Add all components.
        3. Set the size of the JFrame.
        4. Set the location of the JFrame.
        5. Make the JFrame visible.
        */
        
        
        
};
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == button1){
            try {
                Conn c = new Conn();
                String cardno = textfield1.getText();
                String pin = passwordfield1.getText();
                String query = "select * from login where card_no = '" +cardno+ "' and pin_no = '" +pin+"'";
                ResultSet rs = c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card No or PIN");
                }
            
                }
            catch(Exception e){
                System.out.println(e);
            }
        }
        else if (ae.getSource() == button2){
                textfield1.setText("");
                passwordfield1.setText("");
                }
        else if (ae.getSource() == button3){
            setVisible(false);
            new SignupOne();
            
        }
                
        
    };
    
    public static void main(String[] args) {
        new Login();
    }
    
}
