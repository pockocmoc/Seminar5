package com.pockocmoc;

public class DiningPhilosophers {
    private static final int NUM_PHILOSOPHERS = 5;
    static final int NUM_EATING_ITERATIONS = 3;

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[NUM_PHILOSOPHERS];
        Object[] forks = new Object[NUM_PHILOSOPHERS];


        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            forks[i] = new Object();
        }


        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % NUM_PHILOSOPHERS];

            philosophers[i] = new Philosopher(i, leftFork, rightFork);
        }

        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }
}