package indi.kevin.selfLearn1.AOPStudy.halfAutoProxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Object targetObject;

    public Object createProxyObject(Object obj){

        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        Object proxyObj = enhancer.create();

        return proxyObj;
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable{
        Object object = null;
        if("addUser".equals(method.getName())){
            System.out.println("doing add user check");
        }
        object = method.invoke(targetObject, args);
        return  object;
    }


}
