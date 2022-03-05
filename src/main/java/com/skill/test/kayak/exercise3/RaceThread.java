package com.skill.test.kayak.exercise3;

import java.util.concurrent.Callable;

import static java.lang.Thread.sleep;

public class RaceThread implements Callable<Robot> {

    private final Robot robot;

    public RaceThread(Robot robot) {
        this.robot = robot;
    }

    @Override
    public Robot call() throws Exception {
        int x = 0, y = 0;
        double theta = 0.0;
        Integer executedAt = 1;

        for (int i = 0; i < robot.getInstructions().length(); i++) {
            Long startTime = System.currentTimeMillis();
            if (i != 0) {
                sleep(robot.getDelay() * 1000);
            }

            if (robot.getInstructions().charAt(i) == 'L') {
                theta = theta + (robot.getProfile().getLeftDirection().getValue() * 90.0);
            } else if (robot.getInstructions().charAt(i) == 'R') {
                theta = theta + (robot.getProfile().getRightDirection().getValue() * 90.0);
            } else {//Consider instructions are valid containing characters 'L', 'R' and 'F' only
                x = x + (int) Math.sin(Math.toRadians(theta)) * robot.getProfile().getMoveForwardUnit();
                y = y + (int) Math.cos(Math.toRadians(theta)) * robot.getProfile().getMoveForwardUnit();
            }

            Long stopTime = System.currentTimeMillis();
            executedAt = calculateExecutedAt(executedAt, startTime, stopTime);

            printInfo(executedAt, robot.getName(), robot.getInstructions().charAt(i));
        }

        robot.setPosition(new Integer[]{x, y});
        robot.setRank(RaceManager.markCompleted());

        return robot;
    }

    private Integer calculateExecutedAt(Integer prevExeTime, Long currentStartTime, Long currentStopTime) {
        Long codeExeTime = (currentStopTime - currentStartTime) / 1000;
        return prevExeTime + Integer.parseInt(String.valueOf(codeExeTime));
    }

    private void printInfo(Integer executedAt, String name, Character turnOrMove) {
        System.out.printf("%02ds %s: %s %s%n",
                executedAt, name, turnOrMove == 'F' ? "Moves" : "Turns", Character.toString(turnOrMove));
    }
}
