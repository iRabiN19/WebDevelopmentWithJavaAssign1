package view;

import javax.swing.*;

import controller.BankController;
import controller.AccountDetailsController;
import model.Bank;
import model.AccountDetails;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class PinVerification extends JFrame implements ActionListener {
    JLabel lblinput;
    JPasswordField txtpin;
    JButton btnok, btnno;
    int verify = 0;
    static String username;
    static String amount;
    static String mode;

    PinVerification(String username, String amount, String mode) {
        PinVerification.username = username;
        PinVerification.amount = amount;
        PinVerification.mode = mode;

        setTitle("Menu Driven");
        setLayout(null);
        setSize(400, 250);

        Color color = new Color(0, 127, 98);
        getContentPane().setBackground(color);

        lblinput = new JLabel("Enter your pin:");
        lblinput.setBounds(90, 40, 280, 40);
        lblinput.setFont(new Font("Raleway", Font.BOLD, 30));
        lblinput.setForeground(Color.BLACK);

        txtpin = new JPasswordField("");
        txtpin.setBounds(60, 95, 280, 30);
        txtpin.setFont(new Font("Raleway", Font.BOLD, 20));

        btnok = new JButton("OK");
        btnok.setBounds(150, 150, 100, 30);
        btnok.setFont(new Font("Monospaced", Font.BOLD, 18));
        btnok.setBackground(Color.BLACK);
        btnok.setForeground(Color.CYAN);

        add(lblinput);
        add(btnok);
        add(txtpin);

        btnok.addActionListener(this);

        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new PinVerification(username, amount, mode);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnok) {
            Date d = new Date();
            String date = d.toString();

            String pin = String.valueOf(txtpin.getPassword());
            AccountDetailsController controller = new AccountDetailsController();
            AccountDetails customer = controller.pinVerification(username, pin);

            if (customer != null) {
                if (mode == "withdraw") {
                    Bank deposit = new Bank(username, "", amount, "Withdraw", date);
                    BankController depositcont = new BankController();
                    double balance = depositcont.transaction(username, amount);
                    if (balance !=0.0) {
                        depositcont.balance(deposit);
                        JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");
                        new Transaction(username);
                        this.dispose();

                    }
                } else if (mode == "edit") {
                    new EditInfo(username,pin);
                    this.dispose();
                }

            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Pin.");
            }

           

        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Pin!!");
        }
      
    }

}
