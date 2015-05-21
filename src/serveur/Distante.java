package serveur;

import java.rmi.RemoteException;

public interface Distante extends java.rmi.Remote{
	public void connexion() throws RemoteException;

}
