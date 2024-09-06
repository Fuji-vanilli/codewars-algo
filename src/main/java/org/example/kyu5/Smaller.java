package org.example.kyu5;

import java.util.*;
import java.util.stream.IntStream;

public class Smaller {
    public static int[] smaller(int[] unsorted) {
        int len = unsorted.length;
        int[] result = new int[len];

        List<Integer> list= new ArrayList<>();
        for (int element : unsorted) {
            list.add(element);
        }
        Collections.sort(list);

        for (int i = 0; i < len; i++) {
            int num = unsorted[i];
            int smallerCount = Collections.binarySearch(list, num);

            result[i] = smallerCount;
            list.remove(Integer.valueOf(num));
        }

        return result;
    }
}
