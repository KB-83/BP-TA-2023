package hw7.q2.food;

import hw7.q2.ingredients.*;

import java.util.HashMap;
import java.util.Map;

public class Pizza extends Food{
    final static Map<Class, Integer> ingredients = new HashMap<Class, Integer>() {{ put(Chicken.class, 1); put(Meat.class, 1); put(Tomato.class, 1); put(Bread.class, 2); put(Sauce.class, 1);}};

    public Pizza() {
        super(ingredients);
    }
}

