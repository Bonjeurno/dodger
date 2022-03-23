package nl.han.jarno.entities.traffic;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import nl.han.jarno.entities.Player;
import nl.han.jarno.scenes.GameLevel;

public class Truck extends Traffic implements Collider, Collided {

    private GameLevel gameLevel;

    public Truck(Coordinate2D initialLocation, GameLevel gameLevel) {
        super("sprites/cars/truck.png", initialLocation);
        this.gameLevel = gameLevel;
        setMotion(2, Direction.DOWN);
    }

    @Override
    public void doDamage(Player player){
        player.gameOver(0);
    }

    @Override
    public void onCollision(Collider collider) {
        remove();
    }
}
