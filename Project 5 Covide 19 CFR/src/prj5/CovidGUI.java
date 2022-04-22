package prj5;

import java.io.*;
/**
 * This is the class for CovidGUI
 * @author ngocq, forrestm, robertpowell
 * @version 4/22/2022
 */
public class CovidGUI {
    /**
     * Fields
     */
    private SinglyLinkedList<Region> casesList;

    /**
     * Constructor
     * @param regionList the list of regions
     */
    public CovidGUI(SinglyLinkedList<Region> regionList) {
        casesList = regionList;
    }

/**
 * This is the method to get the output from the list of regions
 */
    public void getTextFile() {
        //try {
            //PrintWriter pw = new PrintWriter("CovidCases.txt");

        for (int i = 0; i < casesList.size(); i++) {
            Region region = casesList.get(i);
            System.out.println(region.getName());
            region.sortAlpha();
            for (CovidCase c : region.getCovidCases()) {
                System.out.println(c.toString());
            }
            System.out.println("=====");
            region.sortCFR();
            for (int j = 0; j <region.getCovidCases().size(); j++) {
                System.out.println(region.getCovidCases().get(j).toString());
            }
            System.out.println("=====");
        }
            //pw.close();
        //}
        // catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // }

    }

}
