package indi.kevin.selfLearn1.concurrentTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ThreadGenerator {

    private Runnable threadForGenerate;

    public ThreadGenerator(Runnable threadForGenerate){
        this.threadForGenerate = threadForGenerate;
    }

    public ThreadGenerator(String targetThreadName){
        threadForGenerate = getRunnableInstance(targetThreadName);
    }

    public void threadTest(){
        if(threadForGenerate!=null){
            Thread t = new Thread(threadForGenerate);
            t.start();
        }
    }

    public static Runnable getRunnableInstance(String targetThreadName){
        Runnable threadForGenerate = null;
        try {
            Class<?> threadClass = Class.forName(targetThreadName);
            if(threadClass!=null){
                Constructor<?> cons = threadClass.getConstructor(int.class);
                threadForGenerate = (Runnable) cons.newInstance(10);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return threadForGenerate;
    }
}
