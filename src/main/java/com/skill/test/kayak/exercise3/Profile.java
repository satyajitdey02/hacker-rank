package com.skill.test.kayak.exercise3;

public class Profile {
    private Turn leftDirection;
    private Turn rightDirection;
    private Integer moveForwardUnit;

    public Profile() {
        this(Turn.LEFT, Turn.RIGHT, 1);
    }

    public Profile(Turn leftDirection, Turn rightDirection, Integer moveForwardUnit) {
        this.leftDirection = leftDirection;
        this.rightDirection = rightDirection;
        this.moveForwardUnit = moveForwardUnit;
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
}
