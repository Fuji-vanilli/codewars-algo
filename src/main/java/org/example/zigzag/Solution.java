package org.example.zigzag;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Solution {

    public String convert(String s, int numRows) {
        int len= s.length();

        if (len== 1 || len<= numRows)
            return s;

        List<StringBuilder> row= new ArrayList<>();
        IntStream.range(0, numRows).forEach(i-> row.add(new StringBuilder()));

        boolean goingDown= false;
        int currentRow= 0;

        for(char c: s.toCharArray()) {
            row.get(currentRow).append(c);
            if (currentRow== 0 || currentRow== numRows-1)
                goingDown= !goingDown;

            currentRow+= goingDown? 1: -1;
        }
        StringBuilder result= new StringBuilder();
        row.forEach(result::append);

        return result.toString();
    }
}
