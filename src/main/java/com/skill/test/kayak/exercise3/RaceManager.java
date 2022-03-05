package com.skill.test.kayak.exercise3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

public class RaceManager {

    ExecutorService executor = Executors.newFixedThreadPool(10);

    private final List<AbstractRobot> participants = new ArrayList<>();
    private static Integer noOfParticipantsCompletedRace;

    public void addParticipants(AbstractRobot abstractRobot) {
        participants.add(abstractRobot);
    }

    public void startRace() {
        noOfParticipantsCompletedRace = 0;
        List<Future<AbstractRobot>> futureList = new ArrayList<>();
        for (AbstractRobot abstractRobot : participants) {
            Callable<AbstractRobot> joe = new RacingTask(abstractRobot);
            Future<AbstractRobot> joeFuture = executor.submit(joe);
            futureList.add(joeFuture);
        }

        executor.shutdown();
        //make sure all tasks are completed
        while (!executor.isTerminated()) {
            // Do nothing
        }

        System.out.println("The race has ENDED!");
        printResult(futureList);
    }

    public static synchronized Integer markCompleted() {
        return ++noOfParticipantsCompletedRace;
    }

    private void printResult(List<Future<AbstractRobot>> list) {
        list.stream().map(e -> {
            try {
                return e.get();
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }

            return null;
        }).sorted(Comparator.comparingInt(AbstractRobot::getRank)).forEach(AbstractRobot::announceResult);
    }

    public void finishRace() {
        participants.clear();
        noOfParticipantsCompletedRace = 0;
    }
}
