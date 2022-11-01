package controller;

import database.DBConnection;
import model.SignUp;

public class SignUpController {

    DBConnection db;

    public int registerCustomer(SignUp signUp) {
        String query;
        query = "insert into signup(formno, name, father_name, dob, gender, email, marital_status, address, city, state) values('" +
                signUp.getFormno() + "','" +
                signUp.getName() + "','" +
                signUp.getFather_name() + "','" +
                signUp.getDob() + "','" +
                signUp.getGender() + "','" +
                signUp.getEmail() + "','" +
                signUp.getMarital_status() + "','" +
                signUp.getAddress() + "','" +
                signUp.getCity() + "','" +
                signUp.getState() + "');";
        db = new DBConnection();
        return db.insert(query);
    }
}
