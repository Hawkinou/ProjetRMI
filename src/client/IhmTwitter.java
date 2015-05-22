package client;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.rmi.NotBoundException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class IhmTwitter {

	Client client;
	JFrame frame;
	JPanel tweets;
	public IhmTwitter(Client client) {
		this.client=client;
		frame = new JFrame("Serveur");
		frame.setLayout(new GridLayout(3,1));
		createPanel();
		Dimension d = new Dimension(800, 600);
		frame.setMinimumSize(d) ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	private void createPanel(){
		tweets = new JPanel();
		tweets.setLayout(new GridLayout(1,2));
		ArrayList<String> myTweets = new ArrayList<String>();
				
		try {
			myTweets.addAll(client.getMyTweet());
			
			String result = "";
			for(String tweet : myTweets){
							result = tweet + "<br>" +result;
			}
			result = "<html>" + result + "</html>";
			JLabel label = new JLabel(result);
		    tweets.add(label);	
			frame.add(tweets);
			
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
