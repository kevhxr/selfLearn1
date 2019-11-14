package indi.kevin.selfLearn1.genericstudy;

import java.util.ArrayList;
import java.util.List;

public class mainTest {

    public static void main(String[] args) {

        List<Food> foodPlate = new ArrayList<>();
        List<? super Food> plate1 = new ArrayList<>();
        plate1 = foodPlate;


        Apple apple = new Apple();
        Fruit fruit = new Fruit();
        Food food = new Food();
        plate1.add(apple);
        plate1.add(food);
        plate1.add(fruit);

        Object getApple =  plate1.get(0);
        //getApple.printName();

//-------------------------------------------------------------
        List<Apple> apples = new ArrayList<>();
        apples.add(apple);

        List<? super Apple> app = new ArrayList<Food>();

        List<? extends Food> plate2 = new ArrayList<Apple>(apples);
        Food food1 = plate2.get(0);
        System.out.println("==");
        food1.printName();

        System.out.println("==");
        FoodFactory foodFaactory = new FoodFactory<Apple>();
        foodFaactory.getFoodList(plate2);

    }


    public mainTest(){}
}
