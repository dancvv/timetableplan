package com.example.plannertime.domain;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

@PlanningEntity
public class Lesson {
    private Long id;
    private String teacher;
    private String studentGroup;
    @PlanningVariable(valueRangeProviderRefs = "timeslotRange")
    private Timeslot timeslot;
    @PlanningVariable(valueRangeProviderRefs = "roomRange")
    private Room room;
    private Lesson(){}

    public Lesson(Long id, String teacher, String studentGroup, Timeslot timeslot, Room room) {
        this.id = id;
        this.teacher = teacher;
        this.studentGroup = studentGroup;
        this.timeslot = timeslot;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", teacher='" + teacher + '\'' +
                ", studentGroup='" + studentGroup + '\'' +
                ", timeslot=" + timeslot +
                ", room=" + room +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}

