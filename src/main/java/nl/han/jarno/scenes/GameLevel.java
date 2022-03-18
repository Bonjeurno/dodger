package nl.han.jarno.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.han.jarno.Dodger;
import nl.han.jarno.entities.Player;
import nl.han.jarno.entities.traffic.Car;
import nl.han.jarno.entities.traffic.Traffic;
import nl.han.jarno.enums.Lane;

import java.util.ArrayList;
import java.util.Random;

public class GameLevel extends DynamicScene {

    private Dodger dodger;

    public GameLevel(Dodger dodger) {
        this.dodger = dodger;
    }

    @Override
    public void setupScene() {
    setBackgroundImage("backgrounds/road_background.png");
    }

    @Override
    public void setupEntities() {


        Player player = new Player(new Coordinate2D(300, 800));
        addEntity(player);


        Traffic car = new Car(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0));


        addEntity(car);

    }

    private Coordinate2D getCarCoordinates(){

        return null;
    }


}
