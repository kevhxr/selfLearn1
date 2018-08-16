package indi.kevin.selfLearn1.AOPStudy.halfAutoProxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAspect implements MethodInterceptor {
    /*
    public void before(){
        System.out.println("before service!");
    }

    public void after(){
        System.out.println("after service!");
    }*/

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {

        System.out.println("========before service!========");

        Object obj = mi.proceed();

        System.out.println("========after service!========");

        return obj;
    }
}
