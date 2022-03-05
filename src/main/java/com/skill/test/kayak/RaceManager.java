package com.skill.test.kayak;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.*;

public class RaceManager {

    ExecutorService executor = Executors.newFixedThreadPool(10);

    private final List<Robot> participants = new ArrayList<>();
    private static Integer noOfParticipantsCompletedRace;

    public void addParticipants(Robot robot) {
        participants.add(robot);
    }

    public void startRace() {
        noOfParticipantsCompletedRace = 0;
        List<Future<Robot>> futureList = new ArrayList<>();
        for (Robot robot : participants) {
            Callable<Robot> joe = new RaceThread(robot);
            Future<Robot> joeFuture = executor.submit(joe);
            futureList.add(joeFuture);
        }

        executor.shutdown();
        //make sure all tasks are completed
        while (!executor.isTerminated()) {
            // Do nothing
        }

        printResult(futureList);
    }

    public static synchronized Integer markCompleted() {
        return ++noOfParticipantsCompletedRace;
    }

    private void printResult(List<Future<Robot>> list) {
        list.stream().map(e -> {
            try {
                return e.get();
            } catch (InterruptedException | ExecutionException ex) {
                ex.printStackTrace();
            }

            return null;
        }).sorted(Comparator.comparingInt(Robot::getRank)).forEach(e -> {
            System.out.printf("%s is #%d, at [%d,%d]\n", e.getName(), e.getRank(), e.getPosition()[0], e.getPosition()[1]);
        });
    }

    public void finishRace() {
        participants.clear();
        noOfParticipantsCompletedRace = 0;
    }
}
