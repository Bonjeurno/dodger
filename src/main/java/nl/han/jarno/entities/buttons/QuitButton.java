package nl.han.jarno.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import nl.han.jarno.Dodger;

/**
 * dit is de quit button van ons spel, indien geactieveerd wordt het spel afgesloten.
 */

public class QuitButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private Dodger dodger;

    public QuitButton(Coordinate2D initialLocation, Dodger dodger){
        super(initialLocation,"QUIT");
        this.dodger = dodger;
        setFill(Color.YELLOW);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        dodger.quit();
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.WHITE);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.YELLOW);
        setCursor(Cursor.DEFAULT);
    }
}
