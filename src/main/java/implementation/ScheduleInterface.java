package implementation;

import model.Meeting;

public interface ScheduleInterface<T> {

    public T initSchedule();

    public T addMeeting(Meeting meeting);
    public T removeMeeting(Meeting meeting);

    public T filterMeetings(Object... params);

    public T rescheduleMeeting(Meeting meeting);

}
