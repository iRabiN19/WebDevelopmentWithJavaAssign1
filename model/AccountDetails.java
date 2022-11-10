package model;

public class AccountDetails {
    private int formno;
    private String username;
    private String password;
    private int accountType;
    private String accno;
    private String Pin;
    private String services;

    public AccountDetails(int formno,String username, String password,int accountType,String accno, String Pin, String services){
        this.formno=formno;
        this.username=username;
        this.password=password;
        this.accountType=accountType;
        this.accno=accno;
        this.Pin=Pin;
        this.services=services;
    }

    public AccountDetails(String username, String Pin) {
        this.username=username;
        this.Pin=Pin;
    }

    public AccountDetails() {
    }

    public int getFormno()    
    {
        return formno;
    }
    public void setFormno(int formno) {
        this.formno = formno;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAccountType() {
        return accountType;
    }
    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }
    public String getAccno() {
        return accno;
    }
    public void setAccno(String accno) {
        this.accno = accno;
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
