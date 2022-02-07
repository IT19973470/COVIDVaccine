package lk.vaccine.repository;

import lk.vaccine.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TimeSlotRepository extends JpaRepository<TimeSlot, Integer> {

    @Query(value = "from TimeSlot order by assignedTime asc")
    List<TimeSlot> getTimeSlots();
}
