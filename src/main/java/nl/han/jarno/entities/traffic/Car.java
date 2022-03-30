package nl.han.jarno.entities.traffic;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.scenes.SceneBorder;
import nl.han.jarno.entities.Player;
import nl.han.jarno.entities.text.ScoreText;
import nl.han.jarno.scenes.GameLevel;

import java.util.Random;

/**
 * dit it een subklasse van de superklasse traffic. indien collided met speler zal er 1 leven vanaf gaan, als deze het scherm verlaat zal er 100 bij de score worden opgeteld.
 */

public class Car extends Traffic implements Collider, SceneBorderCrossingWatcher {

    private GameLevel gameLevel;

    private double speed = 0;

    public Car(String recourse,Coordinate2D initialLocation, GameLevel gameLevel) {

        super(recourse, initialLocation);
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
    public void doDamage(Player player) {
        int health = player.getHealth();
        player.setHealth(--health);
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