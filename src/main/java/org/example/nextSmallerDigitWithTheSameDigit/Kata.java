package org.example.nextSmallerDigitWithTheSameDigit;

import java.util.Arrays;

/**
 * Write a function that takes a positive integer and returns the next smaller positive integer containing the same digits.

 * For example:

 * nextSmaller(21) == 12
 * nextSmaller(531) == 513
 * nextSmaller(2071) == 2017
 */
public class Kata
{
    public static long nextSmaller(long n) {
        if(n%10== n)
            return -1;

        int[] number= String.valueOf(n).chars().map(Character::getNumericValue).toArray();
        long resultat= 0;

        for(int i= number.length-1; i> 0; i--){
            if(number[i]< number[i-1]){
                int temp= number[i];
                number[i]= number[i-1];
                number[i-1]= temp;
            }
        }
        for(int i= 0; i< number.length; i++)
            resultat= resultat*10 + number[i];

        return resultat;
    }
}