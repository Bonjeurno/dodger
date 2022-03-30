package nl.han.jarno.entities.sidewalk;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.Node;
import javafx.scene.paint.Color;

import java.util.Optional;

public class SidewalkR extends RectangleEntity implements Collider {

    public SidewalkR(Coordinate2D loc) {
        super(loc);
        setHeight(1200);
        setWidth(100);
        setFill(Color.TRANSPARENT);
    }


}
