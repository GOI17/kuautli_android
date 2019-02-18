package net.myprojects.guardappv2;

public class GuardShiftTime {

    //attributes


    private String timeStart;
    private String timeEnd;

    //setters & getters

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public GuardShiftTime() {

        this.timeStart = "";
        this.timeEnd = "";

    }

    public GuardShiftTime(String TimeStart, String TimeEnd) {

        this.timeStart = TimeStart;
        this.timeEnd = TimeEnd;

    }
}
