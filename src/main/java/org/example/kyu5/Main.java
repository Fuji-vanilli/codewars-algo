package org.example.kyu5;

import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        List<String> list= List.of("xender", "bluetooth", "nfc");


        /*int len= 7;
        int[] numbers= new int[len];
        int[] result= new int[len];
        Random random= new Random();

        numbers= IntStream.range(0, len)
                .map(i -> random.nextInt(8))
                .toArray();


        long before= System.currentTimeMillis();
        result= Smaller.smaller(numbers);
        long after= System.currentTimeMillis();


        Arrays.stream(numbers)
                .forEach(number-> System.out.print(number+" - "));

        System.out.println("\n----------------------------------------");

        Arrays.stream(Smaller.smaller(result))
                .forEach(number-> System.out.print(number+" - "));

        System.out.println("\ntemps d'execution: "+(after-before)+"ms");

        List<Integer> lis= new ArrayList<>();
        lis.add(5);
        lis.add(4);
        lis.add(7);
        lis.add(2);
        lis.add(5);
        lis.add(5);

        lis.forEach(System.out::print);
        Collections.sort(lis);
        System.out.println("\n------");
        lis.forEach(System.out::print);

        System.out.println("\n"+Collections.binarySearch(lis, 5));
        lis.remove(2);
        lis.forEach(System.out::print);
        System.out.println("\n"+Collections.binarySearch(lis, 5));*/
    }
}
