package controller;

import java.sql.ResultSet;

import javax.swing.*;

import database.DBConnection;
import model.Bank;

public class BankController {
    DBConnection db;

    public int balance(Bank deposit) {

        String query;

        query = "insert into bank(username,accno, amount, type, date) values('" +
                deposit.getUsername() + "','" +
                deposit.getAccno() + "','" +
                deposit.getAmount() + "','" +
                deposit.getType() + "','" +
                deposit.getDate() + "');";

        db = new DBConnection();
        return db.insert(query);
    }

    public double transaction(String username, String amount) {
        String query;
        query = "select * from bank where username = '" + username + "';";
        db = new DBConnection();
        ResultSet rs;
        rs = db.select(query);
        Bank transact = null;
        double balance = 0.0;
        try {
            while (rs.next()) {
                transact = new Bank();
                transact.setAccno(rs.getString("accno"));
                transact.setDate(rs.getString("date"));
                transact.setType(rs.getString("type"));
                transact.setAmount(rs.getString("amount"));

                if (rs.getString("type").equals("Deposit")) {
                    balance += Double.parseDouble(rs.getString("amount"));
                } else {
                    balance -= Double.parseDouble(rs.getString("amount"));
                }
            }
            if (balance < Double.parseDouble(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        return balance;
    }

    public String statement(String username) {
        String query;
        query = "select * from bank where username = '" + username + "';";
        db = new DBConnection();
        ResultSet rs;
        rs = db.select(query);
        Bank transact = null;
        String state = null;
        try {
            while (rs.next()) {
                transact = new Bank();
                transact.setAccno(rs.getString("accno"));
                state = rs.getString("accno");
            }

        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        return state;

    }
}
