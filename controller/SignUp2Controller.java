package controller;

import database.DBConnection;
import model.SignUp2;

public class SignUp2Controller {
    DBConnection db;

    public int registerCustomer(SignUp2 signUp2) {
        String query;
        query = "insert into signup2(formno,religion,phone,income,qualification,occupation,pan,citizenship,seniorc,existing) values('" +
                signUp2.getFormno() + "','" +
                signUp2.getReligion() + "','" +
                signUp2.getPhone() + "','" +
                signUp2.getIncome() + "','" +
                signUp2.getQualification() + "','" +
                signUp2.getOccupation() + "','" +
                signUp2.getPan() + "','" +
                signUp2.getCitizenship() + "','" +
                signUp2.getSeniorc() + "','" +
                signUp2.getExisting() + "');";
        db = new DBConnection();
        return db.insert(query);
    }
    
}
