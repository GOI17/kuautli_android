package net.myprojects.guardappv2;

public class GuardRounds {

    //attributes

    private String id;
    private String name;
    private String day;
    private GuardRoundRoute route;

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

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public GuardRoundRoute getRoute() {
        return route;
    }

    public void setRoute(GuardRoundRoute route) {
        this.route = route;
    }

    //constructor

    public GuardRounds() {

        this.id = "";
        this.name = "";
        this.day = "";
        this.route = new GuardRoundRoute();

    }

    public GuardRounds(String Id, String Name, String Day, GuardRoundRoute Route) {

        this.id = Id;
        this.name = Name;
        this.day = Day;
        this.route = Route;

    }
}
