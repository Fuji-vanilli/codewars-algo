package org.example.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.example.sort.MergeSort.mergeSort;

public class Main {
    public static void main(String[] args) {

        int len= 10000000;
        int[] numbers= new int[len];
        Random random= new Random();

        numbers= IntStream.range(0, len)
                .map(i -> random.nextInt(1000))
                .toArray();


        long before= System.currentTimeMillis();
        mergeSort(numbers);
        long after= System.currentTimeMillis();

        System.out.println("\ntemps de tri: "+(after-before)+"ms");
    }
}
