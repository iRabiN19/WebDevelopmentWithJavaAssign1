package controller;

import database.DBConnection;
import model.CustomerPDetails;

public class CustomerPController {

    DBConnection db;

    public int registerCustomer(CustomerPDetails customerPDetails) {
        String query;
        query = "insert into customerPdetails(formno, name, father_name, dob, gender, email, marital_status, address, city, state) values('" +
                customerPDetails.getFormno() + "','" +
                customerPDetails.getName() + "','" +
                customerPDetails.getFather_name() + "','" +
                customerPDetails.getDob() + "','" +
                customerPDetails.getGender() + "','" +
                customerPDetails.getEmail() + "','" +
                customerPDetails.getMarital_status() + "','" +
                customerPDetails.getAddress() + "','" +
                customerPDetails.getCity() + "','" +
                customerPDetails.getState() + "');";
        db = new DBConnection();
        return db.insert(query);
    }

    public int updatedetails(CustomerPDetails customerPDetails, String form) {
        String query;

        query = "update customerPdetails "+
        " set name = '"+customerPDetails.getName() +"',"+
        " father_name='"+customerPDetails.getFather_name()+"',"+
        " dob='"+customerPDetails.getDob()+"',"+
        " gender='"+customerPDetails.getGender()+"',"+
        " email='"+customerPDetails.getEmail()+"',"+
        " marital_status='"+customerPDetails.getMarital_status()+"',"+
        " address='"+customerPDetails.getAddress()+"',"+
        " city='"+customerPDetails.getCity()+"',"+

        " state='"+customerPDetails.getState()+ "'"+
        " where formno='"+form+"';";

        db = new DBConnection();
        return db.update(query);
    }
}
