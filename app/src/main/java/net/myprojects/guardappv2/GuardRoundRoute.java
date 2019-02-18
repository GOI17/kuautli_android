package net.myprojects.guardappv2;

public class GuardRoundRoute {

    //attributes

    private GuardRoundRoutePoints points;
    private GuardRoundRouteSpots spots;

    //setters & getters

    public GuardRoundRoutePoints getPoints() {
        return points;
    }

    public void setPoints(GuardRoundRoutePoints points) {
        this.points = points;
    }

    public GuardRoundRouteSpots getSpots() {
        return spots;
    }

    public void setSpots(GuardRoundRouteSpots spots) {
        this.spots = spots;
    }

    public GuardRoundRoute() {

        this.points = new GuardRoundRoutePoints();
        this.spots = new GuardRoundRouteSpots();

    }

    public GuardRoundRoute(GuardRoundRoutePoints Points, GuardRoundRouteSpots Spots) {

        this.points = Points;
        this.spots = Spots;

    }
}
