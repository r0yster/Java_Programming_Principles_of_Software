
/**
 * Write a description of class MarkovWordOne here.
 * 
 * @author Roy Cantu
 * @version 1.0
 */

import java.util.*;

public class MarkovWordOne implements IMarkovModel {
    private String[] myText;
    private Random myRandom;
    
    public MarkovWordOne() {
        myRandom = new Random();
    }
    
    public void setRandom(int seed) {
        myRandom = new Random(seed);
    }
    
    public void setTraining(String text){
		myText = text.split("\\s+");
	}
	
	public String getRandomText(int numWords){
		StringBuilder sb = new StringBuilder();
		int index = myRandom.nextInt(myText.length-1);  // random word to start with
		String key = myText[index];
		sb.append(key);
		sb.append(" ");
		System.out.println("Key being searched : "+key);
		for(int k=0; k < numWords-1; k++){
		    ArrayList<String> follows = getFollows(key);
		    if (follows.size() == 0) {
		        break;
		    }
			index = myRandom.nextInt(follows.size());
			String next = follows.get(index);
			System.out.print("Word following key : "+next);
			sb.append(next);
			sb.append(" ");
			key = next;
		}
		
		return sb.toString().trim();
	}

	/*
	 Returns an Arraylist of all the single words that immediately
	 follow the key in the training text
	*/
	private ArrayList<String> getFollows(String key) {
	    ArrayList<String> follows = new ArrayList<String>();
	    int pos = 0;
	    while(pos < myText.length) {
	    	int start = indexOf(myText, key, pos);
	    	if(start == -1) {
	    		break;
			}
	    	if(start + key.length() >= myText.length-1) {
	    		break;
			}
	    	String next = myText[start+1];
	    	follows.add(next);
	    	pos = start+1;
		}
	    return follows;
    }

    /*
	 Starts looking at the start position and returns the first index
	 location in words that matches target. If no word is found, then
	 this method returns -1.
	*/
	private int indexOf(String[] words, String target, int start){
    	for(int i = start; i < words.length; i++) {
			if (words[i].equals(target)) {
				return i;
			}
		}
		return -1;
	}

	public void testIndexOf(){
		String[] words = {"this","is","just","a","test",
				           "yes","this","is","a","simple","test",};

		System.out.println(indexOf(words, "this", 0));
		System.out.println(indexOf(words, "this", 3));
		System.out.println(indexOf(words, "frog", 0));
		System.out.println(indexOf(words, "frog", 5));
		System.out.println(indexOf(words, "simple", 2));
		System.out.println(indexOf(words, "test", 5));


	}
}
