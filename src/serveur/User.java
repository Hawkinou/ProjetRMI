package serveur;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

@SuppressWarnings("serial")
public class User extends  UnicastRemoteObject implements UserI {
	
	HashMap<String, String> passwords = new HashMap<String, String>(); 
	HashMap<String, ArrayList<String>> following = new HashMap<String, ArrayList<String>>(); 
	
	protected User() throws RemoteException {
		super();
		
	}

	@Override
	public boolean connexion(String user, String password) throws RemoteException {
		
		
		
		if ( passwords.get(user).equals(password))
			{
				System.out.print("Connexion réussie de : " + user );
				return true;
			}
		else
			{
				System.out.print("Connexion raté de : " + user );
				return false;
			}
	}

	@Override
	public void publish(String tweet, String autor) throws RemoteException {
		System.out.println("User.class : " + tweet );
		Registry registry = LocateRegistry.getRegistry("localhost",1088);
		try {
			
			
			((TweetI) registry.lookup("Tweets")).publish(tweet, autor);
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	@Override
	public void newUser(String user, String password) throws RemoteException {
		passwords.put(user, password);		
		following.put(user,  new ArrayList<String>());	
	}
	
	@Override
	public void subscribe(String user,String hashtag) throws RemoteException {
		((ArrayList<String>) following.get(user)).add(hashtag);
		following.put(user, (ArrayList<String>) following.get(user));	
	}

	@Override
	public void unsubscribe(String user, String hashtag) throws RemoteException {
		((ArrayList<String>) following.get(user)).remove(hashtag);
		following.put(user, (ArrayList<String>) following.get(user));			
	}
	
	@Override
	public ArrayList<String> getMyTweet(String autor) throws RemoteException {
		ArrayList<String> result = new ArrayList<String>();
		System.out.println("mes tweets" );
		Registry registry = LocateRegistry.getRegistry("localhost",1088);
		try {
					
			result.addAll(((TweetI) registry.lookup("Tweets")).getTweetByAutor(autor));
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return result;
	}

	

}
