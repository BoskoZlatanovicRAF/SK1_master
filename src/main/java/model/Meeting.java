package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Getter
@Setter
public class Meeting {
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
        String startTimeStr = timeStart != null ? timeStart.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : "Not Set";
        String endTimeStr = timeEnd != null ? timeEnd.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) : "Not Set";
        String roomStr = room != null ? room.toString() : "No Room Assigned";
        String additionalAttributesStr = additionalAttributes != null && !additionalAttributes.isEmpty()
                ? additionalAttributes.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.joining(", "))
                : "No Additional Attributes";

        return "Meeting[start=" + startTimeStr +
                ", end=" + endTimeStr +
                ", place=" + roomStr +
                ", additional=[" + additionalAttributesStr + "]]";
    }

}
