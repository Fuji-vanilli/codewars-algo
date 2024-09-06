package org.example.migratorybirds;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList<>();
        list.add(9);
        list.add(5);
        list.add(8);

        Collections.sort(list);

        list.forEach(System.out::println);

        list.add(3);
        System.out.println("--------");

        Collections.sort(list);

        list.forEach(System.out::println);
    }

    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here

        int socksCount= 0;
        Stack<Integer> stack= new Stack<>();
        ar.forEach(stack::push);

        while (!stack.isEmpty()) {
            int temp= stack.pop();
            ar.remove(0);
            if (ar.contains(temp)) {
                int index= ar.indexOf(temp);
                socksCount++;
                ar.remove(index);
            }
        }

        return socksCount;
    }
}
