package indi.kevin.selfLearn1.concurrentTest.TestQuestions;

import java.util.LinkedList;
import java.util.Random;

public class WaitNotifyTest {

    public static void main(String[] args) {
        int totalTerms = 10;
        String[] carList = {"BMW","BENZ","GreatWall","RedFlag","Honda","Toyota","WW","Ford","Cadillac","VOLVO"};
        CarStorage carStorage = new CarStorage(new LinkedList<>(),20);
        Thread stockThread = new Thread(() -> {
            int startTerm = 0;
            while(startTerm < totalTerms+10){
                carStorage.stock(carList[new Random().nextInt(carList.length-1)]);
                startTerm ++;
            }
        });
        Thread client1Thread = clientBuy(totalTerms, carStorage);
        client1Thread.setName("Buyer Tomas");
        Thread client2Thread =clientBuy(totalTerms, carStorage);
        client2Thread.setName("Buyer Kevin");
        Thread client3Thread =clientBuy(totalTerms, carStorage);
        client3Thread.setName("Buyer Reason");

        stockThread.start();
        client1Thread.start();
        client2Thread.start();
        client3Thread.start();
    }

    private static Thread clientBuy(int totalTerms, CarStorage carStorage) {
        return new Thread(() -> {
            int startTerm = 0;
            while(startTerm < totalTerms-5){
                carStorage.sell();
                startTerm ++;
            }
        });
    }
}

class CarStorage{
    LinkedList<String> storage;
    int storeSize;

    public CarStorage(LinkedList<String> storage, int storeSize){
        this.storage = storage;
        this.storeSize = storeSize;
    }

    public void stock(String carName){
        synchronized (storage) {
            while (storeSize <= storage.size()) {
                try {
                    System.out.println("Sell Thread :No storage position left for sell right now! pls hold up");
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            storage.add(carName);
            System.out.println("Sell Thread :Current amount of car is: "
                    + storage.size() +
                    "; new incoming for storage:"
                    + carName);
            storage.notifyAll();
        }
    }

    public void sell(){
        synchronized (storage) {
            while (storage.size() <= 0) {
                try {
                    System.out.println(
                    Thread.currentThread().getName()
                    + " :No car left for sell right now! pls wait thanks");
                    storage.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String carName = storage.remove(0);
            System.out.println(
                    Thread.currentThread().getName()
                    + " :Current amount of car is: "
                    + storage.size() +
                    "; client just bought the car:"
                    + carName);
            storage.notifyAll();
        }
    }
}
