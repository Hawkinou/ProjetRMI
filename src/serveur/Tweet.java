package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

@SuppressWarnings("serial")
public class Tweet extends  UnicastRemoteObject implements TweetI {

	HashMap<String, ArrayList<String>> tweets = new HashMap<String, ArrayList<String>>(); 
	
	
	protected Tweet() throws RemoteException {
		super();
	}



	@Override
	public void publish(String tweet, String autor) throws RemoteException {
		// TODO Auto-generated method stub
		
		String[] words = tweet.split(" ");
		ArrayList<String> hashtagsBuffer = new ArrayList<String>();
		
		for(String word : words) {
		    if ( word.startsWith("#") ) {
		    	word = word.replace("#","");
		    	hashtagsBuffer.add(word);
		    } 
		    
		}
		tweets.put( (autor + " : " + tweet), hashtagsBuffer);
		
		for(int i = 0; i < hashtagsBuffer.size(); i++)
	    {
	      System.out.println("Tags à l'indice " + i + " = " + hashtagsBuffer.get(i));
	    }  
		
	}
	
	@Override
	public ArrayList<String> getTweetByTag(String tag) throws RemoteException {
		ArrayList<String> result = new ArrayList<String>();
		Set<String> key = tweets.keySet();
		Iterator<String> it = key.iterator();
		while (it.hasNext()){
		   String tweet = it.next(); 
		   if(((ArrayList<String>) tweets.get(tweet)).contains(tag))
			   result.add((String) tweet);
		}
		
		return result;
	}
	
	@Override
	public ArrayList<String> getTweetByAutor(String autor) throws RemoteException {
		ArrayList<String> result = new ArrayList<String>();
		Set<String> key = tweets.keySet();
		Iterator<String> it = key.iterator();
		while (it.hasNext()){
		   String tweet = it.next(); 
		   if(tweet.startsWith(autor))
			   result.add((String) tweet);
		}
		
		return result;
	}

}

	
