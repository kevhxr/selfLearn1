package indi.kevin.selfLearn1.JavaBasic;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

/*        ArrayList<String> a = new ArrayList<String>();
        ArrayList b = new ArrayList();
        Class c1 = a.getClass();
        Class c2 = b.getClass();
        System.out.println(c1 == c2);


        ArrayList<String> arrayList1=new ArrayList<String>();
        arrayList1.add("abc");
        ArrayList<Integer> arrayList2=new ArrayList<Integer>();
        arrayList2.add(123);
        System.out.println(arrayList1.getClass()==arrayList2.getClass());


        ArrayList<Integer> arrayList3=new ArrayList<Integer>();
        arrayList3.add(1);//这样调用add方法只能存储整形，因为泛型类型的实例为Integer
        arrayList3.getClass().getMethod("add", Object.class).invoke(arrayList3, "asd");
        for (int i=0;i<arrayList3.size();i++) {
            System.out.println(arrayList3.get(i) );
        }*/

        List<? super Dad> dadList = new ArrayList<>();
        dadList.add(new Son());
        Object son = dadList.get(0);
        System.out.println(son.toString());
    }
}

class Dad{

    @Override
    public String toString() {
        return "Dad{}";
    }
}

class Son extends Dad{
    @Override
    public String toString() {
        return "Son{}";
    }
}
