package org.example.thread;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class ThreadPuise implements Runnable{
    private int value;
    private long delay;
    private Reserve reserve;

    public ThreadPuise(Reserve reserve, int value, long delay) {
        this.value = value;
        this.delay = delay;
        this.reserve = reserve;
    }

    @Override
    public void run() {
        try {
            while (!interrupted()){
                reserve.puise(value);
                sleep(delay);
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
