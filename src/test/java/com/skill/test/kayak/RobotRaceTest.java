package com.skill.test.kayak;

import org.junit.jupiter.api.Test;

public class RobotRaceTest {

    @Test
    public void raceWith3Robots()  {

       RaceManager manager = new RaceManager();
       manager.addParticipants(new Robot("Joe", 3, "FRFLLFRF"));
       manager.addParticipants(new Robot("Bill", 1, "FFFFFLF"));
       manager.addParticipants(new Robot("Jim", 2, "LFRF"));

       manager.startRace();
       manager.finishRace();
    }
}
