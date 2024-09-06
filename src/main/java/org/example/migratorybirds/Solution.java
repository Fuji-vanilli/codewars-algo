package org.example.migratorybirds;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public int migratoryBirds(List<Integer> arr) {
        // Write your code here
        Map<Integer, Long> collect = arr.stream()
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));

        Map.Entry<Long, List<Integer>> longListEntry = collect.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(
                                Map.Entry::getKey,
                                Collectors.toList()
                        )
                ))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByKey())
                .orElse(null);

        return longListEntry.getValue().stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow();
    }
}
