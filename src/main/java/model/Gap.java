package model;

import lombok.Getter;
import lombok.Setter;
import model.Room;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Gap {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Room> rooms = new ArrayList<>();
    public Gap(LocalDateTime startTime, LocalDateTime endTime, Room room) {
        this.startTime = startTime;
        this.endTime = endTime;
        rooms.add(room);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Gap){

            Gap gap = (Gap) obj;

            return startTime.isEqual(gap.startTime) && endTime.isEqual(gap.endTime);
        }
        else return false;
    }
}
