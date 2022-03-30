package nl.han.jarno.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.han.jarno.Dodger;
import nl.han.jarno.entities.Player;
import nl.han.jarno.entities.sidewalk.SidewalkL;
import nl.han.jarno.entities.entityspawner.SpawnTraffic;
import nl.han.jarno.entities.sidewalk.SidewalkR;
import nl.han.jarno.entities.text.HealthText;
import nl.han.jarno.entities.text.ScoreText;

/**
 * dit is het spel leven. er is een algemene gamespeed voor alle naderende entities, deze wordt in de loop van het spel vergoot.
 *
 */

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {

    private Dodger dodger;
    private long current = 1900;
    private int score;
    private double gameSpeed = 1.8;
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
        var sidewalkL = new SidewalkL(new Coordinate2D(0,0));
        addEntity(sidewalkL);
        var sidewalkR = new SidewalkR(new Coordinate2D(600, 0));
        addEntity(sidewalkR);
        addEntity(scoreText);
        Player player = new Player(new Coordinate2D(300, 900), healthText, dodger, scoreText, this, sidewalkL);
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
