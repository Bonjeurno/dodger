package nl.han.jarno.entities.traffic;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import nl.han.jarno.entities.Player;
import nl.han.jarno.enums.Lane;
import nl.han.jarno.scenes.GameLevel;

import java.util.Random;

/**
 * dit is een abstracte super klasse, deze geeft de functies updateLeven en doDamage mee.
 */

public abstract class Traffic extends DynamicSpriteEntity  {


    public Traffic(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);

    }


    public abstract void updateLevel();


    public abstract void doDamage(Player player);
}
