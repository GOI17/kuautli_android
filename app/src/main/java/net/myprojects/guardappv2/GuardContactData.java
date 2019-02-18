package net.myprojects.guardappv2;

public class GuardContactData {

    //attributes

    private String phone;
    private String email;

    //setters & getters

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GuardContactData() {

        this.phone = "";
        this.email = "";

    }

    public GuardContactData(String Phone, String Email) {

        this.phone = Phone;
        this.email = Email;

    }
}
