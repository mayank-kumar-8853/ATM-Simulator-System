
package atm.simulator.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
  
    Long randomno;
    JTextField nametf,fnametf,emailtf,addtf,citytf,statetf,pintf;
    JDateChooser dobdc;
    JRadioButton male,female,married,unmarried,other;
    JButton next;
    JLabel formno;
    
    SignupOne(){
        
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setTitle("NEW ACCOUNT APLLICATION FORM - PAGE 1");
        
        Random random = new Random();
        randomno = Math.abs((random.nextLong()% 9000L)+ 1000L);
        
        formno = new JLabel("APPLICATION FORM NO. " + randomno);
        formno.setFont(new Font("Times New Roman", Font.BOLD, 38));
        formno.setBounds(140,20,600,40);
        add(formno);
        
        JLabel personaldetails = new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Arial", Font.BOLD, 28));
        personaldetails.setBounds(240,80,600,40);
        add(personaldetails);
       
        JLabel name = new JLabel("Name: ");
        name.setFont(new Font("Arial", Font.BOLD, 18));
        name.setBounds(80,140,100,30);
        add(name);
        
        nametf = new JTextField();
        nametf.setFont(new Font("Arial", Font.BOLD, 14));
        nametf.setBounds(240,140,400,30);
        add(nametf);
        
        JLabel fname = new JLabel("Fathers Name: ");
        fname.setFont(new Font("Arial", Font.BOLD, 18));
        fname.setBounds(80,190,150,30);
        add(fname);
        
        fnametf = new JTextField();
        fnametf.setFont(new Font("Arial", Font.BOLD, 14));
        fnametf.setBounds(240,190,400,30);
        add(fnametf);
        
        JLabel dob = new JLabel("Date of Birth: ");
        dob.setFont(new Font("Arial", Font.BOLD, 18));
        dob.setBounds(80,240,150,30);
        add(dob);
        
        dobdc = new JDateChooser();
        dobdc.setForeground(Color.BLACK);
        dobdc.setFont(new Font("Arial", Font.BOLD, 14));
        dobdc.setBounds(240,240,400,30);
        add(dobdc);
        
        JLabel gender = new JLabel("Gender: ");
        gender.setFont(new Font("Arial", Font.BOLD, 18));
        gender.setBounds(80,290,150,30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBackground(Color.LIGHT_GRAY);
        male.setFont(new Font("Arial", Font.BOLD, 14));
        male.setBounds(240,290,100,30);
        add(male);
        
        female = new JRadioButton("Female");
        female.setBackground(Color.LIGHT_GRAY);
        female.setFont(new Font("Arial", Font.BOLD, 14));
        female.setBounds(380,290,100,30);
        add(female);
        
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(male);
        bg1.add(female);
        
        JLabel email = new JLabel("E-mail: ");
        email.setFont(new Font("Arial", Font.BOLD, 18));
        email.setBounds(80,340,150,30);
        add(email);
        
        emailtf = new JTextField();
        emailtf.setFont(new Font("Arial", Font.BOLD, 14));
        emailtf.setBounds(240,340,400,30);
        add(emailtf);
        
        JLabel marstat = new JLabel("Marital Status: ");
        marstat.setFont(new Font("Arial", Font.BOLD, 18));
        marstat.setBounds(80,390,150,30);
        add(marstat);
        
        married = new JRadioButton("Married");
        married.setBackground(Color.LIGHT_GRAY);
        married.setFont(new Font("Arial", Font.BOLD, 14));
        married.setBounds(240,390,100,30);
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBackground(Color.LIGHT_GRAY);
        unmarried.setFont(new Font("Arial", Font.BOLD, 14));
        unmarried.setBounds(380,390,100,30);
        add(unmarried);
        
        other = new JRadioButton("Other");
        other.setBackground(Color.LIGHT_GRAY);
        other.setFont(new Font("Arial", Font.BOLD, 14));
        other.setBounds(520,390,100,30);
        add(other);
        
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(married);
        bg2.add(unmarried);
        bg2.add(other);
        
        JLabel add = new JLabel("Address: ");
        add.setFont(new Font("Arial", Font.BOLD, 18));
        add.setBounds(80,440,150,30);
        add(add);
        
        addtf = new JTextField();
        addtf.setFont(new Font("Arial", Font.BOLD, 14));
        addtf.setBounds(240,440,400,30);
        add(addtf);
        
        JLabel city = new JLabel("City: ");
        city.setFont(new Font("Arial", Font.BOLD, 18));
        city.setBounds(80,490,150,30);
        add(city);
        
        citytf = new JTextField();
        citytf.setFont(new Font("Arial", Font.BOLD, 14));
        citytf.setBounds(240,490,400,30);
        add(citytf);
        
        JLabel state = new JLabel("State: ");
        state.setFont(new Font("Arial", Font.BOLD, 18));
        state.setBounds(80,540,150,30);
        add(state);
        
        statetf = new JTextField();
        statetf.setFont(new Font("Arial", Font.BOLD, 14));
        statetf.setBounds(240,540,400,30);
        add(statetf);
        
        JLabel pin = new JLabel("PIN: ");
        pin.setFont(new Font("Arial", Font.BOLD, 18));
        pin.setBounds(80,590,150,30);
        add(pin);
        
        pintf = new JTextField();
        pintf.setFont(new Font("Arial", Font.BOLD, 14));
        pintf.setBounds(240,590,400,30);
        add(pintf);
        
        next = new JButton("Next");
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Arial", Font.BOLD, 14));
        next.setBounds(540,650,100,30);
        next.addActionListener(this);
        add(next);
        
        setSize(850,850);
        setLocation(350,10);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
        
    };
    
    public void actionPerformed(ActionEvent ae){
    
        String random = "" + randomno;
        String name = nametf.getText();
        String fname = fnametf.getText();
        String dob = ((JTextField)dobdc.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if (male.isSelected()){
            gender = "Male";
        } else if (female.isSelected()){
            gender = "Female";
        }
        String email = emailtf.getText();
        String maritalstatus = null;
        if (married.isSelected()){
            maritalstatus = "Married";
        } else if (unmarried.isSelected()){
            maritalstatus = "Unmarried";
        } else if (other.isSelected()){
            maritalstatus = "Other";
        }
        String address = addtf.getText();
        String city = citytf.getText();
        String state = statetf.getText();
        String pin = pintf.getText();
        
        try{
            if(name.equals("")){
            JOptionPane.showMessageDialog(null, "name field is required");
            } else{
                Conn c = new Conn();
                String query = "insert into signup values ('" +random+ "', '" +name+ "', '" +fname+ "', '" +dob+ "', '" +gender+"', '" +email+ "', '" +maritalstatus+ "', '" +address+ "', '" +city+ "', '" +state+ "', '" +pin+ "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupTwo(random);
            }
                
        }
        catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        
        new SignupOne();
    }
}
