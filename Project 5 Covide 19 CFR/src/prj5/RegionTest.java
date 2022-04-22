package prj5;
/**
 * This is the test class for Region
 * @author ngocq, forrestm, robertpowell
 * @version 4/22/2022
 */
public class RegionTest extends student.TestCase {

    /**
     * Fields
     */
    private Region region;

    /**
     * Set up the test
     */
    public void setUp() {
        SinglyLinkedList<CovidCase> cases = new SinglyLinkedList<CovidCase>();
        cases.add(new CovidCase("Asian", 5407, 254));
        cases.add(new CovidCase("White", 5407, 254));
        cases.add(new CovidCase("Black", 5407, 274));
        region = new Region("A", cases);
    }

/**
 * Tests getName()
 */
    public void testGetName() {
        assertEquals(region.getName(), "A");
    }

/**
 * Tests getCovidCases()
 */
    public void testGetCovidCases() {
        SinglyLinkedList<CovidCase> cases1 = new SinglyLinkedList<CovidCase>();
        cases1.add(new CovidCase("Asian", 5407, 254));
        cases1.add(new CovidCase("White", 5407, 254));
        cases1.add(new CovidCase("Black", 5407, 274));
        assertEquals(cases1, region.getCovidCases());
    }

/**
 * tests equals()
 */
    public void testEquals() {
        SinglyLinkedList<CovidCase> cases1 = new SinglyLinkedList<CovidCase>();
        cases1.add(new CovidCase("Asian", 5407, 254));
        cases1.add(new CovidCase("White", 5407, 254));
        cases1.add(new CovidCase("Black", 5407, 274));
        Region region1 = new Region("A", cases1);
        Region region2 = new Region("A", new SinglyLinkedList<CovidCase>());
        assertTrue(region.equals(region1));
        assertFalse(region.equals(region2));
        assertFalse(region.equals(null));
        assertFalse(region2.equals("Str"));
        Region region3 = new Region("B", cases1);
        assertFalse(region.equals(region3));
        assertTrue(region.equals(region));
    }

/**
 * tests sortAlpha()
 */
    public void testSortAlpha() {
        SinglyLinkedList<CovidCase> cases1 = new SinglyLinkedList<CovidCase>();
        cases1.add(new CovidCase("Asian", 5407, 254));
        cases1.add(new CovidCase("Black", 5407, 274));
        cases1.add(new CovidCase("White", 5407, 254));

        region.sortAlpha();
        assertEquals(cases1, region.getCovidCases());
    }

/**
 * tests sortCFR()
 */
    public void testSortCFR() {
        SinglyLinkedList<CovidCase> cases1 = new SinglyLinkedList<CovidCase>();
        cases1.add(new CovidCase("White", 5407, 254));
        cases1.add(new CovidCase("Asian", 5407, 254));
        
        cases1.add(new CovidCase("Black", 5407, 274));
        region.sortCFR();
        assertEquals(cases1, region.getCovidCases());
    }
}
