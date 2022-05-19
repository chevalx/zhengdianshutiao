package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        String[] strings = input.split(":");
        int minute = Integer.parseInt(strings[1]);
        int hour = Integer.parseInt(strings[0]);
        double hourAngle = 30 * hour + minute * 0.5;
        double minuteAngle = 6 * minute;
        double res = Math.max(hourAngle, minuteAngle) - Math.min(hourAngle, minuteAngle);
        System.out.println(res < 180 ? res : 360 - res);
    }
}
