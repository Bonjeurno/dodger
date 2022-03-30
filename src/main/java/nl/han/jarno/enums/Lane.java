package nl.han.jarno.enums;

/**
 * deze enum geeft de x coordinaten van de 4 verschillende lanes mee. deze kun je ovragen met de functie getLaneCoordinate.
 */

public enum Lane {
    LANE1(132),
    LANE2(255),
    LANE3(378),
    LANE4(500);

    private double x;


    Lane(double x) {
        this.x = x;
    }

    public double getLaneCoordinate(){
        return x;
    }
}
