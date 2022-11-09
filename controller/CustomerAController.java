package controller;

import database.DBConnection;
import model.CustomerADetails;

public class CustomerAController {
    DBConnection db;

    public int registerCustomer(CustomerADetails customerADetails) {
        String query;
        query = "insert into customerAdetails(formno,religion,phone,income,qualification,occupation,pan,citizenship,seniorc,existing) values('" +
                customerADetails.getFormno() + "','" +
                customerADetails.getReligion() + "','" +
                customerADetails.getPhone() + "','" +
                customerADetails.getIncome() + "','" +
                customerADetails.getQualification() + "','" +
                customerADetails.getOccupation() + "','" +
                customerADetails.getPan() + "','" +
                customerADetails.getCitizenship() + "','" +
                customerADetails.getSeniorc() + "','" +
                customerADetails.getExisting() + "');";
        db = new DBConnection();
        return db.insert(query);
    }

    public int updatedetails(CustomerADetails customeraDetails, String form) {
        String query;

        query = "update customerAdetails "+
        " set religion = '"+customeraDetails.getReligion() +"',"+
        " phone='"+customeraDetails.getPhone()+"',"+
        " income='"+customeraDetails.getIncome()+"',"+
        " qualification='"+customeraDetails.getQualification()+"',"+
        " occupation='"+customeraDetails.getOccupation()+"',"+
        " pan='"+customeraDetails.getPan()+"',"+
        " citizenship='"+customeraDetails.getCitizenship()+"',"+
        " seniorc='"+customeraDetails.getSeniorc()+"',"+
        " existing='"+customeraDetails.getExisting()+ "'"+
        " where formno='"+form+"';";

        db = new DBConnection();
        return db.update(query);
    }
    
}
