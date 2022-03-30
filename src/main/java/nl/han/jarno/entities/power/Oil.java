package nl.han.jarno.entities.power;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import nl.han.jarno.entities.Player;
import nl.han.jarno.scenes.GameLevel;

/**
 * deze klasse spawned olie vlekken op de weg, als player daar overheen rijdt zal die voor 5 seconden langzamer rijden.
 * deze is niet af en daarom niet geimplementeerd.
 */

public class Oil extends Power implements Collider {

    private GameLevel gameLevel;

    public Oil(String resource, Coordinate2D initialLocation, GameLevel gameLevel) {
        super(resource, initialLocation);
        this.gameLevel = gameLevel;
    }

    @Override
    public void doPower(Player player) {

    }
}
