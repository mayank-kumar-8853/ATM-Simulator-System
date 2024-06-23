
package atm.simulator.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
 
    JButton next;
    JComboBox religionbox, categorybox, incomebox, edqualbox, occupationbox;
    JTextField pantf, aadhaartf;
    JRadioButton yes1, no1, yes2, no2;
    String random;
    
    
    SignupTwo(String random){
        
        setLayout(null);
        getContentPane().setBackground(Color.LIGHT_GRAY);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        this.random = random;
        
        JLabel additionaldetails = new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Arial", Font.BOLD, 28));
        additionaldetails.setBounds(240,80,600,40);
        add(additionaldetails);
       
        JLabel religion = new JLabel("Religion: ");
        religion.setFont(new Font("Arial", Font.BOLD, 18));
        religion.setBounds(80,140,100,30);
        add(religion);
        
        String[] religionarray = {"Hindu", "Sikh", "Muslim", "Christian", "Other"};
        religionbox = new JComboBox(religionarray);
        //religionbox.setBackground(Color.WHITE);
        religionbox.setFont(new Font("Arial", Font.BOLD, 14));
        religionbox.setBounds(240,140,400,30);
        add(religionbox);
        
        JLabel category = new JLabel("Category: ");
        category.setFont(new Font("Arial", Font.BOLD, 18));
        category.setBounds(80,190,150,30);
        add(category);
        
        String[] categoryarray = {"General", "OBC", "SC", "ST", "Other"};
        categorybox = new JComboBox(categoryarray);
        categorybox.setFont(new Font("Arial", Font.BOLD, 14));
        categorybox.setBounds(240,190,400,30);
        add(categorybox);
        
        JLabel income = new JLabel("Income: ");
        income.setFont(new Font("Arial", Font.BOLD, 18));
        income.setBounds(80,240,150,30);
        add(income);
        
        String[] incomearray = {"NULL", "< 2.5 lacs", "< 5.0 lacs", "< 7.5 lacs", "upto 10 lacs"};
        incomebox = new JComboBox(incomearray);
        //dobdc.setForeground(Color.BLACK);
        incomebox.setFont(new Font("Arial", Font.BOLD, 14));
        incomebox.setBounds(240,240,400,30);
        add(incomebox);
        
        JLabel eduactional = new JLabel("Educational");
        eduactional.setFont(new Font("Arial", Font.BOLD, 18));
        eduactional.setBounds(80,290,150,30);
        add(eduactional);
      
        JLabel qualification = new JLabel("qualification: ");
        qualification.setFont(new Font("Arial", Font.BOLD, 18));
        qualification.setBounds(80,320,150,30);
        add(qualification);
        
        String[] edqualarray = {"Non Graduate", "Graduate", "Post Graduate", "PhD", "Other"};
        edqualbox = new JComboBox(edqualarray);
        edqualbox.setFont(new Font("Arial", Font.BOLD, 14));
        edqualbox.setBounds(240,320,400,30);
        add(edqualbox);
        
        JLabel occupation = new JLabel("Occupation: ");
        occupation.setFont(new Font("Arial", Font.BOLD, 18));
        occupation.setBounds(80,390,150,30);
        add(occupation);
        
        String[] occupationarray = {"Salaried", "Self employed", "Business", "Student", "Retired"};
        occupationbox = new JComboBox(occupationarray);
        //occupationbox.setBackground(Color.LIGHT_GRAY);
        occupationbox.setFont(new Font("Arial", Font.BOLD, 14));
        occupationbox.setBounds(240,390,400,30);
        add(occupationbox);
        
        JLabel pan = new JLabel("PAN No: ");
        pan.setFont(new Font("Arial", Font.BOLD, 18));
        pan.setBounds(80,440,150,30);
        add(pan);
        
        pantf = new JTextField();
        pantf.setFont(new Font("Arial", Font.BOLD, 14));
        pantf.setBounds(240,440,400,30);
        add(pantf);
        
        JLabel aadhaar = new JLabel("Aadhaar No: ");
        aadhaar.setFont(new Font("Arial", Font.BOLD, 18));
        aadhaar.setBounds(80,490,150,30);
        add(aadhaar);
        
        aadhaartf = new JTextField();
        aadhaartf.setFont(new Font("Arial", Font.BOLD, 14));
        aadhaartf.setBounds(240,490,400,30);
        add(aadhaartf);
        
        JLabel seniorcitizen = new JLabel("Senior Citizen: ");
        seniorcitizen.setFont(new Font("Arial", Font.BOLD, 18));
        seniorcitizen.setBounds(80,540,150,30);
        add(seniorcitizen);
        
        yes1 = new JRadioButton("Yes");
        yes1.setBackground(Color.LIGHT_GRAY);
        yes1.setFont(new Font("Arial", Font.BOLD, 14));
        yes1.setBounds(240,540,150,30);
        add(yes1);
        
        no1 = new JRadioButton("No");
        no1.setBackground(Color.LIGHT_GRAY);
        no1.setFont(new Font("Arial", Font.BOLD, 14));
        no1.setBounds(400,540,150,30);
        add(no1);
        
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(yes1);
        bg1.add(no1);
        
        JLabel existacc = new JLabel("Existing A/c: ");
        existacc.setFont(new Font("Arial", Font.BOLD, 18));
        existacc.setBounds(80,590,150,30);
        add(existacc);
        
        yes2 = new JRadioButton("Yes");
        yes2.setBackground(Color.LIGHT_GRAY);
        yes2.setFont(new Font("Arial", Font.BOLD, 14));
        yes2.setBounds(240,590,150,30);
        add(yes2);
        
        no2 = new JRadioButton("No");
        no2.setBackground(Color.LIGHT_GRAY);
        no2.setFont(new Font("Arial", Font.BOLD, 14));
        no2.setBounds(400,590,150,30);
        add(no2);
        
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(yes2);
        bg2.add(no2);
        
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
        
        String religion = (String)religionbox.getSelectedItem();
        String category = (String)categorybox.getSelectedItem();
        String income = (String)incomebox.getSelectedItem();
        String edqual = (String)edqualbox.getSelectedItem();
        String occupation = (String)occupationbox.getSelectedItem();
        
        String seniorcitizen = null;
        if (yes1.isSelected()){
            seniorcitizen = "Yes";
        } else if (no1.isSelected()){
            seniorcitizen = "No";
        }
        
        String existacc = null;
        if (yes2.isSelected()){
            existacc = "Yes";
        } else if (no2.isSelected()){
            existacc = "No";
        } 
       
        String pan = pantf.getText();
        String aadhaar = aadhaartf.getText();
        
        try{
            if(pan.equals("")){
                JOptionPane.showMessageDialog(null, "pan no field is required");
            } else {
                Conn c = new Conn();
                String query = "insert into signuptwo values ('" +random+ "', '"+religion+ "', '" +category+ "', '" +income+ "', '" +edqual+ "', '" +occupation+"', '" +pan+ "', '" +aadhaar+ "', '" +seniorcitizen+ "', '" +existacc+ "')";
                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(random);
            }
          
        }
        catch (Exception e){
            System.out.println(e);
        }
        
    }
    
    public static void main(String[] args) {
        
        new SignupTwo("");
    }
}
