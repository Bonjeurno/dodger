package nl.han.jarno.scenes;

import com.github.hanyaeger.api.scenes.DynamicScene;
import nl.han.jarno.Dodger;

public class GameLevel extends DynamicScene {

    private Dodger dodger;

    public GameLevel(Dodger dodger) {this.dodger = dodger;}

    @Override
    public void setupScene() {
    setBackgroundImage("backgrounds/road_background.png");
    }

    @Override
    public void setupEntities() {

    }
}
