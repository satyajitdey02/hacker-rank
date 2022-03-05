package com.skill.test.kayak.exercise3;

import static java.lang.Thread.sleep;

public class RegularRobot extends AbstractRobot {

    public RegularRobot(String name, Integer delay, String instructions) {
        super(name, delay, instructions);
    }

    @Override
    public void race() throws InterruptedException {
        int x = 0, y = 0;
        double theta = 0.0;
        Integer executedAt = 1;

        for (int i = 0; i < this.getInstructions().length(); i++) {
            Long startTime = System.currentTimeMillis();
            if (i != 0) {
                sleep(this.getDelay() * 1000);
            }

            if (this.getInstructions().charAt(i) == 'L') {
                theta = theta - 90.0;
            } else if (this.getInstructions().charAt(i) == 'R') {
                theta = theta + 90.0;
            } else {
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

    private Integer calculateExecutedAt(Integer prevExeTime, Long currentStartTime, Long currentStopTime) {
        Long codeExeTime = (currentStopTime - currentStartTime) / 1000;
        return prevExeTime + Integer.parseInt(String.valueOf(codeExeTime));
    }

    private void logStep(Integer executedAt, String name, Character turnOrMove) {
        System.out.printf("%02ds %s: %s %s%n",
                executedAt, name, turnOrMove == 'F' ? "Moves" : "Turns", Character.toString(turnOrMove));
    }
}
