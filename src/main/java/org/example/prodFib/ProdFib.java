package org.example.prodFib;

public class ProdFib {
    public static long[] productFib(long prod) {
        long x= 0L;
        long y= 1L;

        while (x*y< prod){
            long temp= x;
            x= y;
            y+= temp;
        }
        return new long[]{x, y, x*y== prod? 1: 0};
    }
}
