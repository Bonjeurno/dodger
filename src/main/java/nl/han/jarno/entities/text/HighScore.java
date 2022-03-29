package nl.han.jarno.entities.text;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.jarno.Dodger;

public class HighScore extends TextEntity {

    private Dodger dodger;

    public HighScore(Coordinate2D initialLocation, Dodger dodger){
        super(initialLocation);
        this.dodger = dodger;

        setHighScoreText(dodger.getHighscore());

        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 45));

    }

    public void setHighScoreText(int score){
        setText("Highscore: " + score);
    }
}
