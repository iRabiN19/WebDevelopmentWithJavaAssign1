package view;

import javax.swing.*;

import controller.BankController;
import model.Bank;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class DepositView extends JFrame implements ActionListener {

    JLabel lbltitle, lblimage;
    JTextField txtamount;
    JButton btndeposit, btnback;
    static String cardno;
    static String pin;

    DepositView(String cardno, String pin) {
        DepositView.pin = pin;
        DepositView.cardno = cardno;

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

        btndeposit = new JButton("Deposit");
        btndeposit.setBounds(830, 365, 180, 50);
        btndeposit.setFont(new Font("Monospaced", Font.BOLD, 23));
        btndeposit.setBackground(Color.BLACK);
        btndeposit.setForeground(Color.CYAN);

        btnback = new JButton("Back");
        btnback.setBounds(830, 475, 180, 50);
        btnback.setFont(new Font("Monospaced", Font.BOLD, 23));
        btnback.setBackground(Color.BLACK);
        btnback.setForeground(Color.CYAN);

        lblimage.add(lbltitle);
        lblimage.add(txtamount);
        lblimage.add(btndeposit);
        lblimage.add(btnback);

        btndeposit.addActionListener(this);
        btnback.addActionListener(this);

        setLayout(null);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new DepositView(cardno, pin);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btndeposit) {

            String amount = txtamount.getText();
            Date d = new Date();
            String date = d.toString();

            if (txtamount.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
            } else {

                Bank deposit = new Bank(cardno, amount, "Deposit", date);

                BankController depositcont = new BankController();
                int insert = depositcont.balance(deposit);

                if (insert > 0) {
                    System.out.println("Amount Deposited successfully!");
                    JOptionPane.showMessageDialog(null, "Rs. " + amount + " Deposited Successfully");

                } else {
                    System.out.println("Error depositing amount!");
                }
                setVisible(false);
                new Transaction(cardno, pin).setVisible(true);
            }
        } else if (ae.getSource() == btnback) {
            setVisible(false);
            new Transaction("", "");
        }

    }
}
