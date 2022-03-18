package nl.han.jarno.entities.traffic;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public abstract class Traffic extends DynamicSpriteEntity {
    int snelheid = 0;

    protected Traffic(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }




    public abstract void doDamage();
}
