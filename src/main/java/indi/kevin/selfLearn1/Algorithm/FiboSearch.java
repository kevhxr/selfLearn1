package indi.kevin.selfLearn1.Algorithm;

import java.util.Arrays;

public class FiboSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        System.out.println(fibSearch(arr,1234));
    }

    //mid = low+F(k-1)-1
    public static int[] fibCreate() {
        int[] fibArr = new int[maxSize];
        fibArr[0] = 1;
        fibArr[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            fibArr[i] = fibArr[i - 1] + fibArr[i - 2];
        }
        return fibArr;
    }

    /**
     * @param a
     * @param key the key we need to search
     * @return the index of the key, -1 if not
     */
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0; //fib cut point
        int mid = 0;
        int fib[] = fibCreate();
        while (high > fib[k] - 1) {
            k++;
        }
        //f[k] might be > a length,
        // so we need to create a new Array and point to a
        int[] temp = Arrays.copyOf(a, fib[k]);
        //{1, 8, 10, 89, 1000, 1234, 0, 0}
        //-> {1, 8, 10, 89, 1000, 1234, 1234, 1234}
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }
        while (low <= high) {
            mid = low + fib[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                /**
                 * 1. all element = pre ele + pos ele
                 * f[k] = f[k-1] + f[k-2]
                 * 2. since pre has f[k-1] ele, so can keep diverge to
                 * f[k-1] = f[k-2] + f[k-3]
                 * 3. so keep search in front of f[k-1], so k--
                 * 4. so next mid = f[k-1-1]-1
                 */
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                /**
                 * 3. since we have f[k-2] after, so can keep diverge to
                 * f[k-1] = f[k-3] + f[k-4]
                 * 4. so next mid = f[k-1-2]-1
                 */
                k -= 2;
            } else {
                if(mid <=high){
                    return mid;
                }else{
                    return high;
                }
            }
        }
        return -1;
    }
}
