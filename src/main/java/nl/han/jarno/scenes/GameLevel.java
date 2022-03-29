package nl.han.jarno.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.han.jarno.Dodger;
import nl.han.jarno.entities.Player;
import nl.han.jarno.entities.entityspawner.SpawnTraffic;
import nl.han.jarno.entities.text.HealthText;
import nl.han.jarno.entities.text.HighScore;
import nl.han.jarno.entities.text.ScoreText;
import nl.han.jarno.entities.traffic.Car;
import nl.han.jarno.entities.traffic.Traffic;
import nl.han.jarno.enums.Lane;

import java.util.ArrayList;
import java.util.Random;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {

    private Dodger dodger;
    private Traffic traffic;
    private long current = 2500;
    private int score;
    private double gameSpeed = 2;
    private HighScore highScore;
    ScoreText scoreText = new ScoreText(new Coordinate2D(50, 50));


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

        addEntity(scoreText);
        Player player = new Player(new Coordinate2D(300, 900), healthText, dodger, scoreText, this);
        addEntity(player);


    }


    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new SpawnTraffic(current, this));

    }


    public int getScore(){
        return score;
    }

    public void setScore(int score){
        this.score = score;



    }

    public void updateScoreText(){
        scoreText.setScoreText(score);
    }

    public double getGamespeed(){
        return gameSpeed;
    }

    public void setGamespeed(double speed){
        gameSpeed = speed;
    }



}
