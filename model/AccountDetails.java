package model;

public class AccountDetails {
    private int formno;
    private String username;
    private String password;
    private int accountTypeId;
    private String accno;
    private String Pin;
    private String services;

    public AccountDetails(int formno,String username, String password,int accountTypeId,String accno, String Pin, String services){
        this.formno=formno;
        this.username=username;
        this.password=password;
        this.accountTypeId=accountTypeId;
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
    public int getAccountTypeId() {
        return accountTypeId;
    }
    public void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
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
