package org.example.maxNumberVowels;


import java.util.function.Predicate;
import java.util.stream.IntStream;

public class Solution {
    public static String VOWEL= "aeiou";
    public int maxVowels(String s, int k) {
        int max= 0;
        int numberSubstring= (int) Math.ceil((double) s.length()/k);
        return IntStream.range(0, numberSubstring)
                .map(index -> numberVowel(s.substring(index*k, Math.min((index + 1) * k, s.length()))))
                .max()
                .orElse(-1);
    }
    public int numberVowel(String s) {
        return (int) IntStream.range(0, s.length())
                .mapToObj(i-> s.toCharArray()[i])
                .filter(predicateNumber())
                .count();
    }
    private Predicate<Character> predicateNumber() {
        return p-> VOWEL.contains(String.valueOf(p));
    }
}
