package nl.han.jarno.entities.power;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import nl.han.jarno.entities.Player;

public abstract class Power extends DynamicSpriteEntity {



    public Power(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);

    }

    public abstract void doPower(Player player);


}
