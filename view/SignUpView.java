package view;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.*;

import controller.SignUpController;
import model.SignUp;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SignUpView extends JFrame implements ActionListener {

    JLabel lbltitle, lblsubtitle, lblname, lblfathersname, lbldob, lblgender,
            lblemail, lblmart, lbladdress, lblcity, lblstate, lblpin;
    JTextField txtname, txtfathersname, txtemail, txtaddress,
            txtcity, txtstate, txtpin;
    JDateChooser dateChooser;
    JRadioButton btnmale, btnfemale, btngother, btnmarried, btnunmarried, btnmsother;
    ButtonGroup genderGroup, martstatGroup;
    JButton btnnext;
    Random ran = new Random();
    int  num = Math.abs(ran.nextInt(10000));
    
    Font ftitle = new Font("Marker Felt", Font.BOLD, 38);

    SignUpView() {
        setSize(850, 800);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        // Generate random number
        

        lbltitle = new JLabel("Application Form No. " + num);
        lbltitle.setFont(ftitle);
        lbltitle.setBounds(140, 20, 600, 40);

        lblsubtitle = new JLabel("Page 1:Personal Details");
        lblsubtitle.setFont(new Font("Marker Felt", Font.BOLD, 25));
        lblsubtitle.setBounds(230, 75, 400, 30);

        lblname = new JLabel("Name:");
        lblname.setFont(new Font("Raleway", Font.BOLD, 20));
        lblname.setBounds(100, 140, 200, 30);
        txtname = new JTextField();
        txtname.setBounds(300, 140, 300, 30);

        lblfathersname = new JLabel("Father's Name:");
        lblfathersname.setFont(new Font("Raleway", Font.BOLD, 20));
        lblfathersname.setBounds(100, 190, 200, 30);
        txtfathersname = new JTextField();
        txtfathersname.setBounds(300, 190, 300, 30);

        lbldob = new JLabel("Date of Birth:");
        lbldob.setFont(new Font("Raleway", Font.BOLD, 20));
        lbldob.setBounds(100, 240, 200, 30);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 300, 30);
        dateChooser.setForeground(new Color(125, 125, 125));
        dateChooser.setDateFormatString("yyyy-MM-dd");

        lblgender = new JLabel("Gender:");
        lblgender.setFont(new Font("Raleway", Font.BOLD, 20));
        lblgender.setBounds(100, 290, 200, 30);

        btnmale = new JRadioButton("Male");
        btnmale.setBounds(300, 290, 100, 30);
        btnmale.setBackground(new Color(255, 255, 255));
        btnfemale = new JRadioButton("Female");
        btnfemale.setBounds(400, 290, 100, 30);
        btnfemale.setBackground(new Color(255, 255, 255));
        btngother = new JRadioButton("Others");
        btngother.setBounds(500, 290, 100, 30);
        btngother.setBackground(new Color(255, 255, 255));

        genderGroup = new ButtonGroup();
        genderGroup.add(btnmale);
        genderGroup.add(btnfemale);
        genderGroup.add(btngother);

        lblemail = new JLabel("Email:");
        lblemail.setFont(new Font("Raleway", Font.BOLD, 20));
        lblemail.setBounds(100, 340, 200, 30);
        txtemail = new JTextField();
        txtemail.setBounds(300, 340, 300, 30);

        lblmart = new JLabel("marital Status:");
        lblmart.setFont(new Font("Raleway", Font.BOLD, 20));
        lblmart.setBounds(100, 390, 200, 30);

        btnmarried = new JRadioButton("Married");
        btnmarried.setBounds(300, 390, 100, 30);
        btnmarried.setBackground(new Color(255, 255, 255));
        btnunmarried = new JRadioButton("Unmarried");
        btnunmarried.setBounds(400, 390, 100, 30);
        btnunmarried.setBackground(new Color(255, 255, 255));
        btnmsother = new JRadioButton("Others");
        btnmsother.setBounds(500, 390, 100, 30);
        btnmsother.setBackground(new Color(255, 255, 255));

        martstatGroup = new ButtonGroup();
        martstatGroup.add(btnmarried);
        martstatGroup.add(btnunmarried);
        martstatGroup.add(btnmsother);

        lbladdress = new JLabel("Address:");
        lbladdress.setFont(new Font("Raleway", Font.BOLD, 20));
        lbladdress.setBounds(100, 440, 200, 30);
        txtaddress = new JTextField();
        txtaddress.setBounds(300, 440, 300, 30);

        lblcity = new JLabel("City:");
        lblcity.setFont(new Font("Raleway", Font.BOLD, 20));
        lblcity.setBounds(100, 490, 200, 30);
        txtcity = new JTextField();
        txtcity.setBounds(300, 490, 300, 30);

        lblstate = new JLabel("State:");
        lblstate.setFont(new Font("Raleway", Font.BOLD, 20));
        lblstate.setBounds(100, 540, 200, 30);
        txtstate = new JTextField();
        txtstate.setBounds(300, 540, 300, 30);

        lblpin = new JLabel("Pin Code:");
        lblpin.setFont(new Font("Raleway", Font.BOLD, 20));
        lblpin.setBounds(100, 590, 200, 30);
        txtpin = new JTextField();
        txtpin.setBounds(300, 590, 300, 30);

        btnnext = new JButton("Next");
        btnnext.setFont(new Font("Monospaced", Font.BOLD, 20));
        btnnext.setBackground(Color.BLACK);
        btnnext.setForeground(Color.CYAN);
        btnnext.setBounds(620, 660, 100, 30);
        btnnext.addActionListener(this);

        add(lbltitle);
        add(lblsubtitle);
        add(lbladdress);
        add(lblcity);
        add(lbldob);
        add(lblemail);
        add(lblfathersname);
        add(lblgender);
        add(lblmart);
        add(lblname);
        add(lblstate);
        add(lblpin);
        add(txtaddress);
        add(txtcity);
        add(txtemail);
        add(txtfathersname);
        add(txtname);
        add(txtstate);
        add(txtpin);
        add(dateChooser);
        add(btnmale);
        add(btnfemale);
        add(btngother);
        add(btnmarried);
        add(btnunmarried);
        add(btnmsother);
        add(btnnext);

        setLocation(350, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        new SignUpView();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        int formno = num;
        String name = txtname.getText();
        String father_name = txtfathersname.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

        Date dateofbirth=new Date(2001-07-26);
        try {
            dateofbirth = formatter.parse(dob);
        } 
        catch (ParseException e1) {
            e1.printStackTrace();
        }
            
        String gender = "other";
        if (btnmale.isSelected()) {
            gender = "Male";
        } else if (btnfemale.isSelected()) {
            gender = "Female";
        } else if (btngother.isSelected()) {
            gender = "Other";
        }

        String email = txtemail.getText();
        String marital_status = "married";
        if (btnmarried.isSelected()) {
            marital_status = "Married";
        } else if (btnunmarried.isSelected()) {
            marital_status = "Unmarried";
        } else if (btnmsother.isSelected()) {
            marital_status = "Other";
        }

        String address = txtaddress.getText();
        String city = txtcity.getText();
        String state = txtstate.getText();
        String pin = txtpin.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill your name.");
            } else if (father_name.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill your father's name.");
            } else if (dob.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill your date of birth.");
            } else if (gender.equals("")) {
                JOptionPane.showMessageDialog(null, "Please select your gender.");
            } else if (email.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill your email.");
            } else if (marital_status.equals("")) {
                JOptionPane.showMessageDialog(null, "Please select your marital status.");
            } else if (address.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill your address.");
            } else if (city.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill your city.");
            } else if (state.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill your state.");
            } else if (pin.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill your pin.");
            } else {
                SignUp signUp = new SignUp(formno, name, father_name, dateofbirth, gender, email, marital_status,
                        address, city, state, pin);

                SignUpController singcont = new SignUpController();
                int insert = singcont.registerCustomer(signUp);

                if (insert > 0) {
                    System.out.println("Customer added successfully");
                } else {
                    System.out.println("Error registering customer");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
