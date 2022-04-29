package prj5;

import cs2.Shape;
import java.awt.Color;;

public class CovidGlyph {
    private Shape shape;
    private static final double MAX_CFR = 20.0;
    private static final int MAX_HEIGHT = 400;
    private static final int WIDTH = 20;
    private double cfr;
    public CovidGlyph(int x, int y, CovidCase c){
        cfr = c.getCfr();
        shape = new Shape(x, y, WIDTH, height(), Color.BLUE);
    }


    public Shape getCovidShape() {
        return shape;
    }
    public int width() {
        return WIDTH;
    }
    
    public int height() {
        return (int) (cfr/MAX_CFR*MAX_HEIGHT);
    }
    
    public static int calcHeight(double objCfr) {
        return (int) (objCfr/MAX_CFR*MAX_HEIGHT);
    }

    
}
