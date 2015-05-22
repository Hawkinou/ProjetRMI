package client;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class IhmTwitter {

	Client client;
	JFrame frame;
	public IhmTwitter(Client client) {
		this.client=client;
		frame = new JFrame("Serveur");
		frame.setLayout(new GridLayout(3,1));
		Dimension d = new Dimension(800, 600);
		frame.setMinimumSize(d) ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
