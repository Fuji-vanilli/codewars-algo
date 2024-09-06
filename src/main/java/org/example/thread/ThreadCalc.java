package org.example.thread;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class ThreadCalc implements Runnable{
    private Nombre nombre;

    public ThreadCalc(Nombre nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            while (!interrupted()){
                nombre.calcul();
                sleep(100);
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
