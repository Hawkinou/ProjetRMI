package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collection;

import serveur.UserI;


public class Client {

	IhmConnexion ihm;
	IhmTwitter ihmTwit;
	Registry registry;
	String user=null;

	
	/**
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(String user) {
		this.user = user;
	}

	public Client() {
		ihm=new IhmConnexion(this);
				
	}

	public boolean connexion(String user, String password) throws NotBoundException{
		try{
			registry=LocateRegistry.getRegistry("localhost",1088);				
			if( ((UserI) registry.lookup("Users")).connexion(user, password))
			{
				this.setUser(user);
				ihm.quit();
				ihmTwit=new IhmTwitter(this);

				return true;
			}
			
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void publish( String tweet) throws NotBoundException{
		if(this.getUser() != null)
		{
			try{
				
				registry=LocateRegistry.getRegistry("localhost",1088);			
				((UserI) registry.lookup("Users")).publish( tweet, this.getUser());
				System.out.println("Publication réussie du tweet :"+tweet );
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Client non connecté" );
		}
	}
	
	public ArrayList<String> getMyTweet() throws NotBoundException{
		if(this.getUser() != null)
		{
			try{
				
				registry=LocateRegistry.getRegistry("localhost",1088);			
				ArrayList<String> result = new ArrayList<String>();
				result.addAll(((UserI) registry.lookup("Users")).getMyTweet( this.getUser()));
				System.out.println("Tweets  :");
				for(String tweet: result) {
				    System.out.println(tweet);
				}
				return result;
				
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		else
		{
			System.out.println("Client non connecté" );
		}
		return null;
	}
	
	/**
	 * @param args
	 * @throws NotBoundException 
	 */
	public static void main(String[] args) throws NotBoundException {
		System.out.println("Creation de client" );
		Client client = new Client();
		/*client.connexion("toto","mdp");
		client.publish("C'est un tweet #tag #lol qui sert à rien #pd");
		client.connexion("clement","azerty");
		client.publish("Cegrgaeet #tag #a rien #pd");	
		client.connexion("toto","mdp");
		client.publish("agt un ageg #lolagert à rien #pd");	
		client.getMyTweet();*/
		
	}

}
