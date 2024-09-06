package org.example.scramblies.singlePermutation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    public static List<String> permutations(String input) {
        Set<String> result = new HashSet<>();
        permute(input.toCharArray(), 0, result);
        return new ArrayList<>(result);
    }

    private static void permute(char[] array, int index, Set<String> result) {
        if (index == array.length - 1) {
            result.add(String.valueOf(array));
        } else {
            for (int i = index; i < array.length; i++) {
                swap(array, index, i);
                permute(array, index + 1, result);
                swap(array, index, i);
            }
        }
    }

    private static void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        String input = "aabb";
        List<String> permutations = permutations(input);
        System.out.println(permutations);
    }
}
