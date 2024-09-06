package org.example.noZeroForHero;

public class NoBoring {
    public static int noBoringZeros(int n) {
        StringBuilder builder= new StringBuilder(String.valueOf(n));

        for(int j= builder.length()-1; j>= 0; j--){
            if(Character.getNumericValue(builder.charAt(j))== (char) 0)
                builder.deleteCharAt(j);
            else
                break;

        }
        return Integer.parseInt(builder.toString());
    }
}
