import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Partie_Vue extends Panel{
	
	Modele modl;

	public Partie_Vue (Modele m){
		modl=m;
		this.setBackground(Minecraft.fond);
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		/*Button sauvegarde= new Button("Sauvegarder");
		sauvegarde.setFont(new Font("Arial",Font.BOLD,12));
		sauvegarde.setForeground(Color.black);
		sauvegarde.setPreferredSize(new Dimension(Minecraft.larg*2,30));
		sauvegarde.setBackground(Minecraft.fond_bouton);
		sauvegarde.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					modl.saveGame();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		gbc.gridx=0;
		gbc.gridy=60;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		this.add(sauvegarde,gbc);*/
		
		Button partie= new Button("Choisir partie");
		partie.setFont(new Font("Arial",Font.BOLD,12));
		partie.setForeground(Color.black);
		partie.setPreferredSize(new Dimension(50*2,30));
		partie.setBackground(new Color(219,219,219));
		// partie.addActionListener(new ActionListener() {}); Complique donc a voir
		
		gbc.gridx=0;
		gbc.gridy=100;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		gbc.gridwidth=2*50;
		this.add(partie,gbc);
		
		/*Button quitter= new Button("Quitter");
		quitter.setFont(new Font("Arial",Font.BOLD,12));
		quitter.setForeground(Color.black);
		quitter.setPreferredSize(new Dimension(Minecraft.larg*2,30));
		quitter.setBackground(new Color(219,219,219));
		gbc.gridx=0;
		gbc.gridy=140;
		gbc.fill= GridBagConstraints.HORIZONTAL;
		this.add(quitter,gbc);
		quitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});*/
	}
}
