package org.example.pgcd;


import java.util.List;

public class Solution {
    public static void main(String[] args) {
        System.out.println(multipleGCD(List.of(4, 2)));
    }
    public static int GCD(int a, int b) {
        while (b!= 0) {
            int rest= a% b;
            a= b;
            b= rest;
        }
        return a;
    }
    public static int multipleGCD(List<Integer> list) {
        int gcd= list.get(0);
        for (int i= 1; i< list.size(); i++) {
            gcd= GCD(gcd, list.get(i));
        }
        return gcd;
    }
}
