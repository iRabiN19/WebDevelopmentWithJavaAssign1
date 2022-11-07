package model;

import java.util.Date;

public class CustomerPDetails {
    private int formno;
    private String name; 
    private String father_name; 
    private Date dob; 
    private String gender;
    private String email;
    private String marital_status; 
    private String address; 
    private String city; 
    private String state;


    public CustomerPDetails(int formno, String name, String father_name,
        Date dob, String gender, String email,
        String marital_status, String address, 
        String city, String state){
            this.formno=formno;
            this.name=name;
            this.father_name=father_name;
            this.dob=dob;
            this.gender=gender;
            this.email=email;
            this.marital_status=marital_status;
            this.address=address;
            this.city=city;
            this.state=state;
    }

    public int getFormno() {
        return formno;
    }
    public void setFormno(int formno) {
        this.formno = formno;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFather_name() {
        return father_name;
    }
    public void setFather_name(String father_name) {
        this.father_name = father_name;
    }
    public Date getDob() {
        return dob;
    }
    public void setDob(Date dob) {
        this.dob = dob;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMarital_status() {
        return marital_status;
    }
    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
   
}
