package model;

public class CustomerADetails {
    private int formno;
    private String religion;
    private String phone;
    private String income;
    private String qualification;
    private String occupation;
    private String pan;
    private String citizenship;
    private String seniorc;
    private String existing;

    public CustomerADetails(int formno, String religion, String phone, String income,
            String qualification, String occupation, String pan, String citizenship,
            String seniorc, String existing) {
        this.formno = formno;
        this.religion = religion;
        this.phone = phone;
        this.income = income;
        this.qualification = qualification;
        this.occupation = occupation;
        this.pan = pan;
        this.citizenship = citizenship;
        this.seniorc = seniorc;
        this.existing = existing;
    }

    public CustomerADetails(String religion, String phone, String income,
            String qualification, String occupation, String pan, String citizenship,
            String seniorc, String existing) {
        this.religion = religion;
        this.phone = phone;
        this.income = income;
        this.qualification = qualification;
        this.occupation = occupation;
        this.pan = pan;
        this.citizenship = citizenship;
        this.seniorc = seniorc;
        this.existing = existing;
    }

    public int getFormno() {
        return formno;
    }

    public void setFormno(int formno) {
        this.formno = formno;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getSeniorc() {
        return seniorc;
    }

    public void setSeniorc(String seniorc) {
        this.seniorc = seniorc;
    }

    public String getExisting() {
        return existing;
    }

    public void setExisting(String existing) {
        this.existing = existing;
    }

}
