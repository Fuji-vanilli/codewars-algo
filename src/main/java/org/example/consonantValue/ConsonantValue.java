package org.example.consonantValue;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Given a lowercase string that has alphabetic characters only
 * and no spaces, return the highest value of consonant substrings.
 * Consonants are any letters of the alphabet except "aeiou".
 * We shall assign the following values: a = 1, b = 2, c = 3, .... z = 26.
 */
public class ConsonantValue {
    private static int[] alphabetValue= new int[26];
    static {
        for(int i= 0; i< 26; i++){
            alphabetValue[i]= i+1;
        }
    }
    public static int solve(final String s) {
        Pattern pattern= Pattern.compile("[bcdfghjklmnpqrstvwxyz]+");
        Matcher matcher= pattern.matcher(s.toLowerCase());
        StringBuilder builder= new StringBuilder();

        while(matcher.find())
            builder.append(matcher.group()).append(" ");

        return Arrays.stream(builder.toString().trim().split(" "))
                .map(w-> {
                    int size= 0;
                    for(char c: w.toCharArray())
                        size+= alphabetValue[c-'a'];
                    return size;
                })
                .max(Integer::compare)
                .orElse(0);
    }
}