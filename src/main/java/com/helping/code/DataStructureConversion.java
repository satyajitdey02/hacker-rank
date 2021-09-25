package com.helping.code;

import java.util.*;

public class DataStructureConversion {
    public static void main(String[] args) {
        Integer[] nums = {6, 1, 2, 2, 3, 4, 7, 5};
        //Set<Integer> numsSet = new HashSet<Integer>(Arrays.asList(nums));
        //System.out.println(numsSet);

        Set<Integer> target = new HashSet<Integer>();
        Collections.addAll(target, nums);
        System.out.println(target);
    }
}
