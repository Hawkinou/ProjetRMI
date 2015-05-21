package serveur;

import java.rmi.Remote;
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
		ObjetDistant objetdistant = new ObjetDistant();
		try {

			try {
				registry = LocateRegistry.createRegistry(1080);
			} catch (Exception e) {
				registry = LocateRegistry.getRegistry(1080);
			}			
			registry.rebind("Hello", objetdistant);
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
