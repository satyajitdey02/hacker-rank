package com.skill.test.zalando.misc;

public class Task1 {
    public static void main(String[] args) {
        String input = "my.song.mp3 11b\ngreatSong.flac 1000b\nnot3.txt 5b\nvideo.mp4 200b\ngame.exe 100b\nmov!e.mkv 10000b";
        Task1 task1 = new Task1();

        System.out.println(task1.solution(input));
    }

//    "music 1011b
//    images 0b
//    movies 10200b
//    other 105b"

    public String solution(String S) {
        long musicsSizeCount = 0, imagesSizeCount = 0, moviesSizeCount = 0, otherSizeCount = 0;
        String[] fileDescriptions = S.split("\n");
        for (String fd : fileDescriptions) {
            String[] fdParts = fd.split("\\s+");
            if (fdParts[0].endsWith(".mp3") || fdParts[0].endsWith(".aac") || fdParts[0].endsWith(".flac")) {
                musicsSizeCount += Integer.parseInt(fdParts[1].substring(0, fdParts[1].length() - 1));
            } else if (fdParts[0].endsWith(".jpg") || fdParts[0].endsWith(".bmp") || fdParts[0].endsWith(".gif")) {
                imagesSizeCount += Integer.parseInt(fdParts[1].substring(0, fdParts[1].length() - 1));
            } else if (fdParts[0].endsWith(".mp4") || fdParts[0].endsWith(".avi") || fdParts[0].endsWith(".mkv")) {
                moviesSizeCount += Integer.parseInt(fdParts[1].substring(0, fdParts[1].length() - 1));
            } else {
                otherSizeCount += Integer.parseInt(fdParts[1].substring(0, fdParts[1].length() - 1));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("music ").append(musicsSizeCount).append("b\n");
        result.append("images ").append(imagesSizeCount).append("b\n");
        result.append("movies ").append(moviesSizeCount).append("b\n");
        result.append("other ").append(otherSizeCount).append("b\n");

        return result.toString();
    }
}
