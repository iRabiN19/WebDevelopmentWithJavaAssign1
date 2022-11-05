package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    JLabel lbltransaction, lblimage;
    JButton btndeposit, btnwithdraw, b3, btnstatement, btnpin, btnenquiry, btnexit;
    static String cardno;
    static String pin;

    Transaction(String cardno, String pin) {
        Transaction.cardno = cardno;
        Transaction.pin = pin;

        setSize(1360, 906);
        setLocation(350, 95);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/laptop.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1360, 906, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        lblimage = new JLabel(i3);
        lblimage.setBounds(0, 0, 1360, 906);
        add(lblimage);

        lbltransaction = new JLabel("Please Select Your Transaction");
        lbltransaction.setForeground(Color.BLACK);
        lbltransaction.setFont(new Font("System", Font.BOLD, 35));
        lbltransaction.setBounds(425, 150, 700, 35);

        btndeposit = new JButton("DEPOSIT");
        btndeposit.setBounds(360, 250, 180, 50);
        btndeposit.setFont(new Font("Monospaced", Font.BOLD, 18));
        btndeposit.setBackground(Color.BLACK);
        btndeposit.setForeground(Color.CYAN);

        btnwithdraw = new JButton("CASH WITHDRAWL");
        btnwithdraw.setBounds(830, 250, 180, 50);
        btnwithdraw.setFont(new Font("Monospaced", Font.BOLD, 17));
        btnwithdraw.setBackground(Color.BLACK);
        btnwithdraw.setForeground(Color.CYAN);

        btnstatement = new JButton("MINI STATEMENT");
        btnstatement.setBounds(360, 365, 180, 50);
        btnstatement.setFont(new Font("Monospaced", Font.BOLD, 17));
        btnstatement.setBackground(Color.BLACK);
        btnstatement.setForeground(Color.CYAN);

        btnpin = new JButton("PIN CHANGE");
        btnpin.setBounds(830, 365, 180, 50);
        btnpin.setFont(new Font("Monospaced", Font.BOLD, 17));
        btnpin.setBackground(Color.BLACK);
        btnpin.setForeground(Color.CYAN);

        btnenquiry = new JButton("BALANCE ENQUIRY");
        btnenquiry.setBounds(360, 475, 180, 50);
        btnenquiry.setFont(new Font("Monospaced", Font.BOLD, 15));
        btnenquiry.setBackground(Color.BLACK);
        btnenquiry.setForeground(Color.CYAN);

        btnexit = new JButton("EXIT");
        btnexit.setBounds(830, 475, 180, 50);
        btnexit.setFont(new Font("Monospaced", Font.BOLD, 20));
        btnexit.setBackground(Color.BLACK);
        btnexit.setForeground(Color.CYAN);

        lblimage.add(lbltransaction);
        lblimage.add(btndeposit);
        lblimage.add(btnwithdraw);
        lblimage.add(btnstatement);
        lblimage.add(btnpin);
        lblimage.add(btnenquiry);
        lblimage.add(btnexit);

        btndeposit.addActionListener(this);
        btnwithdraw.addActionListener(this);
        btnstatement.addActionListener(this);
        btnpin.addActionListener(this);
        btnenquiry.addActionListener(this);
        btnexit.addActionListener(this);

        setLayout(null);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnexit) {
            setVisible(false);
            new Continue().setVisible(true);
        } else if (ae.getSource() == btndeposit) {
            setVisible(false);
            new DepositView(cardno,pin).setVisible(true);
        } else if (ae.getSource() == btnwithdraw) {
            setVisible(false);
            new Withdrawl(cardno,pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Transaction(cardno, pin);
    }
}
