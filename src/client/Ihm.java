package client;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class Ihm {
	RmiClient client;
	JTextArea textZone;
	JFrame frame;
	JPanel connexion;
	JPanel champ;
	JPanel validation;
	JTextField pseudo;
	JTextField motDePasse;
	JButton boutonEnvoi;

	public Ihm(RmiClient client){
		this.client=client;
		frame = new JFrame("Twitter");
		frame.setLayout(new GridLayout(3,1));
		createPanel();
		Dimension d = new Dimension(300, 150);
		frame.setMinimumSize(d) ;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	private void createPanel(){
		connexion = new JPanel();
		connexion.add(new JLabel("Connexion"));
		
		champ = new JPanel();
		champ.setLayout(new GridLayout(2,2));
		pseudo=new JTextField();
		motDePasse=new JTextField();
		champ.add(new JLabel("Identifiant"));
		champ.add(pseudo);
		champ.add(new JLabel("Mot de passe"));
		champ.add(motDePasse);
		
		validation = new JPanel();
		boutonEnvoi = new JButton("Valider");
		boutonEnvoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				client.connexion(pseudo.getText(),motDePasse.getText());
				
			}
		});
		validation.add(boutonEnvoi);
		frame.add(connexion);
		frame.add(champ);
		frame.add(validation);
	}
	public void quit(){
		frame.dispose();
	}
}
