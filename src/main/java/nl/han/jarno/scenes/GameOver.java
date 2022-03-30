package nl.han.jarno.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.jarno.Dodger;
import nl.han.jarno.entities.buttons.Button;
import nl.han.jarno.entities.buttons.QuitButton;
import nl.han.jarno.entities.text.HighScore;

/**
 * dit is het game over scherm voor als je dood gaat. vanaf hier kan je de highscore zien, opnieuw spelen of stoppen
 */

public class GameOver extends StaticScene {

    private Dodger dodger;


    public GameOver(Dodger dodger) {this.dodger = dodger;}

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/title_background.png");
    }

    @Override
    public void setupEntities() {
        var gameoverText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2), "GAME OVER"

        );
        gameoverText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        gameoverText.setFill(Color.WHITE);
        gameoverText.setFont(Font.font("Roboto", FontWeight.BOLD, 80));
        addEntity(gameoverText);

        var highScore = new HighScore(new Coordinate2D(getWidth()/2, 800), dodger);
        addEntity(highScore);


        Button playAgainButton = new Button(new Coordinate2D(getWidth() / 2, getHeight() / 1.7),dodger, "Play again");
        addEntity(playAgainButton);

        QuitButton quitButton = new QuitButton(new Coordinate2D(getWidth() / 2, getHeight() / 1.2), dodger);
        addEntity(quitButton);
    }
}
