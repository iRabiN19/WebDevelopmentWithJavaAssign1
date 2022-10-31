package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class SignUp3View extends JFrame implements ActionListener {

    JLabel lblform, lbltype, lblcard, lblcardno, lblcarddetails, lblappear,
            lblpin, lblpinx, lblpindetails, lblpass, lblservices;
    JRadioButton rbtnsav, rbtnsalary;
    ButtonGroup grpaccount;
    JCheckBox chkatm, chkinternet, chkmobile, chkemail, chkcheque,
            chkestat, chkknowledge;
    JButton btnsubmit, btncancel;
    static int formno;

    public SignUp3View(int formno3) {

        SignUp3View.formno = formno3;

        setTitle("Sthg");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        lblform = new JLabel("Page 3:Account Details");
        lblform.setFont(new Font("Raleway", Font.BOLD, 23));
        lblform.setBounds(280, 45, 400, 35);

        lbltype = new JLabel("Account Type");
        lbltype.setFont(new Font("Raleway", Font.BOLD, 17));
        lbltype.setBounds(100, 145, 200, 30);

        rbtnsav = new JRadioButton("Saving Account");
        rbtnsav.setFont(new Font("Raleway", Font.BOLD, 17));
        rbtnsav.setBounds(100, 185, 200, 20);
        rbtnsav.setBackground(Color.WHITE);

        rbtnsalary = new JRadioButton("Salary Account");
        rbtnsalary.setFont(new Font("Raleway", Font.BOLD, 17));
        rbtnsalary.setBounds(320, 185, 200, 20);
        rbtnsalary.setBackground(Color.WHITE);

        grpaccount = new ButtonGroup();
        grpaccount.add(rbtnsav);
        grpaccount.add(rbtnsalary);

        lblcard = new JLabel("Card Number:");
        lblcard.setFont(new Font("Raleway", Font.BOLD, 23));
        lblcard.setBounds(100, 205, 200, 30);

        lblcardno = new JLabel("XXXX-XXXX-XXXX-7581");
        lblcardno.setFont(new Font("Raleway", Font.BOLD, 23));
        lblcardno.setBounds(330, 205, 300, 30);
        lblcarddetails = new JLabel("(Your 16-digit Card number)");
        lblcarddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        lblcarddetails.setBounds(100, 235, 200, 20);
        lblappear = new JLabel("It would appear on ATM Card/Cheque Book and Statements");
        lblappear.setFont(new Font("Raleway", Font.BOLD, 12));
        lblappear.setBounds(330, 235, 500, 20);

        lblpin = new JLabel("Pin:");
        lblpin.setFont(new Font("Raleway", Font.BOLD, 23));
        lblpin.setBounds(100, 275, 200, 30);

        lblpinx = new JLabel("XXXX");
        lblpinx.setFont(new Font("Raleway", Font.BOLD, 23));
        lblpinx.setBounds(330, 275, 200, 30);
        lblpass = new JLabel("(Your 4-digit pin)");
        lblpass.setFont(new Font("Raleway", Font.BOLD, 12));
        lblpass.setBounds(100, 305, 200, 20);

        lblservices = new JLabel("Services Required:");
        lblservices.setFont(new Font("Raleway", Font.BOLD, 23));
        lblservices.setBounds(100, 355, 450, 20);

        chkatm = new JCheckBox("ATM CARD");
        chkatm.setBackground(Color.WHITE);
        chkatm.setFont(new Font("Raleway", Font.BOLD, 16));
        chkatm.setBounds(100, 405, 200, 30);

        chkinternet = new JCheckBox("Internet Banking");
        chkinternet.setBackground(Color.WHITE);
        chkinternet.setFont(new Font("Raleway", Font.BOLD, 16));
        chkinternet.setBounds(350, 405, 200, 30);

        chkmobile = new JCheckBox("Mobile Banking");
        chkmobile.setBackground(Color.WHITE);
        chkmobile.setFont(new Font("Raleway", Font.BOLD, 16));
        chkmobile.setBounds(100, 455, 200, 30);

        chkemail = new JCheckBox("EMAIL Alerts");
        chkemail.setBackground(Color.WHITE);
        chkemail.setFont(new Font("Raleway", Font.BOLD, 16));
        chkemail.setBounds(350, 455, 200, 30);

        chkcheque = new JCheckBox("Cheque Book");
        chkcheque.setBackground(Color.WHITE);
        chkcheque.setFont(new Font("Raleway", Font.BOLD, 16));
        chkcheque.setBounds(100, 505, 200, 30);

        chkestat = new JCheckBox("E-Statement");
        chkestat.setBackground(Color.WHITE);
        chkestat.setFont(new Font("Raleway", Font.BOLD, 16));
        chkestat.setBounds(350, 505, 200, 30);

        chkknowledge = new JCheckBox(
                "I hereby declare that the above entered details are correct to the best of my knowledge.", true);
        chkknowledge.setBackground(Color.WHITE);
        chkknowledge.setFont(new Font("Raleway", Font.BOLD, 12));
        chkknowledge.setBounds(100, 585, 550, 30);

        btnsubmit = new JButton("Submit");
        btnsubmit.setBackground(Color.BLACK);
        btnsubmit.setForeground(Color.CYAN);
        btnsubmit.setFont(new Font("Monospaced", Font.BOLD, 20));
        btnsubmit.setBounds(250, 625, 150, 30);

        btncancel = new JButton("Cancel");
        btncancel.setBackground(Color.BLACK);
        btncancel.setForeground(Color.CYAN);
        btncancel.setFont(new Font("Monospaced", Font.BOLD, 20));
        btncancel.setBounds(450, 625, 150, 30);

        add(lblform);
        add(lbltype);
        add(rbtnsav);
        add(rbtnsalary);
        add(lblcard);
        add(lblcardno);
        add(lblcarddetails);
        add(lblappear);
        add(lblpin);
        add(lblpinx);
        add(lblpass);
        add(lblservices);
        add(chkatm);
        add(chkcheque);
        add(chkemail);
        add(chkestat);
        add(chkinternet);
        add(chkknowledge);
        add(chkmobile);
        add(btnsubmit);
        add(btncancel);

        btnsubmit.addActionListener(this);
        btncancel.addActionListener(this);

        setSize(850, 750);
        setLocation(500, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignUp3View(formno);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnsubmit) {

            String accountType = null;
            if (rbtnsav.isSelected()) {
                accountType = "Saving Account";
            } else if (rbtnsalary.isSelected()) {
                accountType = "Salary Account";
            }

            Random random = new Random();
            int card1 = Math.abs(random.nextInt(10000));
            int card2 = Math.abs(random.nextInt(10000));
            int pin = Math.abs(random.nextInt(10000));

            String cardno = "7459-9635-" + card1 + "-" + card2;
            String Pin = "" + pin;

            String services = "";
            if (chkatm.isSelected()) {
                services = services + " ATM Card";
            }
            if (chkinternet.isSelected()) {
                services = services + " Internet Banking";
            }
            if (chkmobile.isSelected()) {
                services = services + " Mobile Banking";
            }
            if (chkemail.isSelected()) {
                services = services + " EMAIL Alerts";
            }
            if (chkcheque.isSelected()) {
                services = services + " Cheque Book";
            }
            if (chkestat.isSelected()) {
                services = services + " E-Statement";
            }

        } else if (ae.getSource() == btncancel) {

        }
    }
}
