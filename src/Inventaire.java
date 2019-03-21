import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
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
		for (int i=0; i<this.inventaire.length; i++){
			for (int j=0; j<this.inventaire[0].length;j++){
				inventaire [i][j]=new JButton();
				inventaire[i][j].setPreferredSize(new Dimension(car,car));
				this.add(inventaire[i][j]);
			}
		}
		
		this.setPreferredSize(new Dimension(colonne*50,ligne*50));
	}
	
	public void Recolte(int quantite) {
		quantite+=5;
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
