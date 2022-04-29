package prj5;

import cs2.Shape;
import java.awt.Color;;

/**
 *
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor
 * will I accept the actions of those who do.
 * Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell (robertp18)
 * 
 * This is the CovidGlyph class.
 * 
 * 
 * @author Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell
 *         (robertp18)
 * @version 4/22/2022
 */
public class CovidGlyph {
    /**
     * Fields
     */
    private Shape shape;
    private static final double MAX_CFR = 20.0;
    private static final int MAX_HEIGHT = 400;
    private static final int WIDTH = 20;
    private double cfr;

    /**
     * Creates the shape of one rectangular bar for the given CovidCase object.
     * 
     * @param x
     *            the x-coordinate placed on the window
     * @param y
     *            the y-coordinate placed on the window
     * @param c
     *            the CovidCase obj that will be used for its cfr
     */
    public CovidGlyph(int x, int y, CovidCase c) {
        cfr = c.getCfr();
        shape = new Shape(x, y, WIDTH, height(), Color.BLUE);
    }


    /**
     * A getter method for the newly made bar based on the CovidCase object's
     * cfr.
     * 
     * @return the shape of the bar
     */
    public Shape getCovidShape() {
        return shape;
    }


    /**
     * The width() uses a static final constant for the bar width because each
     * bar will share the same width size.
     * 
     * @return the width of the bar
     */
    public int width() {
        return WIDTH;
    }


    /**
     * The height() returns the height of the rectangular bar without being
     * passed a given cfr double as a parameter.
     * 
     * @return the height of the bar
     */
    public int height() {
        return (int)(cfr / MAX_CFR * MAX_HEIGHT);
    }


    /**
     * The calcHeight() takes in the cfr of the give CovidCase obj and
     * calculates the height with the give cfr parameter.
     * 
     * @param objCfr
     * @return
     */
    public static int calcHeight(double objCfr) {
        return (int)(objCfr / MAX_CFR * MAX_HEIGHT);
    }

}
