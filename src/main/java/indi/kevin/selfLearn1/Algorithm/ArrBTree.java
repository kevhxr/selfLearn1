package indi.kevin.selfLearn1.Algorithm;

public class ArrBTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);
    }
}


class ArrBinaryTree {
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {
            System.out.println("arr is empty cant do");
        }
        System.out.println(arr[index]);
        if ((2 * index + 1) < arr.length) {

            preOrder(2 * index + 1);
        }
        if ((2 * index + 2) < arr.length) {

            preOrder(2 * index + 2);
        }
    }
}