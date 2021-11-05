package com.skill.test.Toptal;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        Test2 test = new Test2();
        System.out.println(test.solution(new int[]{100, 100, 100, -10}, new String[]{"2020-12-31", "2020-12-22", "2020-12-03", "2020-12-29"}));
        //System.out.println(test.solution(new int[]{180, -50, -25, -25}, new String[]{"2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31"}));
    }

    public int solution(int[] A, String[] D) {
        int result = 0;

        Map<String, String> transactions = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int month = Integer.parseInt(D[i].split("\\-")[1]);
            String key = "2020-" + month;
            if (transactions.containsKey(key)) {
                String txDetails = transactions.get(key);
                String[] parts = txDetails.split(":");
                int prevAmount = Integer.parseInt(parts[0]);
                int noCardTx = Integer.parseInt(parts[1]);
                int cardAmount = Integer.parseInt(parts[2]);

                if (A[i] < 0) {
                    noCardTx += 1;
                    cardAmount += A[i];
                }

                int curAmount = prevAmount + A[i];

                transactions.put(key, curAmount + ":" + noCardTx + ":" + cardAmount);
            } else {
                transactions.put(key, A[i] + ":" + (A[i] < 0 ? 1 : 0) + ":" + (Math.min(A[i], 0)));
            }
        }

        int monthFeeCut = 0;
        for (Map.Entry<String, String> entry : transactions.entrySet()) {
            String[] parts = entry.getValue().split(":");


            int txAmount = Integer.parseInt(parts[0]);
            int noCardTx = Integer.parseInt(parts[1]);
            int cardTxAmount = Integer.parseInt(parts[2]);

            if (noCardTx >= 3 && cardTxAmount <= -100) {
                monthFeeCut += 5;
            }

            result += txAmount;
        }

        return result - 60 + monthFeeCut;
    }
}
