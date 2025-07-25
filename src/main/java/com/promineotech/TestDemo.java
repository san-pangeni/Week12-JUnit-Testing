package com.promineotech;

import java.util.Random;

public class TestDemo {

    /**
     * Adds two positive integers.
     * @param a The first positive integer.
     * @param b The second positive integer.
     * @return The sum of the two integers.
     * [cite_start]@throws IllegalArgumentException if either parameter is not positive. [cite: 224, 226]
     */
    public int addPositive(int a, int b) {
        if (a > 0 && b > 0) {
            return a + b;
        } else {
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
    }

    /**
     * [cite_start]This method obtains a random int between 1 and 10. [cite: 353]
     * [cite_start]It has package-private visibility so it can be spied on by the test class. [cite: 356]
     * @return A random integer between 1 and 10.
     */
    int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    /**
     * [cite_start]Squares the value of a random number obtained from getRandomInt(). [cite: 353]
     * [cite_start]@return The squared random number. [cite: 364]
     */
    public int randomNumberSquared() {
        return getRandomInt() * getRandomInt();
    }
}