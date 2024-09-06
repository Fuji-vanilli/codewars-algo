package org.example.EncryptThis;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Kata {

    public static String encryptThisWithStream(String text){

        return Arrays.stream(text.split(" "))
                .map(w-> w.length()> 2 ? (int) w.charAt(0)+w.substring(w.length()-1)+w.substring(2, w.length()-1)+w.substring(1,2) :
                        w.length()> 1 ? (int) w.charAt(0)+w.substring(1) :
                                w.length()== 1 ? (int) w.charAt(0)+"":"")
                .collect(Collectors.joining(" "));
    }
    public static String encryptThis(String text){
        String[] words= text.split(" ");

        StringBuilder builder= new StringBuilder();

        for(String word: words){
            builder.append(encrypt(word)).append(" ");
        }
        return builder.toString();
    }

    public static String encrypt(String word) {
        if(word.length()== 1)
            return String.valueOf((int) word.charAt(0));
        else if(word.length()== 2)
            return String.valueOf((int) word.charAt(0))+ word.charAt(1);
        return String.valueOf((int) word.charAt(0)) +
                word.charAt(word.length() - 1) +
                word.substring(2, word.length()-1) +
                word.charAt(1);
    }
}
