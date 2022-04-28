package prj5;

import java.awt.Color;
import cs2.TextShape;
import cs2.Window;
import cs2.Shape;

/**
 * 
 */
public class GUIGlyph {
    private TextShape textShape;
    private CovidCase covidObj;
    private Window window; // delete window when integrating with the window
                           // class

    public GUIGlyph(CovidCase obj) {
        textShape = new TextShape(0, 0, "", Color.BLACK);
        window = new Window();
        window.addShape(textShape);
        covidObj = obj;
    }


    /**
     * trying to make cfr value out of a percentage of
     * the max height of the rectangle to get the height for the race according
     * to its cfr. I also had problms with trying to get to connect the cfr with
     * their race and I tried something like a for loop, but I don't think the
     * loop is working as I have hoped.
     */
    public void barHeightCalc() {
        if (covidObj.getCfr() == -1.0) {
            textShape.setText("NA"); // Checks for invalid inputs/ cfr

        }
        else {
            int count = 0;
            int tenthX = window.getGraphPanelWidth() / 10;
            int tenthY = window.getGraphPanelHeight() / 10;
            int numCfr = (int)Math.round(covidObj.getCfr());
            Shape bars;
            for (RaceEnum race : RaceEnum.values()) {
                count++;
                // (x, y, width, height, color)
                bars = new Shape(tenthX + count * 2, tenthY, 3, numCfr * 10,
                    Color.BLUE);

            }

        }

    }
}
