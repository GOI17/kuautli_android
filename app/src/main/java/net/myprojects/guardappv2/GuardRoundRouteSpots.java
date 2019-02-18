package net.myprojects.guardappv2;

public class GuardRoundRouteSpots {

    //attributes

    private GuardRoundRouteStops stop;

    //setters & getters

    public GuardRoundRouteStops getStop() {
        return stop;
    }

    public void setStop(GuardRoundRouteStops stop) {
        this.stop = stop;
    }

    public GuardRoundRouteSpots() {

        this.stop = new GuardRoundRouteStops();

    }

    public GuardRoundRouteSpots(GuardRoundRouteStops Stop) {

        this.stop = Stop;

    }
}
