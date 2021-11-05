package com.skill.test.discovery.task1;

import java.util.ArrayList;
import java.util.Collections;

public class LatencyRecorderRefactoredMedium {
    public static void main(String[] args) {
        addLatency(100);
        addLatency(200);
        addLatency(50);

        System.out.println(getMaxLatency());
        System.out.println(getMinLatency());

        System.out.println(getLatencyProcent(50.0));
    }

    private static final int ZERO = 0;
    private static ArrayList<Integer> lt = new ArrayList<>();

    private static Integer MAX_LATENCY = Integer.MIN_VALUE;//I can keep track of get_max() here as MAX_LATENCY
    private static Integer MIN_LATENCY = Integer.MAX_VALUE;//I can keep track of smallest() here as MAX_LATENCY

    public static void reset() {
        lt.clear();
    }

    //I can rename putLatency to addLatency which may be more semantic for this method. May be not a big deal!
    //We need to make sure that all the references to this method are updated after rename
    public static void addLatency(Integer tim) {
        lt.add(tim);
        //I can update the MAX_LATENCY on every insert to avoid Collections.sort(lt) on every call to getMaxLatency()
        MAX_LATENCY = Integer.max(MAX_LATENCY, tim);
        //I can update the MIN_LATENCY on every insert to avoid Collections.sort(lt) on every call to getMinLatency()
        MIN_LATENCY = Integer.min(MIN_LATENCY, tim);
    }

    //I can rename get_max to getMaxLatency to follow the Java naming convention
    //We need to make sure that all the references to this method are updated after rename
    public static Integer getMaxLatency() {
        return MAX_LATENCY;
    }

    //I can rename smallest() to getMinLatency() to characterize a method as verb
    static int getMinLatency() {
        return MIN_LATENCY;
    }

    //Here by getLatencyProcent I understood getLatencyPercent,
    //however I don't have enough clear idea about the business logic of this method
    //So I am just fixing the potential error j <= lt.size() condition ignoring the business logic
    public static long getLatencyProcent(double z) {
        Collections.sort(lt);
        for (int j = 0; j < lt.size(); j++)//Replace {j <= lt.size()} with {j < lt.size()} to avoid IndexOutOfBoundsException
            if ((double) (j / lt.size() * 100) > z) return lt.get(j);
        return ZERO;
    }
}
