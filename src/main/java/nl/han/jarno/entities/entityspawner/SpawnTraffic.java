package nl.han.jarno.entities.entityspawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.jarno.entities.traffic.Car;
import nl.han.jarno.entities.traffic.Police;
import nl.han.jarno.entities.traffic.Truck;
import nl.han.jarno.enums.Lane;
import nl.han.jarno.scenes.GameLevel;

import java.util.Random;

public class SpawnTraffic extends EntitySpawner {

    private GameLevel gameLevel;

    public SpawnTraffic(long intervalInMs, GameLevel gameLevel) {
        super(intervalInMs);
        this.gameLevel = gameLevel;
    }

    @Override
    protected void spawnEntities() {
        int random = random(6);
        if (random < 1) {
            spawn(new Truck(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
        } else if (random == 1) {
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));

        } else if (random == 2) {
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            spawn(new Truck(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));

        } else if (random == 3) {
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));

        } else if (random == 4) {
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));

        } else if (random == 5) {
            spawn(new Truck(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            spawn(new Police(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));

        } else if (random == 6) {
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            spawn(new Police(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
        }


    }

    public int random(int max){
        int random = new Random().nextInt(max);
        return random;
    }


}
