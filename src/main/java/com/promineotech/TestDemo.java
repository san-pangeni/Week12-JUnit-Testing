package com.promineotech;

import java.util.Random;

public class TestDemo {

    // Adds two positive integers
    public int addPositive(int a, int b) {
        if (a > 0 && b > 0) {
            return a + b;
        } else {
            throw new IllegalArgumentException("Both parameters must be positive!");
        }
    }

    // Returns a random integer between 1 and 10
    int getRandomInt() {
        Random random = new Random();
        return random.nextInt(10) + 1;
    }

    // Returns the square of a random number
    public int randomNumberSquared() {
        int num = getRandomInt();
        return num * num;
    }
}