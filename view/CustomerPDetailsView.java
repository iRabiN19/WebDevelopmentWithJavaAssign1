package view;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.*;

import controller.CustomerPController;
import database.DBConnection;
import model.CustomerPDetails;
import java.awt.event.*;
import java.sql.Date;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CustomerPDetailsView extends JFrame implements ActionListener {

    JLabel lbltitle, lblsubtitle, lblname, lblfathersname, lbldob, lblgender,
            lblemail, lblmart, lbladdress, lblcity, lblstate;
    JTextField txtname, txtfathersname, txtemail, txtaddress,
            txtcity, txtstate;
    JDateChooser dateChooser;
    JRadioButton btnmale, btnfemale, btngother, btnmarried, btnunmarried, btnmsother;
    ButtonGroup genderGroup, martstatGroup;
    JButton btnnext;
    Random ran = new Random();
    int num = Math.abs(ran.nextInt(10000));
    static String mode;
    static String form;

    CustomerPDetailsView(String mode, String form) {
        CustomerPDetailsView.mode = mode;
        CustomerPDetailsView.form = form;

        setSize(850, 800);
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 1");

        Color color = new Color(242, 202, 133);
        getContentPane().setBackground(color);

        lbltitle = new JLabel("Application Form No. " + num);
        lbltitle.setFont(new Font("Marker Felt", Font.BOLD, 38));
        lbltitle.setBounds(140, 20, 600, 40);

        lblsubtitle = new JLabel("Page 1:Personal Details");
        lblsubtitle.setFont(new Font("Marker Felt", Font.BOLD, 25));
        lblsubtitle.setBounds(230, 75, 400, 30);

        lblname = new JLabel("Name:");
        lblname.setFont(new Font("Raleway", Font.BOLD, 20));
        lblname.setBounds(100, 140, 200, 30);
        txtname = new JTextField();
        txtname.setBounds(300, 140, 300, 30);
        txtname.setFont(new Font("Raleway", Font.BOLD, 20));

        lblfathersname = new JLabel("Father's Name:");
        lblfathersname.setFont(new Font("Raleway", Font.BOLD, 20));
        lblfathersname.setBounds(100, 190, 200, 30);
        txtfathersname = new JTextField();
        txtfathersname.setBounds(300, 190, 300, 30);
        txtfathersname.setFont(new Font("Raleway", Font.BOLD, 20));

        lbldob = new JLabel("Date of Birth:");
        lbldob.setFont(new Font("Raleway", Font.BOLD, 20));
        lbldob.setBounds(100, 240, 200, 30);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 300, 30);
        dateChooser.setForeground(new Color(125, 125, 125));
        dateChooser.setDateFormatString("yyyy-MM-dd");
        dateChooser.setFont(new Font("Raleway", Font.BOLD, 20));

        lblgender = new JLabel("Gender:");
        lblgender.setFont(new Font("Raleway", Font.BOLD, 20));
        lblgender.setBounds(100, 290, 200, 30);

        btnmale = new JRadioButton("Male");
        btnmale.setBounds(300, 290, 100, 30);
        btnmale.setBackground(color);
        btnfemale = new JRadioButton("Female");
        btnfemale.setBounds(400, 290, 100, 30);
        btnfemale.setBackground(color);
        btngother = new JRadioButton("Others");
        btngother.setBounds(500, 290, 100, 30);
        btngother.setBackground(color);

        genderGroup = new ButtonGroup();
        genderGroup.add(btnmale);
        genderGroup.add(btnfemale);
        genderGroup.add(btngother);

        lblemail = new JLabel("Email:");
        lblemail.setFont(new Font("Raleway", Font.BOLD, 20));
        lblemail.setBounds(100, 340, 200, 30);
        txtemail = new JTextField();
        txtemail.setBounds(300, 340, 300, 30);
        txtemail.setFont(new Font("Raleway", Font.BOLD, 20));

        lblmart = new JLabel("Marital Status:");
        lblmart.setFont(new Font("Raleway", Font.BOLD, 20));
        lblmart.setBounds(100, 390, 200, 30);

        btnmarried = new JRadioButton("Married");
        btnmarried.setBounds(300, 390, 100, 30);
        btnmarried.setBackground(color);
        btnunmarried = new JRadioButton("Unmarried");
        btnunmarried.setBounds(400, 390, 100, 30);
        btnunmarried.setBackground(color);
        btnmsother = new JRadioButton("Others");
        btnmsother.setBounds(500, 390, 100, 30);
        btnmsother.setBackground(color);

        martstatGroup = new ButtonGroup();
        martstatGroup.add(btnmarried);
        martstatGroup.add(btnunmarried);
        martstatGroup.add(btnmsother);

        lbladdress = new JLabel("Address:");
        lbladdress.setFont(new Font("Raleway", Font.BOLD, 20));
        lbladdress.setBounds(100, 440, 200, 30);
        txtaddress = new JTextField();
        txtaddress.setBounds(300, 440, 300, 30);
        txtaddress.setFont(new Font("Raleway", Font.BOLD, 20));

        lblcity = new JLabel("City:");
        lblcity.setFont(new Font("Raleway", Font.BOLD, 20));
        lblcity.setBounds(100, 490, 200, 30);
        txtcity = new JTextField();
        txtcity.setBounds(300, 490, 300, 30);
        txtcity.setFont(new Font("Raleway", Font.BOLD, 20));

        lblstate = new JLabel("State:");
        lblstate.setFont(new Font("Raleway", Font.BOLD, 20));
        lblstate.setBounds(100, 540, 200, 30);
        txtstate = new JTextField();
        txtstate.setBounds(300, 540, 300, 30);
        txtstate.setFont(new Font("Raleway", Font.BOLD, 20));

        btnnext = new JButton("Next");
        btnnext.setFont(new Font("Monospaced", Font.BOLD, 20));
        btnnext.setBackground(Color.BLACK);
        btnnext.setForeground(Color.CYAN);
        btnnext.setBounds(620, 660, 100, 30);
        btnnext.addActionListener(this);

        if (mode.equals("update")) {
            setTitle("Update Info");
            lbltitle.setText("");
            try {
                DBConnection db = new DBConnection();
                String query = "select * from customerPdetails where formno = '" + form + "';";
                ResultSet rs;
                rs = db.select(query);

                while (rs.next()) {
                    txtname.setText(rs.getString("name"));
                    txtfathersname.setText(rs.getString("father_name"));
                    dateChooser.setDate(rs.getDate("dob"));

                    if (rs.getString("gender").equals("Male")) {
                        btnmale.setSelected(true);
                    } else if (rs.getString("gender").equals("Female")) {
                        btnfemale.setSelected(true);
                    } else if (rs.getString("gender").equals("Other")) {
                        btngother.setSelected(true);
                    }

                    txtemail.setText(rs.getString("email"));

                    if (rs.getString("marital_status").equals("Married")) {
                        btnmarried.setSelected(true);
                    } else if (rs.getString("marital_status").equals("Unmarried")) {
                        btnunmarried.setSelected(true);
                    } else if (rs.getString("marital_status").equals("Other")) {
                        btnmsother.setSelected(true);
                    }

                    txtaddress.setText(rs.getString("address"));
                    txtcity.setText(rs.getString("city"));
                    txtstate.setText(rs.getString("state"));

                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }

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
        add(txtaddress);
        add(txtcity);
        add(txtemail);
        add(txtfathersname);
        add(txtname);
        add(txtstate);
        add(dateChooser);
        add(btnmale);
        add(btnfemale);
        add(btngother);
        add(btnmarried);
        add(btnunmarried);
        add(btnmsother);
        add(btnnext);

        setLocation(500, 120);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {

        new CustomerPDetailsView(mode, form);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        int formno = num;

        String name = txtname.getText();

        String father_name = txtfathersname.getText();

        String strdate = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date date = new java.util.Date();
        try {
            date = sdf.parse(strdate);
        } catch (ParseException e1) {
            e1.printStackTrace();
        }

        java.sql.Date dob = new Date(date.getTime());

        String gender = null;
        if (btnmale.isSelected()) {
            gender = "Male";
        } else if (btnfemale.isSelected()) {
            gender = "Female";
        } else if (btngother.isSelected()) {
            gender = "Other";
        }

        String email = txtemail.getText();
        String marital_status = null;
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

        if (ae.getSource() == btnnext) {
            try {
                if (name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill your name.");
                } else if (father_name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill your father's name.");
                } else if (strdate.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill your date of birth.");
                } else if (email.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill your email.");
                } else if (address.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill your address.");
                } else if (city.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill your city.");
                } else if (state.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill your state.");
                } else {

                    if (mode.equals("update")) {
                        CustomerPDetails customerPDetails = new CustomerPDetails(name, father_name, dob, gender, email,
                                marital_status,
                                address, city, state);
                        CustomerPController controller = new CustomerPController();
                        int update = controller.updatedetails(customerPDetails, form);
                        if (update > 0) {
                            System.out.println("Details updated successfully");
                        } else {
                            System.out.println("Error updating details.");
                        }
                    }
                    CustomerPDetails signUp = new CustomerPDetails(formno, name, father_name, dob, gender, email,
                            marital_status,
                            address, city, state);
                    CustomerPController controller = new CustomerPController();
                    int insert = controller.registerCustomer(signUp);

                    if (insert > 0) {
                        System.out.println("Customer added successfully");
                    } else {
                        System.out.println("Error registering customer");
                    }

                    new CustomerADetailsView(formno, mode, form);
                    this.dispose();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

}
