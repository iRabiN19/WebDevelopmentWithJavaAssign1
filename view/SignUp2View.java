package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

import controller.SignUp2Controller;
import model.SignUp2;

public class SignUp2View extends JFrame implements ActionListener {

   
    JLabel lbladdDetails,lblreligion,lblphone,lblincome,lbledu,lblocc,
            lblpan,lblseniorc,lblextacc,lblqlc,lblform,lblcitizen;
    JButton btnnext;
    JRadioButton rbtnSCyes,rbtnSCno,rbtnEAyes,rbtnEAno;
    JTextField txtpan,txtphone,txtcitizen;
    JComboBox<String> combReligion,combIncome,combEdu,combOcc;
    static int formno;

    SignUp2View(int formno2){
        
        // ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        // Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        // ImageIcon i3 = new ImageIcon(i2);
        // JLabel l14 = new JLabel(i3);
        // l14.setBounds(150, 0, 100, 100);
        // add(l14);
        
        
        SignUp2View.formno = formno2;
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        lbladdDetails = new JLabel("Page 2: Additonal Details");
        lbladdDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        lbladdDetails.setBounds(280,30,600,40);
        
        lblreligion = new JLabel("Religion:");
        lblreligion.setFont(new Font("Raleway", Font.BOLD, 18));
        lblreligion.setBounds(100,120,100,30);
        

        lblphone = new JLabel("Phone no:");
        lblphone.setFont(new Font("Raleway", Font.BOLD, 18));
        lblphone.setBounds(100,170,100,30);
        txtphone = new JTextField();
        txtphone.setFont(new Font("Raleway", Font.BOLD, 14));
        txtphone.setBounds(350,170,320,30);
        
        lblincome = new JLabel("Income:");
        lblincome.setFont(new Font("Raleway", Font.BOLD, 18));
        lblincome.setBounds(100,220,100,30);
        
        lbledu = new JLabel("Educational");
        lbledu.setFont(new Font("Raleway", Font.BOLD, 18));
        lbledu.setBounds(100,270,150,30);
        
        lblqlc = new JLabel("Qualification:");
        lblqlc.setFont(new Font("Raleway", Font.BOLD, 18));
        lblqlc.setBounds(100,290,150,30);
        
        lblocc = new JLabel("Occupation:");
        lblocc.setFont(new Font("Raleway", Font.BOLD, 18));
        lblocc.setBounds(100,340,150,30);
        
        lblpan = new JLabel("PAN Number:");
        lblpan.setFont(new Font("Raleway", Font.BOLD, 18));
        lblpan.setBounds(100,390,150,30);
        txtpan = new JTextField();
        txtpan.setFont(new Font("Raleway", Font.BOLD, 14));
        txtpan.setBounds(350,390,320,30);    
        
        lblcitizen = new JLabel("Citizenship Number:");
        lblcitizen.setFont(new Font("Raleway", Font.BOLD, 18));
        lblcitizen.setBounds(100,440,150,30);
        txtcitizen = new JTextField();
        txtcitizen.setFont(new Font("Raleway", Font.BOLD, 14));
        txtcitizen.setBounds(350,440,320,30);  

        lblseniorc = new JLabel("Senior Citizen:");
        lblseniorc.setFont(new Font("Raleway", Font.BOLD, 18));
        lblseniorc.setBounds(100,490,150,30);
        
        lblextacc = new JLabel("Existing Account:");
        lblextacc.setFont(new Font("Raleway", Font.BOLD, 18));
        lblextacc.setBounds(100,540,180,30);
        
        lblform = new JLabel("Form No:"+formno2);
        lblform.setFont(new Font("Raleway", Font.BOLD, 13));
        lblform.setBounds(700,10,120,30);
                
        btnnext = new JButton("Next");
        btnnext.setFont(new Font("Monospaced", Font.BOLD, 20));
        btnnext.setBackground(Color.BLACK);
        btnnext.setForeground(Color.CYAN);
        btnnext.setBounds(570,640,100,30);
        
        
        rbtnSCyes = new JRadioButton("Yes");
        rbtnSCyes.setFont(new Font("Raleway", Font.BOLD, 14));
        rbtnSCyes.setBackground(Color.WHITE);
        rbtnSCyes.setBounds(350,490,100,30);
        
        rbtnSCno = new JRadioButton("No");
        rbtnSCno.setFont(new Font("Raleway", Font.BOLD, 14));
        rbtnSCno.setBackground(Color.WHITE);
        rbtnSCno.setBounds(460,490,100,30);
        
        rbtnEAyes = new JRadioButton("Yes");
        rbtnEAyes.setFont(new Font("Raleway", Font.BOLD, 14));
        rbtnEAyes.setBackground(Color.WHITE);
        rbtnEAyes.setBounds(350,540,100,30);
        
        rbtnEAno = new JRadioButton("No");
        rbtnEAno.setFont(new Font("Raleway", Font.BOLD, 14));
        rbtnEAno.setBackground(Color.WHITE);
        rbtnEAno.setBounds(460,540,100,30);        
        
        String religion[] = {"Hindu","Muslim","Buddhism","Christian","Other"};
        combReligion = new JComboBox<>(religion);
        combReligion.setBackground(Color.WHITE);
        combReligion.setFont(new Font("Raleway", Font.BOLD, 14));
        combReligion.setBounds(350,120,320,30);
                
        String income[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        combIncome = new JComboBox<>(income);
        combIncome.setBackground(Color.WHITE);
        combIncome.setFont(new Font("Raleway", Font.BOLD, 14));
        combIncome.setBounds(350,220,320,30);
        
        String education[] = {"Non-Graduate","Graduate","Post-Graduate","Doctrate","Others"};
        combEdu = new JComboBox<>(education);
        combEdu.setBackground(Color.WHITE);
        combEdu.setFont(new Font("Raleway", Font.BOLD, 14));
        combEdu.setBounds(350,270,320,30);
        
        String occupation[] = {"Salaried","Self-Employmed","Business","Student","Retired","Others"};
        combOcc = new JComboBox<>(occupation);
        combOcc.setBackground(Color.WHITE);
        combOcc.setFont(new Font("Raleway", Font.BOLD, 14));
        combOcc.setBounds(350,340,320,30);
       
        
        add(lblform);
        add(lbladdDetails);
        add(lblreligion);
        add(combReligion);
        add(lblphone);
        add(txtphone);
        add(lblincome);
        add(combIncome);
        add(lbledu);
        add(combEdu);
        add(lblqlc);
        add(lblocc);
        add(combOcc);
        add(lblpan);
        add(txtpan);
        add(lblcitizen);
        add(txtcitizen);
        add(lblseniorc);
        add(rbtnSCyes);
        add(rbtnSCno);
        add(lblextacc);
        add(rbtnEAyes);
        add(rbtnEAno);
        add(btnnext);
        

        btnnext.addActionListener(this);
        
        
        setSize(850,750);
        setLocation(500,120);
        setVisible(true);
    }
    
    
    public static void main(String[] args){
        new SignUp2View(formno);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String religion = (String)combReligion.getSelectedItem(); 
        String phone=txtphone.getText();
        String income = (String)combIncome.getSelectedItem();
        String qualification = (String)combEdu.getSelectedItem();
        String occupation = (String)combOcc.getSelectedItem();
        
        String pan = txtpan.getText();     
        String citizenship=txtcitizen.getText();   
        String seniorc = "";
        if(rbtnSCyes.isSelected()){ 
            seniorc = "Yes";
        }
        else if(rbtnSCno.isSelected()){ 
            seniorc = "No";
        }
           
        String existing = "";
        if(rbtnEAyes.isSelected()){ 
            existing = "Yes";
        }else if(rbtnEAno.isSelected()){ 
            existing = "No";
        }
        
        try{
            if(txtpan.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }else{
                SignUp2 signUp2 = new SignUp2(formno, religion, phone,  income, qualification,  occupation,  pan,  citizenship,
                 seniorc,  existing);

        SignUp2Controller sign2cont = new SignUp2Controller();
        int insert = sign2cont.registerCustomer(signUp2);

        if (insert > 0) {
            System.out.println("Customer added successfully");

            new SignUp3View(formno).setVisible(true);
        setVisible(false); 
        } else {
            System.out.println("Error registering customer");
        }
        
               
            }
                
      
            
        }catch(Exception ex){
             ex.printStackTrace();
        }
    }
}
