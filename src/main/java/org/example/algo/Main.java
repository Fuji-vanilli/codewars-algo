package org.example.algo;

public class Main {
    public static void main(String[] args) {
        Theoreme theoreme= new Theoreme();
        long begin= System.currentTimeMillis();
        long n= theoreme.fibDP(50);
        long end= System.currentTimeMillis();

        int x= 2;
        while (x> 1) {
            if (x== 10)
                x= 0;
            x++;
        }

        System.out.println(x);
    }
}
