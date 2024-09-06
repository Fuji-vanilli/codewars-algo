package org.example.consonantValue;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Map<Character, Integer> alphabets= new HashMap<>();

        System.out.println(ConsonantValue.solve("chruschtschov"));
    }
}
