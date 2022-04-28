package prj5;

import java.io.*;

/**
 *
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor
 * will I accept the actions of those who do.
 *  Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell (robertp18)
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

    /**
     * Constructor
     * 
     * @param regionList
     *            the list of regions
     */
    public GUICovid(SinglyLinkedList<Region> regionList) {
        casesList = regionList;
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
            for (int j = region.getCovidCases().size() - 1; j >= 0; j--) {
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

}
