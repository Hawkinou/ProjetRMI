package serveur;

import java.rmi.RemoteException;

public interface Distante extends java.rmi.Remote{
	
	public void publier() throws RemoteException;
	void connexion(String user, String password) throws RemoteException;
	

}
