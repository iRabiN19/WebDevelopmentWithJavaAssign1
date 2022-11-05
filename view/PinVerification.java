package view;

import javax.swing.*;

import controller.BankController;
import controller.SignUp3Controller;
import model.Bank;
import model.SignUp3;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class PinVerification extends JFrame implements ActionListener {
    JLabel lblcontinue;
    JPasswordField txtpin;
    JButton btnok, btnno;

    static String cardno;
    static String pin;
    static String amount;

    PinVerification(String cardno, String pin, String amount) {
        PinVerification.cardno = cardno;
        PinVerification.pin = pin;
        PinVerification.amount = amount;

        setTitle("Menu Driven");
        setLayout(null);
        setSize(400, 250);

        Color color = new Color(0, 127, 98);
        getContentPane().setBackground(color);

        lblcontinue = new JLabel("Enter your pin:");
        lblcontinue.setBounds(90, 40, 280, 40);
        lblcontinue.setFont(new Font("Raleway", Font.BOLD, 30));
        lblcontinue.setForeground(Color.BLACK);

        txtpin = new JPasswordField("");
        txtpin.setBounds(60, 95, 280, 30);
        txtpin.setFont(new Font("Raleway", Font.BOLD, 20));

        btnok = new JButton("OK");
        btnok.setBounds(150, 150, 100, 30);
        btnok.setFont(new Font("Monospaced", Font.BOLD, 18));
        btnok.setBackground(Color.BLACK);
        btnok.setForeground(Color.CYAN);

        add(lblcontinue);
        add(btnok);
        add(txtpin);

        btnok.addActionListener(this);

        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new PinVerification(cardno, pin, amount);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnok) {
            Date d = new Date();
            String date = d.toString();
            String password = String.valueOf(txtpin.getPassword());
            SignUp3Controller controller = new SignUp3Controller();
            SignUp3 customer = controller.pinVerification(cardno, password);
            if (customer != null) {


                Bank deposit = new Bank(cardno, amount, "Withdraw", date);
                BankController depositcont = new BankController();
               Bank bank= depositcont.transaction(cardno, amount);
               if(bank!=null){
                depositcont.balance(deposit);
               }

                JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

                setVisible(false);

                new Transaction(cardno, password).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect Pin!!");
            }
            setVisible(false);
            new Transaction("", "").setVisible(true);
        }

    }
}
