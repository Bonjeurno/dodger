package nl.han.jarno.entities.power;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.jarno.entities.Player;

public class Lifes extends Power implements Collider, Collided, SceneBorderCrossingWatcher {

    public Lifes(Coordinate2D initialLocation) {
        super("resource", initialLocation);
    }

    @Override
    public void onCollision(Collider collider) {
        remove();
    }

    @Override
    public void doPower(Player player) {
        int health = player.getHealth();
        player.setHealth(++health);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}
