package prj5;

import java.io.*;  
import java.util.Scanner;  
import prj5.CovidCase;


public class InputManager {
    
    //private SinglyLinkedList<Region> regionList;
    
    public InputManager(String fileName) throws FileNotFoundException {
        
        CovidGUI covidGui = new CovidGUI(readFile(fileName));
        covidGui.getTextFile();

    }
    private void readFile(String fileName) throws FileNotFoundException {
        //<Region> list = new SinglyLinkedList<Region>();
        Scanner s = new Scanner(new File(fileName));
        s.useDelimiter(",");
        s.nextLine();
        while(s.hasNext()){
            String[] sarray = s.nextLine().split(",");
            String state = sarray[0].trim();
            //Region region = new Region(state);
            for (int i = 0 ; i < 5; i++) {
                int cases = sarray[i+1].trim().equals("NA") ? -1 : Integer.parseInt(sarray[i+1].trim());
                int deaths = sarray[i+6].trim().equals("NA") ? -1 : Integer.parseInt(sarray[i+6].trim());
                CovidCase c = new CovidCase(RaceEnum.get(i), cases, deaths);
                //region.add(c);
            }
            
            //list.add(region);

        }
        return;
    }

}
