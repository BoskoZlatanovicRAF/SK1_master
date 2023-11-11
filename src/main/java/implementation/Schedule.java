package implementation;

import lombok.Getter;
import model.Meeting;
import model.Room;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Getter
public abstract class Schedule<T> {
    LocalDateTime timeValidFrom;
    LocalDateTime timeValidTo;
    List<LocalDate> exceptions = new ArrayList<>();
    List<Meeting> meetings = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();

    public abstract T initSchedule();

    public T addRoom(Room room){
        if(!rooms.contains(room)){
            rooms.add(room);
        }
        return null;
    }

    public abstract T addMeeting(Meeting meeting); //dodavanje novog termina uz provere o zauzetost, obraditi situaciju da je termin već zauzet
    public abstract T removeMeeting(Meeting meeting);//brisanje zauzetog termina

    public abstract T filterMeetings(Object... params);

    public abstract T filterMeetings(DayOfWeek dayOfWeek, LocalDate dateStart, LocalDate dateEnd, LocalTime timeStart, LocalTime timeEnd);

    public abstract T filterMeetings(LocalDateTime timeStart);


    public abstract T rescheduleMeeting(Meeting meeting, LocalDateTime startTime, LocalDateTime endTime); //premeštanje termina - brisanje i dodavanje novog termina sa istim vezanim podacima

}
