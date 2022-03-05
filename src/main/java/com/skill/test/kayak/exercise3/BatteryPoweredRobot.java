package com.skill.test.kayak.exercise3;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class BatteryPoweredRobot extends AbstractRobot {

    private final Integer batteryLevel;
    private final Integer powerConsumedPerStep;

    public BatteryPoweredRobot(String name, Integer delay, String instructions, Integer batteryLevel, Integer powerConsumedPerStep) {
        super(name, delay, instructions);
        this.batteryLevel = batteryLevel;
        this.powerConsumedPerStep = powerConsumedPerStep;
    }

    @Override
    public void race() throws InterruptedException {
        int x = 0, y = 0;
        double theta = 0.0;
        Integer executedAt = 1;
        Integer batteryUsed = 0;

        for (int i = 0; i < this.getInstructions().length(); i++) {
            if(batteryUsed >= batteryLevel) {
                System.out.printf("All power consumed, %s dying and quiting race!", this.getName());
                RaceManager.abortRace(this);
                return;
            }

            Long startTime = System.currentTimeMillis();
            if (i != 0) {
                sleep((long) this.getDelay() * SECOND_MILLIS);
            }

            if (this.getInstructions().charAt(i) == 'L') {
                theta = theta - NINETY_DEGREE_VAL;
            } else if (this.getInstructions().charAt(i) == 'R') {
                theta = theta + NINETY_DEGREE_VAL;
            } else {
                x = x + (int) Math.sin(Math.toRadians(theta));
                y = y + (int) Math.cos(Math.toRadians(theta));
            }

            batteryUsed += powerConsumedPerStep;

            Long stopTime = System.currentTimeMillis();
            executedAt = calculateExecutedAt(executedAt, startTime, stopTime);

            logStep(executedAt, this.getName(), this.getInstructions().charAt(i));
        }

        this.setPosition(new Integer[]{x, y});
        this.setRank(RaceManager.markCompleted());
    }
}
