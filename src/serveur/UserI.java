package serveur;

import java.rmi.RemoteException;
import java.util.ArrayList;

public interface UserI extends java.rmi.Remote{	
	
	boolean connexion(String user, String password) throws RemoteException;
	void newUser(String user, String password) throws RemoteException;
	void subscribe(String user, String hashtag) throws RemoteException;
	void unsubscribe(String user, String hashtag) throws RemoteException;
	void publish(String tweet, String autor) throws RemoteException;
	ArrayList<String> getMyTweet(String autor) throws RemoteException;

}
