package hw7.q2.food;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class Food {
    final Map<Class, Integer> ingredients;

    public Food(Map<Class, Integer> ingredients) {
        this.ingredients = ingredients;
    }
}
