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

/**
 * dit is een subklasse van de superklasse traffic, indien collided met player. health -2.
 */

public class Police extends Traffic implements Collider, SceneBorderCrossingWatcher {

    private GameLevel gameLevel;

    private double speed = 0;

    public Police(Coordinate2D initialLocation, GameLevel gameLevel) {
        super("sprites/cars/police.png", initialLocation);
        this.gameLevel = gameLevel;
        speed = gameLevel.getGamespeed();
        setMotion(speed, Direction.DOWN);
    }

    @Override
    public void updateLevel() {
        int score = gameLevel.getScore();
        score += 100;
        gameLevel.setScore(score);
    }

    @Override
    public void doDamage(Player player){
        int health = player.getHealth();
        health -= 2;
        player.setHealth(health);
        remove();

    }


    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(new Random().nextInt((int) getSceneWidth() - 100));
        remove();
        updateLevel();
        gameLevel.updateScoreText();
    }
}
