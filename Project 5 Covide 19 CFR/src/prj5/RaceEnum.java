package prj5;

public enum RaceEnum{
    WHITE,
    BLACK,
    LATINO,
    ASIAN,
    OTHER;

    public static String get(int i){
        return RaceEnum.values()[i].toString();
    }
    
}