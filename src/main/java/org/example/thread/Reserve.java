package org.example.thread;

public class Reserve extends Thread{
    private int stock= 500;

    public synchronized void puise(int value){
        if(value< this.stock){
            this.stock-= value;
            System.out.println("----- On puise: "+value+" et il reste: "+this.stock+" dans le stock ----");
        }else {
            try {
                System.out.println("----- stock insuffisant ----");
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public synchronized void ajout(int value){
        this.stock+= value;
        System.out.println("On vient d'ajouter: "+value+" dans le stock ---- Stock: "+this.stock);
        notifyAll();
    }

    @Override
    public void run() {

    }
}
