package Week1.FilteringData;
/**
 * Write a description of DistanceFilter here.
 * 
 * @author Roy Cantu
 * @version 1.0
 */
public class DistanceFilter implements Filter {
    private double maxDist;
    private Location loc;   
    
    public DistanceFilter(double lat, double lon, double max){
        maxDist = max;
        loc = new Location(lat,lon);    
    }
    
    public boolean satisfies(QuakeEntry qe){
        if(qe.getLocation().distanceTo(loc) <= maxDist){
            return true;
        }
        return false;
    } 
    
    public String getName(){
        return "DistanceFilter";
    }
}
