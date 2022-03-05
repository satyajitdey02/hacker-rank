package com.skill.test.kayak.exercise3;

import org.junit.jupiter.api.Test;

public class RobotRaceTest {

    @Test
    public void raceWith3Robots()  {

       RaceManager manager = new RaceManager();
       manager.addParticipants(new RegularRobot("Joe", 3, "FRFLLFRF"));
       manager.addParticipants(new RegularRobot("Bill", 1, "FFFFFLF"));
       manager.addParticipants(new RegularRobot("Jim", 2, "LFRF"));

       manager.startRace();
       manager.finishRace();
    }
}
