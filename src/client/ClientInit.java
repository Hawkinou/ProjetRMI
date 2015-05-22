package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import serveur.UserI;

public class ClientInit {
	
	
	public ClientInit() {
		
		try {
			Registry registry = LocateRegistry.getRegistry("localhost",1088);
			try {
				((UserI) registry.lookup("Users")).newUser("toto","mdp");
				((UserI) registry.lookup("Users")).newUser("clement","azerty");
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ClientInit client = new ClientInit();

	}

}
