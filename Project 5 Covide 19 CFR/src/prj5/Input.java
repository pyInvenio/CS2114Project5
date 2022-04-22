package prj5;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * This is the project runner class
 * 
 * @author ngocq, forrestm, robertpowell
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
