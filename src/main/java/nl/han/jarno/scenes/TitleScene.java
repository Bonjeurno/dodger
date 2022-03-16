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

public class TitleScene extends StaticScene {

    private Dodger dodger;
    public TitleScene(Dodger dodger){
        this.dodger = dodger;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/title_background.png");
    }

    @Override
    public void setupEntities() {
        var dodgerText = new TextEntity(
                new Coordinate2D(getWidth() / 2, getHeight() / 2), "DODGER"
        );
        dodgerText.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        dodgerText.setFill(Color.WHITE);
        dodgerText.setFont(Font.font("Roboto", FontWeight.BOLD, 80));
        addEntity(dodgerText);

        Button startButton = new Button(new Coordinate2D(getWidth() / 2, getHeight() / 1.7),dodger, "Play game");
        addEntity(startButton);
    }
}
