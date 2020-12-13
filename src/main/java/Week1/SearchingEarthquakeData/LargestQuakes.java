package Week1.SearchingEarthquakeData;
/**
 * Write a description of LargestQuakes here.
 * 
 * @author Roy Cantu 
 * @version 1.0
 */

import java.util.*;

public class LargestQuakes {
    public void findLargestQuakes(){
        int count = 0;
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);       
        System.out.println("read data for "+list.size());
        for (QuakeEntry qe : list){
            System.out.println(qe);
            count++;
        }
        System.out.println("There are "+count+" quakes found");
        int largeQuake = indexOfLargest(list);
        System.out.println("Largest magnitude is found at index: "+largeQuake);
        ArrayList<QuakeEntry> largestQuakes = new ArrayList<QuakeEntry>(getLargest(list, 50));
        for (QuakeEntry qe : largestQuakes){
            System.out.println(qe);
        }
    }
    
    public int indexOfLargest(ArrayList<QuakeEntry> data){
        double maxIndex = 0;
        int index = 0;
        for (int i = 0; i < data.size(); i++){
            QuakeEntry quake = data.get(i);
            double magnitude = quake.getMagnitude();
            if( magnitude > maxIndex){
                maxIndex = magnitude;
                index = i;
            }
        }
        return index;
    }
    
    public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData, int howMany){
        ArrayList<QuakeEntry> ret = new ArrayList<QuakeEntry>();
        ArrayList<QuakeEntry> copy = new ArrayList<QuakeEntry>(quakeData); 
        double currMag = 0;
        for (int i = 0; i < howMany; i++){           
            ret.add(copy.get(indexOfLargest(copy)));
            copy.remove(copy.get(indexOfLargest(copy)));
        }
        return ret;
    }
}
