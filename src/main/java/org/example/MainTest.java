package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class MainTest {
    public static void main(String[] args) {
        System.out.println(reverse(-5680));
    }
    public static int reverse(int x) {
        boolean isNegate= x< 0;
        StringBuilder builder= new StringBuilder(String.valueOf(Math.abs(x)));

        try {
            long reversed= Long.parseLong(builder.reverse().toString());
            if (reversed< Integer.MIN_VALUE || reversed> Integer.MAX_VALUE) {
                return 0;
            }
            int result= (int) reversed;

            return isNegate? -result: result;
        } catch (NumberFormatException e) {
            return 0;
        }

    }

    public static int myAtoi(String s) {
        int whiteSpace= 0;
        while (whiteSpace< s.length() && s.charAt(whiteSpace)== ' ') {
            whiteSpace++;
        }

        int sign= 1;
        if (s.charAt(whiteSpace)== '-' || s.charAt(whiteSpace)== '+') {
            if (s.charAt(whiteSpace)== '-')
                whiteSpace++;
            whiteSpace++;
        }

        int num= 0;
        while (s.length()> whiteSpace && Character.isDigit(s.charAt(whiteSpace))) {
            int digit= Character.getNumericValue(s.charAt(whiteSpace));

            if (num> Integer.MAX_VALUE/ 10 || (num== Integer.MAX_VALUE/ 10) && digit> 7) {
                return sign== 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
            }

            num= num* 10+ digit;
            whiteSpace++;
        }

        return sign* num;
    }
}
