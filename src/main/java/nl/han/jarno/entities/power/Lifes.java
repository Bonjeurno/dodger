package nl.han.jarno.entities.power;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.jarno.entities.Player;
import nl.han.jarno.scenes.GameLevel;

/**
 * dit is een klasse die levens spawned, als je deze op pakt krijg je er een leven bij.
 */

public class Lifes extends Power implements Collider, SceneBorderCrossingWatcher {

    private GameLevel gameLevel;
    private double speed;

    public Lifes(Coordinate2D initialLocation, GameLevel gameLevel) {
        super("sprites/items/jerrycan.png", initialLocation);
        this.gameLevel = gameLevel;

        speed = gameLevel.getGamespeed();
        setMotion(speed, Direction.DOWN);
    }

    @Override
    public void doPower(Player player) {
        int health = player.getHealth();
        player.setHealth(++health);
        remove();
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}
