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
 * This is the class for GUICovid
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
            // window.addShape(covidGlyphs[i].getCovidShape());
            window.addShape(textNames[i]);
            window.addShape(textCFR[i]);
        }
        quit.onClick(this, "onClickQuit");
        sortAlpha.onClick(this, "onClickSort");
        sortCFR.onClick(this, "onClickSort");
    }


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
            int barX = space * (i + 1) - covidGlyphs[i].width()/2;
            int barY = baseY - height;
            int width = covidGlyphs[i].width();
            covidGlyphs[i] = new CovidGlyph(barX, barY, currentRegion
                .getCovidCases().get(i));
            textNames[i].setText(currentRegion.getCovidCases().get(i)
                .getRace().toLowerCase());
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


    public void onClickState(Button b) {
        String[] sa = b.getTitle().split(" ");
        for (StateEnum e : StateEnum.values()) {
            if (sa[1].equals(e.toString())) {
                currentRegion = casesList.get(e.ordinal());
            }
        }
        updateDisplay();
    }


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


    public void onClickQuit(Button b) {
        System.exit(0);
    }


    /**
     * This is the method to get the output from the list of regions
     */
    public void getTextFile() {
        // try {
        // PrintWriter pw = new PrintWriter("CovidCases.txt");

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
        // pw.close();
        // }
        // catch (FileNotFoundException e) {
        // e.printStackTrace();
        // }

    }


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
