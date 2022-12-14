package controller;

import java.sql.ResultSet;

import database.DBConnection;
import model.AccountDetails;

public class AccountDetailsController {
    DBConnection db;

    public int registerCustomer(AccountDetails accountDetails) {
        String query;
        query = "insert into accountdetails(formno,username,password,accountTypeID,accno,Pin,services) values('" +
                accountDetails.getFormno() + "','" +
                accountDetails.getUsername() + "','" +
                accountDetails.getPassword() + "','" +
                accountDetails.getAccountTypeId() + "','" +
                accountDetails.getAccno() + "','" +
                accountDetails.getPin() + "','" +
                accountDetails.getServices() + "');";

        db = new DBConnection();
        return db.insert(query);
    }

    public AccountDetails loginCustomer(String username, String password) {
        String query;
        query = "select * from accountdetails where username = '" + username +
                "'and password ='" + password + "';";
        db = new DBConnection();
        ResultSet rs = db.select(query);
        AccountDetails customer = null;
        try {
            while (rs.next()) {
                customer = new AccountDetails();
                customer.setFormno(rs.getInt("formno"));
                customer.setUsername(rs.getString("username"));
                customer.setPassword(rs.getString("password"));
                customer.setAccountTypeId(rs.getInt("accountTypeId"));
                customer.setAccno(rs.getString("accno"));
                customer.setPin(rs.getString("Pin"));
                customer.setServices(rs.getString("services"));
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex);
        }
        return customer;
    }

    public AccountDetails pinVerification(String username, String pin) {
        String query;
        query = "select * from accountdetails where username = '" + username +
                "'and pin ='" + pin + "';";
        db = new DBConnection();
        ResultSet rs;
        rs = db.select(query);
        AccountDetails customer = null;
        try {
            while (rs.next()) {
                customer = new AccountDetails();
                customer.setAccountTypeId(rs.getInt("accountTypeId"));
                customer.setAccno(rs.getString("accno"));
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

        query = "update accountdetails set pin = '"+rpin+"' where pin = '"+pin+"'; ";

        db = new DBConnection();
        return db.update(query);
    }

    public int edituser(String username,String user){

        String query,query1;

        query = "update accountdetails set username = '"+user+"' where username = '"+username+"' ";
        query1 = "update bank set username = '"+user+"' where username = '"+username+"' ";


        db = new DBConnection();
        db.update(query1);
        return db.update(query);
    }

    public int edituserpw(String username,String user,String rpw){

        String query;

        query = "update accountdetails set username = '"+user+"', password='"+rpw+"' where username = '"+username+"' ";


        db = new DBConnection();
        return db.update(query);
    }

    
}
