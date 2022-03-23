package nl.han.jarno.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.han.jarno.Dodger;
import nl.han.jarno.entities.Player;
import nl.han.jarno.entities.entityspawner.SpawnTraffic;
import nl.han.jarno.entities.text.HealthText;
import nl.han.jarno.entities.traffic.Car;
import nl.han.jarno.entities.traffic.Traffic;
import nl.han.jarno.enums.Lane;

import java.util.ArrayList;
import java.util.Random;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {

    private HealthText healthText;
    private Dodger dodger;
    private Traffic traffic;


    public GameLevel(Dodger dodger) {
        this.dodger = dodger;



    }

    @Override
    public void setupScene() {
    setBackgroundImage("backgrounds/road_background.png");

    }

    @Override
    public void setupEntities() {

        var healthText = new HealthText(new Coordinate2D(500, 40));
        addEntity(healthText);
        Player player = new Player(new Coordinate2D(300, 800), healthText, dodger);
        addEntity(player);











    }

    private Coordinate2D getCarCoordinates(){

        return null;
    }



    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new SpawnTraffic(2500, this));
    }

//    public void spawnAutos(){
//        for(int i=0; i<aantalVehicles(3); i++){
//            Traffic car = new Car(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0), this);
//            addEntity(car);
//        }
//    }
//
//    public void spawnTrucks(){
//        for(int i=0; i<aantalVehicles(3); i++){
//            Traffic car = new Car(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0), this);
//            addEntity(car);
//        }
//    }



}
