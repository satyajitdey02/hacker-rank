package com.skill.test.kayak.exercise3;

import java.util.concurrent.Callable;

public class RacingTask implements Callable<AbstractRobot> {

    private final AbstractRobot robot;

    public RacingTask(AbstractRobot robot) {
        this.robot = robot;
    }

    @Override
    public AbstractRobot call() throws Exception {
        robot.race();
        return robot;
    }
}
