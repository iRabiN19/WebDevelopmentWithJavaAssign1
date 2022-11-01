package model;

public class SignUp3 {
    private int formno;
    private String accountType;
    private String cardno;
    private String Pin;
    private String services;

    public SignUp3(int formno,String accountType,String cardno, String Pin, String services){
        this.formno=formno;
        this.accountType=accountType;
        this.cardno=cardno;
        this.Pin=Pin;
        this.services=services;
    }

    public SignUp3(String cardno, String Pin) {
        this.cardno=cardno;
        this.Pin=Pin;
    }

    public SignUp3() {
    }

    public int getFormno()    
    {
        return formno;
    }
    public void setFormno(int formno) {
        this.formno = formno;
    }
    public String getAccountType() {
        return accountType;
    }
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public String getCardno() {
        return cardno;
    }
    public void setCardno(String cardno) {
        this.cardno = cardno;
    }
    public String getPin() {
        return Pin;
    }
    public void setPin(String pin) {
        Pin = pin;
    }
    public String getServices() {
        return services;
    }
    public void setServices(String services) {
        this.services = services;
    }


}
