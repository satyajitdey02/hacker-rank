package com.skill.test.kayak.exercise3;

import java.util.Objects;

public abstract class AbstractRobot {

    static final double NINETY_DEGREE_VAL = 90.0;
    static final Integer SECOND_MILLIS = 1000;

    private String name;
    private Integer delay;
    private String instructions;
    private Profile profile;
    private Integer[] position = new Integer[2];
    private Integer rank;

    public AbstractRobot(String name, Integer delay, String instructions) {
        this.name = name;
        this.delay = delay;
        this.instructions = instructions;
    }

    public AbstractRobot(String name, Integer delay, String instructions, Profile profile) {
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

    public abstract void race() throws Exception;

    public void announceResult() {
        System.out.printf("%s is #%d, at [%d,%d]\n",
                this.getName(), this.getRank(), this.getPosition()[0], this.getPosition()[1]);
    }

    Integer calculateExecutedAt(Integer prevExeTime, Long currentStartTime, Long currentStopTime) {
        Long codeExeTime = (currentStopTime - currentStartTime) / 1000;
        return prevExeTime + Integer.parseInt(String.valueOf(codeExeTime));
    }

    void logStep(Integer executedAt, String name, Character turnOrMove) {
        System.out.printf("%02ds %s: %s %s%n",
                executedAt, name, turnOrMove == 'F' ? "Moves" : "Turns", Character.toString(turnOrMove));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractRobot that = (AbstractRobot) o;
        return Objects.equals(name, that.name) && Objects.equals(delay, that.delay) && Objects.equals(instructions, that.instructions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, delay, instructions);
    }
}
