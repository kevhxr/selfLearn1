package indi.kevin.selfLearn1.Algorithm.divergeAlo;

public class HannoTower {
    public static void main(String[] args) {
        moveTower(5,'A','B','C');
    }

    public static void moveTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("move 1 plate from " + a + "->" + c);
        } else {
            moveTower(num - 1, a, c, b);
            System.out.println("move " + num + " plate from " + a + "->" + c);
            moveTower(num - 1, b, a, c);
        }

    }
}
