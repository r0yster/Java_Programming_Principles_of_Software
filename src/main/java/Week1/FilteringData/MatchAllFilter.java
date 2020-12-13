package Week1.FilteringData;
/**
 * Write a description of MatchAllFilter here.
 * 
 * @author Roy Cantu 
 * @version 1.0
 */

import java.util.*;

public class MatchAllFilter implements Filter {

    private ArrayList<Filter> matchAll;
    
    public MatchAllFilter(){
        matchAll = new ArrayList<Filter>();
    }
    
    public void addFilter(Filter f){
        matchAll.add(f);
    }
    
    public boolean satisfies(QuakeEntry qe){
        for (Filter f : matchAll){
            if(!f.satisfies(qe)){
                return false;
            }
        }
        return true;
    } 
    
    public String getName(){
        ArrayList<String> nameAll = new ArrayList<String>();
        for (Filter f : matchAll){
            nameAll.add(f.getName());
        }
        String New = "";
        for (int i = 0; i < nameAll.size(); i++){
            New = New + " " + nameAll.get(i);
        }
        return New;
    }
}
