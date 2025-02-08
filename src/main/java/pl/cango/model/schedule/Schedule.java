package pl.cango.model.schedule;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;
    @ManyToOne
    @JoinColumn(name = "schedulegroup_id")
    ScheduleGroup group_id;
    Type type;
    WeekDay weekDay;
    String start_time;
    int duration;
}
