
package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class PinChange extends JFrame implements ActionListener{
    
     String pin;
     JPasswordField textf1,textf2;
     JButton change,back;
    
    public PinChange(String pin){
        
        this.pin = pin;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img1 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img1);
        
        JLabel imgframe = new JLabel(i2);
        imgframe.setBounds(0,0,700,700);
        add(imgframe);
        
        JLabel text = new JLabel("Change your PIN");
        text.setFont(new Font("Arial", Font.BOLD, 12));
        text.setForeground(Color.WHITE);
        text.setBounds(220,220,300,15);
        imgframe.add(text);
        
        JLabel text1 = new JLabel("New PIN: ");
        text1.setFont(new Font("Arial", Font.BOLD, 12));
        text1.setForeground(Color.WHITE);
        text1.setBounds(120,300,100,15);
        imgframe.add(text1);
        
        textf1 = new JPasswordField();
        textf1.setFont(new Font("Arial", Font.BOLD, 12));
        textf1.setBounds(240,300,150,15);
        imgframe.add(textf1);
        
        JLabel text2 = new JLabel("Re-enter New PIN: ");
        text2.setFont(new Font("Arial", Font.BOLD, 12));
        text2.setForeground(Color.WHITE);
        text2.setBounds(120,330,150,15);
        imgframe.add(text2);
        
        textf2 = new JPasswordField();
        textf2.setFont(new Font("Arial", Font.BOLD, 12));
        textf2.setBounds(240,330,150,15);
        imgframe.add(textf2);
        
        change = new JButton("Change");
        change.setBounds(270,379,130,20);
        imgframe.add(change);
        change.addActionListener(this);
        
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
        if (ae.getSource()==change){
            try{
                String npin = textf1.getText();
                String rpin = textf1.getText();
                if (!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "Entered PIN doesn't match");
                    return;
                }
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter new PIN");
                    return;
                }
                
                if(rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please re-enter new PIN");
                    return;
                }
                
                Conn c = new Conn();
                String query1 = "update bank set pin_no = '" +rpin+ "' where pin_no = '" +pin+ "'";
                String query2 = "update login set pin_no = '" +rpin+ "' where pin_no = '" +pin+ "'";
                String query3 = "update signupthree set pin_no = '" +rpin+ "' where pin_no = '" +pin+ "'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN changed Successfully");
                setVisible(false);
                new Transactions(rpin);
                
                
            }catch(Exception e){
            System.out.println(e);
        }
        }
        else{

            setVisible(false);
            new Transactions(pin);
        }
    }
    
    public static void main(String[] args) {
        new PinChange("");
    }
}
