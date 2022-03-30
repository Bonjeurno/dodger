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

/**
 * dit is de entity spawner, deze spawned de auto's en de power ups in.
 */

public class SpawnTraffic extends EntitySpawner {

    private GameLevel gameLevel;
    private long current = getIntervalInMs();
    private double interval = 0.95;
    private double speed;
    private double randomLane1;
    private double randomLane2;
    private double randomLane3;


    public SpawnTraffic(long intervalInMs, GameLevel gameLevel) {
        super(intervalInMs);
        this.gameLevel = gameLevel;
        speed = gameLevel.getGamespeed();
    }

    @Override
    protected void spawnEntities() {

        int random = 0;
        int chancePower = 0;

        randomLane1 = randomLane();
        randomLane2 = randomLane();
        randomLane3 = randomLane();

        differentLaneCheck(randomLane1, randomLane2, randomLane3);


        if(gameLevel.getScore() < 2000) {
            random = random(4);
            chancePower = random(15);
        } else if(gameLevel.getScore() > 2000 && gameLevel.getScore() < 7500){
            random = random(8);
            chancePower = random(20);
        } else {
            random = random(12);
            chancePower = random(30);
        }


        switch(random) {

            case 1:
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(randomLane1, -100),
                    gameLevel));

            break;
            case 2:
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(randomLane1, -100),
                    gameLevel));
            spawn(new Truck(new Coordinate2D(randomLane2, -100),
                    gameLevel));
            break;
            case 3:
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(randomLane1, -100),
                    gameLevel));
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(randomLane2, -100),
                    gameLevel));
            break;
            case 4:
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(randomLane1, -100),
                    gameLevel));
            spawn(new Car("sprites/cars/car1.png", new Coordinate2D(randomLane2, -100),
                    gameLevel));
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(randomLane3, -100),
                    gameLevel));
            break;
            case 5:
                spawn(new Police(new Coordinate2D(randomLane1, -100),
                        gameLevel));
            spawn(new Truck(new Coordinate2D(randomLane2, -100),
                    gameLevel));

                current *= interval;
                setIntervalInMs((current));
                speed *= 1.05;
                gameLevel.setGamespeed(speed);

            break;
            case 6:
            spawn(new Car("sprites/cars/car2.png", new Coordinate2D(randomLane1, -100),
                    gameLevel));
            spawn(new Police(new Coordinate2D(randomLane2, -100),
                    gameLevel));
            break;
            case 7:
                spawn(new Truck(new Coordinate2D(randomLane1, -100),
                        gameLevel));
                spawn(new Truck(new Coordinate2D(randomLane2, -100),
                        gameLevel));
                break;
            case 8:
                spawn(new Truck(new Coordinate2D(randomLane1, -100),
                        gameLevel));
                spawn(new Police(new Coordinate2D(randomLane2, -100),
                        gameLevel));
                spawn(new Police(new Coordinate2D(randomLane3, -100),
                        gameLevel));
                break;
            case 9:
                spawn(new Police(new Coordinate2D(randomLane1, -100),
                        gameLevel));
                spawn(new Truck(new Coordinate2D(randomLane2, -100),
                        gameLevel));
                spawn(new Truck(new Coordinate2D(randomLane3, -100),
                        gameLevel));
                break;
            case 10:
                spawn(new Car("sprites/cars/car2.png", new Coordinate2D(randomLane1, -100),
                        gameLevel));
                spawn(new Car("sprites/cars/car2.png", new Coordinate2D(randomLane2, -100),
                        gameLevel));
                spawn(new Car("sprites/cars/car1.png", new Coordinate2D(randomLane3, -100),
                        gameLevel));
                break;
            case 11:
                spawn(new Car("sprites/cars/car1.png", new Coordinate2D(randomLane1, -100),
                        gameLevel));
                spawn(new Car("sprites/cars/car2.png", new Coordinate2D(randomLane2, -100),
                        gameLevel));
                spawn(new Car("sprites/cars/car1.png", new Coordinate2D(randomLane3, -100),
                        gameLevel));
                break;
            case 12:
                spawn(new Car("sprites/cars/car1.png", new Coordinate2D(randomLane1, -100),
                        gameLevel));
                spawn(new Police(new Coordinate2D(randomLane2, -100),
                        gameLevel));
                spawn(new Car("sprites/cars/car1.png", new Coordinate2D(randomLane3, -100),
                        gameLevel));
                break;
            default:
                spawn(new Truck(new Coordinate2D(randomLane(), -100),
                        gameLevel));


                break;


        }

       switch(chancePower){
           case 1:
            spawn(new Lifes(new Coordinate2D(randomLane(), 0), gameLevel));
            break;

        }


    }


    public int random(int max){
        int random = new Random().nextInt(max);

        return random;
    }

    public double randomLane(){
        return Lane.values()[new Random().nextInt(Lane.values().length)].getLaneCoordinate();
    }

    public void differentLaneCheck(double l1, double l2, double l3){
        if(l1 == l2 || l1 == l3){
            randomLane1 = randomLane();
        }
        if(l2 == l1 || l2 == l3){
            randomLane2 = randomLane();
        }
        if(l3 == l1 || l3 == l2){
            randomLane3 = randomLane();
        }
    }
}
