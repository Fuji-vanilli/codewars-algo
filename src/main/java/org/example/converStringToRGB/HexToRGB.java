package org.example.converStringToRGB;
/**
 * When working with color values it can sometimes be useful to extract the individual red, green, and blue (RGB)
 * component values for a color. Implement a function that meets these requirements:
 * Accepts a case-insensitive hexadecimal color string as its parameter (ex. "#FF9933" or "#ff9933")
 * Returns a Map<String, int> with the structure {r: 255, g: 153, b: 51} where r, g, and b range from 0 through 255
 * Note: your implementation does not need to support the shorthand form of hexadecimal notation (ie "#FFF")
 * Example
 * "#FF9933" --> {r: 255, g: 153, b: 51}
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class HexToRGB {

    public static int[] hexStringToRGB(String hex) {
       return IntStream.range(0, 3)
               .map(i-> Integer.parseInt(hex.substring(i*2+1, i*2+3),16))
               .toArray();
    }
    public static int convertToDec(String hex){
        Map<Character, Integer> value= Map.of('A',10, 'B', 11, 'C', 12, 'D', 13, 'E', 14, 'F', 15);
        List<Integer> hexa= new ArrayList<>();
        int poid= hex.length()-1;

        for(char c: hex.toCharArray()){
            if(!Character.isDigit(c)){
                hexa.add((int) (value.get(Character.toUpperCase(c))*Math.pow(16, poid--)));
            }
            else{
                hexa.add((int) (Integer.parseInt(String.valueOf(c))*Math.pow(16, poid--)));
            }
        }

        return hexa.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }
    private int toDecimale(String hex){
        return Integer.parseInt(hex, 16);
    }

}