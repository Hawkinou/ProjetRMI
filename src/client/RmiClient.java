package client;

import java.rmi.registry.Registry;

public class RmiClient {
	Ihm ihm;
	Registry reg;


	public RmiClient() {
		ihm=new Ihm(this);
	}

	public void connexion(String pseudo, String motDePasse){
		System.out.println("ok");
	}
}
