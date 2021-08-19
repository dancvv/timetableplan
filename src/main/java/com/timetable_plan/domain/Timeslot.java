package com.timetable_plan.domain;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalTime;
@Data
public class Timeslot {
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    @Override
    public String toString() {
        return "Timeslot{" +
                "dayOfWeek=" + dayOfWeek +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
