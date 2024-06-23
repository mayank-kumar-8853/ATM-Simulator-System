package atm.simulator.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String random;
    
    public SignupThree(String random){
    
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");
        
        this.random = random;
        
        JLabel accountdetails = new JLabel("Page 3: Account Details");
        accountdetails.setFont(new Font("Arial", Font.BOLD, 28));
        accountdetails.setBounds(240,80,600,40);
        add(accountdetails);
        
        JLabel acctype = new JLabel("Account Type: ");
        acctype.setFont(new Font("Arial", Font.BOLD, 18));
        acctype.setBounds(80,140,400,30);
        add(acctype);
        
        r1 = new JRadioButton("Saving Account");
        r1.setBackground(Color.LIGHT_GRAY);
        r1.setFont(new Font("Arial", Font.BOLD, 14));
        r1.setBounds(100,180,300,30);
        add(r1);
        
        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setBackground(Color.LIGHT_GRAY);
        r2.setFont(new Font("Arial", Font.BOLD, 14));
        r2.setBounds(420,180,300,30);
        add(r2);
        
        r3 = new JRadioButton("Current Account");
        r3.setBackground(Color.LIGHT_GRAY);
        r3.setFont(new Font("Arial", Font.BOLD, 14));
        r3.setBounds(100,220,300,30);
        add(r3);
        
        r4  = new JRadioButton("Recurring Deposit Account");
        r4.setBackground(Color.LIGHT_GRAY);
        r4.setFont(new Font("Arial", Font.BOLD, 14));
        r4.setBounds(420,220,300,30);
        add(r4);
        
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(r1);
        bg1.add(r2);
        bg1.add(r3);
        bg1.add(r4);
        
        JLabel cardno = new JLabel("Card Number: ");
        cardno.setFont(new Font("Arial", Font.BOLD, 18));
        cardno.setBounds(80,270,200,30);
        add(cardno);
        
        JLabel cardno2 = new JLabel("Your 16 Digit Card Number");
        cardno2.setFont(new Font("Arial", Font.BOLD, 12));
        cardno2.setBounds(80,300,400,20);
        add(cardno2);
        
        JLabel cardno3 = new JLabel("XXXX-XXXX-XXXX-9876");
        cardno3.setFont(new Font("Arial", Font.BOLD, 18));
        cardno3.setBounds(300,270,400,30);
        add(cardno3);
        
        JLabel pinno = new JLabel("PIN: ");
        pinno.setFont(new Font("Arial", Font.BOLD, 18));
        pinno.setBounds(80,340,200,30);
        add(pinno);
        
        JLabel pinno2 = new JLabel("Your 4 Digit Password");
        pinno2.setFont(new Font("Arial", Font.BOLD, 12));
        pinno2.setBounds(80,370,400,20);
        add(pinno2);
        
        JLabel pinno3 = new JLabel("XXXX");
        pinno3.setFont(new Font("Arial", Font.BOLD, 18));
        pinno3.setBounds(300,340,400,30);
        add(pinno3);
        
        JLabel service = new JLabel("Services Required: ");
        service.setFont(new Font("Arial", Font.BOLD, 18));
        service.setBounds(80,410,200,30);
        add(service);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setBackground(Color.LIGHT_GRAY);
        c1.setFont(new Font("Arial", Font.BOLD, 14));
        c1.setBounds(100,450,200,20);
        add(c1);
        
        c2 = new JCheckBox("Internet Banking");
        c2.setBackground(Color.LIGHT_GRAY);
        c2.setFont(new Font("Arial", Font.BOLD, 14));
        c2.setBounds(320,450,200,20);
        add(c2);
        
        c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(Color.LIGHT_GRAY);
        c3.setFont(new Font("Arial", Font.BOLD, 14));
        c3.setBounds(100,480,200,20);
        add(c3);
        
        c4 = new JCheckBox("E-Mail & SMS Alerts");
        c4.setBackground(Color.LIGHT_GRAY);
        c4.setFont(new Font("Arial", Font.BOLD, 14));
        c4.setBounds(320,480,200,20);
        add(c4);
        
        c5 = new JCheckBox("Cheque Book");
        c5.setBackground(Color.LIGHT_GRAY);
        c5.setFont(new Font("Arial", Font.BOLD, 14));
        c5.setBounds(100,510,200,20);
        add(c5);
        
        c6 = new JCheckBox("E-Statement");
        c6.setBackground(Color.LIGHT_GRAY);
        c6.setFont(new Font("Arial", Font.BOLD, 14));
        c6.setBounds(320,510,200,20);
        add(c6);
        
        c7 = new JCheckBox("I hereby declare that the above information is true to the best of my knowledge.");
        c7.setBackground(Color.LIGHT_GRAY);
        c7.setFont(new Font("Arial", Font.PLAIN, 14));
        c7.setBounds(80,560,600,20);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Arial", Font.BOLD, 14));
        submit.setBounds(200,600,100,30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Arial", Font.BOLD, 14));
        cancel.setBounds(350,600,100,30);
        cancel.addActionListener(this);
        add(cancel);
       
        setSize(850,850);
        setLocation(350,10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
}
    
    public void actionPerformed(ActionEvent ae){
       
        if (ae.getSource() == submit)
        {   
            String accounttype = null;
            if (r1.isSelected()){
            accounttype = "Saving Account";
            }else if (r2.isSelected()){
            accounttype = "Fixed Deposit Account";
            }else if (r3.isSelected()){
            accounttype = "Current Account";
            }else if (r4.isSelected()){
            accounttype = "Recurring Deposit Account";
            }
            
            Random randomno = new Random();
            String cardno = "" + Math.abs((randomno.nextLong() % 90000000L) + 1234567800000000L);
            String pinno = "" + Math.abs((randomno.nextLong() % 9000L) + 1000L);
            
            String services = "";
            if (c1.isSelected()){
            services = services + "ATM CARD";
            }else if (c2.isSelected()){
            services = services + "Internet Banking";
            }else if (c3.isSelected()){
            services = services + "Mobile Banking";
            }else if (c4.isSelected()){
            services = services + "E-Mail & SMS Alerts";
            }else if (c5.isSelected()){
            services = services + "Cheque Book";
            }else if (c6.isSelected()){
            services = services + "E-Statement";
            }
            
            try{
                Conn c = new Conn();
                String query1 = "insert into signupthree values ('" +random+ "', '" +accounttype+ "', '" +cardno+ "', '" +pinno+ "', '" +services+"')";
                c.s.executeUpdate(query1);
                
                String query2 = "insert into login values ('" +random+ "', '" +cardno+ "', '" +pinno+ "')";
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Your Card No: " +cardno+ "\n" + "Your Pin No: " + pinno);
                
                setVisible(false);
                new Deposit(pinno);
                
            } catch(Exception e){
                System.out.println(e);  
            }
            
        }else if (ae.getSource() == cancel){
                setVisible(false);
                new Login();
        } 
    }
    
    public static void main(String[] args) {
        new SignupThree("");
    }
    
}
