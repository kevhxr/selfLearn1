package indi.kevin.selfLearn1.Algorithm.sorting;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int arr[] = {4, 6, 8, 5, 9};
        heapSort(arr);
    }

    /**
     * nlog(n)
     * @param arr
     */
    public static void heapSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length/2-1; i >=0 ; i--) {
            adjustHeap(arr,i,arr.length);
            System.out.println();
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        }
        System.out.println();
        System.out.println("=============================");
        for (int j = arr.length-1; j >0 ; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            System.out.println();
            System.out.println("before:"+j);
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
            adjustHeap(arr,0,j);
            System.out.println("after:");
            Arrays.stream(arr).forEach(a -> System.out.print(a + " "));
        }
        System.out.println();
        System.out.println();
        System.out.println("finish==============");
        Arrays.stream(arr).forEach(a -> System.out.print(a + " "));

    }

    /**
     * int arr[] = {4,6,8,5,9}
     * i = 1 => {4,9,8,5,6}
     * i = 0 => {9,6,8,5,4}
     *
     * @param arr array wait for adjust
     * @param i   non leaf node index in the array
     * @param len how many node need to be adjusted, len
     *            been decreasing
     */
    public static void adjustHeap(int arr[], int i, int len) {
        int temp = arr[i];
        //k is i's left child node
        for (int k = i * 2 + 1; k < len; k = k * 2 + 1) {
            if (k + 1 < len && arr[k] < arr[k + 1]) { //left child < right child
                k++;
            }
            if (arr[k] > temp) {
                //if child larger then parent node
                //put larger value to temp
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //here we have already put the max value to the
        //top of the tree which has i as parent child
        arr[i] = temp;
    }
}
