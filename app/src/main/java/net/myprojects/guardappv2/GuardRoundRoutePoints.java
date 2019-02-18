package net.myprojects.guardappv2;

public class GuardRoundRoutePoints {

    //attributes

    private String latitude;
    private String longitude;

    //setters & getters

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public GuardRoundRoutePoints() {

        this.latitude = "";
        this.longitude = "";

    }

    public GuardRoundRoutePoints(String Latitude, String Longitude) {

        this.latitude = Latitude;
        this.longitude = Longitude;

    }
}
