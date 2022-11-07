package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import controller.BankController;

public class BalanceEnquiry extends JFrame implements ActionListener {
    JLabel lblimage, lbltitle, lblbalance;
    JButton btnback;
    static String username;

    BalanceEnquiry(String username) {
        BalanceEnquiry.username = username;

        setSize(1360, 906);
        setLocation(350, 95);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/laptop.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1360, 906, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        lblimage = new JLabel(i3);
        lblimage.setBounds(0, 0, 1360, 906);
        add(lblimage);

        lbltitle = new JLabel("Balance Enquiry");
        lbltitle.setForeground(Color.BLACK);
        lbltitle.setFont(new Font("System", Font.BOLD, 35));
        lbltitle.setBounds(525, 150, 400, 40);

        lblbalance = new JLabel();
        lblbalance.setFont(new Font("Raleway", Font.BOLD, 25));
        lblbalance.setBounds(425, 210, 400, 30);

        btnback = new JButton("Back");
        btnback.setBounds(830, 475, 180, 50);
        btnback.setFont(new Font("Monospaced", Font.BOLD, 23));
        btnback.setBackground(Color.BLACK);
        btnback.setForeground(Color.CYAN);

        BankController controller = new BankController();
        double balance = controller.transaction(username, "");

        lblbalance.setText("Your balance is Rs." + balance);

        lblimage.add(lbltitle);
        lblimage.add(lblbalance);
        lblimage.add(btnback);

        btnback.addActionListener(this);

        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry(username);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Transaction(username);
        this.dispose();
    }

}
