package org.example.multithreadExample;

public class NumberPrinter implements Runnable {
    private int number;

    public NumberPrinter(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        System.out.println("We are using "+ Thread.currentThread().getName()  + "to print this Number:: ==>" + number);

    }
}
