package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transaction extends JFrame implements ActionListener {
    JLabel lbltransaction, lblimage;
    JButton btndeposit, btnwithdraw, btnstatement, btnedit, btnenquiry, btnexit;
    static String username;

    Transaction(String username) {
        Transaction.username = username;

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
        btndeposit.setBounds(360, 250, 200, 50);
        btndeposit.setFont(new Font("Monospaced", Font.BOLD, 18));
        btndeposit.setBackground(Color.BLACK);
        btndeposit.setForeground(Color.CYAN);

        btnwithdraw = new JButton("CASH WITHDRAWL");
        btnwithdraw.setBounds(810, 250, 200, 50);
        btnwithdraw.setFont(new Font("Monospaced", Font.BOLD, 17));
        btnwithdraw.setBackground(Color.BLACK);
        btnwithdraw.setForeground(Color.CYAN);

        btnstatement = new JButton("MINI STATEMENT");
        btnstatement.setBounds(360, 365, 200, 50);
        btnstatement.setFont(new Font("Monospaced", Font.BOLD, 17));
        btnstatement.setBackground(Color.BLACK);
        btnstatement.setForeground(Color.CYAN);

        btnedit = new JButton("Edit information");
        btnedit.setBounds(810, 365, 200, 50);
        btnedit.setFont(new Font("Monospaced", Font.BOLD, 17));
        btnedit.setBackground(Color.BLACK);
        btnedit.setForeground(Color.CYAN);

        btnenquiry = new JButton("BALANCE ENQUIRY");
        btnenquiry.setBounds(360, 475, 200, 50);
        btnenquiry.setFont(new Font("Monospaced", Font.BOLD, 15));
        btnenquiry.setBackground(Color.BLACK);
        btnenquiry.setForeground(Color.CYAN);

        btnexit = new JButton("EXIT");
        btnexit.setBounds(810, 475, 200, 50);
        btnexit.setFont(new Font("Monospaced", Font.BOLD, 20));
        btnexit.setBackground(Color.BLACK);
        btnexit.setForeground(Color.CYAN);

        lblimage.add(lbltransaction);
        lblimage.add(btndeposit);
        lblimage.add(btnwithdraw);
        lblimage.add(btnstatement);
        lblimage.add(btnedit);
        lblimage.add(btnenquiry);
        lblimage.add(btnexit);

        btndeposit.addActionListener(this);
        btnwithdraw.addActionListener(this);
        btnstatement.addActionListener(this);
        btnedit.addActionListener(this);
        btnenquiry.addActionListener(this);
        btnexit.addActionListener(this);

        setLayout(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnexit) {
            new Continue(username);
            this.dispose();
        } else if (ae.getSource() == btndeposit) {
            new DepositView(username);
            this.dispose();
        } else if (ae.getSource() == btnwithdraw) {
            new Withdrawl(username);
            this.dispose();
        } else if (ae.getSource() == btnedit) {
            new PinVerification(username, "", "edit");
            this.dispose();
        } else if (ae.getSource() == btnenquiry) {
            new BalanceEnquiry(username);
            this.dispose();
        } else if (ae.getSource() == btnstatement) {
            new MiniStatement(username);
            this.dispose();
        }
    }

    public static void main(String[] args) {
        new Transaction(username);
    }
}
