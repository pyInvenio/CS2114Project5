package prj5;
/**
 *
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor
 * will I accept the actions of those who do.
 * -- Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell (robertp18)
 * 
 * This is the enum for States
 * 
 * 
 * @author Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell
 *         (robertp18)
 * @version 4/22/2022
 */
public enum StateEnum {
    DC, GA, MD, NC, TN, VA;

    /**
     * This is the method to get the state name
     * @param i the index of the state
     * @return the name of the state
     */
    public static String get(int i) {
        return StateEnum.values()[i].toString();
    }

}