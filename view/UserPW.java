package view;

import javax.swing.*;

import controller.AccountDetailsController;
import database.DBConnection;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class UserPW extends JFrame implements ActionListener {
    JLabel lblimage, lbltitle, lbluser, lblnpw, lblrpw;
    JTextField txtuser;
    JPasswordField txtnpw, txtrpw;
    JButton btnchangepin, btnback;
    static String username;

    UserPW(String username) {
        UserPW.username = username;

        setSize(1360, 906);
        setLocation(350, 95);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/laptop.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1360, 906, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        lblimage = new JLabel(i3);
        lblimage.setBounds(0, 0, 1360, 906);
        add(lblimage);

        lbltitle = new JLabel("Change username and/or password");
        lbltitle.setForeground(Color.BLACK);
        lbltitle.setFont(new Font("System", Font.BOLD, 28));
        lbltitle.setBounds(495, 150, 700, 30);

        lbluser = new JLabel("Username:");
        lbluser.setFont(new Font("Raleway", Font.BOLD, 23));
        lbluser.setBounds(405, 210, 200, 25);
        txtuser = new JTextField();
        txtuser.setBounds(680, 210, 200, 25);
        txtuser.setFont(new Font("Raleway", Font.BOLD, 23));

        lblnpw = new JLabel("New password:");
        lblnpw.setFont(new Font("Raleway", Font.BOLD, 23));
        lblnpw.setBounds(405, 270, 200, 25);
        txtnpw = new JPasswordField();
        txtnpw.setBounds(680, 270, 200, 25);
        txtnpw.setFont(new Font("Raleway", Font.BOLD, 23));

        lblrpw = new JLabel("Confirm password:");
        lblrpw.setFont(new Font("Raleway", Font.BOLD, 23));
        lblrpw.setBounds(405, 330, 240, 25);
        txtrpw = new JPasswordField();
        txtrpw.setBounds(680, 330, 200, 25);
        txtrpw.setFont(new Font("Raleway", Font.BOLD, 23));

        btnchangepin = new JButton("Change");
        btnchangepin.setBounds(830, 415, 180, 50);
        btnchangepin.setFont(new Font("Monospaced", Font.BOLD, 23));
        btnchangepin.setBackground(Color.BLACK);
        btnchangepin.setForeground(Color.CYAN);

        btnback = new JButton("Back");
        btnback.setBounds(830, 475, 180, 50);
        btnback.setFont(new Font("Monospaced", Font.BOLD, 23));
        btnback.setBackground(Color.BLACK);
        btnback.setForeground(Color.CYAN);

        try{
            DBConnection db= new DBConnection();
            String query="select * from accountdetails where username='"+username+"';";
            ResultSet rs;
            rs=db.select(query);
            while(rs.next()){
                txtuser.setText(rs.getString("username"));
            }

                    }catch(Exception e){
                        System.out.println(e);
                    }

        lblimage.add(lbltitle);
        lblimage.add(lbluser);
        lblimage.add(txtuser);
        lblimage.add(lblnpw);
        lblimage.add(txtnpw);
        lblimage.add(lblrpw);
        lblimage.add(txtrpw);
        lblimage.add(btnchangepin);
        lblimage.add(btnback);

        btnchangepin.addActionListener(this);
        btnback.addActionListener(this);

        setLayout(null);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new UserPW(username);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnchangepin) {
            String user = txtuser.getText();
            String npw = String.valueOf(txtnpw.getPassword());
            String rpw = String.valueOf(txtrpw.getPassword());
            AccountDetailsController controller = new AccountDetailsController();
            if (user.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter the username.");
            } else if (npw.equals("") && !rpw.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter the password.");
            } else if (rpw.equals("") && !npw.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter the confirmed password");
            } else if (!npw.equals(rpw)) {
                JOptionPane.showMessageDialog(null, "The passwords do not match.");
                return;
            } else if (rpw.equals("") && npw.equals("") && !user.equals("")) {
                int update = controller.edituser(username, user);

                if (update > 0) {
                    System.out.println("Username changed successfully");
                    JOptionPane.showMessageDialog(null, "Username changed successfully");

                    new Transaction(username);
                    this.dispose();
                } else {
                    System.out.println("Error changing username.");
                }
            } else{
                int update = controller.edituserpw(username, user,rpw);

                if (update > 0) {
                    System.out.println("Username changed successfully");
                    JOptionPane.showMessageDialog(null, "Information updated successfully");

                    new Transaction(username);
                    this.dispose();
                } else {
                    System.out.println("Error changing username.");
                }

            }

        } else if (ae.getSource() == btnback) {
            new Transaction(username);
            this.dispose();
        }
    }
}
