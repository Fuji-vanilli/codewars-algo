package org.example.thread;

import java.util.Scanner;

public class ThreadMain {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        Ecrit e1= new Ecrit("bonjour", 1000);
        Ecrit e2= new Ecrit("bonsoir", 1000);
        Ecrit e3= new Ecrit("Au revoir", 1000);

        Thread t1= new Thread(e1);
        Thread t2= new Thread(e2);
        Thread t3= new Thread(e3);

        t1.start();
        t2.start();
        t3.start();

        if(scanner.nextLine().toLowerCase().equals("x")){
            t1.interrupt();
            System.out.println("\n**** Thread t1 interrupted ****");
        }

        if(scanner.nextLine().toLowerCase().equals("q")){
            t2.interrupt();
            t3.interrupt();
            System.out.println("\n**** Thread t1 & t2 interrupted ****");
        }

    }
}
