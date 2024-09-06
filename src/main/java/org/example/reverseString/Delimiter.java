package org.example.reverseString;

import lombok.RequiredArgsConstructor;

import java.util.Stack;

@RequiredArgsConstructor
public class Delimiter {

    private final String code;

    public boolean isMatching() {
        String openBracket= "{[(";
        String closedBracket= "}])";

        Stack<Character> stackMatcher= new Stack<>();

        for (char c: code.toCharArray()) {
            if (openBracket.indexOf(c)!= -1) {
                stackMatcher.push(c);
            } else if (closedBracket.indexOf(c)!= -1) {
                if (stackMatcher.isEmpty())
                    return false;
                if (closedBracket.indexOf(c)!= openBracket.indexOf(stackMatcher.pop()))
                    return false;
            }
        }

        return stackMatcher.isEmpty();
    }

    public boolean isHTMLMatched(String html) {
        Stack<String> tagStack= new Stack<>();

        int indexOpening= html.indexOf('<');

        while (indexOpening!= -1) {
            int indexClosed= html.indexOf('>', indexOpening+1);
            if (indexClosed== -1)
                return false;

            String tag= html.substring(indexOpening+1, indexClosed);

            if (!tag.startsWith("/")) {
                tagStack.push(tag);
            } else {
                if (tagStack.isEmpty())
                    return false;
                if (!tag.substring(1).equals(tagStack.pop()))
                    return false;
            }
            indexOpening= html.indexOf('<', indexClosed+1);
        }

        return tagStack.isEmpty();
    }
}
