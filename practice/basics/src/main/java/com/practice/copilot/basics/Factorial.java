package com.practice.copilot.basics;

/**
 * Class that calculates the factorial of a number.
 */
public class Factorial {
    
    /**
     * Method that calculates the factorial of a number.
     * @param number the number to calculate the factorial of
     * @return the factorial of the number
     * @throws IllegalArgumentException if the number is less than 0 or greater than 20
     */
    public long calculateFactorial(int number) {
        if (number < 0 || number > 20) {
            throw new IllegalArgumentException("Number must be between 0 and 20");
        }
        if (number == 0) {
            return 1;
        }
        return number * calculateFactorial(number - 1);
    }

    public static void main(String[] args) {
        Factorial factorial = new Factorial();
        System.out.println(factorial.calculateFactorial(5));
    }
}