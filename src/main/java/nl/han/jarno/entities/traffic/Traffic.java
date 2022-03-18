package nl.han.jarno.entities.traffic;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import nl.han.jarno.enums.Lane;
import nl.han.jarno.scenes.GameLevel;

import java.util.Random;

public abstract class Traffic extends DynamicSpriteEntity {
    int snelheid = 0;

    public Traffic(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);

    }




    public abstract void doDamage();
}
