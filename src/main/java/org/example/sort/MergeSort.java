package org.example.sort;

import java.util.Arrays;

public class MergeSort {

    public static void mergeSort(int[] numbers){
        int len= numbers.length;
        int midleIndex= numbers.length/2;

        if(len< 2){
            return;
        }

        int[] leftArray= new int[midleIndex];
        int[] rightArray= new int[len-midleIndex];

        System.arraycopy(numbers, 0, leftArray, 0, midleIndex);
        System.arraycopy(numbers, midleIndex, rightArray, 0, len-midleIndex);

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(numbers, leftArray, rightArray);

    }

    private static void merge(int[] numbers, int[] leftArray, int[] rightArray) {
        int i= 0, j= 0, k= 0;

        while(i< leftArray.length && j< rightArray.length){
            if(leftArray[i]<= rightArray[j]){
                numbers[k]= leftArray[i];
                i++;
            } else if(rightArray[j]< leftArray[i]){
                numbers[k]= rightArray[j];
                j++;
            }
            k++;
        }
        while (i< leftArray.length){
            numbers[k]= leftArray[i];
            i++;
            k++;
        }
        while (j< rightArray.length){
            numbers[k]= rightArray[j];
            j++;
            k++;
        }
    }
}
