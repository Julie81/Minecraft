import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Inventaire extends Panel implements ActionListener {
	
	public JitmButton[][] inventaire;
	
	public Inventaire(ArrayList<Item> r) {
		super();
		int ligne = 1;
		int colonne = r.size();
		int larg = 50; // largeur d'une cellule pour les cases de l'inventaire
		
		this.inventaire = new JitmButton [ligne][colonne];
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
				String sobriquet = j+"";
				JitmButton b = new JitmButton(r.get(j));
				inventaire[i][j] = b;
				
				ImageIcon icon = new ImageIcon("miniatures/RC/"+r.get(j).name+".png");
				Image img = icon.getImage() ;
				Image newimg = img.getScaledInstance( larg, larg,  java.awt.Image.SCALE_SMOOTH ) ;
				icon = new ImageIcon(newimg);
				b.setIcon(icon);
				
				b.setPreferredSize(new Dimension(larg,larg));
				//b.setText(sobriquet);
				b.setActionCommand(sobriquet);  // Il y aura ici en fait un string caracterisant l'item sur lequel on a cliqu�
				b.addActionListener(this);
				this.add(b,gbc);
			}
		}
		
		this.setPreferredSize(new Dimension(colonne*55,ligne*55));

	}
	
	/*
	public Craft GetCraft(Item item, Craft[] EnsembleDesCrafts) {
		for(Craft craft : EnsembleDesCrafts) {
			if(item.compareTo(craft.item)) {
				return craft;
			}
		}
		return null;
	}*/


	@Override
	public void actionPerformed(ActionEvent arg0) {
		String n = arg0.getActionCommand();
		System.out.println(this.inventaire[0][n.charAt(0)-'0'].it.quantity);
	}

}
