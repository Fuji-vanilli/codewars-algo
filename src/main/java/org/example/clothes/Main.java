package org.example.clothes;

public class Main {
    public static void main(String[] args) {
        Clothes[] clothes= { new Clothes(12.5, 0.2), new Clothes(20.5, 0.2)};
        double total= 0;

        for(Clothes c: clothes){
            total+= c.price;
        }

        System.out.println(total);
    }
}
