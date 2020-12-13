package Week3.GeneratingRandomText;
/**
 * Write a description of Tester here.
 * 
 * @author Roy Cantu 
 * @version 1.0
 */

import java.util.*;
import edu.duke.*;

public class Tester {
    public void testGetFollows(){
        MarkovOne one = new MarkovOne();
        one.setTraining("this is a test yes this is a test.");
        String key = "t";
        System.out.print(one.getFollows(key));
    }
    
    public void testGetFollowsWithFile(){
        MarkovOne one = new MarkovOne();
        FileResource f = new FileResource();
        one.setTraining(f.asString());
        String key = "th";
        System.out.print(one.getFollows(key).size());
    }
}
