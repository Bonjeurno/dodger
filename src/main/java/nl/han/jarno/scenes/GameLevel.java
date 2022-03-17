package nl.han.jarno.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.han.jarno.Dodger;
import nl.han.jarno.entities.Player;
import nl.han.jarno.entities.traffic.Car;
import nl.han.jarno.entities.traffic.Traffic;

import java.util.ArrayList;

public class GameLevel extends DynamicScene {

    private Dodger dodger;

    public GameLevel(Dodger dodger) {this.dodger = dodger;}

    @Override
    public void setupScene() {
    setBackgroundImage("backgrounds/road_background.png");
    }

    @Override
    public void setupEntities() {

        ArrayList<Traffic> traffic = new ArrayList<Traffic>();
        var player = new Player(new Coordinate2D(300, 800));
        addEntity(player);
        var car = new Car(new Coordinate2D(150, 0));
        traffic.add(car);
    }


}
