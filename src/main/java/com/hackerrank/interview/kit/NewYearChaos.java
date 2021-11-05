package com.hackerrank.interview.kit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NewYearChaos {
    public static void main(String[] args) {
        minimumBribes(Arrays.asList(2, 1, 5, 3, 4));
        minimumBribes(Arrays.asList(2, 5, 1, 3, 4));
        minimumBribes(Arrays.asList(1, 2, 5, 3, 7, 8, 6, 4));

    }

    public static void minimumBribes(List<Integer> q) {
        List<Integer> queuedList = new ArrayList<>(q);
        Collections.sort(queuedList);
        int move = 0;
        int index = 0;
        while (index < queuedList.size()) {
            if (q.get(index).equals(queuedList.get(index))) {
                index++;
                continue;
            }

            if (q.get(index) - (index + 1) > 2) {
                System.out.println("Too chaotic");
                return;
            }


            if (q.get(index) == (index + 2)) {
                int temp = queuedList.get(index + 1);
                queuedList.remove(index+1);
                queuedList.add(index + 1, queuedList.get(index));
                queuedList.remove(index);
                queuedList.add(index, temp);
                move += 1;
                index++;
                continue;
            }

            if (q.get(index) == (index + 3)) {
                int temp1 = queuedList.get(index);
                int temp2 = queuedList.get(index + 1);
                int temp3 = queuedList.get(index + 2);
                queuedList.remove(index);
                queuedList.add(index, temp3);
                queuedList.remove(index + 1);
                queuedList.add(index + 1, temp1);
                queuedList.remove(index + 2);
                queuedList.add(index + 2, temp2);
                move += 2;
                index++;
                continue;
            }

            int temp1 = queuedList.get(index);
            int temp2 = queuedList.get(index+1);

            queuedList.remove(index);
            queuedList.add(index, temp2);
            queuedList.remove(index+1);
            queuedList.add(index+1,temp1);
            move++;
            index++;
        }

        System.out.println(move);
    }
}
