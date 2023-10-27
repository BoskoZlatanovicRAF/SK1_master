package model;

public abstract class Meeting {
    String day;
    String timeStart;
    String timeEnd;
    Room room;
    boolean isMeetingAdded = false;

    public Meeting(String day, String timeStart, String timeEnd, Room room, boolean isMeetingAdded) {
        this.day = day;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.room = room;
        this.isMeetingAdded = isMeetingAdded;
        isValid();
    }

    protected abstract void isValid();
}
