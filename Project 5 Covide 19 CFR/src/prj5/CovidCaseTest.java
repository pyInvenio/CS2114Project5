/**
 * 
 */
package proj5;

/**
 * @author ngocq
 *
 */
public class CovidCaseTest extends student.TestCase {
    private CovidCase calc1;
    private CovidCase same;

    private CovidCase infoNa;
    private CovidCase higherCfr;
    private CovidCase diffRace;

    public void setUp() {
        calc1 = new CovidCase("Asian", 5407, 254);
        same = new CovidCase("Asian", 5407, 254);
        diffRace = new CovidCase("White", 5407, 254);

        higherCfr = new CovidCase("White", 3000, 223);
        infoNa = new CovidCase("Black", 5000, -1);
    }


    public void testGetCases() {
        assertEquals(calc1.getCases(), 5407);
    }


    public void testGetDeaths() {
        assertEquals(calc1.getDeaths(), 254);
    }


    public void testGetRace() {
        assertEquals(calc1.getRace(), "Asian");
    }


    public void testCalcCFR() {
        assertEquals(calc1.getCfr(), 4.7, 0.1);
        assertEquals(higherCfr.getCfr(), 7.4, 0.1);
        assertEquals(infoNa.getCfr(), -1.0, 0.1);

        CovidCase caseNa = new CovidCase("Asian", -1, 10);
        assertEquals(caseNa.getCfr(), -1, 0.1);
    }


    public void testCompareTo() {
        assertEquals(calc1.compareTo(infoNa), 1);
        assertEquals(calc1.compareTo(higherCfr), -1);
        assertEquals(calc1.compareTo(same), 0);
        assertEquals(calc1.compareTo(diffRace), 1);
        assertEquals(diffRace.compareTo(calc1), -1);
    }


    public void testToString() {
        assertEquals(calc1.toString(), "asian: 5407 cases, 4.7% CFR");
        assertEquals(higherCfr.toString(), "white: 3000 cases, 7.4% CFR");
        assertEquals(infoNa.toString(), "black: 5000 cases, -1.0% CFR");
    }


    public void testEquals() {
        assertTrue(calc1.equals(same));
        assertTrue(calc1.equals(calc1));

        assertFalse(calc1.equals(new Object()));
        assertFalse(calc1.equals(null));
        assertFalse(calc1.equals(diffRace));
        assertFalse(calc1.equals(higherCfr));
    }

}
