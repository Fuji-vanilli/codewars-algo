package org.example.matrix;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Solution solution= new Solution();
        int[][] matrix= {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };

        solution.spiralOrder(matrix)
                .forEach(System.out::print);
    }
}
