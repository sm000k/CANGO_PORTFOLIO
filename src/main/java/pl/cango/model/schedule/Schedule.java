package pl.cango.model.schedule;

import java.util.UUID;

public class Schedule {
    UUID id;
    ScheduleGroup group_id;
    Type type;
    WeekDay weekDay;
    String start_time;
    int duration;
}
