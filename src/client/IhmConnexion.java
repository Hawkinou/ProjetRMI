package client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.NotBoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class IhmConnexion {
	Client client;
	JTextArea textZone;
	JFrame frame;
	JPanel connexion;
	JPanel champ;
	JPanel validation;
	JTextField pseudo;
	JTextField motDePasse;
	JButton boutonEnvoi;
	JButton connexionButton;
	JButton inscription;


	public IhmConnexion(Client client){
		this.client=client;
		frame = new JFrame("Serveur");
		frame.setLayout(new GridLayout(3,1));
		createPanel();
		Dimension d = new Dimension(300, 150);
		frame.setMinimumSize(d) ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void createPanel(){
		connexion = new JPanel();
		connexion.setLayout(new GridLayout(1,2));
		connexionButton = new JButton("Connexion");
		connexionButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setConnexion();
			}
		});
		inscription=new JButton("Inscription");
		inscription.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setInscription();
			}
		});
		connexion.add(connexionButton);
		connexion.add(inscription);

		champ = new JPanel();
		champ.setLayout(new GridLayout(2,2));
		pseudo=new JTextField();
		motDePasse=new JTextField();
		champ.add(new JLabel("Identifiant"));
		champ.add(pseudo);
		champ.add(new JLabel("Mot de passe"));
		champ.add(motDePasse);
		
		setConnexion();
		frame.add(connexion);
		frame.add(champ);
		frame.add(validation);
	}
	public void setConnexion(){
		inscription.setBackground(Color.GRAY);
		connexionButton.setBackground(Color.lightGray);
		validation = new JPanel();
		boutonEnvoi = new JButton("Valider");
		boutonEnvoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					String user = pseudo.getText();
					boolean isConnected = client.connexion(user,motDePasse.getText());
					System.out.println("connexion " + isConnected);
					if(isConnected)
						{						
							System.out.println("Tentative publication tweet");
							client.publish("C'est un tweet #tag #lol qui sert à rien #pd");
						}
					
				} catch (NotBoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		validation.add(boutonEnvoi);
	}
	public void setInscription(){
		connexionButton.setBackground(Color.GRAY);
		inscription.setBackground(Color.lightGray);
		validation = new JPanel();
		boutonEnvoi = new JButton("Valider");
		boutonEnvoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
//TODO ici c'est le bouton d'inscription
				
			}
		});
		validation.add(boutonEnvoi);
	}
	public void quit(){
		frame.dispose();
	}
}
