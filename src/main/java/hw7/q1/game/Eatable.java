package hw7.q1.game;

import java.util.List;

public interface Eatable {
    default void makeReady(List<Object> ingrediantes) {

    }

    default void makeReady(){}
}
