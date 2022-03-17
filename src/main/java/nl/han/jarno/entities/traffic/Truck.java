package nl.han.jarno.entities.traffic;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class Truck extends DynamicSpriteEntity implements Traffic{

    protected Truck(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void doDamage(){

    }

}
