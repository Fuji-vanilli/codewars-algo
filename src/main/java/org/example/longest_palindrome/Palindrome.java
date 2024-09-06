package org.example.longest_palindrome;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Palindrome {
    public int longestPalindrome(final String s){
        List<String> elements= Arrays.asList(s.split("[,\\s]+"));

        List<Integer> longest= elements.stream()
                .map(this::inPalindrome).toList();

        return longest.stream()
                .max(Integer::compare)
                .orElse(0);
    }
    public boolean isPalindrome(String s){
        int begin= 0;
        int end= s.length()- 1;

        while(end> begin){
            if(s.charAt(begin)!= s.charAt(end))
                return false;
            begin++;
            end--;
        }
        return true;
    }
    public int inPalindrome(String s){
        int max= 0;

        for(int i= 0; i< s.length(); i++)
            for(int j= i+1; j<= s.length(); j++){
                String subString= s.substring(i, j);
                if(isPalindrome(subString) && max< subString.length()){
                    max= subString.length();
                }
            }
        return max;
    }
}
