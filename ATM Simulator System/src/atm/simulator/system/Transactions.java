
package atm.simulator.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Transactions extends JFrame implements ActionListener {
    
    JButton deposit, withdrawl, fastcash, ministmt, pinchange, bal, exit;
    String pin;
    
    public Transactions(String pin){
        
        this.pin = pin;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img1 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img1);
        
        JLabel imgframe = new JLabel(i2);
        imgframe.setBounds(0,0,700,700);
        add(imgframe);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setFont(new Font("Arial", Font.PLAIN, 12));
        text.setForeground(Color.WHITE);
        text.setBounds(170,220,300,15);
        imgframe.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(120,325,130,20);
        imgframe.add(deposit);
        deposit.addActionListener(this);
        
        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(270,325,130,20);
        imgframe.add(withdrawl);
        withdrawl.addActionListener(this);
        
        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(120,352,130,20);
        imgframe.add(fastcash);
        fastcash.addActionListener(this);
        
        ministmt = new JButton("Mini Statement");
        ministmt.setBounds(270,352,130,20);
        imgframe.add(ministmt);
        ministmt.addActionListener(this);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(120,379,130,20);
        imgframe.add(pinchange);
        pinchange.addActionListener(this);
      
        bal = new JButton("Balance Enquiry");
        bal.setBounds(270,379,130,20);
        imgframe.add(bal);
        bal.addActionListener(this);
        
        exit = new JButton("Exit");
        exit.setBounds(270,406,130,20);
        imgframe.add(exit);
        exit.addActionListener(this);
        
        setSize(700,650);
        setLocation(300,30);
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        //JButton deposit, withdrawl, fastcash, ministmt, pinchange, bal, exit;
        
        if(ae.getSource() == exit){
            System.exit(0);
        }else if (ae.getSource() == deposit){
            setVisible(false);
            new Deposit(pin);
        }else if (ae.getSource() == withdrawl){
            setVisible(false);
            new Withdrawl(pin);
        }else if (ae.getSource() == fastcash){
            setVisible(false);
            new FastCash(pin);
        }else if (ae.getSource() == pinchange){
            setVisible(false);
            new PinChange(pin);
        }else if (ae.getSource() == bal){
            setVisible(false);
            new BalEnquiry(pin);
        }
        else if (ae.getSource() == ministmt){
            new MiniStmt(pin);
        }
        
    }
    public static void main(String[] args) {
        
        new Transactions("");
    }
}
