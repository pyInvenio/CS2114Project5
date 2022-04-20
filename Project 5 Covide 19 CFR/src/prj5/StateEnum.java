package prj5;

public enum StateEnum {
    DC,
    GA,
    MD,
    NC,
    TN,
    VA;

    public static String get(int i){
        return StateEnum.values()[i].toString();
    }
    
    
}
