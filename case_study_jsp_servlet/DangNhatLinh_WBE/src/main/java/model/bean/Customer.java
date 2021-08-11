package model.bean;

public class Customer {
    private int idCustomer;
    private int typeCustomer;
    private String nameCustomer;
    private int genderCustomer;
    private String codeCustomer;
    private String dateOfBirthCustomer;
    private String identifyCodeCustomer;
    private String phoneNumberCustomer;
    private String emailCustomer;
    private String addressCustomer;

    public Customer() {
    }

    public Customer(int idCustomer, int typeCustomer, String nameCustomer, int genderCustomer, String codeCustomer, String dateOfBirthCustomer, String identifyCodeCustomer, String phoneNumberCustomer, String emailCustomer, String addressCustomer) {
        this.idCustomer = idCustomer;
        this.typeCustomer = typeCustomer;
        this.nameCustomer = nameCustomer;
        this.genderCustomer = genderCustomer;
        this.codeCustomer = codeCustomer;
        this.dateOfBirthCustomer = dateOfBirthCustomer;
        this.identifyCodeCustomer = identifyCodeCustomer;
        this.phoneNumberCustomer = phoneNumberCustomer;
        this.emailCustomer = emailCustomer;
        this.addressCustomer = addressCustomer;
    }

    public Customer(int typeCustomer, String nameCustomer, int genderCustomer, String codeCustomer, String dateOfBirthCustomer, String identifyCodeCustomer, String phoneNumberCustomer, String emailCustomer, String addressCustomer) {
        this.typeCustomer = typeCustomer;
        this.nameCustomer = nameCustomer;
        this.genderCustomer = genderCustomer;
        this.codeCustomer = codeCustomer;
        this.dateOfBirthCustomer = dateOfBirthCustomer;
        this.identifyCodeCustomer = identifyCodeCustomer;
        this.phoneNumberCustomer = phoneNumberCustomer;
        this.emailCustomer = emailCustomer;
        this.addressCustomer = addressCustomer;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(int typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public int getGenderCustomer() {
        return genderCustomer;
    }

    public void setGenderCustomer(int genderCustomer) {
        this.genderCustomer = genderCustomer;
    }

    public String getCodeCustomer() {
        return codeCustomer;
    }

    public void setCodeCustomer(String codeCustomer) {
        this.codeCustomer = codeCustomer;
    }

    public String getDateOfBirthCustomer() {
        return dateOfBirthCustomer;
    }

    public void setDateOfBirthCustomer(String dateOfBirthCustomer) {
        this.dateOfBirthCustomer = dateOfBirthCustomer;
    }

    public String getIdentifyCodeCustomer() {
        return identifyCodeCustomer;
    }

    public void setIdentifyCodeCustomer(String identifyCodeCustomer) {
        this.identifyCodeCustomer = identifyCodeCustomer;
    }

    public String getPhoneNumberCustomer() {
        return phoneNumberCustomer;
    }

    public void setPhoneNumberCustomer(String phoneNumberCustomer) {
        this.phoneNumberCustomer = phoneNumberCustomer;
    }

    public String getEmailCustomer() {
        return emailCustomer;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer = emailCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }
}
