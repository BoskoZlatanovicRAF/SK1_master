package model;

import lombok.Getter;
import lombok.Setter;

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
