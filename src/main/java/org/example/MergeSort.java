package org.example;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

public class MergeSort {
    public static final int SIZE_MAX= 10;

    public static void main(String[] args) {
        int[] carte= new int[SIZE_MAX];

        for(int i= 0; i< SIZE_MAX; i++){
            carte[i]= new Random().nextInt(100);
        }

        Arrays.stream(carte)
                .forEach(consumer());

        mergeSort(carte);
        System.out.println("\n************************");
        Arrays.stream(carte)
                .forEach(consumer());
    }
    public static IntConsumer consumer(){
        return tab-> {
            System.out.print(tab+" - ");
        };
    }

    public static void mergeSort(int[] carte){
        int len= carte.length;
        int middle= carte.length/2;

        if(len< 2)
            return;

        int[] left= new int[middle];
        int[] right= new int[len-middle];

        System.arraycopy(carte, 0, left, 0, middle);
        System.arraycopy(carte, middle, right, 0, len-middle);

        mergeSort(left);
        mergeSort(right);

        merge(carte, left, right);
    }
    public static void merge(int[] carte, int[] left, int[] right){
        int i= 0, j= 0, k= 0;

        while(i< left.length && j< right.length){
            if(left[i]< right[j]){
                carte[k]= left[i];
                i++;
                k++;
            }else if(left[i]> right[j]){
                carte[k]= right[j];
                j++;
                k++;
            }
        }
        while(i< left.length){
            carte[k]= left[i];
            k++;
            i++;
        }
        while(j< right.length){
            carte[k]= right[j];
            k++;
            j++;
        }
    }
}
