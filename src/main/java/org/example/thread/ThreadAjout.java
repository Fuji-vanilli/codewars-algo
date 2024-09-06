package org.example.thread;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class ThreadAjout implements Runnable{
    private int value;
    private long delay;
    private Reserve reserve;

    public ThreadAjout(Reserve reserve, int value, long delay){
        this.reserve= reserve;
        this.value= value;
        this.delay= delay;
    }

    @Override
    public void run() {
        try {
            while (!interrupted()){
                reserve.ajout(this.value);
                sleep(delay);
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
