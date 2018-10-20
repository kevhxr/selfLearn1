package indi.kevin.selfLearn1.Java8;

public interface Sample {
    default String getSampleName(){
        return "Sample interface";
    }
    default int getSampleId(){
        return 0;
    }
    static void printName(){
        System.out.println("Sample interface printName");
    }
    int getNumber();

}
