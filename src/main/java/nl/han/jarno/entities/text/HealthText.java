package nl.han.jarno.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * in deze klasse worden de eigenschappen van de health text meegegeven.
 */

public class HealthText extends TextEntity {

    public HealthText(Coordinate2D initialLocation){
        super(initialLocation);

        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setFill(Color.WHITE);
    }

    public void setHealthText(int health){
        setText("Health: " + health);
    }

}

