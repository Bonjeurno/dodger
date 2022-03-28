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

public class Truck extends Traffic implements Collider, SceneBorderCrossingWatcher {

    private GameLevel gameLevel;

    public Truck(Coordinate2D initialLocation, GameLevel gameLevel) {
        super("sprites/cars/truck.png", initialLocation);
        this.gameLevel = gameLevel;
        setMotion(2, Direction.DOWN);
    }

    @Override
    public void updateLevel() {
        int score = gameLevel.getScore();
        score += 100;
        gameLevel.setScore(score);
    }

    @Override
    public void doDamage(Player player){
        player.gameOver(0);
        remove();
    }


    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        setAnchorLocationX(new Random().nextInt((int) getSceneWidth() - 100));
        remove();
        updateLevel();

    }


}
