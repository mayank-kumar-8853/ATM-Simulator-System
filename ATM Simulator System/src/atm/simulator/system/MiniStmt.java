package atm.simulator.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStmt extends JFrame implements ActionListener {
    
    String pin;
    
    public MiniStmt(String pin){
        
        setLayout(null);
        
        setTitle("Mini Statement");
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        this.pin = pin;
        
        JLabel bankname = new JLabel("MAC Bank of UK");
        bankname.setFont(new Font("Times New Roman", Font.BOLD, 18));
        bankname.setBounds(120,30,200,20);
        add(bankname);
        
        JLabel card = new JLabel();
        bankname.setFont(new Font("Arial", Font.BOLD, 16));
        card.setBounds(20,80,400,20);
        add(card);
        
        JLabel stmt = new JLabel();
        stmt.setFont(new Font("Arial", Font.PLAIN, 12));
        stmt.setBounds(20,120,400,120);
        add(stmt);
        
        JLabel bal = new JLabel();
        bal.setFont(new Font("Arial", Font.BOLD, 12));
        bal.setBounds(20,280,400,20);
        add(bal);
        
        try{
            Conn c = new Conn();
            String query = "select * from login where pin_no = '" +this.pin+ "'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                card.setText("Card Number: " +rs.getString("card_no").substring(0,4)+"XXXXXXXX" +rs.getString("card_no").substring(12));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        
        try{
            Conn c = new Conn();
            String query = "select * from bank where pin_no = '" +this.pin+ "'";
            ResultSet rs = c.s.executeQuery(query);
            /*while(rs.next()){
                stmt.setText(stmt.getText()+"<html>"+rs.getString("date")+"&emsp;"+ rs.getString("transaction_type")+"&emsp;"+rs.getString("amount")+"<br><br><html>");
            }*/
            StringBuilder htmlText = new StringBuilder("<html>");
            while (rs.next()) {
            htmlText.append(rs.getString("date")).append("&emsp;")
                .append(rs.getString("transaction_type")).append("&emsp;")
                .append(rs.getString("amount")).append("<br><br>");
            }
            htmlText.append("</html>");
            stmt.setText(htmlText.toString());
        }catch(Exception e){
            System.out.println(e);
        }
   
        try {
                int balance = 0;
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin_no = '" +this.pin+ "'");
                
                while(rs.next()){
                    if(rs.getString("transaction_type").equals("Deposit")) {
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                bal.setText("Your account balnce is " + balance);
            }
            catch(Exception e){
                System.out.println(e);
            }
        
        
        setSize(400,600);
        setLocation(20,20);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
    }
    
    public static void main(String[] args) {
        new MiniStmt("");
    }
}
