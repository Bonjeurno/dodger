package nl.han.jarno.entities.traffic;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;

import java.util.Random;

public class Car extends DynamicSpriteEntity implements Traffic, Collider, SceneBorderCrossingWatcher {


    public Car( Coordinate2D initialLocation) {

        super("sprites/cars/car1.png", initialLocation);
        setMotion(2, Direction.DOWN);

    }

    @Override
    public void doDamage() {

    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(new Random().nextInt((int) getSceneWidth() - 100));
    }
}