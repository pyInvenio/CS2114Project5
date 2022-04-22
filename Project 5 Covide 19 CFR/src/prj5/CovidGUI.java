package prj5;

import java.io.*;

public class CovidGUI {
    SinglyLinkedList<Region> casesList;
    public CovidGUI(SinglyLinkedList<Region> regionList) {
        casesList = regionList;
    }

    public void getTextFile(){
        try {
            PrintWriter pw = new PrintWriter("CovidCases.txt");
            
            for (int i = 0; i < casesList.size(); i++) {
                Region region = casesList.get(i);
                pw.println(region.getName());
                region.sortAlpha();
                for (CovidCase c : region.getCovidCases()){
                    pw.println(c.toString());
                }
                pw.println("=====");
                region.sortCFR();
                for (int j = region.getCovidCases().size() - 1; j >= 0; j--) {
                    pw.println(region.getCovidCases().get(j).toString());
                }
                pw.println("=====");
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    
}
