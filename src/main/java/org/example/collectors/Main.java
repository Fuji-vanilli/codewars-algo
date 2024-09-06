package org.example.collectors;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        User u1= new User("rakoto", 19, "USER");
        User u2= new User("randria", 19, "USER");
        User u3= new User("rabe", 18, "USER");
        User u4= new User("raso", 24, "ADMIN");
        User u5= new User("finoana", 24, "ADMIN");

        final Map<Integer, Long> usersByAge = Stream.of(u1, u2, u3, u4, u5)
                .map(User::getName)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        final Map<Long, List<Integer>> collect = usersByAge.entrySet().stream()
                .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));

        final Map.Entry<Long, List<Integer>> max = collect.entrySet().stream()
                .max(Map.Entry.comparingByKey())
                .orElse(null);

        usersByAge.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        System.out.println(max);




    }
}
