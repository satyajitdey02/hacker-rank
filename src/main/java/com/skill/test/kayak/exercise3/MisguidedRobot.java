package com.skill.test.kayak.exercise3;

import static java.lang.Thread.sleep;

public class MisguidedRobot extends AbstractRobot {

    public MisguidedRobot(String name, Integer delay, String instructions, Profile profile) {
        super(name, delay, instructions, profile);
    }

    @Override
    public void race() throws Exception {
        int x = 0, y = 0;
        double theta = 0.0;
        Integer executedAt = 1;

        for (int i = 0; i < this.getInstructions().length(); i++) {
            Long startTime = System.currentTimeMillis();
            if (i != 0) {
                sleep((long) this.getDelay() * SECOND_MILLIS);
            }

            if (this.getInstructions().charAt(i) == 'L') {
                theta = theta + (this.getProfile().getLeftDirection().getValue() * NINETY_DEGREE_VAL);
            } else if (this.getInstructions().charAt(i) == 'R') {
                theta = theta + (this.getProfile().getRightDirection().getValue() * NINETY_DEGREE_VAL);
            } else {//Consider instructions are valid containing characters 'L', 'R' and 'F' only
                x = x + (int) Math.sin(Math.toRadians(theta));
                y = y + (int) Math.cos(Math.toRadians(theta));
            }

            Long stopTime = System.currentTimeMillis();
            executedAt = calculateExecutedAt(executedAt, startTime, stopTime);

            logStep(executedAt, this.getName(), this.getInstructions().charAt(i));
        }

        this.setPosition(new Integer[]{x, y});
        this.setRank(RaceManager.markCompleted());
    }
}
