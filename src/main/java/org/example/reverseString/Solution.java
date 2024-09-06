package org.example.reverseString;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.Function;
import java.util.stream.Collectors;

class Solution {
    public String reverseWords(String s) {
        return Arrays.stream(s.split(" "))
                .map(reverseFunction())
                .collect(Collectors.joining(" "));
    }
    public Function<String, String> reverseFunction() {
        return this::reverse;
    }
    public String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    public String reverseWithStack(String s) {
        String result= "";
        Stack<String> stack= new Stack<>();

        Arrays.stream(s.split(" ")).forEach(stack::push);

        while (!stack.isEmpty())
            result= result+" "+stack.pop();

        return result;
    }
}