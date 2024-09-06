package org.example.threadPratique;

import lombok.AllArgsConstructor;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

@AllArgsConstructor
public class ThreadFetch implements Runnable {
    private long delay;
    private int value;
    private Reserve reserve;

    @Override
    public void run() {
        try {
            while (!interrupted()) {
                this.reserve.fetch(this.value);
                sleep(this.delay);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
