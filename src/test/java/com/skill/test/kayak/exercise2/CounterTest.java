package com.skill.test.kayak.exercise2;

import com.skill.test.kayak.exercise2.Counter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CounterTest {

    private final Counter counter = new Counter();

    @Test
    @DisplayName("Count number up from {start} to {end}")
    public void printCountUp() {
        counter.countUp(0, 5);
    }

    @Test
    @DisplayName("Count number up from {start} to {end} and then down to {start}")
    public void printCountUpAndDown() {
        counter.countUpAndDown(0, 5);
    }
}
