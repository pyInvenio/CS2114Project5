/**
 * 
 */
package prj5;

import prj5.CovidCase.AlphaCompare;
import prj5.CovidCase.CFRCompare;

/**
 *
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor
 * will I accept the actions of those who do.
 * -- Forrest Meng (forrestm), Ngoc Quy Tran(ngocquy), Robert Powell (robertp18)
 * 
 * This is the class for testing CovidCase
 * 
 * 
 * @author Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell
 *         (robertp18)
 * @version 4/22/2022
 */
public class CovidCaseTest extends student.TestCase {
    /**
     * Fields
     */
    private CovidCase calc1;
    private CovidCase same;
    private CovidCase infoNa;
    private CovidCase higherCfr;
    private CovidCase diffRace;
    private AlphaCompare alpha;
    private CFRCompare cfr;

    /**
     * Set up the test
     */
    public void setUp() {
        calc1 = new CovidCase("Asian", 5407, 254);
        same = new CovidCase("Asian", 5407, 254);
        diffRace = new CovidCase("White", 5407, 254);

        higherCfr = new CovidCase("White", 3000, 223);
        infoNa = new CovidCase("Black", 5000, -1);
        alpha = new AlphaCompare();
        cfr = new CFRCompare();
    }


    /**
     * Tests getCases()
     */
    public void testGetCases() {
        assertEquals(calc1.getCases(), 5407);
    }


    /**
     * test getDeaths()
     */
    public void testGetDeaths() {
        assertEquals(calc1.getDeaths(), 254);
    }


    /**
     * test getRace()
     */
    public void testGetRace() {
        assertEquals(calc1.getRace(), "Asian");
    }


    /**
     * test calcCFR()
     */
    public void testCalcCFR() {
        assertEquals(calc1.getCfr(), 4.7, 0.1);
        assertEquals(higherCfr.getCfr(), 7.4, 0.1);
        assertEquals(infoNa.getCfr(), -1.0, 0.1);

        CovidCase caseNa = new CovidCase("Asian", -1, 10);
        assertEquals(caseNa.getCfr(), -1, 0.1);
    }


    /**
     * test compareTo()
     */
    public void testCompareTo() {
        assertEquals(alpha.compare(calc1, same), 0);
        assertTrue(alpha.compare(calc1, diffRace) < 0);
        assertEquals(cfr.compare(calc1, same), 0);
        assertTrue(cfr.compare(infoNa, calc1) < 0);
    }


    /**
     * test toString()
     */
    public void testToString() {
        assertEquals(calc1.toString(), "asian: 5407 cases, 4.7% CFR");
        assertEquals(higherCfr.toString(), "white: 3000 cases, 7.4% CFR");
        assertEquals(infoNa.toString(), "black: 5000 cases, -1% CFR");
    }


    /**
     * test equals()
     */
    public void testEquals() {
        assertTrue(calc1.equals(same));
        assertTrue(calc1.equals(calc1));

        assertFalse(calc1.equals(new Object()));
        assertFalse(calc1.equals(null));
        assertFalse(calc1.equals(diffRace));
        assertFalse(calc1.equals(higherCfr));
    }


    /**
     * Tests the readfile()
     * 
     * @throws FileNotFoundException
     * @throws ParseParseException
     */
    public void testReadFile() {
        Exception e = null;
        try {
            InputManager input = new InputManager("test.txt");
        }
        catch (Exception e1) {
            e = e1;
        }
        assertNotNull(e);
        e = null;
        try {
            InputManager input = new InputManager(
                "Cases_and_Deaths_by_race_CRDT_Sep2020.csv");

        }
        catch (Exception e2) {
            e = e2;
        }
        assertNull(e);
    }

}
