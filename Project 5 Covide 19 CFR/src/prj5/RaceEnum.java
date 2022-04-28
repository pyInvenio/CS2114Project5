package prj5;

/**
 *
 * Virginia Tech Honor Code Pledge:
 * As a Hokie, I will conduct myself
 * with honor and integrity at all times.
 * I will not lie, cheat, or steal, nor
 * will I accept the actions of those who do.
 *  Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell (robertp18)
 * 
 * This is the enum for race
 * 
 * 
 * @author Forrest Meng (forrestm), Ngoc Quy (ngocquy), Robert Powell
 *         (robertp18)
 * @version 4/22/2022
 */
public enum RaceEnum {
    WHITE, BLACK, LATINX, ASIAN, OTHER;

    /**
     * This is to get the race
     * 
     * @param i
     *            index of race
     * @return race
     */
    public static String get(int i) {
        return RaceEnum.values()[i].toString();
    }

}
