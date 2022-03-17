package nl.han.jarno;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.han.jarno.scenes.GameLevel;
import nl.han.jarno.scenes.GameOver;
import nl.han.jarno.scenes.TitleScene;

/**
 * Het startpunt van onze GAME, with hugokemme7
 */
public class Dodger extends YaegerGame {

    public static void main(String[] args){
        launch(args);
    }
    
    @Override
    public void setupGame() {
    setGameTitle("Dodger");
    setSize(new Size(700, 1200));
    }

    @Override
    public void setupScenes() {
    addScene(0, new TitleScene(this));
    addScene(1, new GameLevel(this));
    addScene(2, new GameOver(this));
    }
}
