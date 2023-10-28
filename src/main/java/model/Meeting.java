package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
public abstract class Meeting {
    LocalDate day;
    LocalTime timeStart;
    LocalTime timeEnd;
    Room room;

    public Meeting(LocalDate day, LocalTime timeStart, LocalTime timeEnd, Room room) {
        this.day = day;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.room = room;
    }

    protected abstract void isValid();
}
