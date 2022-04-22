/**
 * 
 */
package prj5;

/**
 * @author robertpowell
 *
 */
public class Region {
    
    private String name; 
    private SinglyLinkedList<CovidCase> covidCases;
    
    /**
     * Creates a Region object
     * 
     * @param regionName
     *      the name of the region
     * @oaram cases
     *      the linked list of covid cases
     */
    public Region(String regionName, SinglyLinkedList<CovidCase> cases) {
        name = regionName;
        covidCases = cases;
    }
    
    /**
     * Returns the name of the region 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Returns the covidCase data
     */
    public SinglyLinkedList<CovidCase> getCovidCases() {
        return covidCases;
    }

    /**
     * Checks if two regions have the same data
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Region other = (Region) obj;
        return name.equals(other.getName()) && covidCases.equals(other.getCovidCases());
    }
    
    /**
     * Sorts the regions alphabetically
     */
    public void sortAlpha() {
        
        this.covidCases.insertionSort(new CovidCase.AlphaCompare());
    }
    
    /**
     * Sorts the regions by CFR
     */
    public void sortCFR() {
        this.covidCases.insertionSort(new CovidCase.CFRCompare());
    }

}
