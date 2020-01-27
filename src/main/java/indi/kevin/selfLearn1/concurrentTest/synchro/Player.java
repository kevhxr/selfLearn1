package indi.kevin.selfLearn1.concurrentTest.synchro;

/**
 * boolean 1 + int 4
 * + (mark word 12 byte)
 * 3 * header 4 = 17
 * + 7 empty = 24 = 8*3
 */
public class Player {
    private boolean isTrue;
    private int age;

    public boolean isTrue() {
        return isTrue;
    }

    public void setTrue(boolean aTrue) {
        isTrue = aTrue;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
