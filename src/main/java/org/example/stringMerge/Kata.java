package org.example.stringMerge;

import java.util.Arrays;

public class Kata {
    public static String stringMerge(String s1, String s2, char letter) {

        return s1.substring(0, indexLetter(s1, letter))+ s2.substring(indexLetter(s2, letter), s2.length());
    }
    public static int indexLetter(String s, char letter) {
        int index= 0;
        for(int i= 0; i< s.length(); i++){
            if(s.charAt(i)== letter){
                index= i;
                break;
            }
        }
        return index;
    }
}