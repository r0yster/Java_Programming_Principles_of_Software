package Week3.InterfaceAndAbstractClass;
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class EfficientMarkovModel extends AbstractMarkovModel{
    private int n;
    private HashMap<String, ArrayList<String>> map;
    
    public EfficientMarkovModel(int number){
        myRandom = new Random();
        n = number;
        map = new HashMap<String, ArrayList<String>>();
    }
    
    public void setRandom(int seed){
        myRandom = new Random(seed);
    }
    
    public void setTraining(String s){
        myText = s.trim();
        buildMap();
    }
    
    public void buildMap(){
        for(int i = 0; i < myText.length() - n; i++){
            String newKey = myText.substring(i, i + n);
            if(!map.containsKey(newKey)){
                ArrayList<String> list = getFollows(newKey);
                map.put(newKey, list);
            }
        }
    }
    
    public void printHashMapInfo(){
        buildMap();
        System.out.println("Keys in the hasmap: "+(map.size()+1));
        int index = 0;
        int maxSize = 0;
        String maxkey = "";
        for (String s : map.keySet()){
            maxSize = Math.max(maxSize, map.get(s).size());
            if(map.get(s).size() > index){
                index = map.get(s).size();
                maxkey = s;
            }
            //System.out.println(s+" "+map.get(s));
        }
        System.out.println("max num of keys = "+index);
        System.out.println("the key is this: "+maxkey);
        System.out.println("The maximum number of keys following a key is " + maxSize);
        ArrayList<String> keys = new ArrayList<String>();
        for (String key : map.keySet()) {
			if(map.get(key).size() == maxSize){
				keys.add(key);
			}
		}
		System.out.println("Keys that have the largest ArrayList are: " + keys);
    }
    
    public String getRandomText(int numChars){
        if (myText == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int index = myRandom.nextInt(myText.length() - n);
        String key = myText.substring(index, index+n);
        sb.append(key);
        for(int k=0; k < numChars; k++){
            ArrayList<String> follows = getFollows(key);
            if(follows.size() == 0){
                break;
            }
            index = myRandom.nextInt(follows.size());
            String next = follows.get(index);
            sb.append(next);
            key = key.substring(1) + next;
        }        
        return sb.toString();
    }
}
