package com.timetable_plan.domain;

import lombok.Data;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
@Data
public class TimeTable {
    @ValueRangeProvider(id="timeslotRange")
    @ProblemFactCollectionProperty
    private List<Timeslot> timeslotList;
    @ValueRangeProvider(id="roomRange")
    @ProblemFactCollectionProperty
    private List<Room> roomList;
    @PlanningEntityCollectionProperty
    private List<Lesson> lessonList;
    @PlanningScore
    private HardSoftScore score;

    private TimeTable(){}

    public TimeTable(List<Timeslot> timeslotList, List<Room> roomList, List<Lesson> lessonList, HardSoftScore score) {
        this.timeslotList = timeslotList;
        this.roomList = roomList;
        this.lessonList = lessonList;
        this.score = score;
    }
}
