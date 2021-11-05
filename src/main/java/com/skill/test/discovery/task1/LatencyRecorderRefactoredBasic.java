package com.skill.test.discovery.task1;

import java.util.ArrayList;
import java.util.Collections;

public class LatencyRecorderRefactoredBasic {

    private static final int ZERO = 0;
    private static ArrayList<Integer> lt = new ArrayList<>();

    public static void main(String[] args) {
        putLatency(100);
        putLatency(200);
        putLatency(50);

        System.out.println(get_max());
        System.out.println(smallest());

        System.out.println(getLatencyProcent(50.0));
    }

    public static void reset() {
        lt.clear();
    }

    public static void putLatency(Integer tim) {
        lt.add(tim);
    }

    public static Integer get_max() {
        Collections.sort(lt);
        return lt.get(lt.size() - 1);//Replace {lt.size()} with {lt.size() - 1} to avoid IndexOutOfBoundsException
    }

    static int smallest() {
        Collections.sort(lt);
        return lt.get(ZERO);
    }

    //Here by getLatencyProcent I understood getLatencyPercent,
    //however I don't have enough idea how this should be calculated
    //So I am just fixing the potential error j <= lt.size() condition ignoring the business logic
    public static long getLatencyProcent(double z) {
        Collections.sort(lt);
        for (int j = 0; j < lt.size(); j++)//Replace {j <= lt.size()} with {j < lt.size()} to avoid IndexOutOfBoundsException
            if ((double) (j / lt.size() * 100) > z) return lt.get(j);
        return ZERO;
    }
}
