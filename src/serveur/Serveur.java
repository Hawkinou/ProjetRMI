package serveur;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Serveur {

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException {
		Registry  registry;
		User allUser = new User();
		Tweet allTweet = new Tweet();
		
		try {

			try {
				registry = LocateRegistry.createRegistry(1088);
			} catch (Exception e) {
				registry = LocateRegistry.getRegistry(1088);
			}			
			registry.rebind("Users", allUser);
			registry.rebind("Tweets", allTweet);
			try {
				((UserI) registry.lookup("Users")).newUser("admin","admin");
				((UserI) registry.lookup("Users")).newUser("edouard","password");
				((UserI) registry.lookup("Users")).newUser("clement","password");
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
