package view;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Withdrawl extends JFrame implements ActionListener {

    JLabel lbltitle, lblimage;
    JTextField txtamount;
    JButton btnwithdraw, btnback;
    static String username;

    Withdrawl(String username) {
        Withdrawl.username = username;

        setSize(1360, 906);
        setLocation(350, 95);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/laptop.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1360, 906, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        lblimage = new JLabel(i3);
        lblimage.setBounds(0, 0, 1360, 906);
        add(lblimage);

        lbltitle = new JLabel("Please enter the amount: ");
        lbltitle.setForeground(Color.BLACK);
        lbltitle.setFont(new Font("System", Font.BOLD, 35));
        lbltitle.setBounds(425, 150, 700, 35);

        txtamount = new JTextField();
        txtamount.setBounds(425, 200, 450, 55);
        txtamount.setFont(new Font("Raleway", Font.BOLD, 50));

        btnwithdraw = new JButton("Withdraw");
        btnwithdraw.setBounds(830, 365, 180, 50);
        btnwithdraw.setFont(new Font("Monospaced", Font.BOLD, 23));
        btnwithdraw.setBackground(Color.BLACK);
        btnwithdraw.setForeground(Color.CYAN);

        btnback = new JButton("Back");
        btnback.setBounds(830, 475, 180, 50);
        btnback.setFont(new Font("Monospaced", Font.BOLD, 23));
        btnback.setBackground(Color.BLACK);
        btnback.setForeground(Color.CYAN);

        lblimage.add(lbltitle);
        lblimage.add(txtamount);
        lblimage.add(btnwithdraw);
        lblimage.add(btnback);

        btnwithdraw.addActionListener(this);
        btnback.addActionListener(this);

        setLayout(null);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Withdrawl(username);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnwithdraw) {

            String amount = txtamount.getText();

            if (txtamount.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
            } else {

                new PinVerification(username, amount, "withdraw");
                this.dispose();

            }
        } else if (ae.getSource() == btnback) {
            setVisible(false);
            new Transaction("");
        }

    }
}
