package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetDistant extends  UnicastRemoteObject implements Distante {

	String user;
	String password;
	
	protected ObjetDistant() throws RemoteException {
		super();
	}

	@Override
	public void connexion(String user, String password) throws RemoteException {
				System.out.print("Connexion de : " + user + password);
	}

	@Override
	public void publier() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	

}
