package indi.kevin.selfLearn1.concurrentTest.synchro;

/**
 * openjdk src code > hotspot > jvm
 *
 * eden > survivor from-to (15 times) > tenured
 * 012...15 -> marked in object header 4 bit
 * 0000>0001>0011>...1111 = 15
 * 1000 = 2^4=16 > 15
 *
 * header -> mark word 64b + klass pointer 32b (after 64b pointer express)
 *
 * object status 5:
 * no status (when new)
 * biased lock
 * lightweight lock
 * heavylock
 * gc mark
 *
 *
 * boolean 1 + int 4
 * + (mark word 12 byte)
 * 3 * header 4 = 17
 * + 7 empty = 24 = 8*3
 */
public class Player {
    private boolean isTrue;
    private int age;
    //private int[] scores;


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
