package model;

public class Bank {
    private String cardno;
    private String amount;
    private String type;
    private String date;

    public Bank(String cardno, String amount, String type, String date){
        this.cardno=cardno;
        this.amount=amount;
        this.type=type;
        this.date=date;
    }

    public Bank() {
    }

    public String getCardno() {
        return cardno;
    }
    public void setCardno(String cardno) {
        this.cardno = cardno;
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
