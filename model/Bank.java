package model;

public class Bank {
    private String username;
    private String accno;
    private String amount;
    private String type;
    private String date;

    public Bank(String username,String accno, String amount, String type, String date){
        this.username=username;
        this.accno=accno;
        this.amount=amount;
        this.type=type;
        this.date=date;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public Bank() {
    }
    public String getAccno() {
        return accno;
    }
    public void setAccno(String accno) {
        this.accno = accno;
    }
    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }    
}
