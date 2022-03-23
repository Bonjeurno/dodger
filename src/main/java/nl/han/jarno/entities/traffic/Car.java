package nl.han.jarno.entities.traffic;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.jarno.entities.Player;
import nl.han.jarno.scenes.GameLevel;

import java.util.Random;

public class Car extends Traffic implements Collider, SceneBorderCrossingWatcher, Collided {

    private GameLevel gameLevel;


    public Car(String recourse,Coordinate2D initialLocation, GameLevel gameLevel) {

        super(recourse, initialLocation);
        this.gameLevel = gameLevel;
        setMotion(2, Direction.DOWN);

    }


    @Override
    public void doDamage(Player player) {
        int health = player.getHealth();
        player.setHealth(health--);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(new Random().nextInt((int) getSceneWidth() - 100));
        remove();

    }

    @Override
    public void onCollision(Collider collider) {
        remove();
    }
}