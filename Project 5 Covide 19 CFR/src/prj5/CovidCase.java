package prj5;

import java.text.DecimalFormat;

// Question on: For this test, if deaths or cases or both are NA, we ask that
// your CFR
// calculator method return -1.0 to indicate that CFR is NA. If -1.0 is returned
// for your Cases, you should also then report -1.0 in your output.

public class CovidCase {

    private String race;
    private int cases;
    private int deaths;
    private double cfr;

    /**
     * Creates a CovidCase Object
     * 
     * @param raceCategory
     *            the race all the information is based on
     * @param covidCases
     *            the total covid case for the given race
     * @param numDeaths
     *            the total covid deaths for the given race
     */
    public CovidCase(String raceCategory, int covidCases, int numDeaths) {
        race = raceCategory;
        cases = covidCases;
        deaths = numDeaths;
        cfr = calcCfr(numDeaths, covidCases);

    }


    /**
     * A getter method for the total number of COVID cases associated with the
     * given race
     * 
     * @return the total number of COVID cases for the given race
     */
    public int getCases() {
        return cases;
    }


    /**
     * A getter method for the total COVID deaths associated with the given race
     * 
     * @return the total number of COVID deaths for the given race
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * A getter method for the race that the calculater will be calculating the
     * CFR for
     * 
     * @return the race that the program currently
     */
    public String getRace() {
        return race;
    }


    /**
     * A getter method for returning the CFR of the given race
     * 
     * @return the CFR calculation of the given race using its total COVID cases
     *         and COVID deaths
     */
    public double getCfr() {
        return cfr;
    }


    /**
     * The helper method calculates the CFR and rounds it to the nearest tenth
     * 
     * @param numDeaths
     *            total COVID deaths
     * @param numCases
     *            total COVID cases
     * @return the CFR calculation of the given race by dividing the total COVID
     *         deaths over the total COVID cases multiplied by 100 to get the
     *         percentage value
     * 
     * 
     *         Rounding without DecimalFormat --> return
     *         (double)Math.round(calculation * 100) / 100;
     * 
     * 
     */
    private double calcCfr(int numDeaths, int numCases) {

        if (numDeaths == -1 || numCases == -1) {
            return -1.0;
        }
        double calculation = (Double.valueOf(numDeaths) / Double.valueOf(
            numCases)) * 100;

        return calculation;

    }


    /**
     * 
     * The compareTo method to help woth sorting CovidCase objects based on
     * their CFR
     * 
     * @param other
     *            is the other CovidCase object the current CovidCase is being
     *            compared to
     * @return either a positive, negative, or zero integer based on if the
     *         current CovidCase object has a larger CFR, lower CFR, or equal
     */
    public int compareTo(CovidCase other) {
        if (this.cfr > other.cfr) {
            return 1;
        }
        else if (this.cfr < other.cfr) {
            return -1;
        }
        return this.getRace().compareTo(other.getRace());

    }


    /**
     * 
     * @return the race, covid case, death cases, and cfr properly formated as a
     *         string
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getRace().toLowerCase() + ": " + getCases()
            + " cases, ");

        DecimalFormat rounded = new DecimalFormat("0.0");
        builder.append(rounded.format(getCfr()) + "% CFR");

        return builder.toString();
    }


    /**
     * @param obj
     * @return the equality between two CovidCase objects
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        else if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }

        CovidCase other = (CovidCase)obj;

        return this.toString().equals(other.toString());
    }

}
