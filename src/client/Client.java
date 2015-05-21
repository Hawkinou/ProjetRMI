package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RmiClient client = new RmiClient();

		/*try{
			reg=LocateRegistry.getRegistry("localhost",2001);
			//mod = (Distante) reg.lookup("Hello");
		} catch (RemoteException e) {
			e.printStackTrace();
		}*/
	}

}
