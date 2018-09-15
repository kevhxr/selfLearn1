package indi.kevin.selfLearn1.common.Reflect;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Properties;

public class Loaders {

    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        /*ClassLoader c = Loaders.class.getClassLoader();
        while(c!=null){
            System.out.println(c.getClass().getName());
            c = c.getParent();
        }*/
        Properties prop = new Properties();
        String className = null,propKey;
        BufferedReader bR = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/WEB-INF/className.properties")));
        prop.load(bR);
        Iterator<String> iterator = prop.stringPropertyNames().iterator();
        while(iterator.hasNext()){
            propKey = iterator.next();
            className = prop.get(propKey).toString();
            System.out.println(className);
        }
        Class c = Class.forName(className);
        Object o = c.newInstance();
        Method[] methods = c.getMethods();
        for(Method m : methods){
            System.out.println(m.getName());
            if(m.getName().equals("getName")){
                m.invoke(o,"kevin");
            }
        }

/*        String readLine;
        while((readLine = bR.readLine())!=null){
            System.out.println(readLine);
        }*/
    }
}

class T{
    public T(){

    }
    public String getName(String name){
        System.out.println("hello"+name);
        return "hello"+name;
    }
}
