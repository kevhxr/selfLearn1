package indi.kevin.selfLearn1.Algorithm.sorting;

import java.util.Arrays;

public class HillSort {
    public static void main(String[] args) {

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        hillSortMove(arr);
        int a=1;
    }


    public static void hillSortSwitch(int[] arr) {
        int temp = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            //gap: 2
            for (int i = gap; i < arr.length; i++) {
                //i: 2
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            System.out.println();
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        }
    }

    public static void hillSortMove(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
            System.out.println();
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        }
    }
}
