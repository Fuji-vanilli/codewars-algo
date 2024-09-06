package org.example.noZeroForHero;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println(NoBoring.noBoringZeros(960000));

        StringBuilder builder= new StringBuilder("960000");
        System.out.println(Character.getNumericValue(builder.charAt(1))==  0);

        /*
        IntStream.range(0, num.length)
                .mapToObj(i-> num[i])
                .forEach(System.out::println);

         */
    }
}
