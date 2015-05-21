package serveur;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetDistant extends  UnicastRemoteObject implements Distante {

	protected ObjetDistant() throws RemoteException {
		super();
	}

	@Override
	public void connexion() throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	

}
