package model;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;

@Getter
@Setter
public class Meeting {
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private Room room;
    private HashMap<String, String> additionalAttributes;

    private DayOfWeek dayOfWeek;

    public Meeting(){
        this.additionalAttributes = new HashMap<>();
    }

    public Meeting(LocalDateTime timeStart, LocalDateTime timeEnd, Room room, HashMap<String, String> additionalAttributes, DayOfWeek dayOfWeek) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.room = room;
        this.additionalAttributes = additionalAttributes;
        this.dayOfWeek = dayOfWeek;
    }

    public Meeting(LocalDateTime timeStart, LocalDateTime timeEnd, Room room) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.room = room;
        this.additionalAttributes = new HashMap<>();
    }

    public Meeting(LocalDateTime timeStart, LocalDateTime timeEnd, Room room, HashMap<String, String> additionalAttributes){
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.room = room;
        this.additionalAttributes = additionalAttributes;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "timeStart=" + timeStart +
                ", timeEnd=" + timeEnd +
                ", room=" + room +
                ", additionalAttributes=" + additionalAttributes +
                ", dayOfWeek=" + dayOfWeek +
                '}';
    }

    public boolean overlapsWith(Meeting meeting){
        if (this.equals(meeting) || (meeting.getTimeStart().isBefore(this.getTimeEnd()) &&
                meeting.getTimeEnd().isAfter(this.getTimeStart()) && meeting.getRoom().equals(this.getRoom()))) return true;
        return false;
    }

    public boolean equals(Object obj) {

        if (obj instanceof Meeting){
            Meeting meeting = (Meeting)obj;

            return this.getTimeStart().isEqual(meeting.getTimeStart()) && this.getTimeEnd().isEqual(meeting.getTimeEnd()) &&  meeting.getRoom().equals(this.getRoom());
        }
        return false;
    }

    public boolean isOnSameDay(LocalDate date) {
        return this.getTimeStart().toLocalDate().isEqual(date);
    }
}
