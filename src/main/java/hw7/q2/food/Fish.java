package hw7.q2.food;

import hw7.q2.ingredients.Chicken;
import hw7.q2.ingredients.Tomato;

import java.util.HashMap;
import java.util.Map;

public class Fish extends Food{
    final static Map<Class, Integer> ingredients = new HashMap<Class, Integer>() {{ put(Fish.class, 1); put(Tomato.class, 3);}};

    public Fish() {
        super(ingredients);
    }
}
