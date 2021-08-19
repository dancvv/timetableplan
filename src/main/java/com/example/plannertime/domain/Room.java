package com.example.plannertime.domain;




public class Room {
    private String name;
    private Room(){}

    @Override
    public String toString() {
        return "Room{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public Room(String name) {
        this.name = name;
    }
}

