package nl.han.jarno.entities.traffic;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import nl.han.jarno.entities.Player;
import nl.han.jarno.scenes.GameLevel;

public class Police extends Traffic implements Collider {

    private GameLevel gameLevel;

    public Police(Coordinate2D initialLocation, GameLevel gameLevel) {
        super("sprites/cars/truck.png", initialLocation);
        this.gameLevel = gameLevel;
        setMotion(2, Direction.DOWN);
    }

    @Override
    public void doDamage(Player player){
        int health = player.getHealth();
        health -= 2;
        player.setHealth(health);
        remove();
    }


}
