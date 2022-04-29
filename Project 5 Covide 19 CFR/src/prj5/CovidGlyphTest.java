package prj5;

import java.awt.Color;

/**
 *
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor
 * will I accept the actions of those who do.
 * Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell (robertp18)
 * 
 * This is the test class for the CovidGlyph class.
 * 
 * 
 * @author Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell
 *         (robertp18)
 * @version 4/22/2022
 */
public class CovidGlyphTest extends student.TestCase {

    /**
     * Fields
     */
    private CovidGlyph glyph;
    private CovidCase covidObj;

    /**
     * Initializing all necessary fields which is a CovidCase obj and and
     * CovidGlyph obj that needs the CovidCase obj as a parameter
     */
    public void setUp() {
        covidObj = new CovidCase("White", 70678, 1924);
        glyph = new CovidGlyph(10, 5, covidObj);
    }


    /**
     * Tests getCovidShape() by testing if its x and y coordinates are correct
     * and also it's color is set to BLUE.
     */
    public void testGetCovidShape() {
        assertEquals(glyph.getCovidShape().getX(), 10);
        assertEquals(glyph.getCovidShape().getY(), 5);
        assertEquals(glyph.getCovidShape().getForegroundColor(), Color.BLUE);
    }


    /**
     * Tests width() to see if it displays the correct width for the rectangle
     * bar.
     */
    public void testWidth() {
        assertEquals(glyph.width(), 20);
    }


    /**
     * Tests height() to see if the correct height was calculated and set to the
     * bar shape.
     */
    public void testHeight() {
        assertEquals(glyph.height(), 54);
    }


    /**
     * Tests calcHeight() to see if it properly calculated the height of the bar
     * according to the given CovidCase obj's cfr.
     */
    public void testCalcHeight() {
        assertEquals(glyph.calcHeight(covidObj.getCfr()), 54);
    }
}
