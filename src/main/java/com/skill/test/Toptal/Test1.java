package com.skill.test.Toptal;

public class Test1 {
    public static void main(String[] args) {
        String testStr1 = "We test coders. Give us a try?";
        String testStr2 = "Forget  CVs.. Save time . X x! Nothing? Ok";

        System.out.println(solution(testStr1));
    }

    public static int solution(String S) {
        String altText = S.replaceAll("\\?", ".").replaceAll("!", ".");
        String[] sentences = altText.split("\\.");
        if(sentences.length == 0) {
            return 0;
        }

        int maxNoWords = Integer.MIN_VALUE;
        for (String sent : sentences) {
            String[] words = sent.trim().split("\\s+");
            if(words.length > maxNoWords) {
                maxNoWords = words.length;
            }
        }

        return maxNoWords;
    }
}
