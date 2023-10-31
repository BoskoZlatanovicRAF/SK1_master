package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

@Getter
public abstract class Meeting {
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private Room room;
    private HashMap<String, String> additionalAttributes;


    public Meeting(LocalTime timeStart, LocalTime timeEnd, Room room) {
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.room = room;
        this.additionalAttributes = new HashMap<>();
    }

    public Meeting(LocalTime timeStart, LocalTime timeEnd, Room room, HashMap<String, String> additionalAttributes){
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.room = room;
        this.additionalAttributes = additionalAttributes;
    }

    protected abstract void isValid();
}
