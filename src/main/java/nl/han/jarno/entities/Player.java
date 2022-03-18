package nl.han.jarno.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;

import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided, Newtonian {

    private int speed = 2;

    public Player(Coordinate2D initialLocation) {

        super("sprites/cars/player.png", initialLocation);
        setGravityConstant(0);
        setFrictionConstant(0.1);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        setSpeed(0);

        switch(border){
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        if(pressedKeys.contains(KeyCode.LEFT)){
            setSpeed(2);
            setMotion(speed,270d);
        } else if(pressedKeys.contains(KeyCode.RIGHT)){
            setSpeed(2);
            setMotion(speed,90d);
        } else if(pressedKeys.isEmpty()){
            setSpeed(0);
        }
    }

    public void Weerstand(){

    }

    public void setSpeed(int speed1){

        speed = speed1;
    }

    @Override
    public void onCollision(Collider collider) {

    }
}
