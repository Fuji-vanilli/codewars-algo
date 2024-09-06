package org.example.test1;

import java.util.Scanner;
import java.util.stream.Stream;

public class Solution {
    private static Scanner scanner= new Scanner(System.in);

    public int closest(int n) {
        int result= scanner.nextInt();
        for (int i= 1; i< n; i++) {
            int r= scanner.nextInt();
            if (Math.abs(r)< Math.abs(result))
                result= r;
        }
        return result;
    }
}
