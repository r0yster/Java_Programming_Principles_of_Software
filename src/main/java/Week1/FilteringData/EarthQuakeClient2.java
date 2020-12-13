package Week1.FilteringData;

import java.util.*;
//import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        int count = 0;
        Filter f1 = new MagnitudeFilter(3.5,4.5);
        Filter f2 = new DepthFilter(-55000.0,-20000.0);        
        //Filter f3 = new DistanceFilter(39.7392, -104.9903, 1000000);
        //Filter f4 = new PhraseFilter("a","end");
        ArrayList<QuakeEntry> appliedF1 = filter(list, f1);
        ArrayList<QuakeEntry> appliedF2 = filter(appliedF1, f2);
        //ArrayList<QuakeEntry> appliedF3 = filter(list, f3);
        //ArrayList<QuakeEntry> appliedF4 = filter(appliedF3, f4);
        for (QuakeEntry qe: appliedF2) { 
            System.out.println(qe);
            count++;
        }
        System.out.println("There were "+count+" quakes found");
    }

    public void testMatchAllFilter() {
        int count = 0;
        EarthQuakeParser parser = new EarthQuakeParser();         
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        /*
        for (QuakeEntry qe : list){
            System.out.println(qe);
            count++;
        }
        System.out.println("There are "+count+" quakes found");
        */
        MatchAllFilter maf = new MatchAllFilter();
        Filter f1 = new MagnitudeFilter(1.0,4.0);
        maf.addFilter(f1);
        Filter f2 = new DepthFilter(-180000.0, -30000.0);
        maf.addFilter(f2);
        Filter f3 = new PhraseFilter("o","any");
        maf.addFilter(f3);
        ArrayList<QuakeEntry> quakes = filter(list, maf);
        for (QuakeEntry qe : quakes){
            System.out.println(qe);
            count++;
        }
        System.out.println("There are "+count+" quakes found");
    }    
    
    public void testMatchAllFilter2(){
        int count = 0;
        EarthQuakeParser parser = new EarthQuakeParser();         
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        MatchAllFilter maf = new MatchAllFilter();
        Filter f1 = new MagnitudeFilter(0.0,5.0);
        maf.addFilter(f1);
        Filter f2 = new DistanceFilter(55.7308, 9.1153, 3000000);
        maf.addFilter(f2);
        Filter f3 = new PhraseFilter("e","any");
        maf.addFilter(f3);
        ArrayList<QuakeEntry> quakes = filter(list, maf);
        for (QuakeEntry qe : quakes){
            System.out.println(qe);
            count++;
        }
        System.out.println("There are "+count+" quakes found");
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedata.atom";
        //String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }

}
