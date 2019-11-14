package indi.kevin.selfLearn1.Algorithm.sorting;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {101, 15, 34, 119, 223, 1};
        insertSort(arr);
    }

    public static void insertSort(int[] arr) {

        for (int i = 1; i <arr.length ; i++) {

            int insertVal = arr[i];
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex --;
            }
            arr[insertIndex+1] = insertVal;
        }

        Arrays.stream(arr).forEach(a-> System.out.print(a+" "));
    }
}
