
package atm.simulator.system;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {
    
    JButton hundred, fivehund, thousand, twothous, fivethous, tenthous, back;
    String pin;
    
    public FastCash(String pin){
        
        this.pin = pin;
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image img1 = i1.getImage().getScaledInstance(700, 700, Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(img1);
        
        JLabel imgframe = new JLabel(i2);
        imgframe.setBounds(0,0,700,700);
        add(imgframe);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setFont(new Font("Arial", Font.BOLD, 12));
        text.setForeground(Color.WHITE);
        text.setBounds(190,220,300,15);
        imgframe.add(text);
        
        hundred = new JButton("Rs 100");
        hundred.setBounds(120,325,130,20);
        imgframe.add(hundred);
        hundred.addActionListener(this);
        
        fivehund = new JButton("Rs 500");
        fivehund.setBounds(270,325,130,20);
        imgframe.add(fivehund);
        fivehund.addActionListener(this);
        
        thousand = new JButton("Rs 1000");
        thousand.setBounds(120,352,130,20);
        imgframe.add(thousand);
        thousand.addActionListener(this);
        
        twothous = new JButton("Rs 2000");
        twothous.setBounds(270,352,130,20);
        imgframe.add(twothous);
        twothous.addActionListener(this);
        
        fivethous = new JButton("Rs 5000");
        fivethous.setBounds(120,379,130,20);
        imgframe.add(fivethous);
        fivethous.addActionListener(this);
      
        tenthous = new JButton("Rs 10000");
        tenthous.setBounds(270,379,130,20);
        imgframe.add(tenthous);
        tenthous.addActionListener(this);
        
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
        
        //JButton hundred, fivehund, thousand, twothous, fivethous, tenthous, back;
        
        if(ae.getSource() == back){
            setVisible(false);
            new Transactions(pin);
            
        } else {
            String value = ((JButton)ae.getSource()).getText().substring(3);
            try {
                
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin_no = '" +pin+ "'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("transaction_type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if (balance < Integer.parseInt(value)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String msg = "Withdrawl";
                
                String query = "insert into bank values ('" +pin+ "', '" +date+ "', '" +msg+ "', '" +value+ "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+value+ " has been Withdrawl Successfully" );
                setVisible(false);
                new Transactions(pin);
            }
            catch(Exception e){
                
                System.out.println(e);
                
            }
        }
        
    }
    public static void main(String[] args) {
        
        new FastCash("");
    }
}
