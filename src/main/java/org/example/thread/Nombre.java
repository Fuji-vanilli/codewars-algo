package org.example.thread;

public class Nombre {
    private int n= 0;
    private int carre= 1;
    private boolean pret= false;

    public synchronized void calcul(){
        try {
            if(!pret){
                this.n++;
                carre= n*n;
                pret= true;
                notifyAll();
            } else {
                wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public synchronized void affichage(){
        try {
            if(pret){
                System.out.println(n+" a pour carre: "+carre);
                notifyAll();
                pret= false;
            } else {
                wait();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
