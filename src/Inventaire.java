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
		int quota = 64;
		int width = 5;
		int car = 50;
		
		this.inventaire = new JButton [ligne][colonne];
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridheight=ligne;
		gbc.gridwidth=colonne;
		
		for (int i=0; i<this.inventaire.length; i++){
			gbc.gridy=i*car;
			for (int j=0; j<this.inventaire[0].length;j++){
				if(j==colonne-1){
					gbc.gridwidth=GridBagConstraints.REMAINDER;
				}
				gbc.gridx=j*car;
				inventaire [i][j]=new JButton();
				inventaire[i][j].setPreferredSize(new Dimension(car,car));
				inventaire[i][j].setBackground(Color.GRAY);
				this.add(inventaire[i][j],gbc);
			}
		}
		
		this.setPreferredSize(new Dimension(colonne*55,ligne*55));
	}
	
	/*public void paint(Graphics g) {

		int width = 5;
		int car = 50;
		for (int i=0; i<=this.inventaire.length; i++){
			for (int j=0; j<this.inventaire[0].length;j++){
				g.setColor(Color.darkGray);
				g.fillRect(j*car, i*car, car, car);
				g.setColor(Color.gray);
				g.fillRect(j*car + width, i*car + width , car-width , car-width);

			}
		}
	}*/
	
	public Craft GetCraft(Item item, Craft[] EnsembleDesCrafts) {
		for(Craft craft : EnsembleDesCrafts) {
			if(item.compareTo(craft.item)) {
				return craft;
			}
		}
		return null;
	}
}
