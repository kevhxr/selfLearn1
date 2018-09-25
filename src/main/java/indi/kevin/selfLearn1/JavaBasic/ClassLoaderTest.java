package indi.kevin.selfLearn1.JavaBasic;

public class ClassLoaderTest {

    public static void main(String[] args) {
        try {
            Class myClass = Class.forName("indi.kevin.selfLearn1.JavaBasic.ClassLoaderTest");
            ClassLoaderTest classLoader = (ClassLoaderTest) myClass.newInstance();
            classLoader.doSth();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(staticInt);
    }

    static { staticInt = 6; }
    int vInt = 10;
    { vInt = 15; }
    static int staticInt = 3;

    public ClassLoaderTest() {
        staticInt = 9;
        vInt = 20;
    }
    public void doSth(){
        System.out.println("ddddd");
    }

}
