package com.skill.test.Toptal;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        String ts1 =
                "photo.jpg, Warsaw, 2013-09-05 14:08:15\n"
                        + "john.png, London, 2015-06-20 15:13:22\n"
                        + "myFriends.png, Warsaw, 2013-09-05 14:07:13\n"
                        + "Eiffel.jpg, Paris, 2015-07-23 08:03:02\n"
                        + "pisatower.jpg, Paris, 2015-07-22 23:59:59\n"
                        + "BOB.jpg, London, 2015-08-05 00:02:03\n"
                        + "notredame.png, Paris, 2015-09-01 12:00:00\n"
                        + "me.jpg, Warsaw, 2013-09-06 15:40:22\n"
                        + "a.png, Warsaw, 2016-02-13 13:33:50\n"
                        + "b.jpg, Warsaw, 2016-01-02 15:12:22\n"
                        + "c.jpg, Warsaw, 2016-01-02 14:34:30\n"
                        + "d.jpg, Warsaw, 2016-01-02 15:15:01\n"
                        + "e.png, Warsaw, 2016-01-02 09:49:09\n"
                        + "f.png, Warsaw, 2016-01-02 10:55:32\n"
                        + "g.jpg, Warsaw, 2016-02-29 22:13:11\n"
                        + "h.jpg, Warsaw, 2016-02-29 22:13:12";
        Test3 t3 = new Test3();
        System.out.println(t3.solution(ts1));
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        Map<String, TreeMap<String, Integer>> cityWisePhotosList = new HashMap<>();
        List<String> photoList = new ArrayList<>();
        Map<String, String> cityWiseExt = new HashMap<>();

        String[] photoData = s.split("\\n");
        for (String photo : photoData) {
            String[] parts = photo.split(",");
            photoList.add(String.format("%s,%s", parts[1].trim(), parts[2].trim()));

            if (cityWisePhotosList.containsKey(parts[1].trim())) {
                cityWisePhotosList
                        .get(parts[1].trim())
                        .put(parts[2].trim(), cityWisePhotosList.get(parts[1].trim()).size());
            } else {
                TreeMap<String, Integer> entry = new TreeMap<>();
                entry.put(parts[2].trim(), 0);
                cityWisePhotosList.put(parts[1].trim(), entry);
                cityWiseExt.put(parts[1].trim(), parts[0].trim());
            }
        }

        for (String value : photoList) {
            String[] cityDateParts = value.split(",");
            String[] cityWiseFileNameParts = cityWiseExt.get(cityDateParts[0].trim()).split("\\.");

            String formatStr =
                    "%0"
                            + String.valueOf(cityWisePhotosList.get(cityDateParts[0].trim()).size() - 1).length()
                            + "d";
            String fIndexName =
                    String.format(
                            formatStr, cityWisePhotosList.get(cityDateParts[0].trim()).get(cityDateParts[1]));
            String fName =
                    String.format(
                            "%s%s.%s",
                            cityWiseFileNameParts[0].trim(), fIndexName, cityWiseFileNameParts[1].trim());

            sb.append(
                    String.format("%s, %s, %s\n", fName, cityDateParts[0].trim(), cityDateParts[1].trim()));
        }

        return sb.toString();
    }
}