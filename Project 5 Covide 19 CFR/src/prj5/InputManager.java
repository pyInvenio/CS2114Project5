package prj5;

import java.io.*;
import java.text.ParseException;
import java.util.Scanner;

/**
 *
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor
 * will I accept the actions of those who do.
 *  Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell (robertp18)
 * 
 * This is the class for Input Manager
 * 
 * 
 * @author Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell
 *         (robertp18)
 * @version 4/22/2022
 */
public class InputManager {
    /**
     * This is the constructor for the Input Manager class
     * 
     * @param fileName
     *            the file to read in
     * @throws FileNotFoundException
     *             if file not found
     * @throws ParseException
     *             if there is an error parsing
     */
    public InputManager(String fileName)
        throws FileNotFoundException,
        ParseException {

        GUICovid covidGui = new GUICovid(readFile(fileName));
        covidGui.getTextFile();

    }


    /**
     * This is the method to read in the file
     * 
     * @param fileName
     *            the file to read in
     * @return the list of regions
     * @throws FileNotFoundException
     *             if file not found
     * @throws ParseException
     *             If there is a parse exception
     */
    private SinglyLinkedList<Region> readFile(String fileName)
        throws FileNotFoundException,
        ParseException {
        SinglyLinkedList<Region> list = new SinglyLinkedList<Region>();
        Scanner s = new Scanner(new File(fileName));
        s.useDelimiter(",");
        s.nextLine();
        while (s.hasNext()) {
            String[] sarray = s.nextLine().split(",");
            String state = sarray[0].trim();
            SinglyLinkedList<CovidCase> covidCases =
                new SinglyLinkedList<CovidCase>();
            for (int i = 0; i < 5; i++) {

                int cases = sarray[i + 1].trim().equals("NA")
                    ? -1
                    : Integer.parseInt(sarray[i + 1].trim());
                int deaths = sarray[i + 6].trim().equals("NA")
                    ? -1
                    : Integer.parseInt(sarray[i + 6].trim());
                CovidCase c = new CovidCase(RaceEnum.get(i), cases, deaths);
                covidCases.add(c);
            }

            Region region = new Region(state, covidCases);
            list.add(region);

        }
        return list;
    }

}
