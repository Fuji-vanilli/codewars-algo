package org.example.thread;

import java.util.Scanner;

public class ReserveMain {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Reserve reserve= new Reserve();

        Runnable ajout= new ThreadAjout(reserve, 10, 1000);
        Runnable ajout2= new ThreadAjout(reserve, 50, 1000);
        Runnable puise= new ThreadPuise(reserve, 300, 1000);

        Thread t1= new Thread(ajout);
        Thread t2= new Thread(ajout2);
        Thread t3= new Thread(puise);

        System.out.println("--- Suivi de stock, faire entrer pour arrêter ---");

        t1.start();
        t2.start();
        t3.start();

        scanner.nextLine();
        t1.interrupt();
        t2.interrupt();
        t3.interrupt();

    }
}
