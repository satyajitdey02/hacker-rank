package com.skill.test.kayak.exercise3;

public class Profile {
    private Turn leftDirection;
    private Turn rightDirection;
    private Integer moveForwardUnit;
    private Integer batteryLevel;
    private Integer powerUsedPerMovement;

    public Profile() {
        this(Turn.LEFT, Turn.RIGHT, 1, 100, 1);
    }

    public Profile(Turn leftDirection, Turn rightDirection, Integer moveForwardUnit,
                   Integer batteryLevel, Integer powerUsedPerMovement) {
        this.leftDirection = leftDirection;
        this.rightDirection = rightDirection;
        this.moveForwardUnit = moveForwardUnit;
        this.batteryLevel = batteryLevel;
        this.powerUsedPerMovement = powerUsedPerMovement;
    }

    public Turn getLeftDirection() {
        return leftDirection;
    }

    public void setLeftDirection(Turn leftDirection) {
        this.leftDirection = leftDirection;
    }

    public Turn getRightDirection() {
        return rightDirection;
    }

    public void setRightDirection(Turn rightDirection) {
        this.rightDirection = rightDirection;
    }

    public Integer getMoveForwardUnit() {
        return moveForwardUnit;
    }

    public void setMoveForwardUnit(Integer moveForwardUnit) {
        this.moveForwardUnit = moveForwardUnit;
    }

    public Integer getBatteryLevel() {
        return batteryLevel;
    }

    public void setBatteryLevel(Integer batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public Integer getPowerUsedPerMovement() {
        return powerUsedPerMovement;
    }

    public void setPowerUsedPerMovement(Integer powerUsedPerMovement) {
        this.powerUsedPerMovement = powerUsedPerMovement;
    }
}
