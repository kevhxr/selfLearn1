package indi.kevin.selfLearn1.Algorithm;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] w = {1, 4, 3};
        int[] val = {1500, 3000, 2000};
        int m = 4;
        int n = val.length;

        //v[i][j] represents the largest value that
        // the first i item can hold with volume j
        int[][] v = new int[n + 1][m + 1];

        int[][] path = new int[n + 1][m + 1];

        for (int i = 0; i < v.length; i++) {
            v[i][0] = 0;
        }
        for (int i = 0; i < v[0].length; i++) {
            v[0][i] = 0;
        }


        for (int i = 1; i < v.length; i++) {
            for (int j = 1; j < v[0].length; j++) {
                if (w[i - 1] > j) {
                    v[i][j] = v[i - 1][j];
                } else {
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    if (v[i - 1][j] > val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = v[i - 1][j];
                    } else {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[i].length; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }

/*        for (int i = 0; i <path.length ; i++) {
            for (int j = 0; j <path[i].length ; j++) {
                if(path[i][j] == 1){
                    System.out.println(i+" been put to bag");
                }
            }
        }*/
        int i = path.length - 1;
        int j = path[0].length - 1;
        //iterate from last to first
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println(i + " been put to bag");
                j -= w[i - 1];
            }
            i--;
        }


    }
}
