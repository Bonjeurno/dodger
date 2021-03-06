package nl.han.jarno.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * in deze klasse woorden de eigenschappen van de score text meegeven. per traffic entity die het scherm verlaat wordt er 100 bij opgeteld.
 */

public class ScoreText extends TextEntity {

    public ScoreText(Coordinate2D initialLocation){
        super(initialLocation);

        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setFill(Color.WHITE);
    }

    public void setScoreText(int score){
        setText("Score: " + score);
    }
}
