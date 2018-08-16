package indi.kevin.selfLearn1.concurrentTest.TestQuestions;

public class multiplrth {

    public static void main(String[] args){
        int max = 10000;
        NumCount numCount = new NumCount(new Counter(0,max));
        for (int i=0;i<max;i++){
            Thread thread = new Thread(() -> numCount.addNum());
            thread.start();
        }
    }


}


class NumCount{
    public Counter counter;

    public NumCount(Counter counter){
        this.counter = counter;
    }

    public void addNum (){
        synchronized (counter) {
            counter.addCount();
            this.printNum();
        }

    }

    public void printNum(){
        counter.printCount();
    }

}

class Counter{
    public int num ;
    public int max ;
    public Counter(int num, int max){
        this.num = num;
        this.max = max;
    }

    public void printCount(){
        if(num<max-3){
            return;
        }
        System.out.println(num);
    }

    public void addCount(){
        num ++;
    }

}