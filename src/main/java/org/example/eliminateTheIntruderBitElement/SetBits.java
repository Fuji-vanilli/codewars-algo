package org.example.eliminateTheIntruderBitElement;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * You are given a string representing a number in binary.
 * Your task is to delete all the unset bits in this string and
 * return the corresponding number (after keeping only the '1's).

 * In practice, you should implement this function:

 * public long eliminateUnsetBits(String number);
 * Examples
 * eliminateUnsetBits("11010101010101") ->  255 (= 11111111)
 * eliminateUnsetBits("111") ->  7
 * eliminateUnsetBits("1000000") -> 1
 * eliminateUnsetBits("000") -> 0
 */
public class SetBits {
    public static long eliminateUnsetBits(String bit) {

        return bit.replaceAll("0", "").length()== 0 ? 0 : Long.parseLong(bit.replaceAll("0", ""), 2);
    }
    public static  long convertDecimale(String bit){
        long resultat= 0;
        for(int i= bit.length()-1; i>= 0; i--){
            resultat+= (long) Math.pow(2, i);
        }
        return resultat;
    }
    public static String fizbiz(int n){
        return ((n % 3 == 0) && (n % 5 == 0)) ? "fizzbuzz" :
                    (n % 3 == 0) ? "fizz" :
                        (n % 5 == 0) ? "buzz" :
                                "" + n;
    }
    public static String fizbiz2(int n){
        String output= "";
        if(n% 3== 0)
            output+= "fizz";
        if(n% 5== 0)
            output+= "buzz";
        return output.length()> 2 ? output : String.valueOf(n);
    }
}