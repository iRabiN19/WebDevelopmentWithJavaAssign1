package view;

import javax.swing.*;

import controller.AccountDetailsController;
// import database.DBConnection;
import model.AccountDetails;

import java.awt.*;
import java.awt.event.*;
// import java.sql.ResultSet;

public class LoginView extends JFrame implements ActionListener {

    JLabel label, lblwlc, lblusername, lblpw;
    JTextField txtusername;
    JPasswordField txtpw;
    JButton btnlogin, btnreg, btnclear;

    LoginView() {

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

        lblusername = new JLabel("Username:");
        lblusername.setFont(new Font("Raleway", Font.BOLD, 23));
        lblusername.setBounds(120, 150, 300, 40);
        txtusername = new JTextField();
        txtusername.setFont(new Font("Arial", Font.BOLD, 16));
        txtusername.setBounds(340, 150, 270, 30);

        lblpw = new JLabel("Password:");
        lblpw.setFont(new Font("Raleway", Font.BOLD, 23));
        lblpw.setBounds(120, 200, 300, 40);
        txtpw = new JPasswordField();
        txtpw.setFont(new Font("Arial", Font.BOLD, 16));
        txtpw.setBounds(340, 200, 270, 30);

        btnlogin = new JButton("Log In");
        btnlogin.setBounds(300, 250, 150, 25);
        btnlogin.setFont(new Font("Monospaced", Font.BOLD, 23));
        btnlogin.setBackground(Color.BLACK);
        btnlogin.setForeground(Color.CYAN);

        btnreg = new JButton("Sign Up");
        btnreg.setBounds(360, 290, 150, 25);
        btnreg.setFont(new Font("Monospaced", Font.BOLD, 23));
        btnreg.setBackground(Color.BLACK);
        btnreg.setForeground(Color.CYAN);

        btnclear = new JButton("Clear");
        btnclear.setBounds(470, 250, 150, 25);
        btnclear.setFont(new Font("Monospaced", Font.BOLD, 23));
        btnclear.setBackground(Color.BLACK);
        btnclear.setForeground(Color.CYAN);

        btnlogin.addActionListener(this);
        btnreg.addActionListener(this);
        btnclear.addActionListener(this);

        add(label);
        add(lblwlc);
        add(lblusername);
        add(lblpw);
        add(txtusername);
        add(txtpw);
        add(btnlogin);
        add(btnreg);
        add(btnclear);

        Color color = new Color(242, 202, 133);
        getContentPane().setBackground(color);

        setLocation(500, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new LoginView();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnclear) {
            txtusername.setText("");
            txtpw.setText("");
        } else if (e.getSource() == btnreg) {
            setVisible(false);
            new CustomerPDetailsView().setVisible(true);

        } else if (e.getSource() == btnlogin) {
            String username = txtusername.getText();
            String password = String.valueOf(txtpw.getPassword());

            if (username.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill your username.");
            } else if (password.equals("")) {
                JOptionPane.showMessageDialog(null, "Please fill your password.");

            } else {

                AccountDetailsController controller = new AccountDetailsController();
                AccountDetails customer = controller.loginCustomer(username, password);
                if (customer != null) {

                  

                    new Transaction(username);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Username or password incorrect!!");
                }
            }
        }

    }

}