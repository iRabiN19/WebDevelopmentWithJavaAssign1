package controller;

import java.sql.ResultSet;

import database.DBConnection;
import model.SignUp3;

public class SignUp3Controller {
    DBConnection db;

    public int registerCustomer(SignUp3 signUp3) {
        String query;
        query = "insert into signup3(formno,accountType,cardno,Pin,services) values('" +
                signUp3.getFormno() + "','" +
                signUp3.getAccountType() + "','" +
                signUp3.getCardno() + "','" +
                signUp3.getPin() + "','" +
                signUp3.getServices() + "');";

        db = new DBConnection();
        return db.insert(query);
    }

    public SignUp3 loginCustomer(String cardno, String pin) {
        String query;
        query = "select * from signup3 where cardno = '" + cardno +
                "'and pin ='" + pin + "';";
        db = new DBConnection();
        ResultSet rs = db.select(query);
        SignUp3 customer = null;
        try {
            while (rs.next()) {
                customer = new SignUp3();
                customer.setFormno(rs.getInt("formno"));
                customer.setAccountType(rs.getString("accountType"));
                customer.setCardno(rs.getString("cardno"));
                customer.setPin(rs.getString("Pin"));
                customer.setServices(rs.getString("services"));
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        return customer;
    }

    public SignUp3 pinVerification(String cardno, String pin) {
        String query;
        query = "select * from signup3 where cardno = '" + cardno +
                "'and pin ='" + pin + "';";
        db = new DBConnection();
        ResultSet rs;
        rs = db.select(query);
        SignUp3 customer = null;
        try {
            while (rs.next()) {
                customer = new SignUp3();
                customer.setAccountType(rs.getString("accountType"));
                customer.setCardno(rs.getString("cardno"));
                customer.setPin(rs.getString("Pin"));
                customer.setServices(rs.getString("services"));

            }

        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        return customer;
    }

    public int changepin(String pin, String rpin) {
        String query;

        query = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";

        db = new DBConnection();
        return db.insert(query);
    }
}
