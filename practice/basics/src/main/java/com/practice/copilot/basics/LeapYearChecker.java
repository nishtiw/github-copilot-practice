package com.practice.copilot.basics;

public class LeapYearChecker {
    public static void main(String[] args) {
        int year = 2024; // Example year, you can change this to test other years.
        System.out.println(year + " is a leap year? " + isLeapYear(year));
    }

    public static boolean isLeapYear(int year) {
        // if (year % 4 != 0) {
        //     return false; // not divisible by 4
        // } else if (year % 100 != 0) {
        //     return true; // divisible by 4 but not by 100
        // } else if (year % 400 != 0) {
        //     return false; // divisible by 100 but not by 400
        // } else {
        //     return true; // divisible by 400
        // }
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}

