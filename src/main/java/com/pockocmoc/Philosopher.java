package com.pockocmoc;


import static com.pockocmoc.DiningPhilosophers.NUM_EATING_ITERATIONS;

public class Philosopher extends Thread {
    private final int id;
    private final Object leftFork;
    private final Object rightFork;

    public Philosopher(int id, Object leftFork, Object rightFork) {
        this.id = id;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_EATING_ITERATIONS; i++) {
            think();
            eat();
        }
    }

    private void think() {
        System.out.println("Философ " + id + " размышляет");
        try {
            Thread.sleep((long) (Math.random() * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void eat() {
        synchronized (leftFork) {
            System.out.println("Философ " + id + " взял левую вилку");

            synchronized (rightFork) {
                System.out.println("Философ " + id + " взял правую вилку");

                System.out.println("Философ " + id + " ест");
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Философ " + id + " освободил правую вилку");
            }

            System.out.println("Философ " + id + " освободил левую вилку");
        }
    }
}
