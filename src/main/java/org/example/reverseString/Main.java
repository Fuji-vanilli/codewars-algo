package org.example.reverseString;

public class Main {
    public static void main(String[] args) {
        Solution solution= new Solution();
        System.out.println(solution.reverseWithStack("Let's take LeetCode contest"));
        Delimiter delimiter= new Delimiter("{x+5[(x2+3)]}");
        System.out.println(delimiter.isMatching());

        String html= "<body>\n" +
                "<center>\n" +
                "<h1> The Little Boat </h1>\n" +
                "</center>\n" +
                "<p> The storm tossed the little\n" +
                "boat like a cheap sneaker in an\n" +
                "old washing machine. The three\n" +
                "drunken fishermen were used to\n" +
                "such treatment, of course, but\n" +
                "not the tree salesman, who even as\n" +
                "a stowaway now felt that he\n" +
                "had overpaid for the voyage. </p>\n" +
                "<ol>\n" +
                "<li> Will the salesman die? </li>\n" +
                "<li> What color is the boat? </li>\n" +
                "<li> And what about Naomi? </li>\n" +
                "</ol>\n" +
                "</body>";

        System.out.println(delimiter.isHTMLMatched(html));
    }

}
