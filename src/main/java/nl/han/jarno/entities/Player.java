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
import nl.han.jarno.Dodger;
import nl.han.jarno.entities.text.HealthText;
import nl.han.jarno.entities.traffic.Car;
import nl.han.jarno.entities.traffic.Traffic;
import nl.han.jarno.entities.traffic.Truck;

import java.util.ArrayList;
import java.util.Set;

public class Player extends DynamicSpriteEntity implements KeyListener, SceneBorderTouchingWatcher, Collided, Newtonian {

    private HealthText healthText;
    private Dodger dodger;
    private int speed = 2;
    private int health = 3;

    public Player(Coordinate2D initialLocation, HealthText healthText, Dodger dodger) {

        super("sprites/cars/player.png", initialLocation);
        this.healthText = healthText;
        this.dodger = dodger;

        healthText.setHealthText(health);
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

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void Weerstand(){

    }

    public void setSpeed(int speed1){

        speed = speed1;
    }

    @Override
    public void onCollision(Collider collider) {

        if (collider instanceof Traffic traffic){
            traffic.doDamage(this);
        }
        //car.doDamage(this);
        healthText.setHealthText(getHealth());
        gameOver(getHealth());


    }

    public void gameOver(int lives){
        if(lives <= 0){
            dodger.setActiveScene(2);
        }
    }
}
