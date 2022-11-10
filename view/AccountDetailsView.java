package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

import controller.AccountDetailsController;
import model.AccountDetails;

public class AccountDetailsView extends JFrame implements ActionListener {

    JLabel lblform, lbltype, lblcard, lblaccno, lblcarddetails, lblappear,
            lblpin, lblpinx, lblpindetails, lblpass, lblservices, lblusername, lblpassword;
    JRadioButton rbtnsav, rbtnsalary;
    ButtonGroup grpaccount;
    JCheckBox chkatm, chkinternet, chkmobile, chkemail, chkcheque,
            chkestat, chkknowledge;
    JButton btnsubmit, btncancel;
    JTextField txtusername;
    JPasswordField txtpassword;
    static int formno;

    public AccountDetailsView(int formno3) {

        AccountDetailsView.formno = formno3;

        setTitle("Account Details");
        setLayout(null);

        Color color = new Color(242, 202, 133);
        getContentPane().setBackground(color);

        lblform = new JLabel("Page 3:Account Details");
        lblform.setFont(new Font("Raleway", Font.BOLD, 23));
        lblform.setBounds(280, 45, 400, 35);

        lblusername = new JLabel("Username:");
        lblusername.setFont(new Font("Raleway", Font.BOLD, 23));
        lblusername.setBounds(100, 145, 200, 30);

        txtusername = new JTextField();
        txtusername.setFont(new Font("Raleway", Font.BOLD, 23));
        txtusername.setBounds(330, 145, 200, 30);

        lblpassword = new JLabel("Password:");
        lblpassword.setFont(new Font("Raleway", Font.BOLD, 23));
        lblpassword.setBounds(100, 195, 200, 30);

        txtpassword = new JPasswordField();
        txtpassword.setFont(new Font("Raleway", Font.BOLD, 23));
        txtpassword.setBounds(330, 195, 200, 30);

        lbltype = new JLabel("Account Type");
        lbltype.setFont(new Font("Raleway", Font.BOLD, 20));
        lbltype.setBounds(100, 245, 200, 30);

        rbtnsav = new JRadioButton("Saving Account");
        rbtnsav.setFont(new Font("Raleway", Font.BOLD, 17));
        rbtnsav.setBounds(100, 285, 200, 20);
        rbtnsav.setBackground(color);

        rbtnsalary = new JRadioButton("Salary Account");
        rbtnsalary.setFont(new Font("Raleway", Font.BOLD, 17));
        rbtnsalary.setBounds(320, 285, 200, 20);
        rbtnsalary.setBackground(color);

        grpaccount = new ButtonGroup();
        grpaccount.add(rbtnsav);
        grpaccount.add(rbtnsalary);

        lblcard = new JLabel("Account Number:");
        lblcard.setFont(new Font("Raleway", Font.BOLD, 23));
        lblcard.setBounds(100, 345, 200, 30);

        lblaccno = new JLabel("XXXXXXXXXXXX7581");
        lblaccno.setFont(new Font("Raleway", Font.BOLD, 23));
        lblaccno.setBounds(330, 345, 300, 30);
        lblcarddetails = new JLabel("(Your 16-digit Account number)");
        lblcarddetails.setFont(new Font("Raleway", Font.BOLD, 12));
        lblcarddetails.setBounds(100, 380, 200, 20);
        lblappear = new JLabel("It will appear on ATM Card/Cheque Book and Statements");
        lblappear.setFont(new Font("Raleway", Font.BOLD, 12));
        lblappear.setBounds(330, 380, 500, 20);

        lblpin = new JLabel("Pin:");
        lblpin.setFont(new Font("Raleway", Font.BOLD, 23));
        lblpin.setBounds(100, 420, 200, 30);

        lblpinx = new JLabel("XXXX");
        lblpinx.setFont(new Font("Raleway", Font.BOLD, 23));
        lblpinx.setBounds(330, 420, 200, 30);
        lblpass = new JLabel("(Your 4-digit pin)");
        lblpass.setFont(new Font("Raleway", Font.BOLD, 12));
        lblpass.setBounds(100, 450, 200, 20);

        lblservices = new JLabel("Services Required:");
        lblservices.setFont(new Font("Raleway", Font.BOLD, 23));
        lblservices.setBounds(100, 500, 450, 20);

        chkatm = new JCheckBox("ATM CARD");
        chkatm.setBackground(color);
        chkatm.setFont(new Font("Raleway", Font.BOLD, 16));
        chkatm.setBounds(100, 530, 200, 30);

        chkinternet = new JCheckBox("Internet Banking");
        chkinternet.setBackground(color);
        chkinternet.setFont(new Font("Raleway", Font.BOLD, 16));
        chkinternet.setBounds(350, 530, 200, 30);

        chkmobile = new JCheckBox("Mobile Banking");
        chkmobile.setBackground(color);
        chkmobile.setFont(new Font("Raleway", Font.BOLD, 16));
        chkmobile.setBounds(100, 580, 200, 30);

        chkemail = new JCheckBox("EMAIL Alerts");
        chkemail.setBackground(color);
        chkemail.setFont(new Font("Raleway", Font.BOLD, 16));
        chkemail.setBounds(350, 580, 200, 30);

        chkcheque = new JCheckBox("Cheque Book");
        chkcheque.setBackground(color);
        chkcheque.setFont(new Font("Raleway", Font.BOLD, 16));
        chkcheque.setBounds(100, 630, 200, 30);

        chkestat = new JCheckBox("E-Statement");
        chkestat.setBackground(color);
        chkestat.setFont(new Font("Raleway", Font.BOLD, 16));
        chkestat.setBounds(350, 630, 200, 30);

        chkknowledge = new JCheckBox(
                "I hereby declare that the above entered details are correct to the best of my knowledge.", true);
        chkknowledge.setBackground(color);
        chkknowledge.setFont(new Font("Raleway", Font.BOLD, 12));
        chkknowledge.setBounds(100, 670, 550, 30);

        btnsubmit = new JButton("Submit");
        btnsubmit.setBackground(Color.BLACK);
        btnsubmit.setForeground(Color.CYAN);
        btnsubmit.setFont(new Font("Monospaced", Font.BOLD, 20));
        btnsubmit.setBounds(250, 715, 150, 30);

        btncancel = new JButton("Cancel");
        btncancel.setBackground(Color.BLACK);
        btncancel.setForeground(Color.CYAN);
        btncancel.setFont(new Font("Monospaced", Font.BOLD, 20));
        btncancel.setBounds(450, 715, 150, 30);


        add(lblform);
        add(lbltype);
        add(rbtnsav);
        add(rbtnsalary);
        add(lblcard);
        add(lblaccno);
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
        add(lblusername);
        add(txtusername);
        add(lblpassword);
        add(txtpassword);
        add(btnsubmit);
        add(btncancel);

        btnsubmit.addActionListener(this);
        btncancel.addActionListener(this);

        setSize(750, 850);
        setLocation(500, 120);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AccountDetailsView(formno);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnsubmit) {

            String username = txtusername.getText();
            String password = String.valueOf(txtpassword.getPassword());
            int accountType = 0;
            if (rbtnsav.isSelected()) {
                accountType = 1;
            } else if (rbtnsalary.isSelected()) {
                accountType = 2;
            }

            Random random = new Random();
            int acc1 = Math.abs(random.nextInt(10000));
            int acc2 = Math.abs(random.nextInt(10000));
            int pin = Math.abs(random.nextInt(10000));

            String accno = "74599635" + acc1 + acc2;
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

            try {
                if (accountType==0) {
                    JOptionPane.showMessageDialog(null, "Fill all the required fields");
                } else {
                    AccountDetails signUp3 = new AccountDetails(formno, username, password, accountType, accno, Pin,
                            services);

                    AccountDetailsController sign3cont = new AccountDetailsController();
                    int insert = sign3cont.registerCustomer(signUp3);

                    if (insert > 0) {
                        System.out.println("Customer added successfully");

                        JOptionPane.showMessageDialog(null, "Your Account Number: " + accno +
                                "\n Your Pin: " + Pin);
                        JOptionPane.showMessageDialog(null,
                                "You are requested to deposit some amount into your account initially.");
                        new DepositView(username);
                        this.dispose();
                    } else {
                        System.out.println("Error registering customer");
                    }

                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (ae.getSource() == btncancel) {
            new LoginView();
            this.dispose();

        }
    }
}
