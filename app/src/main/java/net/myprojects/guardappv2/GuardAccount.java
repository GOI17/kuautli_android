package net.myprojects.guardappv2;

public class GuardAccount {

    //attributes

    private String userName;
    private String lastLogin;

    //setters & getters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    //constructor

    public GuardAccount() {

        this.userName = "";
        this.lastLogin = "";

    }

    public GuardAccount(String UserName, String LastLogin) {

        this.userName = UserName;
        this.lastLogin = LastLogin;

    }

}
