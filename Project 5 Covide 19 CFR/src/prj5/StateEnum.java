package prj5;
/**
 * This is the enum for the states
 * @author ngocq, forrestm, robertpowell
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
