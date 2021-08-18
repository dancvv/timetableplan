package com.timetable_plan.domain;

public class Room {
    private String name;
    private Room(){}

    public String getName() {
        return name;
    }

    public Room(String name) {
        this.name = name;
    }
}
