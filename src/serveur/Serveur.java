package serveur;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Serveur {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {

			Registry reg=LocateRegistry.createRegistry(2001);
			//enregistre l'objet RMI
			//reg.rebind("Hello", objet);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
