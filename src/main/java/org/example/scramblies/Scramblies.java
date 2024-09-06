package org.example.scramblies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Scramblies {

    public static boolean scramble(String str1, String str2) {

        List<Character> chars= new ArrayList<>();

        for(Character c: str2.toCharArray()){
            chars.add(c);
        }

        return chars.size()== 0;
    }
}
