import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.JButton;

public class Inventaire extends Panel {
	
	public JButton[][] inventaire;
	
	public Inventaire() {
		super();
		int ligne = 5;
		int colonne = 12;
		int larg = 50; // largeur d'une cellule pour les cases de l'inventaire
		
		this.inventaire = new JButton [ligne][colonne];
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridheight = ligne;
		gbc.gridwidth = colonne;
		
		for (int i=0; i<ligne; i++){
			gbc.gridy = i*larg;
			
			for (int j=0; j<colonne;j++){

				gbc.gridx = j*larg;
				inventaire[i][j] = new JButton();
				inventaire[i][j].setPreferredSize(new Dimension(larg,larg));
				inventaire[i][j].setBackground(Color.GRAY);
				this.add(inventaire[i][j],gbc);
			}
		}
		
		this.setPreferredSize(new Dimension(colonne*55,ligne*55));
	}
	
	
	public Craft GetCraft(Item item, Craft[] EnsembleDesCrafts) {
		for(Craft craft : EnsembleDesCrafts) {
			if(item.compareTo(craft.item)) {
				return craft;
			}
		}
		return null;
	}
}
