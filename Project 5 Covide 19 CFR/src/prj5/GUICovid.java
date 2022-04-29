package prj5;

import java.text.DecimalFormat;
import cs2.Button;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import cs2.Shape;

/**
 *
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor
 * will I accept the actions of those who do.
 * Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell (robertp18)
 * 
 * This is the class for GUICovid that displays the window, buttons, text, and
 * bars associated with each race for different settings.
 * 
 * 
 * @author Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell
 *         (robertp18)
 * @version 4/22/2022
 */
public class GUICovid {
    /**
     * Fields
     */
    private SinglyLinkedList<Region> casesList;
    private Window window;
    private Region currentRegion;
    private TextShape[] textNames;
    private TextShape[] textCFR;
    private TextShape title;
    private CovidGlyph[] covidGlyphs;

    /**
     * Creates one instance of the window that has all the buttons for the
     * regions, sorting alpha, sorting cfr, and title.
     * 
     * @param regionList
     *            the list of regions
     */
    public GUICovid(SinglyLinkedList<Region> regionList) {
        casesList = regionList;
        window = new Window("Covid-19 Visualizer");
        window.setSize(800, 500);
        currentRegion = casesList.get(0);
        Button quit = new Button("Quit");
        Button sortCFR = new Button("Sort by CFR");
        Button sortAlpha = new Button("Sort by ALPHA");
        for (StateEnum e : StateEnum.values()) {
            Button stateButton = new Button("Represent " + e.toString());
            stateButton.onClick(this, "onClickState");
            window.addButton(stateButton, WindowSide.SOUTH);
        }
        window.addButton(sortAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortCFR, WindowSide.NORTH);

        title = new TextShape(0, 0, "");
        title.setY(title.getHeight() * 2);
        window.addShape(title);

        int numRaces = RaceEnum.values().length;
        covidGlyphs = new CovidGlyph[numRaces];
        textNames = new TextShape[numRaces];
        textCFR = new TextShape[numRaces];

        for (int i = 0; i < numRaces; i++) {
            covidGlyphs[i] = new CovidGlyph(0, 0, currentRegion.getCovidCases()
                .get(i));
            textNames[i] = new TextShape(0, 0, "");
            textCFR[i] = new TextShape(0, 0, "");
            window.addShape(textNames[i]);
            window.addShape(textCFR[i]);
        }
        quit.onClick(this, "onClickQuit");
        sortAlpha.onClick(this, "onClickSort");
        sortCFR.onClick(this, "onClickSort");
    }


    /**
     * The updateDisplay() changes the title of the window based on the region
     * name that was clicked. This method is the bulk of how the bars are
     * formatted on the window after its height and width is calculated using
     * the CovidGlyph class. The text of the cfr percentage and race are also
     * updated on the window right below each bar to ensure labeling is
     * accurate. Lastly, this method accounts for invalid data input for a race
     * by subsituting the bar with a text object, "NA".
     */
    public void updateDisplay() {
        title.setText(currentRegion.getName()
            + " Case Fatality Ratios by Race");
        title.setX((window.getGraphPanelWidth() - title.getWidth()) / 2);

        int space = window.getGraphPanelWidth() / (covidGlyphs.length + 1);
        int bottomHeight = title.getHeight() * 5;
        int baseY = (int)(window.getGraphPanelHeight() - bottomHeight);

        for (int i = 0; i < covidGlyphs.length; i++) {
            window.removeShape(covidGlyphs[i].getCovidShape());
            int height = CovidGlyph.calcHeight(currentRegion.getCovidCases()
                .get(i).getCfr());
            int barX = space * (i + 1) - covidGlyphs[i].width() / 2;
            int barY = baseY - height;
            int width = covidGlyphs[i].width();
            covidGlyphs[i] = new CovidGlyph(barX, barY, currentRegion
                .getCovidCases().get(i));
            textNames[i].setText(currentRegion.getCovidCases().get(i).getRace()
                .toLowerCase());
            textCFR[i].setText(convertCFR(currentRegion.getCovidCases().get(i)
                .getCfr()));

            textNames[i].setX(barX + (width - textNames[i].getWidth()) / 2);
            textNames[i].setY(baseY + textNames[i].getHeight());
            textCFR[i].setX(barX + (width - textCFR[i].getWidth()) / 2);
            if (textCFR[i].getText().equals("NA")) {
                textCFR[i].setY(textNames[i].getY() - textCFR[i].getHeight());
            }
            else {
                textCFR[i].setY(textNames[i].getY() + textCFR[i].getHeight());
            }
            window.addShape(covidGlyphs[i].getCovidShape());
        }

    }


    /**
     * Once the parameter button is clicked, the onClickState() goes through the
     * StateEnum to find the parameter state and displays its information on the
     * GUI window.
     * 
     * @param b
     *            the region button being clicked
     */
    public void onClickState(Button b) {
        String[] sa = b.getTitle().split(" ");
        for (StateEnum e : StateEnum.values()) {
            if (sa[1].equals(e.toString())) {
                currentRegion = casesList.get(e.ordinal());
            }
        }
        updateDisplay();
    }


    /**
     * The onClickSort() should determine which sort button is being clicked
     * given through the parameters and then update the information on screen
     * either alphabetically or by cfr after determining which sort button was
     * clicked.
     * 
     * @param b
     *            either the sortCFR or sortAlpha button that is being clicked
     */
    public void onClickSort(Button b) {
        String[] s = b.getTitle().split(" ");
        if (s[0].equals("Sort")) {
            if (s[1].equals("by")) {
                if (s[2].equals("CFR")) {
                    for (Region r : casesList) {
                        r.sortCFR();
                    }
                }
                else if (s[2].equals("ALPHA")) {
                    for (Region r : casesList) {
                        r.sortAlpha();
                    }
                }
            }
        }
        updateDisplay();
    }


    /**
     * Exits from the GUI once the user click the quit button
     * 
     * @param b
     *            the quit button
     */
    public void onClickQuit(Button b) {
        System.exit(0);
    }


    /**
     * This is the method to get the output from the list of regions
     */
    public void getTextFile() {

        for (int i = 0; i < casesList.size(); i++) {
            Region region = casesList.get(i);
            System.out.println(region.getName());
            region.sortAlpha();
            for (CovidCase c : region.getCovidCases()) {
                System.out.println(c.toString());
            }
            System.out.println("=====");
            region.sortCFR();
            for (int j = 0; j < region.getCovidCases().size(); j++) {
                System.out.println(region.getCovidCases().get(j).toString());
            }
            System.out.println("=====");
        }

    }


    /**
     * A helper method for displaying the formated text below each bar
     * representing what each race's cfr is and what data the height of the bars
     * are based on.
     * 
     * @param cfr
     *            the cfr of a given CovidCase obj
     * @return the string formate of "NA" if the cfr is -1.0 and the string
     *         version of the double rounded to the tenths place with "%" at the
     *         end.
     */
    private String convertCFR(double cfr) {
        StringBuilder builder = new StringBuilder();
        if (cfr == -1) {
            return "NA";
        }
        double cfrRounded = Math.round(cfr * 10.0) / 10.0;
        if (cfrRounded % 1 == 0) {

            builder.append((int)cfr + "%");
        }
        else {
            DecimalFormat rounded = new DecimalFormat("0.0");
            builder.append(rounded.format(cfr) + "%");
        }

        return builder.toString();
    }

}
