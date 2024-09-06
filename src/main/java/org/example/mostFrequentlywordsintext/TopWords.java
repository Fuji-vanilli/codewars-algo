package org.example.mostFrequentlywordsintext;

import java.util.*;

public class TopWords {

    public static List<String> top3(String s) {
        String[] words= s.split("[^a-zA-Z']+");
        Map<String, Integer> map= new HashMap<>();
        List<String> result= new ArrayList<>();

        for(String word: words){
            map.compute(word, (k, v)-> (v== null) ? 1: v++);
        }
        int index= 0;
        while (index< 3){
            String maxWord= maxKey(map);
            result.add(maxWord);
            map.remove(maxWord);
            index++;
        }

        return result;
    }
    public static String maxKey(Map<String, Integer> map){
        String keyMax = "";
        int max= Integer.MIN_VALUE;

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            if(entry.getValue()> max){
                max= entry.getValue();
                keyMax= entry.getKey();
            }
        }
        return keyMax;
    }
}