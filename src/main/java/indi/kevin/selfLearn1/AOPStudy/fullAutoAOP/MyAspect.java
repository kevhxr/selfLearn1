package indi.kevin.selfLearn1.AOPStudy.fullAutoAOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect implements MethodInterceptor {

    public void myBefore(JoinPoint joinPoint){
        System.out.println("Before advice: before service!" + joinPoint.getSignature().getName());
    }

    public void myAfterReturning(JoinPoint joinPoint, Object returnVal){
        System.out.println("After advice: after service!" + joinPoint.getSignature().getName() + "  returnVal: "+ returnVal);
    }

    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //must execute method target
        System.out.println("Around advice: before");
        Object object = proceedingJoinPoint.proceed();
        System.out.println("Around advice: after");
        return object;
    }

    public void myAfterThrowing(JoinPoint joinPoint, Throwable e){
        System.out.println("AfterrThrowing advice: throw execption " + e.getMessage());
    }

    public void myAfter(JoinPoint joinPoint){
        System.out.println("AfterReturning advice: finally after " + joinPoint.getSignature().getName());
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {

        System.out.println("========before service!========");

        Object obj = mi.proceed();

        System.out.println("========after service!========");

        return obj;
    }
}
