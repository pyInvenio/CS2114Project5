package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 *
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor
 * will I accept the actions of those who do.
 *  Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell (robertp18)
 * 
 * This is the main input class
 * 
 * 
 * @author Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell
 *         (robertp18)
 * @version 4/22/2022
 */
public class Input {
    /**
     * This is the main method
     * 
     * @param args
     *            possible arguments input by console
     * @throws ParseException
     *             if there is an error parsing
     * @throws FileNotFoundException
     *             if we cannot find the file
     */
    public static void main(String[] args) throws FileNotFoundException {
        try {
            if (args.length > 0) {
                new InputManager(args[0]);
            }
            else {
                new InputManager("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
            }
        }
        catch (ParseException e) {

        }

    }

}
