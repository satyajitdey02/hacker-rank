package com.skill.test.kayak;

public class Robot {
    private String name;
    private Integer delay;
    private String instructions;
    private Profile profile;
    private Integer[] position = new Integer[2];
    private Integer rank;

    public Robot() {
    }

    public Robot(String name, Integer delay, String instructions) {
        this.name = name;
        this.delay = delay;
        this.instructions = instructions;
        this.profile = new Profile(Turn.LEFT, Turn.RIGHT, 1, 100, 1);
    }

    public Robot(String name, Integer delay, String instructions, Profile profile) {
        this.name = name;
        this.delay = delay;
        this.instructions = instructions;
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDelay() {
        return delay;
    }

    public void setDelay(Integer delay) {
        this.delay = delay;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public Integer[] getPosition() {
        return position;
    }

    public void setPosition(Integer[] position) {
        this.position = position;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
