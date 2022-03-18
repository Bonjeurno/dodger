package nl.han.jarno.enums;

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
