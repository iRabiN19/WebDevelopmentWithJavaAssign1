package view;

import javax.swing.*;

import controller.SignUp3Controller;

import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {
    JLabel lblimage, lbltitle, lblnpin, lblrpin;
    JPasswordField txtnpin, txtrpin;
    JButton btnchangepin, btnback;
    static String cardno;
    static String pin;

    PinChange(String cardno, String pin) {
        PinChange.cardno = cardno;
        PinChange.pin = pin;

        setSize(1360, 906);
        setLocation(350, 95);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/laptop.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(1360, 906, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        lblimage = new JLabel(i3);
        lblimage.setBounds(0, 0, 1360, 906);
        add(lblimage);

        lbltitle = new JLabel("Request to change pin.");
        lbltitle.setForeground(Color.BLACK);
        lbltitle.setFont(new Font("System", Font.BOLD, 35));
        lbltitle.setBounds(495, 150, 700, 40);

        lblnpin = new JLabel("New pin:");
        lblnpin.setFont(new Font("Raleway", Font.BOLD, 26));
        lblnpin.setBounds(425, 210, 200, 30);

        txtnpin = new JPasswordField();
        txtnpin.setBounds(680, 210, 200, 30);
        txtnpin.setFont(new Font("Raleway", Font.BOLD, 26));

        lblrpin = new JLabel("Re-write pin:");
        lblrpin.setFont(new Font("Raleway", Font.BOLD, 26));
        lblrpin.setBounds(425, 270, 200, 30);

        txtrpin = new JPasswordField();
        txtrpin.setBounds(680, 270, 200, 30);
        txtrpin.setFont(new Font("Raleway", Font.BOLD, 26));

        btnchangepin = new JButton("Change");
        btnchangepin.setBounds(830, 415, 180, 50);
        btnchangepin.setFont(new Font("Monospaced", Font.BOLD, 23));
        btnchangepin.setBackground(Color.BLACK);
        btnchangepin.setForeground(Color.CYAN);

        btnback = new JButton("Back");
        btnback.setBounds(830, 475, 180, 50);
        btnback.setFont(new Font("Monospaced", Font.BOLD, 23));
        btnback.setBackground(Color.BLACK);
        btnback.setForeground(Color.CYAN);

        lblimage.add(lbltitle);
        lblimage.add(lblnpin);
        lblimage.add(txtnpin);
        lblimage.add(lblrpin);
        lblimage.add(txtrpin);
        lblimage.add(btnchangepin);
        lblimage.add(btnback);

        btnchangepin.addActionListener(this);
        btnback.addActionListener(this);

        setLayout(null);
        setUndecorated(true);
        setVisible(true);

    }

    public static void main(String[] args) {
        new PinChange(cardno, pin);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == btnchangepin){
            String npin = String.valueOf(txtnpin.getPassword());
            String rpin = String.valueOf(txtrpin.getPassword());
            
                if (npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Enter New PIN");
                }
                else if (rpin.equals("")){
                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
                } else if(!npin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "The PINs do not match.");
                    return;
                }
                
                SignUp3Controller controller = new SignUp3Controller();
                int update = controller.changepin(pin,rpin);

                if (update > 0) {
                    System.out.println("Pin changed successfully");
                    JOptionPane.showMessageDialog(null, "PIN changed successfully");

                        new Transaction(cardno,rpin);
                        this.dispose();
                } else {
                    System.out.println("Error changing pin.");
                }

                // Conn c1 = new Conn();
                // String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
                // String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";

              

               

        } else if(ae.getSource()==btnback){
            new Transaction(cardno, pin);
            this.dispose();
        }
    }
}
