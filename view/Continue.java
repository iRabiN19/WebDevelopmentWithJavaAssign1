package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Continue extends JFrame implements ActionListener {
    JLabel lblcontinue;
    JButton btnyes, btnno;
    static String username;



    Continue(String username) {
        Continue.username=username;
        setTitle("Menu Driven");
        setLayout(null);
        setSize(400, 250);

        Color color = new Color(0, 127, 98);
        getContentPane().setBackground(color);

        lblcontinue = new JLabel("Do you want to continue?");
        lblcontinue.setBounds(70, 60, 280, 30);
        lblcontinue.setFont(new Font("Raleway", Font.BOLD, 20));
        lblcontinue.setForeground(Color.BLACK);

        btnyes = new JButton("Yes");
        btnyes.setBounds(20, 120, 100, 30);
        btnyes.setFont(new Font("Monospaced", Font.BOLD, 18));
        btnyes.setBackground(Color.BLACK);
        btnyes.setForeground(Color.CYAN);

        btnno = new JButton("No");
        btnno.setBounds(240, 120, 100, 30);
        btnno.setFont(new Font("Monospaced", Font.BOLD, 18));
        btnno.setBackground(Color.BLACK);
        btnno.setForeground(Color.CYAN);

        add(lblcontinue);
        add(btnyes);
        add(btnno);

        btnyes.addActionListener(this);
        btnno.addActionListener(this);

        setLocation(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public static void main(String[] args) {
        new Continue(username);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
if(e.getSource()==btnyes){
    setVisible(false);
    new Transaction("").setVisible(true);
} else if(e.getSource()==btnno){
    setVisible(false);
    new LoginView().setVisible(true);
}  

    }
}
