package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login extends JFrame implements ActionListener {

    JLabel label, lblwlc, lblacc, lblpw;
    JTextField txtacc;
    JPasswordField txtpw;
    JButton btnlogin, btnreg, btnclear;

    Login() {

        setTitle("Banking System");
        setLayout(null);
        setSize(800, 400);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);

        lblwlc = new JLabel("Welcome to Kathmandu Bank Ltd");
        lblwlc.setFont(new Font("Oswald", Font.BOLD, 30));
        lblwlc.setBounds(200, 40, 500, 40);

        lblacc = new JLabel("Account Number:");
        lblacc.setFont(new Font("Raleway", Font.BOLD, 23));
        lblacc.setBounds(120, 150, 300, 40);
        txtacc = new JTextField();
        txtacc.setFont(new Font("Arial", Font.BOLD,16));
        txtacc.setBounds(340, 150, 270, 30);

        lblpw = new JLabel("Password:");
        lblpw.setFont(new Font("Raleway", Font.BOLD, 23));
        lblpw.setBounds(120, 200, 300, 40);
        txtpw = new JPasswordField();
        txtpw.setFont(new Font("Arial", Font.BOLD,16));
        txtpw.setBounds(340, 200, 270, 30);

        btnlogin = new JButton("Login");
        btnlogin.setBounds(300, 250, 110, 25);
        btnlogin.setFont(new Font("Raleway", Font.BOLD, 20));
        btnlogin.setBackground(Color.BLACK);
        btnlogin.setForeground(Color.CYAN);

        btnreg = new JButton("Sign Up");
        btnreg.setBounds(360, 290, 110, 25);
        btnreg.setFont(new Font("Raleway", Font.BOLD, 20));
        btnreg.setBackground(Color.BLACK);
        btnreg.setForeground(Color.CYAN);

        btnclear = new JButton("Clear");
        btnclear.setBounds(430, 250, 110, 25);
        btnclear.setFont(new Font("Raleway", Font.BOLD, 20));
        btnclear.setBackground(Color.BLACK);
        btnclear.setForeground(Color.CYAN);

        btnlogin.addActionListener(this);
        btnreg.addActionListener(this);
        btnclear.addActionListener(this);

        add(label);
        add(lblwlc);
        add(lblacc);
        add(lblpw);
        add(txtacc);
        add(txtpw);
        add(btnlogin);
        add(btnreg);
        add(btnclear);

        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

 

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnclear) {
            txtacc.setText("");
            txtpw.setText("");
        } else if (e.getSource() == btnreg) {

        } else if (e.getSource() == btnlogin) {

        }
        
    }

}