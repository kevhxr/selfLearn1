package indi.kevin.selfLearn1.Algorithm.sorting;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1};
        selectSort(arr);
    }

    public static void selectSort(int[] arr) {

        for (int j = 0; j <arr.length-1 ; j++) {
            int minIndex = j;
            int min = arr[j];
            for (int i = j+1; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                    minIndex = i;
                }
            }
            if(minIndex!=j) {
                arr[minIndex] = arr[j];
                arr[j] = min;
            }
            Arrays.stream(arr).forEach(a-> System.out.print(a+" "));
            System.out.println();
        }
    }
}
