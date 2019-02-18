package net.myprojects.guardappv2;

public class GuardShift {

    //attributes

    private String id;
    private String name;
    private GuardShiftTime time;

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

    public GuardShiftTime getTime() {
        return time;
    }

    public void setTime(GuardShiftTime time) {
        this.time = time;
    }

    public GuardShift() {

        this.id = "";
        this.name = "";
        this.time = new GuardShiftTime();

    }

    public GuardShift(String Id, String Name, GuardShiftTime Time) {

        this.id = Id;
        this.name = Name;
        this.time = Time;

    }

}
