package hw7.q2.food;

import hw7.q2.ingredients.Bread;
import hw7.q2.ingredients.Chicken;
import hw7.q2.ingredients.Meat;
import hw7.q2.ingredients.Sauce;

import java.util.HashMap;
import java.util.Map;

public class Hamberger extends Food{
    final static Map<Class, Integer> ingredients = new HashMap<Class, Integer>() {{ put(Meat.class, 2); put(Bread.class, 1); put(Sauce.class, 1);}};

    public Hamberger() {
        super(ingredients);
    }
}
