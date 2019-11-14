package indi.kevin.selfLearn1.genericstudy;

import java.util.List;

public class FoodFactory<T extends Food> {

    private List<T> a;

    public <T> void getFoodList(List<T> foods){
        foods.stream().map(food-> (Food) food).forEach(
                food -> food.printName()
        );
    }
}
