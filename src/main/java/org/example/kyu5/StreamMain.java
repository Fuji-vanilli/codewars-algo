package org.example.kyu5;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StreamMain {
    public static void main(String[] args) throws IOException {
        final Path path= Paths.get("D:\\codes.txt");
        List<String> codes= Files.readAllLines(path);

        Stream<String> streamStrings= Files.lines(path);
        String line= codes.get(1);

        Pattern pattern= Pattern.compile(" ");
        //Stream<String> streamSplit= pattern.splitAsStream(line);

        Function<String, Stream<String>> functionSplit= pattern::splitAsStream;
        Stream<String> streamSplit= functionSplit.apply(line);

        Stream<String> flatMapStream= Files.lines(path)
               .flatMap(functionSplit);

        //flatMapStream.forEach(System.out::println);

        int max= flatMapStream
                .mapToInt(String::length)
                        .max()
                                .orElseThrow();

       /* Stream<Character> letters= line.chars().mapToObj(letter-> (char) letter);
        letters.forEach(System.out::println);
        */
        Function<String, Stream<Character>> functionLetter= word-> word.chars().mapToObj(letter-> (char) letter);
        Stream<Character> letters= functionLetter.apply(line);
        letters.forEach(System.out::print);
    }
}
