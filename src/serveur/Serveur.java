package serveur;

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
			
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
