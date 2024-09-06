package org.example;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("What is the difference between == and .equals() me".length());

    }
    public static void mergeSort(int[] t){
        if(t.length< 2){
            return;
        }
        int len= t.length;
        int[] left= new int[len/2];
        int[] right= new int[len-len/2];

        System.arraycopy(t, 0, left, 0, len / 2);
        System.arraycopy(t, len/2, right, 0, len - len/2);

        mergeSort(left);
        mergeSort(right);

        merge(t, left, right);
    }
    private static void merge(int[] t, int[] left, int[] right){
        int i= 0, j= 0, k= 0;

        while(i< left.length && j<  right.length){
            if(left[i]<= right[j]){
                t[k]= left[i];
                i++;
            }else if(left[i]> right[j]){
                t[k]= t[j];
                j++;
            }
            k++;
        }
        while(i< left.length){
            t[k]= left[i];
            i++;
            k++;
        }
        while(j< right.length){
            t[k]= right[j];
            j++;
            k++;
        }
    }
    public static boolean isPrimary(long n){
        for(int i= 2; i< Math.sqrt(n); i++){
            if(n% i== 0){
                return false;
            }
        }
        return true;
    }
}