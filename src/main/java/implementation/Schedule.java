package implementation;

import model.Meeting;
import model.Room;

import java.util.ArrayList;
import java.util.List;

public abstract class Schedule<T> {

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

    public abstract T rescheduleMeeting(Meeting meeting); //premeštanje termina - brisanje i dodavanje novog termina sa istim vezanim podacima

}
