package nl.han.jarno.entities.sidewalk;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class SidewalkL extends RectangleEntity implements Collider {

    public SidewalkL(Coordinate2D loc) {
        super(loc);
        setHeight(1200);
        setWidth(100);
        setFill(Color.TRANSPARENT);
    }


}
