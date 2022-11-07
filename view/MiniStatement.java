package view;

import javax.swing.*;

import database.DBConnection;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class MiniStatement extends JFrame implements ActionListener{
    JButton btnexit;
    JLabel lblstatement,lblbank,lblcard,lblbalance,lblimage;
    static String username;
    MiniStatement(String username){
        MiniStatement.username=username;

        setTitle("Bank Statement");
        setSize(500,600);
        setLayout(null);

        getContentPane().setBackground(Color.WHITE);

        lblstatement = new JLabel();
        lblstatement.setBounds(20, 180, 400, 155);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        lblimage = new JLabel(i3);
        lblimage.setBounds(30, 10, 100, 100);

        lblbank = new JLabel("Kathmandu Bank Ltd");
        lblbank.setBounds(150, 50, 330, 20);
        lblbank.setFont(new Font("Raleway" , Font.BOLD,18));

        lblcard=new JLabel();
        try{
            DBConnection db = new DBConnection();
            String query="select * from accountdetails where username = '" + username + "';";
            ResultSet rs;
        rs = db.select(query);
            while(rs.next()){
                lblcard.setText("Account Number:    " + rs.getString("accno").substring(0, 4) + "XXXXXXXX" + rs.getString("accno").substring(12));
            }
            lblcard.setFont(new Font("Raleway" , Font.BOLD,15));
        lblcard.setBounds(20, 120, 300, 20);
        }catch(Exception e){}

        

        lblbalance = new JLabel();
        lblbalance.setBounds(20, 400, 300, 20);

        try{
            int balance = 0;
            DBConnection db  = new DBConnection();
           String query = "select * from bank where username = '" + username + "';";

            ResultSet rs;
        rs = db.select(query);
        try {
            while (rs.next()) {
                               lblstatement.setText(lblstatement.getText() + "<html>"+rs.getString("date")+ 
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + 
                "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") +
                 "<br><br><html>");


                 if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            lblbalance.setText("Your total Balance is Rs "+balance);

        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    
    btnexit = new JButton("Exit");
    btnexit.setBounds(20, 500, 100, 25);
    btnexit.setFont(new Font("Monospaced", Font.BOLD, 23));
    btnexit.setBackground(Color.BLACK);
    btnexit.setForeground(Color.CYAN);

    btnexit.addActionListener(this);

    add(lblimage);
    add(lblstatement);
    add(lblbank);
    add(lblcard);
    add(lblbalance);
    add(btnexit);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocation(500,20);
    setVisible(true);

    }

    public static void main(String[] args) {
        new MiniStatement(username);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new Transaction(username);       
        this.dispose();
    }
    
}
