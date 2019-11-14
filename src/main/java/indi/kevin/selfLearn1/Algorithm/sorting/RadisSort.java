package indi.kevin.selfLearn1.Algorithm.sorting;

import java.util.Arrays;

public class RadisSort {

    public static void main(String[] args) {
        int arr[] = {53, 3, 542, 748, 14, 214};
        radisSort(arr);
    }

    public static void radisSort(int[] arr) {
        //use space to buy time
        int[][] bucket = new int[10][arr.length];

        int[] bucketEleCounts = new int[10];

        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        int maxLength = (max + "").length();
        System.out.println(maxLength);
        for (int i = 0; i < maxLength; i++) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfEle = arr[j] / (10 ^ i) % 10;
                bucket[digitOfEle][bucketEleCounts[digitOfEle]] = arr[j];
                bucketEleCounts[digitOfEle]++;
            }
            int index = 0;
            for (int k = 0; k < bucketEleCounts.length; k++) {
                if (bucketEleCounts[k] != 0) {
                    for (int l = 0; l < bucketEleCounts[k]; l++) {
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketEleCounts[k] = 0;
            }
            System.out.println();
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        }
    }

}
