package org.example.algoLuhn;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Luhn luhn= new Luhn("4606422036338560");

        System.out.println(luhn.isValid());
    }
}
