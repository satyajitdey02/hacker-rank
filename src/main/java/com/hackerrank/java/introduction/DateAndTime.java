package com.hackerrank.java.introduction;

import java.util.Calendar;
import java.util.Scanner;

/**
 * Created by satyajit on 12/25/16.
 */
public class DateAndTime {
  public static void main(String[] args) {
    String[] daysOfWeek = {"SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY"};
    Scanner scanner = new Scanner(System.in);
    int mm = scanner.nextInt();
    int dd = scanner.nextInt();
    int yyyy = scanner.nextInt();
    if (yyyy <= 2000 || yyyy >= 3000) {
      return;
    }

    Calendar calendar = Calendar.getInstance();
    calendar.set(yyyy, mm - 1, dd);

    System.out.println(daysOfWeek[calendar.get(calendar.DAY_OF_WEEK) - 1]);
    scanner.close();
  }
}
