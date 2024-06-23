
package atm.simulator.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    
    JTextField amount;
    JButton deposit, back;
    String pin;
    
    public Deposit(String pin){
        this.pin = pin;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img1 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img1);
        
        JLabel imgframe = new JLabel(i2);
        imgframe.setBounds(0,0,700,700);
        add(imgframe);
        
        JLabel text = new JLabel("Enter the Amount you want to Deposit");
        text.setFont(new Font("Arial", Font.BOLD, 12));
        text.setForeground(Color.WHITE);
        text.setBounds(170,220,300,15);
        imgframe.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Arial", Font.BOLD,15));
        amount.setBounds(180,250,180,30);
        imgframe.add(amount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(270,379,130,20);
        imgframe.add(deposit);
        deposit.addActionListener(this);
        
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
        
        if (ae.getSource() == deposit){
            String money = amount.getText();
            Date date = new Date();
            String msg = "Deposit";
            if(money.equals("")){
                JOptionPane.showMessageDialog(null,"Enter the Amount");
            }
            else{
                try{
                    Conn c = new Conn();
                    String query = "insert into bank values ('" +pin+ "', '" +date+ "', '" +msg+ "', '" +money+ "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+money+ " has been Deposited Successfully" );
                    setVisible(false);
                    new Transactions(pin);
                }
                catch(Exception e){
                    System.out.println(e);
                }
            }
            
        }else if (ae.getSource() == back){
            
            setVisible(false);
            new Transactions(pin);
        }
        
    }
    
    public static void main(String[] args) {
        
        new Deposit(""); 
    }
}
