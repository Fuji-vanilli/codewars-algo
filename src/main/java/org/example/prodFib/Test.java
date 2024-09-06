package org.example.prodFib;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Arrays.stream(ProdFib.productFib(715))
                .forEach(System.out::println);
    }
}
