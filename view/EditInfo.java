package view;

import javax.swing.*;

import database.DBConnection;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class EditInfo extends JFrame implements ActionListener {
    JLabel lblselection, lblimage;
    JButton btnpersonal, btnwithdraw, btnuspw, btnpin, btnexit;
    static String username;
    static String pin;

    String form;

    EditInfo(String username, String pin) {
        EditInfo.username = username;
        EditInfo.pin = pin;


        setSize(1360, 906);
        setLocation(350, 95);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/laptop.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1360, 906, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        lblimage = new JLabel(i3);
        lblimage.setBounds(0, 0, 1360, 906);
        add(lblimage);

        lblselection = new JLabel("Make Your Selection");
        lblselection.setForeground(Color.BLACK);
        lblselection.setFont(new Font("System", Font.BOLD, 35));
        lblselection.setBounds(525, 150, 700, 35);

        btnpersonal = new JButton("Edit personal info");
        btnpersonal.setBounds(360, 250, 250, 50);
        btnpersonal.setFont(new Font("Monospaced", Font.BOLD, 18));
        btnpersonal.setBackground(Color.BLACK);
        btnpersonal.setForeground(Color.CYAN);

        btnuspw = new JButton("Change username/password");
        btnuspw.setBounds(360, 365, 250, 50);
        btnuspw.setFont(new Font("Monospaced", Font.BOLD, 15));
        btnuspw.setBackground(Color.BLACK);
        btnuspw.setForeground(Color.CYAN);

        btnpin = new JButton("Change Pin");
        btnpin.setBounds(360, 475, 250, 50);
        btnpin.setFont(new Font("Monospaced", Font.BOLD, 18));
        btnpin.setBackground(Color.BLACK);
        btnpin.setForeground(Color.CYAN);

        btnexit = new JButton("EXIT");
        btnexit.setBounds(830, 475, 180, 50);
        btnexit.setFont(new Font("Monospaced", Font.BOLD, 20));
        btnexit.setBackground(Color.BLACK);
        btnexit.setForeground(Color.CYAN);

        lblimage.add(lblselection);
        lblimage.add(btnpersonal);
        lblimage.add(btnuspw);
        lblimage.add(btnpin);
        lblimage.add(btnexit);

        btnpersonal.addActionListener(this);
        btnuspw.addActionListener(this);
        btnpin.addActionListener(this);
        btnexit.addActionListener(this);

        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        try{
            DBConnection db = new DBConnection();
            String query="select * from accountdetails where username = '" + username + "';";
            ResultSet rs;
        rs = db.select(query);
            while(rs.next()){
                form=rs.getString("formno");
            }
        }catch(Exception e){
            System.out.println(e);
        }

        if (ae.getSource() == btnexit) {
            new Transaction(username);
            this.dispose();
        } else if (ae.getSource() == btnpersonal) {
            new CustomerPDetailsView("update",form);
            this.dispose();
        } else if (ae.getSource() == btnpin) {
            new BalanceEnquiry(username);
            this.dispose();
        } else if (ae.getSource() == btnuspw) {
            new UserPW(username);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new EditInfo(username,pin);
    }
}
