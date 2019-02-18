package net.myprojects.guardappv2;

import android.graphics.drawable.Drawable;

public class Guard {

    //attributes

    private GuardAccount account;
    private String firstName;
    private String lastName;
    private String birthDate;
    private String gender;
    private int age;
    private Drawable photo;
    private GuardContactData contactData;
    private String status;
    private GuardShift shift;
    private GuardRounds rounds;

    //setters & getters

    public GuardAccount getAccount() {
        return account;
    }

    public void setAccount(GuardAccount account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Drawable getPhoto() {
        return photo;
    }

    public void setPhoto(Drawable photo) {
        this.photo = photo;
    }

    public GuardContactData getContactData() {
        return contactData;
    }

    public void setContactData(GuardContactData contactData) {
        this.contactData = contactData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GuardShift getShift() {
        return shift;
    }

    public void setShift(GuardShift shift) {
        this.shift = shift;
    }

    public GuardRounds getRounds() {
        return rounds;
    }

    public void setRounds(GuardRounds rounds) {
        this.rounds = rounds;
    }

    //constructor

    public Guard() {

        this.account = new GuardAccount();
        this.firstName = "";
        this.lastName = "";
        this.birthDate = "";
        this.gender = "";
        this.age = 0;
        this.photo = null;
        this.contactData = new GuardContactData();
        this.status = "";
        this.shift = new GuardShift();
        this.rounds = new GuardRounds();

    }

    public Guard(String firstName, String lastName, String photoURL, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = Image.fromUrl(photoURL);
        this.status = status;
    }

    public Guard(GuardAccount account, String firstName, String lastName, String birthDate, String gender, int age, String photoURL, GuardContactData contactData, String status, GuardShift shift, GuardRounds rounds) {
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.gender = gender;
        this.age = age;
        this.photo = Image.fromUrl(photoURL);
        this.contactData = contactData;
        this.status = status;
        this.shift = shift;
        this.rounds = rounds;
    }
}
