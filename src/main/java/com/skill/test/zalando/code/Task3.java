package com.skill.test.zalando.code;

public class Task3 {

    public static void main(String[] args) {
        Task3 task = new Task3();
//        System.out.println("bb -> " + task.solution("bb"));
//        System.out.println("bbb -> " + task.solution("bbb"));
//        System.out.println("bbbb -> " + task.solution("bbbb"));
//        System.out.println("bbbbb -> " + task.solution("bbbbb"));
//        System.out.println("bbbbbb -> " + task.solution("bbbbbb"));
//        //System.out.println("aaaaaa -> " + task.solution("aaaaaa"));
//        System.out.println("bbbb -> " + task.solution("bbbb"));
//        System.out.println("bbbbb -> " + task.solution("bbbbb"));
//        System.out.println("bbbaaa -> " + task.solution("bbbaaa"));
//        System.out.println("bbbaaa -> " + task.solution("bbbaaa"));
//        System.out.println("bbbaaaa -> " + task.solution("bbbaaaa"));
//        System.out.println("bbbaaaaaa -> " + task.solution("bbbaaaaaa"));
        //System.out.println("babaa -> " + task.solution("babaa"));
//        System.out.println("baabaabaa -> " + task.solution("baabaabaa"));
//        System.out.println("aabaabaa -> " + task.solution("aabaabaa"));
      // System.out.println("ababab -> " + task.solution("ababab"));
        System.out.println("ababab -> " + task.solution("ababab"));
       // System.out.println("ababa -> " + task.solution("ababa"));
        System.out.println("ababa -> " + task.solution("bbbababab"));
    }

    public int solution(String S) {
        if(S == null || S.length() < 3) {
            return 0;
        }

        String lowerCasedS = S.toLowerCase();
        int numOfA = (int) lowerCasedS.chars().filter(c -> c == 'a').count();
        if (numOfA % 3 != 0) {
            return 0;
        }

        int numOfB = (int) lowerCasedS.chars().filter(c -> c == 'b').count();
        if(numOfA == 0) {
            int n = (numOfB - 3) + 1;
            return (n * (n+1)) / 2;
        }
        String strr  = S.replaceAll("^[b]*", "").replaceAll("[b]*$", "");
         numOfB = (int) strr.chars().filter(c -> c == 'b').count();
         return 2 * numOfB;
//        if (lowerCasedS.indexOf("b") == 0 && lowerCasedS.lastIndexOf("b") == (lowerCasedS.length() - 1)) {
//            return 2 * (numOfB - 2);
//        } else if (lowerCasedS.indexOf("b") == 0 || lowerCasedS.lastIndexOf("b") == (lowerCasedS.length() - 1)) {
//            return 2 * (numOfB - 1);
//        } else {
//            return 2 * numOfB;
//        }

    }
}
