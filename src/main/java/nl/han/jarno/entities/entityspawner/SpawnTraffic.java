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

        int random = 0;
        int chancePower = 0;

        if(gameLevel.getScore() < 2000) {
            random = random(3);
            chancePower = random(15);
        } else if(gameLevel.getScore() > 2000 && gameLevel.getScore() < 10000){
            random = random(6);
            chancePower = random(20);
        } else {
            random = random(9);
            chancePower = random(30);
        }


        switch(random) {

            case 1:
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                    gameLevel));

            break;
            case 2:
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                    gameLevel));
            spawn(new Truck(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                    gameLevel));
            break;
            case 3:
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                    gameLevel));
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                    gameLevel));
            break;
            case 4:
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                    gameLevel));
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                    gameLevel));
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                    gameLevel));
            break;
            case 5:
                spawn(new Police(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                        gameLevel));
            spawn(new Truck(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                    gameLevel));

                current *= interval;
                setIntervalInMs((current));
                speed *= 1.05;
                gameLevel.setGamespeed(speed);

            break;
            case 6:
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                    gameLevel));
            spawn(new Police(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                    gameLevel));
            break;
            case 7:
                spawn(new Truck(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                        gameLevel));
                spawn(new Truck(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                        gameLevel));
                break;
            case 8:
                spawn(new Truck(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                        gameLevel));
                spawn(new Police(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                        gameLevel));
                spawn(new Police(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                        gameLevel));
                break;
            case 9:
                spawn(new Police(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                        gameLevel));
                spawn(new Truck(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                        gameLevel));
                spawn(new Truck(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                        gameLevel));
                break;
            default:
                spawn(new Truck(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), -100),
                        gameLevel));


                break;


        }

       switch(chancePower){
           case 1:
            spawn(new Lifes(new Coordinate2D(Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate(), 0), gameLevel));
            break;

        }


    }


    public int random(int max){
        int random = new Random().nextInt(max);

        return random;
    }


}
