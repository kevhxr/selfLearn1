package indi.kevin.selfLearn1.AOPStudy.fullAutoAOP;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import java.lang.reflect.Proxy;

//@Service("myPostProcessor")
public class MyPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBefore");
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(final Object o, String s) throws BeansException {
        System.out.println("postProcessAfter");
        return Proxy.newProxyInstance(o.getClass().getClassLoader(),
                o.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println("InvocationHandler-----------: before method call: " +method.getName());
                    Object object = null;
                    if(o.getClass().getName().equals(UserServiceAno.class.getName())
                            && method.getName().equals("updateUser")) {
                        object = method.invoke(o, args);
                    }
                    System.out.println("InvocationHandler-----------: after method call: " +method.getName());
                    return object;
                });
    }
}
