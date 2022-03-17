package nl.han.jarno.entities.traffic;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Car extends DynamicSpriteEntity {

    private int health = 3;

    protected Car(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }
}