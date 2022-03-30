package nl.han.jarno;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import nl.han.jarno.entities.Player;
import nl.han.jarno.entities.text.HealthText;
import nl.han.jarno.scenes.GameLevel;
import nl.han.jarno.scenes.GameOver;
import nl.han.jarno.scenes.TitleScene;

/**
 * dit is het startpunt van onze game, hier wordt de highscore bijgehouden en de scenes geinitialiseerd.
 */
public class Dodger extends YaegerGame {

    private int highscore = 0;


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

    public void setHighscore(int score){
        highscore = score;
    }

    public int getHighscore(){
        return highscore;
    }
}
