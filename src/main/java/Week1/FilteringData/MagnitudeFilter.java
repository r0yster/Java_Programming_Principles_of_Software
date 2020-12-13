package Week1.FilteringData;

/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author Roy Cantu
 * @version 1.0
 */


public class MagnitudeFilter implements Filter{
    private double minMag;
    private double maxMag;
    
    public MagnitudeFilter(double min, double max){
        minMag = min;
        maxMag = max;
    }
    
    public boolean satisfies(QuakeEntry qe){
        if(qe.getMagnitude() >= minMag && qe.getMagnitude() <= maxMag){
            return true;
        }
        return false;
    }
    
    public String getName(){
        return "MagnitudeFilter";
    }
}
