package Week2.SortingAtScale;
/**
 * Write a description of TitleAndDepthComparator here.
 * 
 * @author Roy Cantu
 * @version 1.0
 */

import java.util.*;

public class TitleAndDepthComparator implements Comparator<QuakeEntry> {
    
    public int compare(QuakeEntry qe1, QuakeEntry qe2) {
        int compString = qe1.getInfo().compareTo(qe2.getInfo());
        if(compString == 0){
            return Double.compare(qe1.getDepth(), qe2.getDepth());
        }
        return compString;
    }
    
}
