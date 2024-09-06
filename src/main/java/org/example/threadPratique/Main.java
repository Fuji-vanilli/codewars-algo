package org.example.threadPratique;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        Reserve reserve= new Reserve(500);
        Thread addThread= new Thread(new ThreadAdd(1000, 100, reserve));
        Thread fetchThread= new Thread(new ThreadFetch(1000, 150, reserve));
        Thread fetchThread2= new Thread(new ThreadFetch(1000, 100, reserve));

        addThread.start();
        fetchThread.start();
        fetchThread2.start();

        scanner.nextLine();
        addThread.interrupt();
        fetchThread.interrupt();
        fetchThread2.interrupt();

    }
}
