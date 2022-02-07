package lk.vaccine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int timeSlotId;
    private LocalTime assignedTime;

    public int getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(int timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public LocalTime getAssignedTime() {
        return assignedTime;
    }

    public void setAssignedTime(LocalTime assignedTime) {
        this.assignedTime = assignedTime;
    }
}
