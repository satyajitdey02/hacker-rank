package com.skill.test.kayak;

public enum Turn {
    LEFT(-1),
    RIGHT(1);

    Integer value;

    Turn(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
