package net.myprojects.guardappv2;

public class GuardRoundRouteStops {

    //attributes

    private String id;
    private String name;
    private GuardRoundRouteStopsLocation location;

    //setters & getters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GuardRoundRouteStopsLocation getLocation() {
        return location;
    }

    public void setLocation(GuardRoundRouteStopsLocation location) {
        this.location = location;
    }

    public GuardRoundRouteStops() {

        this.id = "";
        this.name = "";
        this.location = new GuardRoundRouteStopsLocation();

    }

    public GuardRoundRouteStops(String Id, String Name, GuardRoundRouteStopsLocation location) {

        this.id = Id;
        this.name = Name;
        this.location = location;

    }
}
