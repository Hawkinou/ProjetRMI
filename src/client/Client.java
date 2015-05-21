package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import serveur.Distante;


public class Client {

	Ihm ihm;
	Registry registry;


	public Client() {
		ihm=new Ihm(this);
	}

	public void connexion(String user, String password) throws NotBoundException{
		try{
			registry=LocateRegistry.getRegistry("localhost",1080);				
			((Distante) registry.lookup("Hello")).connexion(user, password);	
			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	public void publication(String msg) throws NotBoundException{
		try{
			registry=LocateRegistry.getRegistry("localhost",1080);			
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @param args
	 * @throws NotBoundException 
	 */
	public static void main(String[] args) throws NotBoundException {
		Client client = new Client();

		client.publication("h");

		
		
	}

}
