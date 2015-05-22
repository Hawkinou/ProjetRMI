package serveur;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface TweetI extends java.rmi.Remote{
	
	void publish(String tweet, String autor) throws RemoteException;

	ArrayList<String> getTweetByTag(String tag) throws RemoteException;

	ArrayList<String> getTweetByAutor(String autor) throws RemoteException;
	

}
