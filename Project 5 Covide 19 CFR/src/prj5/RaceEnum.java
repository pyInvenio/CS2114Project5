package prj5;
/**
 * This is the enum for races
 * @author ngocq, forrestm, robertpowell
 * @version 4/22/2022
 */
public enum RaceEnum {
    WHITE, BLACK, LATINX, ASIAN, OTHER;

    /**
     * This is to get the race
     * @param i index of race
     * @return race
     */
    public static String get(int i) {
        return RaceEnum.values()[i].toString();
    }

}
