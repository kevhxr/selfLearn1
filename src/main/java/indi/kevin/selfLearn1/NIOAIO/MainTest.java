package indi.kevin.selfLearn1.NIOAIO;

import indi.kevin.selfLearn1.NIOAIO.ClientSide.BadClient;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MainTest {

    public static void main(String[] args){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,15,TimeUnit.SECONDS, new LinkedBlockingDeque<>());
        executor.execute(new BadClient());
        executor.shutdown();

    }
}
