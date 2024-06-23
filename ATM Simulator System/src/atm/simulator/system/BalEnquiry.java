
package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class BalEnquiry extends JFrame implements ActionListener {
    
    JButton back;
    String pin;
    
    public BalEnquiry(String pin){
        
        this.pin = pin;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img1 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img1);
        
        JLabel imgframe = new JLabel(i2);
        imgframe.setBounds(0,0,700,700);
        add(imgframe);
        
        int balance = 0;
        try {
                
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin_no = '" +this.pin+ "'");
                
                while(rs.next()){
                    if(rs.getString("transaction_type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
            }
            catch(Exception e){
                
                System.out.println(e);
                
            }
        
        JLabel text = new JLabel("Your current A/C balance is " +balance);
        text.setFont(new Font("Arial", Font.BOLD, 12));
        text.setForeground(Color.WHITE);
        text.setBounds(190,300,300,15);
        imgframe.add(text);
        
        back = new JButton("Back");
        back.setBounds(270,406,130,20);
        imgframe.add(back);
        back.addActionListener(this);
        
        setSize(700,650);
        setLocation(300,30);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pin);
        }
    }
    
    public static void main(String[] args) {
        
        new BalEnquiry("");
    }
}
