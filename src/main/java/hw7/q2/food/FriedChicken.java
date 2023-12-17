package hw7.q2.food;

import hw7.q2.ingredients.Bread;
import hw7.q2.ingredients.Chicken;
import hw7.q2.ingredients.Sauce;
import hw7.q2.ingredients.Tomato;

import java.util.HashMap;
import java.util.Map;

public class FriedChicken extends Food{
    final static Map<Class, Integer> ingredients = new HashMap<Class, Integer>() {{ put(Chicken.class, 3); put(Bread.class, 1); put(Sauce.class, 1);}};

    public FriedChicken() {
        super(ingredients);
    }
}
