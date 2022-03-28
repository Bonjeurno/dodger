package nl.han.jarno.entities.entityspawner;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import nl.han.jarno.entities.power.Lifes;
import nl.han.jarno.entities.traffic.Car;
import nl.han.jarno.entities.traffic.Police;
import nl.han.jarno.entities.traffic.Truck;
import nl.han.jarno.enums.Lane;
import nl.han.jarno.scenes.GameLevel;

import java.util.Random;

public class SpawnTraffic extends EntitySpawner {

    private GameLevel gameLevel;
    long current = getIntervalInMs();
    double interval = 0.95;
    private double speed;


    public SpawnTraffic(long intervalInMs, GameLevel gameLevel) {
        super(intervalInMs);
        this.gameLevel = gameLevel;
        speed = gameLevel.getGamespeed();
    }

    @Override
    protected void spawnEntities() {

        int random = random(6);
        int chancePower = random(10);
        switch(random) {

            case 1:
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));

            break;
            case 2:
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            spawn(new Truck(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            break;
            case 3:
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            break;
            case 4:
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            break;
            case 5:
            spawn(new Truck(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            spawn(new Police(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            break;
            case 6:
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            spawn(new Police(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                    gameLevel));
            break;
            default:
                spawn(new Truck(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0),
                        gameLevel));

                current *= interval;
                setIntervalInMs((current));
                speed *= 1.05;
                gameLevel.setGamespeed(speed);
                break;


        }
       // if(chancePower == 1){
            //spawn(new Lifes(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0)));
       // }


    }


    public int random(int max){
        int random = new Random().nextInt(max);

        return random;
    }


}
