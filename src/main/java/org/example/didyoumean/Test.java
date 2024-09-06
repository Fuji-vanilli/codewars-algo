package org.example.didyoumean;

public class Test {
    public static void main(String[] args) {
        Dictionary dictionary= new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});

        System.out.println(dictionary.findMostSimilar("pineapple"));
    }
}
