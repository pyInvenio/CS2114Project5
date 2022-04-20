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
    private SingleLinkedList<CovidCase> covidCases;
    
    /**
     * Creates a Region object
     * 
     * @param regionName
     *      the name of the region
     * @oaram cases
     *      the linked list of covid cases
     */
    public Region(String regionName, SingleLinkedList<CovidCase> cases) {
        name = regionName;
        
    }
    
    /**
     * Returns the name of the region 
     */
    public void getName() {
        
    }
    
    /**
     * Returns the covidCase data
     */
    public SingleLinkedList<CovidCases> getCovidCases() {
        
    }
    
    /**
     * Compares the data of two regions
     */
    @Override
    public int compareTo() {
        
    }
    
    /**
     * Converts the data of the region to a string
     */
    public String toString() {
        
        
    }
    
    /**
     * Checks if two regions have the same data
     */
    @Override
    public void equals() {
        
    }
    
    /**
     * Sorts the regions alphabetically
     */
    public void sortAlpha() {
        
    }
    
    /**
     * Sorts the regions by CFR
     */
    public void sortCFR() {
        
    }

}
