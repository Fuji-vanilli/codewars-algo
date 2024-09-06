package org.example.thread;

import java.util.Scanner;

public class CalcMain {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Nombre nombre= new Nombre();

        ThreadCalc calc= new ThreadCalc(nombre);
        ThreadAff aff= new ThreadAff(nombre);

        Thread t1= new Thread(calc);
        Thread t2= new Thread(aff);

        t1.start();
        t2.start();

        scanner.nextLine();
        t1.interrupt();

        System.out.println("\nthread 1 interrupted");

        scanner.nextLine();
        t2.interrupt();
        System.out.println("\nthread 2 interrupted");
    }
}
