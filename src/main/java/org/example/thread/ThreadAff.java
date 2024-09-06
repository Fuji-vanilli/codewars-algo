package org.example.thread;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class ThreadAff implements Runnable{
    private Nombre nombre;

    public ThreadAff(Nombre nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            while (!interrupted()){
                nombre.affichage();
                sleep(150);
            }
        } catch (InterruptedException e) {
            return;
        }
    }
}
