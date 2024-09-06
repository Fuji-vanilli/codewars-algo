package org.example.thread;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class Ecrit implements Runnable{
    private String str;
    private long attempt;

    public Ecrit(String str, long attempt) {
        this.str = str;
        this.attempt = attempt;
    }

    @Override
    public void run() {
        try {
            while (true){
                if(interrupted()) return;
                System.out.println(str+" ");
                sleep(attempt);
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
