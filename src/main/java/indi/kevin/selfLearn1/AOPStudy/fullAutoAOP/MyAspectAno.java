package indi.kevin.selfLearn1.AOPStudy.fullAutoAOP;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspectAno implements MethodInterceptor {

    @Pointcut("execution(* indi.kevin.selfLearn1.AOPStudy.fullAutoAOP.UserServiceAno.*(..))")
    private void myPointCut(){}

    @Before(value = "myPointCut()")
    public void myBefore(JoinPoint joinPoint){
        System.out.println("Before advice: before service!" + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "myPointCut()", returning = "returnVal")
    public void myAfterReturning(JoinPoint joinPoint, Object returnVal){
        System.out.println("After advice: after service!" + joinPoint.getSignature().getName() + "  returnVal: "+ returnVal);
    }

    @Around(value = "myPointCut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        //must execute method target
        Object object = null;
        System.out.println("Around advice: before");
        if(proceedingJoinPoint.getSignature().getName().equals("updateUser")) {
            object = proceedingJoinPoint.proceed();
        }
        System.out.println("Around advice: after");
        return object;
    }

    @AfterThrowing(value = "myPointCut()", throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e){
        System.out.println("AfterrThrowing advice: throw execption " + e.getMessage());
    }

    @After(value = "myPointCut()")
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
