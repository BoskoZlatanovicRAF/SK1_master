package implementation;

import lombok.Getter;
import lombok.Setter;
import model.Gap;
import model.Meeting;
import model.Room;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public abstract class Schedule<T> {
    LocalDate timeValidFrom;
    LocalDate timeValidTo;
    List<LocalDate> exceptions = new ArrayList<>();
    List<Meeting> meetings = new ArrayList<>();
    List<Room> rooms = new ArrayList<>();
    private LocalTime scheduleTimeStart = LocalTime.of(9,0);
    private LocalTime scheduleTImeEnd = LocalTime.of(21,0);

    public abstract T initSchedule();

    public T addRoom(Room room){
        if(!rooms.contains(room)){
            rooms.add(room);
        }
        return null;
    }

    public abstract T addMeeting(Meeting meeting); //dodavanje novog termina uz provere o zauzetost, obraditi situaciju da je termin već zauzet
    public abstract boolean removeMeeting(Meeting meeting);//brisanje zauzetog termina


    public List<Meeting> filterMeetingByParameters(HashMap<String,Object> additionalAttributes,String type){

        return this.getMeetings().stream().filter(meeting -> ((Meeting)meeting).hasAdditionalAttribute(additionalAttributes,type))
                .sorted(Comparator.comparing(Meeting::getTimeStart))
                .collect(Collectors.toList());
    }
    public List<Meeting> filterRoomsByAtribute(HashMap<String,Object> meetingParameters, HashMap<String,Object> roomParameters) {
        return (List<Meeting>) this.getMeetings().stream().filter(meeting -> ((Meeting)meeting).hasAdditionalAttribute(meetingParameters,"meeting")).filter(m -> ((Meeting)m).hasAdditionalAttribute(roomParameters,"room"))
                .sorted(Comparator.comparing(Meeting::getTimeStart))
                .collect(Collectors.toList());
    }

    public abstract List<Meeting> filterByParameters(HashMap<String,Object> meetingParams,HashMap<String,Object> roomParams);

    public abstract List<Gap> filterMeetingsGapsByTimeSpan(DayOfWeek dayOfWeek, LocalDate dateStart, LocalDate dateEnd, LocalTime timeStart, LocalTime timeEnd);
    public abstract List<Meeting> filterMeetingsByTimeSpan(DayOfWeek dayOfWeek, LocalDate dateStart, LocalDate dateEnd, LocalTime timeStart, LocalTime timeEnd);

    public abstract List<Gap> filterMeetingsGaps(LocalDateTime timeStart);
    public abstract List<Meeting> filterMeetings(LocalDateTime timeStart);



    public abstract T rescheduleMeeting(Meeting meeting, LocalDateTime startTime, LocalDateTime endTime); //premeštanje termina - brisanje i dodavanje novog termina sa istim vezanim podacima

}
