/**
 * 
 */
package proj5;

import java.io.FileNotFoundException;
import java.text.ParseException;
import proj5.InputManager;

/**
 * @author ngocq
 *
 */
public class Input {

    public static void main(String[] args)
        throws ParseException,
        FileNotFoundException {
        if (args.length == 1) {
            new InputManager(args[0]);
        }
        else {
            new InputManager("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
        }

    }

}
