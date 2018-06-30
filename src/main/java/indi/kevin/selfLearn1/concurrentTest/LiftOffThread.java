package indi.kevin.selfLearn1.concurrentTest;

import org.apache.log4j.Logger;

public class LiftOffThread implements Runnable{
    protected int countDownNum = 10;

    final static Logger logger = Logger.getLogger(LiftOffThread.class);

    public LiftOffThread(){ }

    public LiftOffThread(int countDownNum){
        this.countDownNum = countDownNum;
    }

    public void displayCount(){

        logger.info("count down : "+ countDownNum +" seconds left");
    }

    @Override
    public void run() {
        while(countDownNum-->0){
            displayCount();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Lift Off!");
    }
}