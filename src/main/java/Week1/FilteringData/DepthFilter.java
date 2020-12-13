package Week1.FilteringData;
/**
 * Write a description of DepthFilter here.
 * 
 * @author Roy Cantu 
 * @version 1.0
 */
public class DepthFilter implements Filter{
    private double minDepth;
    private double maxDepth;   
    
    public DepthFilter(double min, double max){
        minDepth = min;
        maxDepth = max;    
    }
    
    public boolean satisfies(QuakeEntry qe){
        if(qe.getDepth() >= minDepth && qe.getDepth() <= maxDepth){
            return true;
        }
        return false;
    } 
    
    public String getName(){
        return "DepthFilter";
    }
}

