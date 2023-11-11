package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;

@Getter
@Setter
public abstract class Meeting {
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private Room room;
    private HashMap<String, String> additionalAttributes;

    public Meeting(){
        this.additionalAttributes = new HashMap<>();
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

    public String toString() {
        return "Meeting{" +
                "start=" + timeStart +
                ", end=" + timeEnd +
                ", place='" + room + '\'' +
                ", additional=" + additionalAttributes +
                '}';
    }

    public abstract boolean overlapsWith(Meeting meeting);
}
