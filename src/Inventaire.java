import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Inventaire extends Panel implements ActionListener {
	
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
				String sobriquet = i*12+j+"";
				JButton b = new JButton();
				inventaire[i][j] = b;
				b.setPreferredSize(new Dimension(larg,larg));
				b.setText(sobriquet);
				b.setActionCommand("Item sélectionné : "+sobriquet);  // Il y aura ici en fait un string caractérisant l'item sur lequel on a cliqué
				b.setBackground(Color.lightGray);
				b.addActionListener(this);
				this.add(b,gbc);
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


	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println(arg0.getActionCommand());
	}

}
