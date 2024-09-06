package org.example.threadPratique;

import lombok.Getter;

@Getter
public class Reserve extends Thread{
    private int capital;

    public Reserve(int cap) {
        this.capital= cap;
    }

    public synchronized void add(int amount) {
        this.capital+= amount;
        System.out.println("we add the amount: "+amount+" --- Stock value: "+this.capital);
        notifyAll();
    }

    public synchronized void fetch(int amount) throws InterruptedException {
        if (this.capital>= amount) {
            this.capital-= amount;
            System.out.println("we fetch the value: "+amount+" --- Rest in the stock: "+this.capital);
        } else {
            System.out.println("sorry! stock not enough...Wait!!!");
            wait();
        }
    }
}
